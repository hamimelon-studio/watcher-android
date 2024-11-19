package com.mikeapp.watcher.ui

import android.webkit.JavascriptInterface
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.runtime.Composable
import androidx.compose.ui.viewinterop.AndroidView

@Composable
fun WoolworthsWebScreen(onDataExtracted: (String) -> Unit) {
    val url = "https://www.woolworths.com.au/shop/productdetails/586813"
    AndroidView(
        factory = { context ->
            WebView(context).apply {
                settings.javaScriptEnabled = true
                addJavascriptInterface(
                    object {
                        @JavascriptInterface
                        fun sendData(data: String) {
                            onDataExtracted(data) // Pass data back to Compose
                        }
                    },
                    "AndroidInterface"
                )
                webViewClient = object : WebViewClient() {
                    override fun onPageFinished(view: WebView?, url: String?) {
                        super.onPageFinished(view, url)
                        // Execute JavaScript to extract data
                        view?.evaluateJavascript(
                            """
                            (function() {
                                var data = document.body.innerText; // Example: Extract body text
                                AndroidInterface.sendData(data); // Send data to Android
                            })();
                            """.trimIndent(),
                            null
                        )
                    }
                }
                loadUrl(url)
            }
        }
    )
}