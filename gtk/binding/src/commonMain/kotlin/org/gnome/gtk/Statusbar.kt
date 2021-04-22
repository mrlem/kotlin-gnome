@file:Suppress("RemoveRedundantBackticks","RedundantVisibilityModifier","unused","RedundantUnitReturnType")

package org.gnome.gtk

import gtk3.GtkStatusbar
import gtk3.gtk_statusbar_get_context_id
import gtk3.gtk_statusbar_get_message_area
import gtk3.gtk_statusbar_new
import gtk3.gtk_statusbar_pop
import gtk3.gtk_statusbar_push
import gtk3.gtk_statusbar_remove
import gtk3.gtk_statusbar_remove_all
import kotlin.String
import kotlin.UInt
import kotlin.Unit
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.reinterpret
import org.gnome.gobject.InitiallyUnowned
import org.gnome.gobject.Object
import org.gnome.gobject.connect

public typealias Statusbar = CPointer<GtkStatusbar>

public val Statusbar.asObject: Object
  get() = reinterpret()

public val Statusbar.asInitiallyUnowned: InitiallyUnowned
  get() = reinterpret()

public val Statusbar.asWidget: Widget
  get() = reinterpret()

public val Statusbar.asContainer: Container
  get() = reinterpret()

public val Statusbar.asBox: Box
  get() = reinterpret()

public object StatusbarFactory {
  public fun new(): Statusbar = gtk_statusbar_new()!!.reinterpret()
}

public val Statusbar.messageArea: Box?
  get() = gtk_statusbar_get_message_area(this)?.reinterpret()

public fun Statusbar.getContextId(contextDescription: String): UInt =
    gtk_statusbar_get_context_id(this, contextDescription)

public fun Statusbar.pop(contextId: UInt): Unit {
  gtk_statusbar_pop(this, contextId)
}

public fun Statusbar.push(contextId: UInt, text: String): UInt = gtk_statusbar_push(this, contextId,
    text)

public fun Statusbar.remove(contextId: UInt, messageId: UInt): Unit {
  gtk_statusbar_remove(this, contextId, messageId)
}

public fun Statusbar.removeAll(contextId: UInt): Unit {
  gtk_statusbar_remove_all(this, contextId)
}

public fun Statusbar.onTextPopped(callback: (Statusbar) -> Unit): Statusbar {
  // TODO - handle callback data

  asObject.connect("text-popped") { callback(this) }
  return this
}

public fun Statusbar.onTextPushed(callback: (Statusbar) -> Unit): Statusbar {
  // TODO - handle callback data

  asObject.connect("text-pushed") { callback(this) }
  return this
}
