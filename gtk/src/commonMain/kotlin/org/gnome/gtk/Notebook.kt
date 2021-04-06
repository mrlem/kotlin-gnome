// TODO - implement:
//   append_page
//   append_page_menu
//   detach_tab
//   get_action_widget
//   get_menu_label
//   get_menu_label_text
//   get_nth_page
//   get_tab_detachable
//   get_tab_label
//   get_tab_label_text
//   get_tab_pos
//   get_tab_reorderable
//   insert_page
//   insert_page_menu
//   next_page
//   page_num
//   popup_disable
//   popup_enable
//   prepend_page
//   prepend_page_menu
//   prev_page
//   remove_page
//   reorder_child
//   set_action_widget
//   set_menu_label
//   set_menu_label_text
//   set_tab_detachable
//   set_tab_label
//   set_tab_label_text
//   set_tab_pos
//   set_tab_reorderable
package org.gnome.gtk

import gtk3.GtkNotebook
import gtk3.gtk_notebook_get_current_page
import gtk3.gtk_notebook_get_group_name
import gtk3.gtk_notebook_get_n_pages
import gtk3.gtk_notebook_get_scrollable
import gtk3.gtk_notebook_get_show_border
import gtk3.gtk_notebook_get_show_tabs
import gtk3.gtk_notebook_get_tab_hborder
import gtk3.gtk_notebook_get_tab_vborder
import gtk3.gtk_notebook_set_current_page
import gtk3.gtk_notebook_set_group_name
import gtk3.gtk_notebook_set_scrollable
import gtk3.gtk_notebook_set_show_border
import gtk3.gtk_notebook_set_show_tabs
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.UInt
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.convert
import kotlinx.cinterop.reinterpret
import org.gnome.glib.gobject.InitiallyUnowned
import org.gnome.glib.toBoolean
import org.gnome.glib.toInt
import org.gnome.glib.toKString

public typealias Notebook = CPointer<GtkNotebook>

public val Notebook.asInitiallyUnowned: InitiallyUnowned
  get() = reinterpret()

public val Notebook.asWidget: Widget
  get() = reinterpret()

public val Notebook.asContainer: Container
  get() = reinterpret()

public var Notebook.currentPage: Int
  get() = gtk_notebook_get_current_page(this)
  set(`value`) {
    gtk_notebook_set_current_page(this, value)
  }

public var Notebook.groupName: String?
  get() = gtk_notebook_get_group_name(this).toKString
  set(`value`) {
    gtk_notebook_set_group_name(this, value)
  }

public var Notebook.scrollable: Boolean
  get() = gtk_notebook_get_scrollable(this).toBoolean
  set(`value`) {
    gtk_notebook_set_scrollable(this, value.toInt)
  }

public var Notebook.showBorder: Boolean
  get() = gtk_notebook_get_show_border(this).toBoolean
  set(`value`) {
    gtk_notebook_set_show_border(this, value.toInt)
  }

public var Notebook.showTabs: Boolean
  get() = gtk_notebook_get_show_tabs(this).toBoolean
  set(`value`) {
    gtk_notebook_set_show_tabs(this, value.toInt)
  }

public val Notebook.nPages: Int
  get() = gtk_notebook_get_n_pages(this)

public val Notebook.tabHborder: UInt
  get() = gtk_notebook_get_tab_hborder(this).convert()

public val Notebook.tabVborder: UInt
  get() = gtk_notebook_get_tab_vborder(this).convert()
