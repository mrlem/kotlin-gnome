// TODO - implement:
//   get_widgets
package org.gnome.gtk

import gtk3.GtkTextChildAnchor
import gtk3.gtk_text_child_anchor_get_deleted
import kotlin.Boolean
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.reinterpret
import org.gnome.glib.gobject.Object
import org.gnome.glib.toBoolean

public typealias TextChildAnchor = CPointer<GtkTextChildAnchor>

public val TextChildAnchor.asObject: Object
  get() = reinterpret()

public val TextChildAnchor.deleted: Boolean
  get() = gtk_text_child_anchor_get_deleted(this).toBoolean