package org.gnome.gobject

import interop.GInitiallyUnowned
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.reinterpret

///////////////////////////////////////////////////////////////////////////
// Type
///////////////////////////////////////////////////////////////////////////

typealias InitiallyUnowned = CPointer<GInitiallyUnowned>

///////////////////////////////////////////////////////////////////////////
// Conversion
///////////////////////////////////////////////////////////////////////////

val InitiallyUnowned.asObject: Object
    get() = reinterpret()