package org.gnome.gir.generator.kotlin.generators

import com.squareup.kotlinpoet.*
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.plusParameter
import org.gnome.gir.GNOME_PACKAGE_NAME
import org.gnome.gir.GTK_CINTEROP_PACKAGE_NAME
import org.gnome.gir.model.ClassDefinition
import org.gnome.gir.model.NamespaceDefinition
import org.gnome.gir.resolver.Resolver

fun ClassDefinition.toFileSpec(namespace: NamespaceDefinition, resolver: Resolver): FileSpec? {
    val cType = cType
    if (cType == null) {
        println("warning: class '$name' ignored: no cType")
        return null
    }

    val classNameString = "${namespace.name}.$name"
    val className = classNameString.toClassName
    val packageName = namespace.packageName
    val ancestors = resolver.ancestors(classNameString)

    // filter out some classes
    when {
        deprecated && classNameString != "Gtk.Misc" -> {
            println("info: class '$name' ignored: deprecated")
            return null
        }
        // FIXME - Misc is annoying: deprecated, but not its children...
        ancestors.any { it != "Gtk.Misc" && resolver.classDefinition(it)?.deprecated == true } -> {
            println("info: class '$name' ignored: deprecated ancestor")
            return null
        }
        arrayOf("Gtk.Plug", "Gtk.Socket").contains(classNameString) -> {
            println("warning: class '$name' ignored: excluded class")
            return null
        }
        // FIXME - unhandled for now:
        //  - naming of Atk.Object clashes with GObject.Object
        //  - didn't manage yet to get cinterop to generate ATK classes
        ancestors.contains("Atk.Object") -> {
            println("warning: class '$name' ignored: accessibility not handled yet")
            return null
        }
    }

    return FileSpec.builder(packageName, name)
            // type
            .addTypeAlias(
                TypeAliasSpec.builder(
                    name,
                    ClassName("kotlinx.cinterop", "CPointer")
                        .plusParameter(ClassName(GTK_CINTEROP_PACKAGE_NAME, cType))
                )
                    .build()
            )
            // converters
            .apply { addConverters(classNameString, className, resolver) }
            // sub-elements
            // TODO - compress property methods
            .apply { methods.forEach { addMethod(className, it, resolver) } }
                // TODO - the rest :)
            .build()
}

private fun FileSpec.Builder.addConverters(classNameString: String, className: ClassName, resolver: Resolver) {
    resolver.ancestors(classNameString)
        .reversed()
        .forEach { ancestor ->
            addConverter(className, ancestor)
        }
}

private fun FileSpec.Builder.addConverter(className: ClassName, ancestor: String) {
    val (ancestorNamespaceName, ancestorClassName) = ancestor.split(".")
    val ancestorPackageName = "${GNOME_PACKAGE_NAME}.${ancestorNamespaceName.toLowerCase()}"

    addProperty(
        PropertySpec.builder("as$ancestorClassName", ClassName(ancestorPackageName, ancestorClassName))
            .receiver(className)
            .getter(
                FunSpec.getterBuilder()
                    .addStatement(
                        "return %M()",
                        MemberName("kotlinx.cinterop", "reinterpret")
                    )
                    .build()
            )
            .build()
    )
}