package org.mrlem.gir.xml

sealed class MemberDefinition {

    /**
     * Name identifying the member.
     */
    abstract val name: String

    // TODO - args
    data class Constructor(
        override val name: String
    ) : MemberDefinition()

    data class PropertyGetter(
        override val name: String,
        val type: Type
    ) : MemberDefinition()

    data class PropertySetter(
        override val name: String,
        val type: Type
    ) : MemberDefinition()

    data class Property(
        override val name: String,
        var readOnly: Boolean,
        val type: Type
    ) : MemberDefinition()

    // TODO - args
    data class Method(
        override val name: String
    ) : MemberDefinition()

    // TODO - args
    data class EventHandler(
        override val name: String
    ) : MemberDefinition()

    /**
     * A member that will generate a comment for functions not covered by the binding yet.
     */
    data class Todo(
        override val name: String
    ) : MemberDefinition()

}
