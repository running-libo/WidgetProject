package com.example.googlesearchwidget

import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.widget.RemoteViews

/**
 * Implementation of App Widget functionality.
 */
class GoogleSearchWidget : AppWidgetProvider() {

    override fun onUpdate(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetIds: IntArray
    ) {
        //此方法可以按 AppWidgetProviderInfo 中的 updatePeriodMillis 属性定义的时间间隔来更新应用微件
        for (appWidgetId in appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId)
        }
    }

    override fun onEnabled(context: Context) {
        // 首次创建应用微件的实例时，会调用此方法。
    }

    override fun onDisabled(context: Context) {
        // 从应用微件托管应用中删除了应用微件的最后一个实例时，会调用此方法。
    }
}

internal fun updateAppWidget(
    context: Context,
    appWidgetManager: AppWidgetManager,
    appWidgetId: Int
) {
    val views = RemoteViews(context.packageName, R.layout.google_search_widget)

    appWidgetManager.updateAppWidget(appWidgetId, views)
}