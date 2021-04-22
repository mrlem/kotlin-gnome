@file:Suppress("RemoveRedundantBackticks","RedundantVisibilityModifier","unused","RedundantUnitReturnType")

package org.gnome.gtk

import gtk3.GtkFontChooserDialog
import gtk3.gtk_font_chooser_dialog_new
import kotlin.String
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.reinterpret
import org.gnome.gobject.InitiallyUnowned
import org.gnome.gobject.Object

public typealias FontChooserDialog = CPointer<GtkFontChooserDialog>

public val FontChooserDialog.asObject: Object
  get() = reinterpret()

public val FontChooserDialog.asInitiallyUnowned: InitiallyUnowned
  get() = reinterpret()

public val FontChooserDialog.asWidget: Widget
  get() = reinterpret()

public val FontChooserDialog.asContainer: Container
  get() = reinterpret()

public val FontChooserDialog.asBin: Bin
  get() = reinterpret()

public val FontChooserDialog.asWindow: Window
  get() = reinterpret()

public val FontChooserDialog.asDialog: Dialog
  get() = reinterpret()

public object FontChooserDialogFactory {
  public fun new(title: String, parent: Window?): FontChooserDialog =
      gtk_font_chooser_dialog_new(title, parent?.reinterpret())!!.reinterpret()
}
