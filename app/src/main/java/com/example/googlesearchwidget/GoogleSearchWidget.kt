package com.example.googlesearchwidget

import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.content.Intent
import android.widget.RemoteViews


/**
 * Implementation of App Widget functionality.
 */
class GoogleSearchWidget : AppWidgetProvider() {
    // 保存 widget 的id的HashSet，每新建一个 widget 都会为该 widget 分配一个 id。
    private val idsSet = HashSet<Int>()
    companion object {
        const val ACTION_UPDATE = "action_update"
    }

    override fun onUpdate(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetIds: IntArray
    ) {
        //此方法可以按 AppWidgetProviderInfo 中的 updatePeriodMillis 属性定义的时间间隔来更新应用微件
        for (appWidgetId in appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId)
            idsSet.add(appWidgetId)  //更新控件存储 appWidgetId
        }
    }

    override fun onEnabled(context: Context) {
        // 首次创建应用微件的实例时，会调用此方法。
    }

    override fun onDisabled(context: Context) {
        // 从应用微件托管应用中删除了应用微件的最后一个实例时，会调用此方法。
    }

    override fun onReceive(context: Context, intent: Intent?) {
        super.onReceive(context, intent)

        if (intent?.action.equals(ACTION_UPDATE)) {
            updateAllAppWidgets(context, AppWidgetManager.getInstance(context))
        }
    }

    /**
     * 更新所有widget
     */
    private fun updateAllAppWidgets(context: Context, appWidgetManager: AppWidgetManager) {
        idsSet.forEach {
            val views = RemoteViews(context.packageName, R.layout.google_search_widget)
            appWidgetManager.updateAppWidget(it, views) // 更新 widget
        }
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