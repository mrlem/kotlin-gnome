// TODO - filter_keypress
// TODO - get_preedit_string
// TODO - get_surrounding
// TODO - set_client_window
// TODO - set_cursor_location
//
package org.gnome.gtk

import gtk3.GtkIMContext
import gtk3.gtk_im_context_delete_surrounding
import gtk3.gtk_im_context_focus_in
import gtk3.gtk_im_context_focus_out
import gtk3.gtk_im_context_reset
import gtk3.gtk_im_context_set_surrounding
import gtk3.gtk_im_context_set_use_preedit
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.Unit
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.reinterpret
import org.gnome.gobject.Object
import org.gnome.toBoolean
import org.gnome.toInt

public typealias IMContext = CPointer<GtkIMContext>

public val IMContext.asObject: Object
  get() = reinterpret()

public fun IMContext.deleteSurrounding(offset: Int, nChars: Int): Boolean =
    gtk_im_context_delete_surrounding(this, offset, nChars).toBoolean

public fun IMContext.focusIn(): Unit {
  gtk_im_context_focus_in(this)
}

public fun IMContext.focusOut(): Unit {
  gtk_im_context_focus_out(this)
}

public fun IMContext.reset(): Unit {
  gtk_im_context_reset(this)
}

public fun IMContext.setSurrounding(
  text: String?,
  len: Int,
  cursorIndex: Int
): Unit {
  gtk_im_context_set_surrounding(this, text, len, cursorIndex)
}

public fun IMContext.setUsePreedit(usePreedit: Boolean): Unit {
  gtk_im_context_set_use_preedit(this, usePreedit.toInt)
}
