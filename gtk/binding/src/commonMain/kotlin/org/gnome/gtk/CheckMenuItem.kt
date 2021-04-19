package org.gnome.gtk

import gtk3.GtkCheckMenuItem
import gtk3.gtk_check_menu_item_get_active
import gtk3.gtk_check_menu_item_get_draw_as_radio
import gtk3.gtk_check_menu_item_get_inconsistent
import gtk3.gtk_check_menu_item_set_active
import gtk3.gtk_check_menu_item_set_draw_as_radio
import gtk3.gtk_check_menu_item_set_inconsistent
import gtk3.gtk_check_menu_item_toggled
import kotlin.Boolean
import kotlin.Unit
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.reinterpret
import org.gnome.gobject.InitiallyUnowned
import org.gnome.gobject.Object
import org.gnome.toBoolean
import org.gnome.toInt

public typealias CheckMenuItem = CPointer<GtkCheckMenuItem>

public val CheckMenuItem.asObject: Object
  get() = reinterpret()

public val CheckMenuItem.asInitiallyUnowned: InitiallyUnowned
  get() = reinterpret()

public val CheckMenuItem.asWidget: Widget
  get() = reinterpret()

public val CheckMenuItem.asContainer: Container
  get() = reinterpret()

public val CheckMenuItem.asBin: Bin
  get() = reinterpret()

public val CheckMenuItem.asMenuItem: MenuItem
  get() = reinterpret()

public fun CheckMenuItem.getActive(): Boolean = gtk_check_menu_item_get_active(this).toBoolean

public fun CheckMenuItem.getDrawAsRadio(): Boolean =
    gtk_check_menu_item_get_draw_as_radio(this).toBoolean

public fun CheckMenuItem.getInconsistent(): Boolean =
    gtk_check_menu_item_get_inconsistent(this).toBoolean

public fun CheckMenuItem.setActive(isActive: Boolean): Unit {
  gtk_check_menu_item_set_active(this, isActive.toInt)
}

public fun CheckMenuItem.setDrawAsRadio(drawAsRadio: Boolean): Unit {
  gtk_check_menu_item_set_draw_as_radio(this, drawAsRadio.toInt)
}

public fun CheckMenuItem.setInconsistent(setting: Boolean): Unit {
  gtk_check_menu_item_set_inconsistent(this, setting.toInt)
}

public fun CheckMenuItem.toggled(): Unit {
  gtk_check_menu_item_toggled(this)
}
