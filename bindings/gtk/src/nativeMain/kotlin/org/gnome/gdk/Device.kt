// TODO - method: get_associated_device (return type)
// TODO - method: get_axes (return type)
// TODO - method: get_axis_use (return type)
// TODO - method: get_device_type (return type)
// TODO - method: get_display (return type)
// TODO - method: get_key (param type)
// TODO - method: get_last_event_window (return type)
// TODO - method: get_mode (return type)
// TODO - method: get_position (param type)
// TODO - method: get_position_double (param type)
// TODO - method: get_seat (return type)
// TODO - method: get_source (return type)
// TODO - method: get_window_at_position (return type)
// TODO - method: get_window_at_position_double (return type)
// TODO - method: list_axes (return type)
// TODO - method: list_slave_devices (return type)
// TODO - method: set_axis_use (param type)
// TODO - method: set_key (param type)
// TODO - method: set_mode (param type)
// TODO - method: warp (param type)
//
@file:Suppress("RemoveRedundantBackticks","RedundantVisibilityModifier","unused","RedundantUnitReturnType")

package org.gnome.gdk

import interop.GdkDevice
import interop.gdk_device_get_has_cursor
import interop.gdk_device_get_n_axes
import interop.gdk_device_get_n_keys
import interop.gdk_device_get_name
import interop.gdk_device_get_product_id
import interop.gdk_device_get_vendor_id
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.Unit
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.reinterpret
import org.gnome.gobject.Object
import org.gnome.toBoolean
import org.gnome.toKString
import org.mrlem.gnome.gobject.connect

public typealias Device = CPointer<GdkDevice>

public val Device.asObject: Object
  get() = reinterpret()

public val Device.hasCursor: Boolean
  get() = gdk_device_get_has_cursor(this).toBoolean()

public val Device.nAxes: Int
  get() = gdk_device_get_n_axes(this)

public val Device.nKeys: Int
  get() = gdk_device_get_n_keys(this)

public val Device.name: String?
  get() = gdk_device_get_name(this).toKString()

public val Device.productId: String?
  get() = gdk_device_get_product_id(this).toKString()

public val Device.vendorId: String?
  get() = gdk_device_get_vendor_id(this).toKString()

public fun Device.onChanged(callback: (Device) -> Unit): Device {
  // TODO - handle callback data

  asObject.connect("changed") { callback(this) }
  return this
}

public fun Device.onToolChanged(callback: (Device) -> Unit): Device {
  // TODO - handle callback data

  asObject.connect("tool-changed") { callback(this) }
  return this
}
