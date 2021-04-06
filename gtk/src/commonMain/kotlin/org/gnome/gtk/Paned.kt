// TODO - implement:
//   add1
//   add2
//   get_child1
//   get_child2
//   get_handle_window
//   pack1
//   pack2
package org.gnome.gtk

import gtk3.GtkPaned
import gtk3.gtk_paned_get_position
import gtk3.gtk_paned_get_wide_handle
import gtk3.gtk_paned_set_position
import gtk3.gtk_paned_set_wide_handle
import kotlin.Boolean
import kotlin.Int
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.reinterpret
import org.gnome.glib.gobject.InitiallyUnowned
import org.gnome.glib.toBoolean
import org.gnome.glib.toInt

public typealias Paned = CPointer<GtkPaned>

public val Paned.asInitiallyUnowned: InitiallyUnowned
  get() = reinterpret()

public val Paned.asWidget: Widget
  get() = reinterpret()

public val Paned.asContainer: Container
  get() = reinterpret()

public var Paned.position: Int
  get() = gtk_paned_get_position(this)
  set(`value`) {
    gtk_paned_set_position(this, value)
  }

public var Paned.wideHandle: Boolean
  get() = gtk_paned_get_wide_handle(this).toBoolean
  set(`value`) {
    gtk_paned_set_wide_handle(this, value.toInt)
  }
