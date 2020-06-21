package verbs.conjugate.qutrubi.aplication_qutrubi_v12;

import android.app.Activity;
import android.content.Intent;
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


import java.sql.SQLException;
import java.util.Random;

/**
 * Created by ahmed  and redouane on 16.
 */
public class verbsgame extends Activity {

    TextView tvtens,tvpronouns,tvverbs, suge1,suge2, suge3,head;
    databasehelper databasehelper;

    String  verb_correct="لا يوجد";
    String sug1="لا يوجد";
    String sug="لا يوجد";



   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      // requestWindowFeature(Window.FEATURE_NO_TITLE);
       setContentView(R.layout.activity_verbsgame);
            databasehelper = new databasehelper(this);
       try {
           databasehelper.openDataBase();
       } catch (SQLException e) {
           e.printStackTrace();
       }




       final ImageView im=(ImageView)findViewById(R.id.imagerep);

            suge1=(TextView) findViewById(R.id.tvsuge1);
            suge2=(TextView) findViewById(R.id.tvsuge2);
            suge3=(TextView) findViewById(R.id.tvsuge3);
            tvverbs =(TextView) findViewById(R.id.vtverb);
            tvtens=(TextView) findViewById(R.id.tvtens);
            tvpronouns = (TextView) findViewById(R.id.tvpronoun);
       head = (TextView) findViewById(R.id.text_head);

       int newid_tens=GetId_redndom(1, 12);
       int newid_pro = GetId_redndom(1, 14);

      // int id_verbs_aliatoir = GetId_redndom(0, 5999);
       int id_tense_aliatoir = GetId_redndom(1, 12);
       int id_pronouns_aliatoir =GetId_redndom(1, 14);

/////////////////////////////////////////////////////////
       Cursor cursor = databasehelper.quer("SELECT unvocalized FROM  verbs");
       Cursor cursor2= databasehelper.quer("SELECT idverbs FROM verbs");
       String[] allverbs=new String[1522];
       int[] allidverbs=new int[1522];

       String[] ar1=   PrendreIdVerbs.fct_verbs(cursor,allverbs);
      int[] ar2= PrendreIdVerbs.fct_idverbs(cursor2,allidverbs);


       int[]er;
       er=PrendreIdVerbs.ret_idverbsNOquatre(ar1,ar2);


       int[] er1=new int[er.length];
       for(int nbr=0;nbr<er.length;nbr++){
           er1[nbr]=nbr;
       }
       Log.i("AhmedoAhmeeeeeeeeeeeeeed",String.valueOf(PrendreIdVerbs.ret_idverbsNOquatre(ar1,ar2).length));

       int id_verbs_aliatoir=GetId_redndom(er1[0], er1[er.length - 1]);
    //   int id_verbs_aliatoir=   getIdVerbs(ar1,ar2);
/////////////////////////////////////////////////////////

       String verbs = getVerbs(id_verbs_aliatoir);
       String tens = gettens(id_tense_aliatoir);
            String prouns=getprounous(id_pronouns_aliatoir);

    String res1=  sugeition1(newid_tens,newid_pro,id_verbs_aliatoir);
       String res2= sugeition2(newid_tens,id_pronouns_aliatoir,id_verbs_aliatoir);
       String res3= reponse_co(id_tense_aliatoir,id_pronouns_aliatoir,id_verbs_aliatoir);

       if (res1==null){res1="لا يوجد"       ; }    if (res2==null){res2="لا يوجد"       ; }   if (res3==null){res3="لا يوجد"       ; }
       while (res1.equals(res2) || res1.equals(res3) || res2.equals(res3)){

           newid_tens = GetId_redndom(1, 12);
           newid_pro = GetId_redndom(1, 14);

           res1 = sugeition1(newid_tens, newid_pro, id_verbs_aliatoir);
           res2 = sugeition2(newid_tens, id_pronouns_aliatoir, id_verbs_aliatoir);


           if (res1==null){res1="لا يوجد"       ; }    if (res2==null){res2="لا يوجد"       ; }   if (res3==null){res3="لا يوجد"       ; }

       }


            tvverbs.setText(verbs);
            tvpronouns.setText(prouns);
            tvtens.setText(tens);
       coorect_reponse();







       suge1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
if((suge1.getText()).equals(verb_correct)){
im.setImageResource(R.drawable.avantage);
    Animation anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in);
    im.startAnimation(anim);
    MediaPlayer mediaPlayer=MediaPlayer.create(verbsgame.this,R.raw.you_are_good);
    mediaPlayer.start();
    try {
        Thread.sleep(1000);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    verb_correct=" لا يوجد";
    sug1=" لا يوجد";
    sug=" لا يوجد";
    onCreate(new Bundle());

}else{
    im.setImageResource(R.drawable.inconv);
    Animation anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in);
    im.startAnimation(anim);
    im.setVisibility(View.INVISIBLE);
    MediaPlayer mediaPlayer=MediaPlayer.create(verbsgame.this, R.raw.hawil);
    mediaPlayer.start();
}
           }
       });
       suge2.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               if((suge2.getText()).equals(verb_correct)){
                   im.setImageResource(R.drawable.avantage);
                   Animation anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in);
                   im.startAnimation(anim);
                   MediaPlayer mediaPlayer=MediaPlayer.create(verbsgame.this, R.raw.you_are_good);
                   mediaPlayer.start();
                   try {
                       Thread.sleep(1000);
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
                   verb_correct=" لا يوجد";
                   sug1=" لا يوجد";
                   sug=" لا يوجد";
                   onCreate(new Bundle());
               }else{
                   im.setImageResource(R.drawable.inconv);
                   Animation anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in);
                   im.startAnimation(anim);
                   im.setVisibility(View.INVISIBLE);
                   MediaPlayer mediaPlayer=MediaPlayer.create(verbsgame.this, R.raw.hawil);
                   mediaPlayer.start();
               }
           }
       });
       suge3.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               if((suge3.getText()).equals(verb_correct)){
                   im.setImageResource(R.drawable.avantage);
                   Animation anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in);
                   im.startAnimation(anim);
                   MediaPlayer mediaPlayer=MediaPlayer.create(verbsgame.this, R.raw.you_are_good);
                   mediaPlayer.start();
                   try {
                       Thread.sleep(1000);
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
                   verb_correct=" لا يوجد";
                   sug1=" لا يوجد";
                   sug=" لا يوجد";
                   onCreate(new Bundle());
               }else{
                   im.setImageResource(R.drawable.inconv);
                   Animation anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in);
                   im.startAnimation(anim);
                   im.setVisibility(View.INVISIBLE);
                   MediaPlayer mediaPlayer=MediaPlayer.create(verbsgame.this, R.raw.hawil);
                   mediaPlayer.start();
               }
           }
       });

        }
/*
firest  we selecte aliatoir a nembre from data base for the id of verbs
second   we selecte aliatoir a nembre from data base for the id of tenss
thrad     we selecte aliatoir a nembre from data base for the id of prounouns
 */

     String reponse_co (int id_tense_aliatoir,int id_pronouns_aliatoir,int id_verbs_aliatoir){
         String vrb_cor;
         Cursor cursor = databasehelper.quer("SELECT name_conjugate_verb FROM   conjugate_verbs ,tense,pronouns,verbs where tense.idtense=conjugate_verbs.tense_idtense and tense_idtense=" + id_tense_aliatoir + " and conjugate_verbs.pronouns_idpronouns=pronouns.idpronouns and  pronouns_idpronouns=" + id_pronouns_aliatoir + " and verbs.idverbs=conjugate_verbs.verbs_idverbs and verbs_idverbs=" + id_verbs_aliatoir + " ");

         if(cursor!=null)
         {
             if (cursor.moveToFirst())
             {
                 do {

                     verb_correct  = cursor.getString(0);
                     if (verb_correct == null) {
                         vrb_cor="لا يوجد";
                     }
              else   vrb_cor=verb_correct;
                 } while (cursor.moveToNext());
                 return vrb_cor;
             }
         }
         return null;
     }
      String sugeition1(int id_tense,int id_pronouns,int id_verbs_aliatoir){
          String vrb_cor;
          Cursor cursor1 = databasehelper.quer("SELECT name_conjugate_verb FROM   conjugate_verbs ,tense,pronouns,verbs where tense.idtense=conjugate_verbs.tense_idtense and tense_idtense=" + id_tense + " and conjugate_verbs.pronouns_idpronouns=pronouns.idpronouns and  pronouns_idpronouns=" + id_pronouns + " and verbs.idverbs=conjugate_verbs.verbs_idverbs and verbs_idverbs="+id_verbs_aliatoir+" ");

          if(cursor1!=null)
          {
              if (cursor1.moveToFirst())
              {
                  do {
                      sug1  = cursor1.getString(0);
                      if (sug1 == null) {
                          vrb_cor="لا يوجد";
                      }
                      else   vrb_cor=sug1;
                  } while (cursor1.moveToNext());
                  return vrb_cor;
              }
          }
          return null;
      }
    String sugeition2(int id_tense,int id_pronouns,int id_verbs_aliatoir){
        String vrb_cor;

        Cursor cursor2 = databasehelper.quer("SELECT name_conjugate_verb FROM   conjugate_verbs ,tense,pronouns,verbs where tense.idtense=conjugate_verbs.tense_idtense and tense_idtense="+id_tense+" and conjugate_verbs.pronouns_idpronouns=pronouns.idpronouns and  pronouns_idpronouns="+id_pronouns+" and verbs.idverbs=conjugate_verbs.verbs_idverbs and verbs_idverbs="+id_verbs_aliatoir+" ");

        if(cursor2!=null)
        {
            if (cursor2.moveToFirst())
            {
                do {
                    sug = cursor2.getString(0);
                    if (sug == null) {
                        vrb_cor="لا يوجد";
                    }
                    else   vrb_cor=sug;

                } while (cursor2.moveToNext());
            return vrb_cor;
            }
        }
return null;
    }





    public String getVerbs(int id) {
        String verbs=null;

        Cursor cursor = databasehelper.quer("SELECT vocalized FROM   verbs where idverbs = "+id+"");

        if(cursor!=null)
        {
            if (cursor.moveToFirst())
            {
                do {
                    verbs = cursor.getString(0);
                } while (cursor.moveToNext());
            }
        }
        return verbs;
    }
    public String gettens(int id) {
        String verbs=null;

        Cursor cursor = databasehelper.quer("SELECT tense_name,voice ,inaison,confirmed FROM   tense where idtense= "+ id+" ");

        if(cursor!=null)
        {
            if (cursor.moveToFirst())
            {
                do {

                    String tens_name=cursor.getString(0);
                    String voice=cursor.getString(1);
                    String inaison =cursor.getString(2);
                    String confirmed =cursor.getString(3);

                        verbs = tens_name + " " + voice + " " + "  " + inaison + " "+ confirmed;



                } while (cursor.moveToNext());
            }
        }
        return verbs;
    }
    public String getprounous(int id) {
        String verbs=null;

        Cursor cursor = databasehelper.quer("SELECT pronoun_name FROM   pronouns where idpronouns = "+id+"");

        if(cursor!=null)
        {
            if (cursor.moveToFirst())
            {
                do {
                    verbs = cursor.getString(0);
                } while (cursor.moveToNext());
            }
        }
        return verbs;
    }


    public void coorect_reponse() {

        Random rand = new Random();
        int position = rand.nextInt((3 - 0));
        if(position==0) {

            suge1.setText(sug1);
            suge2.setText(sug);
            suge3.setText(verb_correct);
        }
        if(position==1) {

            suge2.setText(sug1);
            suge3.setText(sug);
            suge1.setText(verb_correct);
        }
        if(position==2) {

            suge3.setText(sug1);
            suge1.setText(sug);
            suge2.setText(verb_correct);
        }


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



    public void try_again(View view) {
        verb_correct=" لا يوجد";
        sug1=" لا يوجد";
        sug=" لا يوجد";
        onCreate(new Bundle());
    }

    public static int getIdVerbs(String[] allverbs,int[] id_allverbs){
        int[]er;
      er=PrendreIdVerbs.ret_idverbsNOquatre(allverbs,id_allverbs);

        int[] er1=new int[er.length];
        for(int nbr=0;nbr<er.length;nbr++){
            er1[nbr]=nbr;
        }


        int newid=GetId_redndom(er1[0],er1[er.length-1]);
        int idverb=Integer.valueOf(er[newid]);
        // System.out.println("the nembre is : "+newid+"\t"+er[newid]);
        return idverb;
    }

}

