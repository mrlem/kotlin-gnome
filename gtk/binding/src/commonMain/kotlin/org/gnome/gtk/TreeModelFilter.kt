// TODO - convert_child_iter_to_iter
// TODO - convert_iter_to_child_iter
// TODO - set_modify_func
// TODO - set_visible_func
//
package org.gnome.gtk

import gtk3.GtkTreeModelFilter
import gtk3.gtk_tree_model_filter_clear_cache
import gtk3.gtk_tree_model_filter_convert_child_path_to_path
import gtk3.gtk_tree_model_filter_convert_path_to_child_path
import gtk3.gtk_tree_model_filter_get_model
import gtk3.gtk_tree_model_filter_refilter
import gtk3.gtk_tree_model_filter_set_visible_column
import kotlin.Int
import kotlin.Unit
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.reinterpret
import org.gnome.gobject.Object

public typealias TreeModelFilter = CPointer<GtkTreeModelFilter>

public val TreeModelFilter.asObject: Object
  get() = reinterpret()

public fun TreeModelFilter.clearCache(): Unit {
  gtk_tree_model_filter_clear_cache(this)
}

public fun TreeModelFilter.convertChildPathToPath(childPath: TreePath): TreePath? =
    gtk_tree_model_filter_convert_child_path_to_path(this, childPath.reinterpret())?.reinterpret()

public fun TreeModelFilter.convertPathToChildPath(filterPath: TreePath): TreePath? =
    gtk_tree_model_filter_convert_path_to_child_path(this, filterPath.reinterpret())?.reinterpret()

public fun TreeModelFilter.getModel(): TreeModel? =
    gtk_tree_model_filter_get_model(this)?.reinterpret()

public fun TreeModelFilter.refilter(): Unit {
  gtk_tree_model_filter_refilter(this)
}

public fun TreeModelFilter.setVisibleColumn(column: Int): Unit {
  gtk_tree_model_filter_set_visible_column(this, column)
}
