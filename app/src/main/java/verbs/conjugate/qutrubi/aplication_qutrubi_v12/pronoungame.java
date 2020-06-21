package verbs.conjugate.qutrubi.aplication_qutrubi_v12;

import android.app.Activity;
import android.database.Cursor;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import java.util.Random;

/**
 * Created by ahmed  and redouane on 16.
 */
public class pronoungame extends Activity {
    databasehelper databasehelper;
    TextView pronoun_type,pronoun_number,pronoun_nature;
    TextView pronoun_name_ana,pronoun_name_anta,pronoun_name_anti,pronoun_name_antoma,pronoun_name_antom,pronoun_name_antona,pronoun_name_nahno;
    TextView pronoun_name_howa,pronoun_name_hiya,pronoun_name_homa,pronoun_name_hom,pronoun_name_hona;

    private String result="";
    String  reponse="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      //  requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_pronoungame);
        databasehelper = new databasehelper(this);
        try {
            databasehelper.openDataBase();
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }

        pronoun_number=(TextView)findViewById(R.id.nembre);
        pronoun_nature=(TextView)findViewById(R.id.nature);
        pronoun_type=(TextView)findViewById(R.id.tvPr_type);

        pronoun_name_ana=(TextView)findViewById(R.id.ana);pronoun_name_nahno=(TextView)findViewById(R.id.nahno);
        pronoun_name_anta=(TextView)findViewById(R.id.anta);pronoun_name_anti=(TextView)findViewById(R.id.anti);
        pronoun_name_antoma=(TextView)findViewById(R.id.antouma);pronoun_name_antom=(TextView)findViewById(R.id.antom);
        pronoun_name_antona=(TextView)findViewById(R.id.Antona);pronoun_name_howa=(TextView)findViewById(R.id.howa);
        pronoun_name_hiya=(TextView)findViewById(R.id.hya);pronoun_name_homa=(TextView)findViewById(R.id.homa);
        pronoun_name_hom=(TextView)findViewById(R.id.home);pronoun_name_hona=(TextView)findViewById(R.id.hona);




        int id_type_aliatoir = GetId_redndom(1, 14);
        int id_numbre_aliatoir = GetId_redndom(1, 14);
        int id_nature_aliatoir =GetId_redndom(3, 14);



        String PronounNum = getPronounNumber(id_numbre_aliatoir);
        String PronounT = getPronounType(id_type_aliatoir);
        String ProunouNatur=getProunouNature(id_nature_aliatoir);


        if(PronounT.equals("متكلم")){
            ProunouNatur="";
            if(PronounNum.equals(getPronounNumber(5))){
                PronounNum="جمع";
            }
            pronoun_number.setText(PronounNum);
            pronoun_nature.setText(ProunouNatur);
            pronoun_type.setText(PronounT);


            Cursor cursor = databasehelper.quer("SELECT  pronoun_name FROM   pronouns  where  pronoun_type='" + pronoun_type.getText().toString() + "' and   pronoun_number='" + pronoun_number.getText().toString() + "' and  pronom_nature='" + pronoun_nature.getText().toString() + "'");

            if (cursor != null) {
                if (cursor.moveToFirst()) {
                    do {

                        result = cursor.getString(0);

                    } while (cursor.moveToNext());
                    //return result;
                    reponse=result;

                }
            }
        }else{
            pronoun_number.setText(PronounNum);
            pronoun_nature.setText(ProunouNatur);
            pronoun_type.setText(PronounT);

            Cursor cursor = databasehelper.quer("SELECT  pronoun_name FROM   pronouns  where  pronoun_type='" + pronoun_type.getText().toString() + "' and   pronoun_number='" + pronoun_number.getText().toString() + "' and  pronom_nature='" + pronoun_nature.getText().toString() + "'");
            if (cursor != null) {
                if (cursor.moveToFirst()) {
                    do {

                        result = cursor.getString(0);

                    } while (cursor.moveToNext());
                    //return result;
                    reponse=result;
                }
            }
        }
        // final String reponse= reponse_correct(PronounT, ProunouNatur, PronounNumb);

        pronoun_name_ana.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                String text= getpronoun(1);
                if(text.equals(reponse)){
                    good();
                }else{
                    faild();
                }

            }
        });
        pronoun_name_nahno.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String text= getpronoun(2);
                if(text.equals(reponse)){
                    good();
                }else{
                    faild();
                }

            }
        });
        pronoun_name_anta.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String text= getpronoun(3);
                if(text.equals(reponse)){
                    good();
                }else{
                    faild();
                }
            }
        });
        pronoun_name_anti.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String text= getpronoun(4);
                if(text.equals(reponse)){
                    good();
                }else{
                    faild();
                }
            }
        });
        pronoun_name_antoma.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String text1= getpronoun(5);String text2= getpronoun(6);
                if(text1.equals(reponse)|| text2.equals(reponse)){
                    good();
                }else{
                    faild();
                }
            }
        });
        pronoun_name_antom.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String text= getpronoun(7);
                if(text.equals(reponse)){
                    good();
                }else{
                    faild();
                }
            }
        });
        pronoun_name_antona.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String text= getpronoun(8);
                if(text.equals(reponse)){
                    good();
                }else{
                    faild();
                }
            }
        });
        pronoun_name_howa.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String text= getpronoun(9);
                if(text.equals(reponse)){
                    good();
                }else{
                    faild();
                }

            }
        });
        pronoun_name_hiya.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String text= getpronoun(10);
                if(text.equals(reponse)){
                    good();
                }else{
                    faild();
                }
            }
        });
        pronoun_name_homa.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                String text1= getpronoun(11);String text2= getpronoun(12);
                if(text1.equals(reponse)||text2.equals(reponse)){
                    good();
                }else{
                    faild();
                }
            }
        });
        pronoun_name_hom.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String text= getpronoun(13);
                if(text.equals(reponse)){
                    good();
                }else{
                    faild();
                }
            }
        });
        pronoun_name_hona.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String text= getpronoun(14);
                if(text.equals(reponse)){
                    good();
                }else{
                    faild();
                }
            }
        });




    }

    public void good(){
        ImageView im= new ImageView(this);
        im.setImageResource(R.drawable.avantage);
        Animation anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in);
        im.startAnimation(anim);
        MediaPlayer mediaPlayer=MediaPlayer.create(pronoungame.this,R.raw.you_are_good);
        mediaPlayer.start();
        result="";
        reponse="";
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        onCreate(new Bundle());
    }
    public void faild(){
        ImageView im= new ImageView(this);
        im.setImageResource(R.drawable.inconv);
        Animation anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in);
        im.startAnimation(anim);
        MediaPlayer mediaPlayer=MediaPlayer.create(pronoungame.this, R.raw.hawil);
        mediaPlayer.start();
        im.setVisibility(View.INVISIBLE);
    }

    public String getPronounType(int id) {



        String pronountype="";

        Cursor cursor = databasehelper.quer("SELECT pronoun_type FROM   pronouns where idpronouns = "+id+"");

        if(cursor!=null)
        {
            if (cursor.moveToFirst())
            {
                do {
                    pronountype = cursor.getString(0);
                } while (cursor.moveToNext());
            }
        }
        return pronountype;
    }
    public String getPronounNumber(int id) {

        String pronounnumber="";

        Cursor cursor = databasehelper.quer("SELECT pronoun_number FROM  pronouns  where idpronouns= " + id + " ");

        if(cursor!=null)
        {
            if (cursor.moveToFirst())
            {
                do {


                    pronounnumber = cursor.getString(0);



                } while (cursor.moveToNext());
            }
        }
        return pronounnumber;
    }
    public String getProunouNature(int id ) {



        String prounounature = "";

        Cursor cursor = databasehelper.quer("SELECT pronom_nature FROM   pronouns where idpronouns = " + id + " ");

        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    prounounature = cursor.getString(0);
                } while (cursor.moveToNext());
            }
        }
        return prounounature;
    }



    public static int GetId_redndom(int min, int max) {

        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;

        return randomNum;
    }


    public void butt_back(View view) {
        databasehelper.close();
        this.finish();
    }



    public String getpronoun(int id){
        String prounouname="";

        Cursor cursor = databasehelper.quer("SELECT pronoun_name FROM   pronouns where idpronouns = " + id + "");

        if(cursor!=null)
        {
            if (cursor.moveToFirst())
            {
                do {
                    prounouname = cursor.getString(0);
                } while (cursor.moveToNext());
            }
        }
        return prounouname;
    }


    public void butt_tryagain(View view) {
        onCreate(new Bundle());
    }
}

