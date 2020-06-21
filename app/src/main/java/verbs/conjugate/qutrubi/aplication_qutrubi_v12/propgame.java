package verbs.conjugate.qutrubi.aplication_qutrubi_v12;

import android.app.Activity;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import java.util.Random;

public class propgame extends Activity {
    TextView verbs, trilitaire, intrilitaire, trasitiv, intransitiv, mithal, ajouf,
            maksour, sahihe, mahmouz, modaef, lafifmakroun , lafifmafrouk,result;
    databasehelper databasehelper;
    verbs_prop verbs_prop;
    String museur,nature_sahih,nature_ilat;
    String transitivit;
    String vocalized;
    int note=0;
    boolean clicked_mus=true;
    boolean clicked_tras=true;
    boolean clicked_type=true;
    public static final  String hamza="أ";
    public static final  String hamza1="ء";
    public static final  String hamza2="ئ";
    public static final  String hamza3="ؤ";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_propgame);
        databasehelper = new databasehelper(this);
        try {
            databasehelper.openDataBase();
        } catch (Exception e) {
            e.printStackTrace();
        }


        verbs_prop = new verbs_prop();
        int id_verbs =GetId_redndom(0, 5999);
        vocalized =getVerb(id_verbs);
        transitivit=getTasitivit(id_verbs);

        String unvolcalized = delet_techkil(vocalized);

        museur = verbs_prop.is_trilitaire(unvolcalized);
        nature_sahih=verbs_prop.Noua_Sahih(unvolcalized,root_hamza(id_verbs));
        nature_ilat=verbs_prop.NouA_ila(unvolcalized);
        verbs =(TextView)findViewById(R.id.verbs_id);
        verbs.setText(vocalized);
        trilitaire =(TextView)findViewById(R.id.trilaire);






        intrilitaire =(TextView)findViewById(R.id.intrilitare);
        trasitiv =(TextView)findViewById(R.id.trasitiv);
        intransitiv =(TextView)findViewById(R.id.intanstiv);
        mithal =(TextView)findViewById(R.id.mithal);
        ajouf =(TextView)findViewById(R.id.ajouf);
        maksour =(TextView)findViewById(R.id.maksour);
        sahihe =(TextView)findViewById(R.id.sahihe);
        mahmouz =(TextView)findViewById(R.id.mahmoue);
        modaef =(TextView)findViewById(R.id.moudaef);
        lafifmafrouk =(TextView)findViewById(R.id.lafif_mafrok);
        lafifmakroun =(TextView)findViewById(R.id.lafif_makron);
        result =(TextView)findViewById(R.id.result);


        /*
        ajouter les Id
         */



        trilitaire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(clicked_mus==true) {
                    if (museur.equals("ثلاثي")) {
                        if (note < 3) {
                            note += 1;
                            result.setText(note + " من 3");
                        }
                        good();
                    }else{      faild();
                    }
                    clicked_mus=false;
                }
            }
        });


        intrilitaire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(clicked_mus==true) {
                    if (museur.equals("غير ثلاثي")) {
                        if (note < 3) {
                            note += 1;
                            result.setText(note + " من 3");
                        }
                        good();
                    } else {
                        faild();
                    }
                    clicked_mus=false;
                }
            }
        });
        trasitiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(clicked_tras==true) {
                    if (transitivit.equals("متعدي")) {

                        if (note < 3) {
                            note += 1;
                            result.setText(note + " من 3");
                        }
                        good();
                    } else {
                        faild();
                    }
                    clicked_tras=false;
                }
            }
        });



        intransitiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (clicked_tras==true) {
                    if (transitivit.equals("لازم")) {
                        if (note < 3) {
                            note += 1;
                            result.setText(note + " من 3");
                        }
                        good();
                    } else {
                        faild();
                    }
                    clicked_tras = false;
                }
            }
        });

        ajouf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (clicked_type==true) {
                    if (nature_ilat.equals("أجوف")) {
                        if (note < 3) {
                            note += 1;
                            result.setText(note + " من 3");
                        }
                        good();
                    } else {
                        faild();
                    }
                    clicked_type = false;
                }
            }
        });


        mithal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (clicked_type==true) {
                    if (nature_ilat.equals("مثال")) {
                        if (note < 3) {
                            note += 1;
                            result.setText(note + " من 3");
                        }
                        good();
                    } else {
                        faild();
                    }
                    clicked_type=false;
                }
            }
        });

        maksour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (clicked_type==true) {
                    if (nature_ilat.equals("مقصور")) {
                        if (note < 3) {
                            note += 1;
                            result.setText(note + " من 3");;
                        }
                        good();
                    } else {
                        faild();
                    }
                    clicked_type = false;
                }
            }
        });




        sahihe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (clicked_type==true) {
                    if (nature_sahih.equals("سالم")) {
                        if (note < 3) {
                            note += 1;
                            result.setText(note + " من 3");
                        }
                        good();
                    } else {
                        faild();
                    }
                    clicked_type = false;
                }
            }
        });

        modaef.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (clicked_type==true) {
                    if (nature_sahih.equals("مضاعف")) {
                        if (note < 3) {
                            note += 1;
                            result.setText(note + " من 3");
                        }
                        good();
                    } else {
                        faild();
                    }
                    clicked_type = false;
                }
            }
        });




        mahmouz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (clicked_type==true) {
                    if (nature_sahih.equals("مهموز")) {
                        if (note < 3) {
                            note += 1;
                            result.setText(note + " من 3");
                        }
                        good();
                    } else {
                        faild();
                    }
                    clicked_type = false;
                }
            }
        });

        lafifmafrouk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (clicked_type==true) {
                    if (nature_sahih.equals("لفيف مفروق")) {
                        if (note < 3) {
                            note += 1;
                            result.setText(note + " من 3");
                        }
                        good();
                    } else {
                        faild();
                    }
                    clicked_type = false;
                }
            }
        });


        lafifmakroun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (clicked_type==true) {
                    if (nature_sahih.equals("لفيف مقرون")) {
                        if (note < 3) {
                            note += 1;
                            result.setText(note + " من 3");
                        }
                        good();
                    } else {
                        faild();
                    }
                    clicked_type = false;
                }
            }
        });


    }
    public static int GetId_redndom(int min, int max) {

        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;

        return randomNum;
    }

    public String getVerb(int newid){
        String vocalized="";

        Cursor cursor = databasehelper.quer("SELECT vocalized FROM  verbs where idverbs = " + newid +"");

        if(cursor!=null)
        {
            if (cursor.moveToFirst())
            {
                do {
                    vocalized = cursor.getString(0);
                } while (cursor.moveToNext());
            }
        }
        return vocalized;
    }


    public void good(){
        MediaPlayer mediaPlayer=MediaPlayer.create(propgame.this,R.raw.corr);
        mediaPlayer.start();


    }
    public void faild(){

        MediaPlayer mediaPlayer=MediaPlayer.create(propgame.this, R.raw.wrong);
        mediaPlayer.start();

    }

    public String getTasitivit (int id){
        String trans="";
        Cursor cur = databasehelper.quer("SELECT trans  FROM verbs where verbs.idverbs= '" + id + "'");

        if (cur != null) {
            if (cur.moveToFirst()) {
                do {
                    trans = cur.getString(0);


                } while (cur.moveToNext());
                if(trans.equals("ل")){
                    trans="لازم"  ;
                }else {
                    trans="متعدي";
                }
                return trans;


            }
        }


        return null;



    }

    public String delet_techkil (String verbe){
        String new_verbs="";
        String []verbe_partager=verbe.split("");
        for(int i =0;i<verbe_partager.length;i++){
            if (verbe_partager[i].equals("َ")||verbe_partager[i].equals("ُ")||verbe_partager[i].equals("ْ")||verbe_partager[i].equals("ِ")||verbe_partager[i].equals("َُ")||verbe_partager[i].equals("ُُ")||verbe_partager[i].equals("ََ")||verbe_partager[i].equals("ِِ")){
                verbe_partager[i]="";
            }
            new_verbs +=(verbe_partager[i]);

        }

        return new_verbs;
    }





    public void button_back(View view) {
        databasehelper.close();
        finish();
    }

    private String root_verbs(int id_verbs) {


        databasehelper dbhelp=new databasehelper(getApplicationContext());


        try {

            // dbhelp.chekandcopy();
            dbhelp.openDataBase();
        } catch (Exception e) {
        }

        Cursor cur = dbhelp.quer("SELECT root FROM verbs where verbs.idverbs= '" + id_verbs+ "'");

        String  root = null;
        if (cur != null) {
            if (cur.moveToFirst()) {
                do {

                    root = cur.getString(0);

                } while (cur.moveToNext());
                return root;
            }

        }

        return "";
    }

    public boolean root_hamza(int id) {
        String verb = root_verbs(id);
        String[] verbs_char = verb.split("");
        for (int i = 0; i < verbs_char.length; i++) {
            if (verbs_char[i].equals(hamza) || verbs_char[i].equals(hamza1) || verbs_char[i].equals(hamza2) || verbs_char[i].equals(hamza3)) {

                return true;
            }
        }return false;
    }

    public void but_again(View view) {
        try {
            Thread.sleep(2000);
        }catch (Exception e){}
        note=0; clicked_type=true;clicked_mus=true;clicked_tras=true;

        onCreate(new Bundle());
    }
}