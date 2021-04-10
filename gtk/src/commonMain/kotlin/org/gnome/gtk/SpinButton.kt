// TODO - implement:
//   configure
//   get_increments
//   get_range
//   set_adjustment
//   set_increments
//   set_range
//   set_update_policy
//   spin
package org.gnome.gtk

import gtk3.GtkSpinButton
import gtk3.gtk_spin_button_get_adjustment
import gtk3.gtk_spin_button_get_digits
import gtk3.gtk_spin_button_get_numeric
import gtk3.gtk_spin_button_get_snap_to_ticks
import gtk3.gtk_spin_button_get_update_policy
import gtk3.gtk_spin_button_get_value
import gtk3.gtk_spin_button_get_value_as_int
import gtk3.gtk_spin_button_get_wrap
import gtk3.gtk_spin_button_set_digits
import gtk3.gtk_spin_button_set_numeric
import gtk3.gtk_spin_button_set_snap_to_ticks
import gtk3.gtk_spin_button_set_value
import gtk3.gtk_spin_button_set_wrap
import gtk3.gtk_spin_button_update
import kotlin.Boolean
import kotlin.Double
import kotlin.Int
import kotlin.UInt
import kotlin.Unit
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.reinterpret
import org.gnome.glib.gobject.InitiallyUnowned
import org.gnome.glib.gobject.Object
import org.gnome.glib.toBoolean
import org.gnome.glib.toInt

public typealias SpinButton = CPointer<GtkSpinButton>

public val SpinButton.asObject: Object
  get() = reinterpret()

public val SpinButton.asInitiallyUnowned: InitiallyUnowned
  get() = reinterpret()

public val SpinButton.asWidget: Widget
  get() = reinterpret()

public val SpinButton.asEntry: Entry
  get() = reinterpret()

public fun SpinButton.getAdjustment(): Unit {
  gtk_spin_button_get_adjustment(this)
}

public fun SpinButton.getUpdatePolicy(): Unit {
  gtk_spin_button_get_update_policy(this)
}

public fun SpinButton.update(): Unit {
  gtk_spin_button_update(this)
}

public var SpinButton.digits: UInt
  get() = gtk_spin_button_get_digits(this)
  set(`value`) {
    gtk_spin_button_set_digits(this, value)
  }

public var SpinButton.numeric: Boolean
  get() = gtk_spin_button_get_numeric(this).toBoolean
  set(`value`) {
    gtk_spin_button_set_numeric(this, value.toInt)
  }

public var SpinButton.snapToTicks: Boolean
  get() = gtk_spin_button_get_snap_to_ticks(this).toBoolean
  set(`value`) {
    gtk_spin_button_set_snap_to_ticks(this, value.toInt)
  }

public var SpinButton.`value`: Double
  get() = gtk_spin_button_get_value(this)
  set(`value`) {
    gtk_spin_button_set_value(this, value)
  }

public var SpinButton.wrap: Boolean
  get() = gtk_spin_button_get_wrap(this).toBoolean
  set(`value`) {
    gtk_spin_button_set_wrap(this, value.toInt)
  }

public val SpinButton.valueAsInt: Int
  get() = gtk_spin_button_get_value_as_int(this)
