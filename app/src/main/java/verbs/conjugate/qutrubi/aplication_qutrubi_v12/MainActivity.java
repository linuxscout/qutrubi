package verbs.conjugate.qutrubi.aplication_qutrubi_v12;
/*
 * Created by ahmed and redouane on 2016.
 */



import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.FragmentManager;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.text.Layout;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Currency;
import java.util.Locale;

public class MainActivity extends Activity {
/*
 * this class allows you to build the home page
 * and link with an XML file
 */


    private databasehelper dbhelp;
    private Context context;
    private ProgressDialog progressdialog;
    private DrawerLayout menu_layout ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);

        context = this;


        ImageView image = (ImageView) findViewById(R.id.img_view);

       // Button menu = (Button) findViewById(R.id.menu_button);
/*
        ImageButton   share=(ImageButton)findViewById(R.id.butt_share);
        ImageButton      fb=(ImageButton)findViewById(R.id.butt_fb);
        ImageButton       info=(ImageButton)findViewById(R.id.butt_information);
        ImageButton       setting=(ImageButton)findViewById(R.id.butt_setting);
*/
        Button start = (Button) findViewById(R.id.butt_start);
        Button games = (Button) findViewById(R.id.butt_games);
        Button exit = (Button) findViewById(R.id.butt_exit);
        Button menuu = (Button) findViewById(R.id.menuu) ;

        // DrawerLayout
        menu_layout = (DrawerLayout) findViewById(R.id.menu_layout);

        // DrawerLayout option
        final RelativeLayout meni = (RelativeLayout) findViewById(R.id.meni);
        // button option
        Button sher = (Button) findViewById(R.id.sher);
        Button fabpage = (Button) findViewById(R.id.fbpage);
        Button setting = (Button) findViewById(R.id.setting);
        Button about = (Button) findViewById(R.id.about);






        Animation anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.blink);
        image.startAnimation(anim);

        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.myanimation);
        start.startAnimation(animation);

        Animation animation1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.myanimation1);
        games.startAnimation(animation1);

        Animation animation2 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.myanimation2);
        exit.startAnimation(animation2);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Conjugate.class);
                startActivity(intent);
            }
        });

        games.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Games.class);
                startActivity(intent);
            }
        });

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fr = getFragmentManager();
                alert_exit st = new alert_exit();
                st.show(fr, null);
            }
        });

        menuu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menu_layout.openDrawer(meni);
            }
        });

        dbhelp=new databasehelper(this);

        boolean   is_chekef =dbhelp.chekdatabase();
        if(is_chekef==false) {
            start_copy_data();
        }

        //------------------------------------------------------
/*
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                LayoutInflater mymenu = getLayoutInflater();
                View myview = mymenu.inflate(R.layout.activity_menu, (ViewGroup) findViewById(R.id.menulayout));
                TextView sher = (TextView) myview.findViewById(R.id.sher);
                TextView fabpage = (TextView) myview.findViewById(R.id.fbpage);
                TextView setting = (TextView) myview.findViewById(R.id.setting);
                TextView about = (TextView) myview.findViewById(R.id.about);


                final Toast toast = new Toast(getApplicationContext());
                toast.setGravity(Gravity.LEFT, 0, -500);
                toast.setDuration(Toast.LENGTH_SHORT);
                toast.setView(myview);
                toast.show();

                sher.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        toast.cancel();


                        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                        sharingIntent.setType("text/plain");
                        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Qutrubi");
                        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, getString(R.string.sharMessage) + " https://www.facebook.com/Qutrub/ ");
                        Toast.makeText(MainActivity.this, String.valueOf("f"), Toast.LENGTH_LONG).show();


                        startActivity(Intent.createChooser(sharingIntent, getString(R.string.sharIt)));


                    }
                });

                fabpage.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        toast.cancel();
                        startActivity(new Intent(Intent.ACTION_VIEW,
                                Uri.parse("https://web.facebook.com/Qutrubi")));

                    }
                });

                setting.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        toast.cancel();
                        FragmentManager fr = getFragmentManager();
                        setting_dialog st = new setting_dialog();
                        st.show(fr, null);

                    }
                });

                about.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        toast.cancel();
                        Intent intent = new Intent(MainActivity.this, about_qutrub.class);
                        startActivity(intent);
                    }
                });
            }});*/
    }

        /*    public void Start_conjugate(View view) {
                Intent intent = new Intent(MainActivity.this, Conjugate.class);
                startActivity(intent);
            }

            public void Start_games(View view) {
                Intent intent = new Intent(MainActivity.this, Games.class);
                startActivity(intent);
            }

            public void Exit_application(View view) {

                FragmentManager fr = getFragmentManager();
                alert_exit st = new alert_exit();
                st.show(fr, null);

            }*/


    public void setting(View view) {
        FragmentManager fr=getFragmentManager();
        setting_dialog st=new setting_dialog();
        st.show(fr,null);

    }

    public void facebook_butt(View view) throws MalformedURLException {
         //  https://www.facebook.com/Qutrab/?ref=aymt_homepage_panel
            URL   url = new URL("https://web.facebook.com/Qutrubi/");
Uri uri=Uri.parse(String.valueOf(url));
            Intent in = new Intent(Intent.ACTION_VIEW,uri);
            startActivity(in);

    }

    public void share_butt(View view) {


        Intent sharingIntent = new Intent(Intent.ACTION_SEND);
        Intent tn=new Intent(Intent.EXTRA_SHORTCUT_ICON_RESOURCE);
        tn.putExtra(Intent.EXTRA_ORIGINATING_URI,R.drawable.about_icon);

        sharingIntent.setType("text/plain");
        sharingIntent.putExtra(Intent.EXTRA_SUBJECT, "Qutrubi");
        sharingIntent.putExtra(Intent.EXTRA_TEXT, getString(R.string.sharMessage) + " http://www.alecsoapps.com/site/store/science/524-/ ");



        startActivity(Intent.createChooser(sharingIntent, getString(R.string.sharIt)));



    }

    public void information_butt(View view) {
        Intent intent=new Intent(this,about_qutrub.class);
        startActivity(intent);

    }

    private void start_copy_data(){


        AsyncTask<Void, Void, Void> task = new AsyncTask<Void, Void, Void>() {

            @Override
            protected void onPreExecute() {
                progressdialog = new ProgressDialog(context);
                progressdialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                progressdialog.setMessage(getString(R.string.loading));
                progressdialog.setCancelable(false);
                progressdialog.setIndeterminate(true);
                progressdialog.show();
            }

            @Override
            protected Void doInBackground(Void... arg0) {
                try {
                    try{

                        dbhelp.chekandcopy();
                        //  dbhelp.openDataBase();
                    }catch (Exception e){

                    }
                    if(dbhelp.chekdatabase()==true){
                        Thread.sleep(0);}
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onPostExecute(Void result) {
                if (progressdialog != null) {
                    progressdialog.dismiss();
                    //start.setEnabled(true);
                }
            }

        };
        task.execute((Void[]) null);




    }

}