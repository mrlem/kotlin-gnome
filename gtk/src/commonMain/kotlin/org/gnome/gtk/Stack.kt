// TODO - implement:
//   add_named
//   add_titled
//   get_child_by_name
//   get_transition_type
//   get_visible_child
//   set_transition_type
//   set_visible_child
//   set_visible_child_full
package org.gnome.gtk

import gtk3.GtkStack
import gtk3.gtk_stack_get_hhomogeneous
import gtk3.gtk_stack_get_homogeneous
import gtk3.gtk_stack_get_interpolate_size
import gtk3.gtk_stack_get_transition_duration
import gtk3.gtk_stack_get_transition_running
import gtk3.gtk_stack_get_vhomogeneous
import gtk3.gtk_stack_get_visible_child_name
import gtk3.gtk_stack_set_hhomogeneous
import gtk3.gtk_stack_set_homogeneous
import gtk3.gtk_stack_set_interpolate_size
import gtk3.gtk_stack_set_transition_duration
import gtk3.gtk_stack_set_vhomogeneous
import gtk3.gtk_stack_set_visible_child_name
import kotlin.Boolean
import kotlin.String
import kotlin.UInt
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.reinterpret
import org.gnome.glib.gobject.InitiallyUnowned
import org.gnome.glib.toBoolean
import org.gnome.glib.toInt
import org.gnome.glib.toKString

public typealias Stack = CPointer<GtkStack>

public val Stack.asInitiallyUnowned: InitiallyUnowned
  get() = reinterpret()

public val Stack.asWidget: Widget
  get() = reinterpret()

public val Stack.asContainer: Container
  get() = reinterpret()

public var Stack.hhomogeneous: Boolean
  get() = gtk_stack_get_hhomogeneous(this).toBoolean
  set(`value`) {
    gtk_stack_set_hhomogeneous(this, value.toInt)
  }

public var Stack.homogeneous: Boolean
  get() = gtk_stack_get_homogeneous(this).toBoolean
  set(`value`) {
    gtk_stack_set_homogeneous(this, value.toInt)
  }

public var Stack.interpolateSize: Boolean
  get() = gtk_stack_get_interpolate_size(this).toBoolean
  set(`value`) {
    gtk_stack_set_interpolate_size(this, value.toInt)
  }

public var Stack.transitionDuration: UInt
  get() = gtk_stack_get_transition_duration(this)
  set(`value`) {
    gtk_stack_set_transition_duration(this, value)
  }

public var Stack.vhomogeneous: Boolean
  get() = gtk_stack_get_vhomogeneous(this).toBoolean
  set(`value`) {
    gtk_stack_set_vhomogeneous(this, value.toInt)
  }

public var Stack.visibleChildName: String?
  get() = gtk_stack_get_visible_child_name(this).toKString
  set(`value`) {
    gtk_stack_set_visible_child_name(this, value)
  }

public val Stack.transitionRunning: Boolean
  get() = gtk_stack_get_transition_running(this).toBoolean
