// TODO - implement:
//   append
//   clear
//   insert
//   insert_after
//   insert_before
//   insert_with_values
//   insert_with_valuesv
//   is_ancestor
//   iter_depth
//   iter_is_valid
//   move_after
//   move_before
//   prepend
//   remove
//   reorder
//   set
//   set_column_types
//   set_valist
//   set_value
//   set_valuesv
//   swap
package org.gnome.gtk

import gtk3.GtkTreeStore
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.reinterpret
import org.gnome.glib.gobject.Object

public typealias TreeStore = CPointer<GtkTreeStore>

public val TreeStore.asObject: Object
  get() = reinterpret()