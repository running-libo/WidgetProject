package com.example.googlesearchwidget

import android.appwidget.AppWidgetManager
import android.content.ComponentName
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<TextView>(R.id.tv_add_shortcut).setOnClickListener {
            createDeskTopWidget()
        }
    }

    /**
     * 动态向桌面添加widget
     */
    fun createDeskTopWidget() {
        val serviceComponent = ComponentName(baseContext, GoogleSearchWidget::class.java)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            AppWidgetManager.getInstance(baseContext).requestPinAppWidget(serviceComponent, null, null)
        }
    }
}