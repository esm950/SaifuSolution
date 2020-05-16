package com.powerbank.saifusolution

import android.net.http.SslError
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.*
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_webview.*

class WebviewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_webview)

        initWebView()
    }

    private fun initWebView() {
        val url = "https://light.microsite.perxtech.io/game/2?token=${BuildConfig.PERX_TOKEN}"
        webview.run {
            webViewClient = object : WebViewClient() {
                override fun onPageFinished(view: WebView?, url: String?) {
                    super.onPageFinished(view, url)
                    Toast.makeText(this@WebviewActivity, "Loaded $url", Toast.LENGTH_SHORT).show()
                }

                override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                    view?.loadUrl(url)
                    return true
                }
            }
        }
        webview.loadUrl(url)
    }
}
