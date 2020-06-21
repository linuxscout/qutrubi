package verbs.conjugate.qutrubi.aplication_qutrubi_v12;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;


import java.net.MalformedURLException;
import java.net.URL;

/**
 /**
 * Created by root on 14/04/16.
 */
public class about_qutrub extends Activity{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.about_activity);


        TextView  back = (TextView) findViewById(R.id.Back1);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        TextView email=(TextView)findViewById(R.id.about9);
        TextView blog=(TextView)findViewById(R.id.about11);
        TextView qutrub=(TextView)findViewById(R.id.about13);

        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent sharingIntent = new Intent(Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                sharingIntent.putExtra(Intent.EXTRA_SUBJECT, "Qutrubi");
                sharingIntent.putExtra(Intent.EXTRA_SHORTCUT_NAME, "qutrubi@gmail.com");
                //   sharingIntent.putExtra(Intent.EXTRA_EMAIL,"qutrubi@gmail.com");

                startActivity(Intent.createChooser(sharingIntent, "share it"));

            }
        });

        blog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                URL url = null;
                try {
                    url = new URL("http://qutrubi.blogspot.com");
                    Uri uri = Uri.parse(String.valueOf(url));
                    Intent in = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(in);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }


            }
        });

        qutrub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(about_qutrub.this,Page_web.class );
                startActivity(intent);
            }
        });
    }
}