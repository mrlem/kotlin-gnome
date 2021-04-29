// TODO - method: choose_icon
// TODO - method: choose_icon_for_scale
// TODO - method: get_icon_sizes
// TODO - method: get_search_path
// TODO - method: list_contexts
// TODO - method: list_icons
// TODO - method: load_icon
// TODO - method: load_icon_for_scale
// TODO - method: load_surface
// TODO - method: set_screen
// TODO - method: set_search_path
//
@file:Suppress("RemoveRedundantBackticks","RedundantVisibilityModifier","unused","RedundantUnitReturnType")

package org.gnome.gtk

import interop.GtkIconTheme
import interop.gtk_icon_theme_add_resource_path
import interop.gtk_icon_theme_append_search_path
import interop.gtk_icon_theme_get_example_icon_name
import interop.gtk_icon_theme_has_icon
import interop.gtk_icon_theme_lookup_by_gicon
import interop.gtk_icon_theme_lookup_by_gicon_for_scale
import interop.gtk_icon_theme_lookup_icon
import interop.gtk_icon_theme_lookup_icon_for_scale
import interop.gtk_icon_theme_new
import interop.gtk_icon_theme_prepend_search_path
import interop.gtk_icon_theme_rescan_if_needed
import interop.gtk_icon_theme_set_custom_theme
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.Unit
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.reinterpret
import org.gnome.gio.Icon
import org.gnome.gobject.Object
import org.gnome.toBoolean
import org.gnome.toKString
import org.mrlem.gnome.gobject.connect

public typealias IconTheme = CPointer<GtkIconTheme>

public val IconTheme.asObject: Object
  get() = reinterpret()

public object IconThemeFactory {
  public fun new(): IconTheme = gtk_icon_theme_new()!!.reinterpret()
}

public val IconTheme.exampleIconName: String
  get() = gtk_icon_theme_get_example_icon_name(this).toKString

public fun IconTheme.addResourcePath(path: String): Unit {
  gtk_icon_theme_add_resource_path(this, path)
}

public fun IconTheme.appendSearchPath(path: String): Unit {
  gtk_icon_theme_append_search_path(this, path)
}

public fun IconTheme.hasIcon(iconName: String): Boolean = gtk_icon_theme_has_icon(this,
    iconName).toBoolean

public fun IconTheme.lookupByGicon(
  icon: Icon?,
  size: Int,
  flags: IconLookupFlags
): IconInfo? = gtk_icon_theme_lookup_by_gicon(this, icon?.reinterpret(), size, flags)?.reinterpret()

public fun IconTheme.lookupByGiconForScale(
  icon: Icon?,
  size: Int,
  scale: Int,
  flags: IconLookupFlags
): IconInfo? = gtk_icon_theme_lookup_by_gicon_for_scale(this, icon?.reinterpret(), size, scale,
    flags)?.reinterpret()

public fun IconTheme.lookupIcon(
  iconName: String,
  size: Int,
  flags: IconLookupFlags
): IconInfo? = gtk_icon_theme_lookup_icon(this, iconName, size, flags)?.reinterpret()

public fun IconTheme.lookupIconForScale(
  iconName: String,
  size: Int,
  scale: Int,
  flags: IconLookupFlags
): IconInfo? = gtk_icon_theme_lookup_icon_for_scale(this, iconName, size, scale,
    flags)?.reinterpret()

public fun IconTheme.prependSearchPath(path: String): Unit {
  gtk_icon_theme_prepend_search_path(this, path)
}

public fun IconTheme.rescanIfNeeded(): Boolean = gtk_icon_theme_rescan_if_needed(this).toBoolean

public fun IconTheme.setCustomTheme(themeName: String): Unit {
  gtk_icon_theme_set_custom_theme(this, themeName)
}

public fun IconTheme.onChanged(callback: (IconTheme) -> Unit): IconTheme {
  // TODO - handle callback data

  asObject.connect("changed") { callback(this) }
  return this
}