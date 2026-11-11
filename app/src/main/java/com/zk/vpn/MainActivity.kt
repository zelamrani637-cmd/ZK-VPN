package com.zk.vpn

import android.app.Activity
import android.os.Bundle
import android.graphics.Color
import android.view.Gravity
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import com.zk.vpn.core.VlessParser

class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val root = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            gravity = Gravity.CENTER
            setPadding(32, 32, 32, 32)
            setBackgroundColor(Color.rgb(16, 19, 27))
        }

        val title = TextView(this).apply {
            text = "ZK VPN"
            textSize = 30f
            setTextColor(Color.WHITE)
            gravity = Gravity.CENTER
        }

        val input = EditText(this).apply {
            hint = "Paste your VLESS link"
            setTextColor(Color.WHITE)
            setHintTextColor(Color.LTGRAY)
            setSingleLine(false)
        }

        val result = TextView(this).apply {
            text = "Ready — VLESS link validation only"
            textSize = 16f
            setTextColor(Color.LTGRAY)
            setPadding(0, 24, 0, 24)
        }

        val checkButton = Button(this).apply {
            text = "CHECK VLESS LINK"
            setOnClickListener {
                try {
                    val config = VlessParser.parse(input.text.toString())
                    result.text = "Valid link format\\nServer: ${config.host}\\nPort: ${config.port}\\nName: ${config.name}\\n\\nXray engine is not connected yet."
                    result.setTextColor(Color.GREEN)
                } catch (error: Exception) {
                    result.text = "Invalid link: ${error.message ?: "Unknown error"}"
                    result.setTextColor(Color.RED)
                }
            }
        }

        root.addView(title)
        root.addView(input, LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        ).apply { topMargin = 32 })
        root.addView(checkButton)
        root.addView(result)

        setContentView(root)
    }
}
