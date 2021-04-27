// TODO - constructor: new
//
@file:Suppress("RemoveRedundantBackticks","RedundantVisibilityModifier","unused","RedundantUnitReturnType")

package org.gnome.gio

import interop.GProxyAddress
import interop.g_proxy_address_get_destination_hostname
import interop.g_proxy_address_get_destination_port
import interop.g_proxy_address_get_destination_protocol
import interop.g_proxy_address_get_password
import interop.g_proxy_address_get_protocol
import interop.g_proxy_address_get_uri
import interop.g_proxy_address_get_username
import kotlin.String
import kotlin.UShort
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.reinterpret
import org.gnome.gobject.Object
import org.gnome.toKString

public typealias ProxyAddress = CPointer<GProxyAddress>

public val ProxyAddress.asObject: Object
  get() = reinterpret()

public val ProxyAddress.asSocketAddress: SocketAddress
  get() = reinterpret()

public val ProxyAddress.asInetSocketAddress: InetSocketAddress
  get() = reinterpret()

public object ProxyAddressFactory

public val ProxyAddress.destinationHostname: String
  get() = g_proxy_address_get_destination_hostname(this).toKString

public val ProxyAddress.destinationPort: UShort
  get() = g_proxy_address_get_destination_port(this)

public val ProxyAddress.destinationProtocol: String
  get() = g_proxy_address_get_destination_protocol(this).toKString

public val ProxyAddress.password: String
  get() = g_proxy_address_get_password(this).toKString

public val ProxyAddress.protocol: String
  get() = g_proxy_address_get_protocol(this).toKString

public val ProxyAddress.uri: String
  get() = g_proxy_address_get_uri(this).toKString

public val ProxyAddress.username: String
  get() = g_proxy_address_get_username(this).toKString