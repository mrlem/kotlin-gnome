// TODO - implement:
//   add_mark
//   clear_marks
//   get_layout
//   get_layout_offsets
//   get_value_pos
//   set_value_pos
package org.gnome.gtk

import gtk3.GtkScale
import gtk3.gtk_scale_get_digits
import gtk3.gtk_scale_get_draw_value
import gtk3.gtk_scale_get_has_origin
import gtk3.gtk_scale_set_digits
import gtk3.gtk_scale_set_draw_value
import gtk3.gtk_scale_set_has_origin
import kotlin.Boolean
import kotlin.Int
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.reinterpret
import org.gnome.glib.gobject.InitiallyUnowned
import org.gnome.glib.toBoolean
import org.gnome.glib.toInt

public typealias Scale = CPointer<GtkScale>

public val Scale.asInitiallyUnowned: InitiallyUnowned
  get() = reinterpret()

public val Scale.asWidget: Widget
  get() = reinterpret()

public val Scale.asRange: Range
  get() = reinterpret()

public var Scale.digits: Int
  get() = gtk_scale_get_digits(this)
  set(`value`) {
    gtk_scale_set_digits(this, value)
  }

public var Scale.drawValue: Boolean
  get() = gtk_scale_get_draw_value(this).toBoolean
  set(`value`) {
    gtk_scale_set_draw_value(this, value.toInt)
  }

public var Scale.hasOrigin: Boolean
  get() = gtk_scale_get_has_origin(this).toBoolean
  set(`value`) {
    gtk_scale_set_has_origin(this, value.toInt)
  }