package org.gnome.gtk

import gtk3.GtkGestureRotate
import gtk3.gtk_gesture_rotate_get_angle_delta
import kotlin.Double
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.reinterpret
import org.gnome.glib.gobject.Object

public typealias GestureRotate = CPointer<GtkGestureRotate>

public val GestureRotate.asObject: Object
  get() = reinterpret()

public val GestureRotate.asEventController: EventController
  get() = reinterpret()

public val GestureRotate.asGesture: Gesture
  get() = reinterpret()

public val GestureRotate.angleDelta: Double
  get() = gtk_gesture_rotate_get_angle_delta(this)