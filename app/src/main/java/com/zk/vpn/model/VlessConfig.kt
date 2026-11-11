package com.zk.vpn.model

data class VlessConfig(
    val uuid: String,
    val host: String,
    val port: Int,
    val name: String,
    val security: String,
    val transport: String,
    val sni: String?,
    val flow: String?
)
