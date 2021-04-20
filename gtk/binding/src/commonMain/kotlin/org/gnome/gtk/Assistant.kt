// TODO - get_page_header_image
// TODO - get_page_side_image
// TODO - set_forward_page_func
// TODO - set_page_header_image
// TODO - set_page_side_image
//
@file:Suppress("RemoveRedundantBackticks","RedundantVisibilityModifier","unused","RedundantUnitReturnType")

package org.gnome.gtk

import gtk3.GtkAssistant
import gtk3.gtk_assistant_add_action_widget
import gtk3.gtk_assistant_append_page
import gtk3.gtk_assistant_commit
import gtk3.gtk_assistant_get_current_page
import gtk3.gtk_assistant_get_n_pages
import gtk3.gtk_assistant_get_nth_page
import gtk3.gtk_assistant_get_page_complete
import gtk3.gtk_assistant_get_page_has_padding
import gtk3.gtk_assistant_get_page_title
import gtk3.gtk_assistant_get_page_type
import gtk3.gtk_assistant_insert_page
import gtk3.gtk_assistant_next_page
import gtk3.gtk_assistant_prepend_page
import gtk3.gtk_assistant_previous_page
import gtk3.gtk_assistant_remove_action_widget
import gtk3.gtk_assistant_remove_page
import gtk3.gtk_assistant_set_current_page
import gtk3.gtk_assistant_set_page_complete
import gtk3.gtk_assistant_set_page_has_padding
import gtk3.gtk_assistant_set_page_title
import gtk3.gtk_assistant_set_page_type
import gtk3.gtk_assistant_update_buttons_state
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.Unit
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.reinterpret
import org.gnome.gobject.InitiallyUnowned
import org.gnome.gobject.Object
import org.gnome.toBoolean
import org.gnome.toInt
import org.gnome.toKString

public typealias Assistant = CPointer<GtkAssistant>

public val Assistant.asObject: Object
  get() = reinterpret()

public val Assistant.asInitiallyUnowned: InitiallyUnowned
  get() = reinterpret()

public val Assistant.asWidget: Widget
  get() = reinterpret()

public val Assistant.asContainer: Container
  get() = reinterpret()

public val Assistant.asBin: Bin
  get() = reinterpret()

public val Assistant.asWindow: Window
  get() = reinterpret()

public var Assistant.currentPage: Int
  get() = gtk_assistant_get_current_page(this)
  set(`value`) {
    gtk_assistant_set_current_page(this, value)
  }

public val Assistant.nPages: Int
  get() = gtk_assistant_get_n_pages(this)

public fun Assistant.addActionWidget(child: Widget?): Unit {
  gtk_assistant_add_action_widget(this, child?.reinterpret())
}

public fun Assistant.appendPage(page: Widget?): Int = gtk_assistant_append_page(this,
    page?.reinterpret())

public fun Assistant.commit(): Unit {
  gtk_assistant_commit(this)
}

public fun Assistant.getNthPage(pageNum: Int): Widget? = gtk_assistant_get_nth_page(this,
    pageNum)?.reinterpret()

public fun Assistant.getPageComplete(page: Widget?): Boolean = gtk_assistant_get_page_complete(this,
    page?.reinterpret()).toBoolean

public fun Assistant.getPageHasPadding(page: Widget?): Boolean =
    gtk_assistant_get_page_has_padding(this, page?.reinterpret()).toBoolean

public fun Assistant.getPageTitle(page: Widget?): String = gtk_assistant_get_page_title(this,
    page?.reinterpret()).toKString

public fun Assistant.getPageType(page: Widget?): AssistantPageType =
    gtk_assistant_get_page_type(this, page?.reinterpret())

public fun Assistant.insertPage(page: Widget?, position: Int): Int = gtk_assistant_insert_page(this,
    page?.reinterpret(), position)

public fun Assistant.nextPage(): Unit {
  gtk_assistant_next_page(this)
}

public fun Assistant.prependPage(page: Widget?): Int = gtk_assistant_prepend_page(this,
    page?.reinterpret())

public fun Assistant.previousPage(): Unit {
  gtk_assistant_previous_page(this)
}

public fun Assistant.removeActionWidget(child: Widget?): Unit {
  gtk_assistant_remove_action_widget(this, child?.reinterpret())
}

public fun Assistant.removePage(pageNum: Int): Unit {
  gtk_assistant_remove_page(this, pageNum)
}

public fun Assistant.setPageComplete(page: Widget?, complete: Boolean): Unit {
  gtk_assistant_set_page_complete(this, page?.reinterpret(), complete.toInt)
}

public fun Assistant.setPageHasPadding(page: Widget?, hasPadding: Boolean): Unit {
  gtk_assistant_set_page_has_padding(this, page?.reinterpret(), hasPadding.toInt)
}

public fun Assistant.setPageTitle(page: Widget?, title: String): Unit {
  gtk_assistant_set_page_title(this, page?.reinterpret(), title)
}

public fun Assistant.setPageType(page: Widget?, type: AssistantPageType): Unit {
  gtk_assistant_set_page_type(this, page?.reinterpret(), type)
}

public fun Assistant.updateButtonsState(): Unit {
  gtk_assistant_update_buttons_state(this)
}
