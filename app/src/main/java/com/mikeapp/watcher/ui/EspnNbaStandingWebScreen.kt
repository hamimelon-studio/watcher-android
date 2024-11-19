package com.mikeapp.watcher.ui

import android.webkit.WebView
import androidx.compose.runtime.Composable
import androidx.compose.ui.viewinterop.AndroidView

@Composable
fun EspnNbaStandingWebScreen() {
//    val url = "https://www.espn.com.au/nba/standings"
//    val url = "https://www.woolworths.com.au/shop/productdetails/586813"
    val url = "https://steamdb.info/app/1840080/"
    val scrollY = 3000
    AndroidView(
        factory = { context ->
            WebView(context).apply {
                settings.javaScriptEnabled = true
                loadUrl(url)
            }
        },
        update = { webView ->
            // Scroll to the desired position after the content is loaded
            webView.post {
                webView.scrollTo(0, scrollY)
            }
        }
    )
}