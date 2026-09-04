package ru.hmao.pomoshchnik;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.webkit.CookieManager;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends Activity {
    private WebView webView;

    private static final String THEME_CSS =
        ":root{--b:#0a0a0f!important;--g:#ff2d95!important;--bg:#08090d!important;--line:#2a2030!important;--mut:#a99cae!important;--txt:#f8f5fa!important}" +
        "html,body{background:radial-gradient(circle at 85% 0,#3a102d 0,transparent 28%),radial-gradient(circle at 0 100%,#211126 0,transparent 30%),#08090d!important;color:#f8f5fa!important}" +
        ".auth{background:radial-gradient(circle at 25% 15%,#57133f 0,transparent 35%),radial-gradient(circle at 90% 90%,#24102f 0,transparent 35%),linear-gradient(135deg,#050508,#0d0910)!important}" +
        ".brand span,.logo span{color:#ff2d95!important;text-shadow:0 0 18px #ff2d9588}" +
        ".box,.hero,.card,.panel,.req,.combo-card{background:linear-gradient(180deg,#151117,#0f0c11)!important;border-color:#332436!important;color:#fff!important;box-shadow:0 14px 40px #0007!important}" +
        ".tabs button{background:#1d1820!important;color:#b9aebc!important}.tabs .on,.primary,.tabs2 button.on{background:linear-gradient(135deg,#ff2d95,#d6006f)!important;color:#fff!important;box-shadow:0 8px 24px #ff2d9540!important}" +
        ".box input,.filters select,.filters input,.qc-filters select,.qc-filters input,.combo input,.combo select,.trainbar input,.req-controls select{background:#0d0b10!important;border-color:#3b2a3e!important;color:#fff!important}" +
        ".side{background:linear-gradient(180deg,#09090d 0%,#120b13 55%,#1b0c17 100%)!important;border-right:1px solid #2b1f2d!important}" +
        ".nav button.on,.nav button:hover{background:linear-gradient(90deg,#ff2d95,#c70068)!important;box-shadow:0 8px 22px #ff2d9530!important}" +
        ".top{background:#0e0c11ee!important;border-bottom-color:#2b1f2d!important;color:#fff!important;backdrop-filter:blur(14px)}.top button{background:#171219!important;border-color:#38273b!important;color:#fff!important}" +
        ".hero h1{color:#fff!important;text-shadow:0 0 30px #ff2d9540!important}.card strong,.combo-grid b{color:#ff55ab!important}" +
        ".months button,.actions button,.tabs2 button,.traintabs button{background:#151117!important;border-color:#3a293d!important;color:#fff!important}.months button:hover,.actions button:hover,.traintabs button:hover{border-color:#ff2d95!important;color:#ff64b2!important}" +
        ".filters{background:#111014!important;border-color:#332436!important}.tbl,.traintable{background:#0f0d11!important;border-color:#332436!important}.row,.tm,.office{border-color:#261d28!important}.cell{border-right-color:#261d28!important}.tm,.office{background:#111014!important;color:#fff!important}" +
        ".off{background:#1c1a20!important;color:#918895!important}" +
        ".qc-wrap{background:radial-gradient(circle at 12% 0,#421334 0,transparent 35%),radial-gradient(circle at 100% 10%,#281139 0,transparent 33%),#08090d!important;color:#fff!important}" +
        ".qc-hero h1{background:linear-gradient(90deg,#fff 0%,#ff7abd 42%,#ff2d95 76%,#d90072)!important;background-clip:text!important;-webkit-background-clip:text!important;color:transparent!important;text-shadow:0 0 40px #ff2d9526!important}.qc-eyebrow{color:#ff5bad!important}.qc-sub,.qc-filters label,.qc-title span,.qc-score p,.qc-meta{color:#a99cae!important}" +
        ".qc-summary{background:#121014!important;box-shadow:0 18px 55px #0008!important;border:1px solid #342237!important}.qc-summary article{border-left-color:#2f2231!important}.qc-summary small,.qc-summary article span{color:#a99cae!important}.qc-summary .total{background:linear-gradient(135deg,#ff2d95,#9d004f)!important}.qc-summary .total small,.qc-summary .total span{color:#fff!important}" +
        ".qc-score div,.qc-card{background:linear-gradient(180deg,#151117,#0e0c10)!important;border-color:#332436!important;box-shadow:0 14px 40px #0007!important}.qc-score b,.qc-tm{color:#ff4da7!important}.qc-card-head{background:linear-gradient(120deg,#1b111a,#101016)!important}.qc-request{background:#301226!important;color:#ff7abd!important}.qc-check{border-bottom-color:#2a202c!important}.qc-comment{background:#22151d!important;color:#e6c8d8!important;border:1px solid #3f2835!important}" +
        ".qc-yes{background:#15352c!important;color:#64e7b4!important}.qc-no{background:#401824!important;color:#ff7894!important}.qc-na{background:#232128!important;color:#aaa2af!important}" +
        ".combo-controls,.trainhero{background:#111014!important;border:1px solid #332436!important}.combo-head{background:linear-gradient(105deg,#351229,#1b1019)!important;color:#ff7abd!important}.combo-grid div{background:#19141b!important;color:#ddd1df!important;border-color:#332436!important}" +
        ".traintabs button.on{background:linear-gradient(135deg,#ff2d95,#c70068)!important}.traintable th{background:#19141b!important;color:#fff!important}.traintable td,.traintable th{border-color:#2b202d!important}" +
        ".req-hidden label{background:#171219!important;border-color:#39283c!important;color:#ddd!important}.approve,.saveaccess{background:linear-gradient(135deg,#ff2d95,#d0006a)!important;color:#fff!important}.reject{background:#3c1822!important;color:#ff9bb0!important}" +
        ".status.pending{background:#3a2a14!important;color:#ffd166!important}.status.approved{background:#15352c!important;color:#6de8b8!important}.status.rejected{background:#401824!important;color:#ff7894!important}.mut{color:#a99cae!important}" +
        "::-webkit-scrollbar{width:10px;height:10px}::-webkit-scrollbar-thumb{background:#3b2639;border-radius:99px}::-webkit-scrollbar-thumb:hover{background:#ff2d95}";

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        webView = new WebView(this);
        webView.setBackgroundColor(Color.rgb(8, 9, 13));
        setContentView(webView);

        CookieManager.getInstance().setAcceptCookie(true);
        CookieManager.getInstance().setAcceptThirdPartyCookies(webView, true);

        WebSettings s = webView.getSettings();
        s.setJavaScriptEnabled(true);
        s.setDomStorageEnabled(true);
        s.setDatabaseEnabled(true);
        s.setCacheMode(WebSettings.LOAD_DEFAULT);
        s.setUseWideViewPort(true);
        s.setLoadWithOverviewMode(false);
        s.setBuiltInZoomControls(false);
        s.setDisplayZoomControls(false);
        s.setMediaPlaybackRequiresUserGesture(false);
        s.setMixedContentMode(WebSettings.MIXED_CONTENT_COMPATIBILITY_MODE);

        webView.setWebChromeClient(new WebChromeClient());
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                injectTheme();
            }
        });

        if (savedInstanceState == null) {
            webView.loadUrl("https://pomoshchnik-hmao.vercel.app/");
        } else {
            webView.restoreState(savedInstanceState);
        }
    }

    private void injectTheme() {
        String safeCss = THEME_CSS.replace("\\", "\\\\").replace("'", "\\'").replace("\n", " ");
        String js = "(function(){var s=document.getElementById('hmao-black-pink-theme');if(!s){s=document.createElement('style');s.id='hmao-black-pink-theme';document.head.appendChild(s);}s.textContent='" + safeCss + "';document.documentElement.style.background='#08090d';document.body.style.backgroundColor='#08090d';})();";
        webView.evaluateJavascript(js, null);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        webView.saveState(outState);
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onBackPressed() {
        if (webView.canGoBack()) webView.goBack(); else super.onBackPressed();
    }
}
