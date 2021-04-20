@file:Suppress("RemoveRedundantBackticks","RedundantVisibilityModifier","unused","RedundantUnitReturnType")

package org.gnome.gtk

import gtk3.GtkListBoxRow
import gtk3.gtk_list_box_row_changed
import gtk3.gtk_list_box_row_get_activatable
import gtk3.gtk_list_box_row_get_header
import gtk3.gtk_list_box_row_get_index
import gtk3.gtk_list_box_row_get_selectable
import gtk3.gtk_list_box_row_is_selected
import gtk3.gtk_list_box_row_set_activatable
import gtk3.gtk_list_box_row_set_header
import gtk3.gtk_list_box_row_set_selectable
import kotlin.Boolean
import kotlin.Int
import kotlin.Unit
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.reinterpret
import org.gnome.gobject.InitiallyUnowned
import org.gnome.gobject.Object
import org.gnome.toBoolean
import org.gnome.toInt

public typealias ListBoxRow = CPointer<GtkListBoxRow>

public val ListBoxRow.asObject: Object
  get() = reinterpret()

public val ListBoxRow.asInitiallyUnowned: InitiallyUnowned
  get() = reinterpret()

public val ListBoxRow.asWidget: Widget
  get() = reinterpret()

public val ListBoxRow.asContainer: Container
  get() = reinterpret()

public val ListBoxRow.asBin: Bin
  get() = reinterpret()

public var ListBoxRow.activatable: Boolean
  get() = gtk_list_box_row_get_activatable(this).toBoolean
  set(`value`) {
    gtk_list_box_row_set_activatable(this, value.toInt)
  }

public var ListBoxRow.header: Widget?
  get() = gtk_list_box_row_get_header(this)?.reinterpret()
  set(`value`) {
    gtk_list_box_row_set_header(this, value)
  }

public val ListBoxRow.index: Int
  get() = gtk_list_box_row_get_index(this)

public var ListBoxRow.selectable: Boolean
  get() = gtk_list_box_row_get_selectable(this).toBoolean
  set(`value`) {
    gtk_list_box_row_set_selectable(this, value.toInt)
  }

public fun ListBoxRow.changed(): Unit {
  gtk_list_box_row_changed(this)
}

public fun ListBoxRow.isSelected(): Boolean = gtk_list_box_row_is_selected(this).toBoolean
