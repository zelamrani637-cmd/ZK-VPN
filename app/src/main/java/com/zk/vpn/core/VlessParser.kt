package com.zk.vpn.core

import android.net.Uri
import com.zk.vpn.model.VlessConfig

object VlessParser {
    fun parse(link: String): VlessConfig {
        val uri = Uri.parse(link.trim())

        require(uri.scheme == "vless") {
            "Only vless:// links are supported"
        }

        val uuid = requireNotNull(uri.userInfo) {
            "Missing UUID"
        }
        val host = requireNotNull(uri.host) {
            "Missing server address"
        }
        val port = uri.port
        require(port in 1..65535) {
            "Invalid server port"
        }

        return VlessConfig(
            uuid = uuid,
            host = host,
            port = port,
            name = uri.fragment ?: "VLESS Server",
            security = uri.getQueryParameter("security") ?: "none",
            transport = uri.getQueryParameter("type") ?: "tcp",
            sni = uri.getQueryParameter("sni"),
            flow = uri.getQueryParameter("flow")
        )
    }
}
