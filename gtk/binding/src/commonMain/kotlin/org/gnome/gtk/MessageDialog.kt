// TODO - implement:
//   format_secondary_markup
//   format_secondary_text
//   set_image
//   set_markup
package org.gnome.gtk

import gtk3.GtkMessageDialog
import gtk3.gtk_message_dialog_get_message_area
import kotlin.Unit
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.reinterpret
import org.gnome.glib.gobject.InitiallyUnowned
import org.gnome.glib.gobject.Object

public typealias MessageDialog = CPointer<GtkMessageDialog>

public val MessageDialog.asObject: Object
  get() = reinterpret()

public val MessageDialog.asInitiallyUnowned: InitiallyUnowned
  get() = reinterpret()

public val MessageDialog.asWidget: Widget
  get() = reinterpret()

public val MessageDialog.asContainer: Container
  get() = reinterpret()

public val MessageDialog.asBin: Bin
  get() = reinterpret()

public val MessageDialog.asWindow: Window
  get() = reinterpret()

public val MessageDialog.asDialog: Dialog
  get() = reinterpret()

public fun MessageDialog.getMessageArea(): Unit {
  gtk_message_dialog_get_message_area(this)
}