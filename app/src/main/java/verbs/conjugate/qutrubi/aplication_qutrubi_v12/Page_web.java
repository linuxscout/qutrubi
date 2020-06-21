package verbs.conjugate.qutrubi.aplication_qutrubi_v12;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Toast;


public class Page_web extends Activity {

    private WebView mWebView;
 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.conjugue_web);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        mWebView = (WebView) findViewById(R.id.webview);
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        String lien =
     "http://qutrub.arabeyes.org/";
        //mWebView.loadUrl("http://qutrub.arabeyes.org/");
        mWebView.loadUrl(lien);
        mWebView.setWebViewClient(new MyAppWebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                //hide loading image
                //show webview
                findViewById(R.id.webview).setVisibility(View.VISIBLE);
            }
        });
    }

    @Override
    public void onBackPressed() {
        if(mWebView.canGoBack()) {
            mWebView.goBack();
        } else {
            super.onBackPressed();
        }
    }





}

