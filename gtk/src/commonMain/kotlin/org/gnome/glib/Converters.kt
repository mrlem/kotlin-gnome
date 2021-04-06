package org.gnome.glib

import gtk3.*
import kotlinx.cinterop.CPointed
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.convert
import kotlinx.cinterop.toKString
import org.mrlem.gnome.glib.List

val Boolean.toInt
    get() = if (this) 1 else 0

val Int.toBoolean
    get() = this == 1

val CPointer<gcharVar>?.toKString
    get() = this?.toKString()

fun <P : CPointed> CPointer<GList>.toKList(): List<P, CPointer<P>> = List(this)
