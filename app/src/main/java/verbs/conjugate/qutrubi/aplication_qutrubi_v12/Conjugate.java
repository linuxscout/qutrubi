package verbs.conjugate.qutrubi.aplication_qutrubi_v12;

/*
 * Created by ahmed and redoune on 2016.
 */

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;

import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import conjugate_algo.Amr;
import conjugate_algo.Amr_moAkad;
import conjugate_algo.Madi_ma3loum;
import conjugate_algo.Madi_majhol;
import conjugate_algo.Modari3_ma3lom_majzom;
import conjugate_algo.Modari3_ma3lom_mansob;
import conjugate_algo.Modari3_ma3lom_marfo3;
import conjugate_algo.Modari3_ma3lom_moAkad;
import conjugate_algo.Modari3_majzom_majhol;
import conjugate_algo.Modari3_mansob_majhol;
import conjugate_algo.Modari3_marfou3_majhol;
import conjugate_algo.Modari3_moAkad_majhol;


public class Conjugate extends Activity {
    Adpterhistory ad;
    ArrayList ar;
    ListView l;DBCon db;
    private AutoCompleteTextView edit_verbs;
    private databasehelper dbhelp;
    private TextView info_voice;
    private ExpandableListAdapter listAdapter;
    private List<String> listDataHeader;
    private HashMap<String, List<String>> listDataChild;
    private Spinner bab_sarf;
    private  ArrayList<String> array_list2 = new ArrayList<String>();
    TextView th;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_conjugate);


        TextView active = (TextView) findViewById(R.id.tv_active);
        TextView passive = (TextView) findViewById(R.id.tv_passive);
         info_voice = (TextView) findViewById(R.id.tv_info);
        bab_sarf = (Spinner) findViewById(R.id.spin);
        edit_verbs = (AutoCompleteTextView) findViewById(R.id.edit_verbs);
       th=(TextView)findViewById(R.id.hist);


        dbhelp = new databasehelper(this);
        try {

            // dbhelp.chekandcopy();
            dbhelp.openDataBase();
        } catch (Exception e) {
        }

        autocompletetion(edit_verbs);

        active.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info_voice.setText(getString(R.string.Active_voice));
                loadSpinnerData(id_verbs(getverbs()));


            }
        });
        passive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                info_voice.setText(getString(R.string.passive_voice));

                loadSpinnerData(id_verbs(getverbs()));
            }
        });


        TextView  back = (TextView) findViewById(R.id.Back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        l =(ListView)findViewById(R.id.listhstry);
        db=new DBCon(this);

        ar=db.arrlist();
        ad = new Adpterhistory(this, R.layout.simpl_list_history, ar);
        l.setAdapter(ad);

        l.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String name = null;
                             
                switch (position) {}

                name = ((TextView) view.findViewById(R.id.verbs))
                        .getText() + "";

                String []verbe_partager=name.split("");
                name="";
                for(int i1 =1;i1<verbe_partager.length;i1++){
                    //if(i1==1){
                    if (verbe_partager[i1].equals(" ")){
                        verbe_partager[i1]="";

                    }
                    name+=verbe_partager[i1];
                }
                l.setVisibility(View.INVISIBLE);th.setVisibility(View.INVISIBLE);
                edit_verbs.setText(name);
                loadSpinnerData(id_verbs(name));

            }
        });


    }

      public AutoCompleteTextView autocompletetion(AutoCompleteTextView edit_verbs) {
         ArrayList<String> array_list = new ArrayList<String>();

        try {

            Cursor cursor = dbhelp.quer("SELECT distinct unvocalized FROM verbs");

            while (cursor.moveToNext()) {
                //      String cop=cursor.getString(0)+"\t"+cursor.getString(1);
                array_list.add(cursor.getString(0));

            }
            ArrayAdapter adapter1 = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, array_list);
            edit_verbs.setAdapter(adapter1);

            edit_verbs.setThreshold(1); //this line for  selecte the nombre   of alphabatic which to strart  autocomplitation


            return edit_verbs;
        } catch (Exception ex) {
            return null;
        }


    }

      public void ListDataActive(ExpandableListView expListView, int verb) {


        expListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {

                prop_dialog(groupPosition, childPosition);

                return false;
            }
        });
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<>();

        // Adding child data
        listDataHeader.add(getString(R.string.pastactive));
        listDataHeader.add(getString(R.string.futuractive));
        listDataHeader.add(getString(R.string.SubjunctiveFuture));
        listDataHeader.add(getString(R.string.JussiveFuture));
        listDataHeader.add(getString(R.string.ConfirmedFuture));
        listDataHeader.add(getString(R.string.impirative));
        listDataHeader.add(getString(R.string.ConfirmedImperative));
        String str = edit_verbs.getText().toString();

        // Adding child data
        List<String> madi = new ArrayList<String>();
        // Cursor cursor1= dbhelp.quer("SELECT pronoun_name,name_conjugate_verb FROM pronouns,conjugate_verbs,verbs,tense where verbs.unvocalized = '"+"أكل"+"'   and verbs.idverbs = conjugate_verbs.verbs_idverbs and pronouns.idpronouns=pronouns_idpronouns and tense.idtense=tense_idtense and tense.idtense= 2   ");
        Cursor cursor1 = dbhelp.quer("SELECT pronoun_name,name_conjugate_verb FROM pronouns,conjugate_verbs,verbs,tense where verbs.idverbs  = '" + verb + "'   and verbs.idverbs = conjugate_verbs.verbs_idverbs and pronouns.idpronouns=pronouns_idpronouns and tense.idtense=tense_idtense and tense.idtense= 1  order by idpronouns ");

          new Madi_ma3loum(cursor1,madi);

          //Collections.sort(madi);

        List<String> modariE = new ArrayList<String>();
        // Cursor cursor2= dbhelp.quer("SELECT pronoun_name,name_conjugate_verb FROM pronouns,conjugate_verbs,verbs,tense where verbs.unvocalized = '"+"أكل"+"'   and verbs.idverbs = conjugate_verbs.verbs_idverbs and pronouns.idpronouns=pronouns_idpronouns and tense.idtense=tense_idtense and tense.idtense= 6  ");
        Cursor cursor2 = dbhelp.quer("SELECT pronoun_name,name_conjugate_verb FROM pronouns,conjugate_verbs,verbs,tense where verbs.idverbs = '" + verb + "'   and verbs.idverbs = conjugate_verbs.verbs_idverbs and pronouns.idpronouns=pronouns_idpronouns and tense.idtense=tense_idtense and tense.idtense= 2  order by idpronouns");

          new Modari3_ma3lom_marfo3(cursor2,modariE);

        List<String> modariE_mansoub = new ArrayList<String>();
        // Cursor cursor2= dbhelp.quer("SELECT pronoun_name,name_conjugate_verb FROM pronouns,conjugate_verbs,verbs,tense where verbs.unvocalized = '"+"أكل"+"'   and verbs.idverbs = conjugate_verbs.verbs_idverbs and pronouns.idpronouns=pronouns_idpronouns and tense.idtense=tense_idtense and tense.idtense= 6  ");
        Cursor cursor6 = dbhelp.quer("SELECT pronoun_name,name_conjugate_verb FROM pronouns,conjugate_verbs,verbs,tense where verbs.idverbs  = '" + verb + "'   and verbs.idverbs = conjugate_verbs.verbs_idverbs and pronouns.idpronouns=pronouns_idpronouns and tense.idtense=tense_idtense and tense.idtense= 6 order by idpronouns ");

       new Modari3_ma3lom_mansob(cursor6,modariE_mansoub);

        List<String> modariE_majzoum = new ArrayList<String>();
        // Cursor cursor2= dbhelp.quer("SELECT pronoun_name,name_conjugate_verb FROM pronouns,conjugate_verbs,verbs,tense where verbs.unvocalized = '"+"أكل"+"'   and verbs.idverbs = conjugate_verbs.verbs_idverbs and pronouns.idpronouns=pronouns_idpronouns and tense.idtense=tense_idtense and tense.idtense= 6  ");
        Cursor cursor5 = dbhelp.quer("SELECT pronoun_name,name_conjugate_verb FROM pronouns,conjugate_verbs,verbs,tense where verbs.idverbs  = '" + verb + "'   and verbs.idverbs = conjugate_verbs.verbs_idverbs and pronouns.idpronouns=pronouns_idpronouns and tense.idtense=tense_idtense and tense.idtense= 5 order by idpronouns ");

       new Modari3_ma3lom_majzom(cursor5,modariE_majzoum);

        List<String> modariE_moAkad = new ArrayList<String>();
        // Cursor cursor2= dbhelp.quer("SELECT pronoun_name,name_conjugate_verb FROM pronouns,conjugate_verbs,verbs,tense where verbs.unvocalized = '"+"أكل"+"'   and verbs.idverbs = conjugate_verbs.verbs_idverbs and pronouns.idpronouns=pronouns_idpronouns and tense.idtense=tense_idtense and tense.idtense= 6  ");
        Cursor cursor4 = dbhelp.quer("SELECT pronoun_name,name_conjugate_verb FROM pronouns,conjugate_verbs,verbs,tense where verbs.idverbs = '" + verb + "'   and verbs.idverbs = conjugate_verbs.verbs_idverbs and pronouns.idpronouns=pronouns_idpronouns and tense.idtense=tense_idtense and tense.idtense= 7  order by idpronouns");

          new Modari3_ma3lom_moAkad(cursor4,modariE_moAkad);

        List<String> Amr_list = new ArrayList<String>();
        //    Cursor cursor3= dbhelp.quer("SELECT pronoun_name,name_conjugate_verb FROM pronouns,conjugate_verbs,verbs,tense where verbs.unvocalized = '"+"أكل"+"'   and verbs.idverbs = conjugate_verbs.verbs_idverbs and pronouns.idpronouns=pronouns_idpronouns and tense.idtense=tense_idtense and tense.idtense= 18   ");
        Cursor cursor3 = dbhelp.quer("SELECT pronoun_name,name_conjugate_verb FROM pronouns,conjugate_verbs,verbs,tense where verbs.idverbs  = '" + verb + "'   and verbs.idverbs = conjugate_verbs.verbs_idverbs and pronouns.idpronouns=pronouns_idpronouns and tense.idtense=tense_idtense and tense.idtense= 3   order by idpronouns");

          new Amr(cursor3,Amr_list);


        List<String> Amr_moAkad_list = new ArrayList<String>();
        //    Cursor cursor3= dbhelp.quer("SELECT pronoun_name,name_conjugate_verb FROM pronouns,conjugate_verbs,verbs,tense where verbs.unvocalized = '"+"أكل"+"'   and verbs.idverbs = conjugate_verbs.verbs_idverbs and pronouns.idpronouns=pronouns_idpronouns and tense.idtense=tense_idtense and tense.idtense= 18   ");
        Cursor cursor7 = dbhelp.quer("SELECT pronoun_name,name_conjugate_verb FROM pronouns,conjugate_verbs,verbs,tense where verbs.idverbs = '" + verb + "'   and verbs.idverbs = conjugate_verbs.verbs_idverbs and pronouns.idpronouns=pronouns_idpronouns and tense.idtense=tense_idtense and tense.idtense= 4  order by idpronouns ");

          new Amr_moAkad(cursor7,Amr_moAkad_list);
       /* String st7, rt7;
        if (cursor7 != null) {
            if (cursor7.moveToFirst()) {
                do {

                    st7 = cursor7.getString(0);
                    rt7 = cursor7.getString(1);
                    if (rt7 != null) {
                        String sr7 = st7 + "\t\t" + rt7;
                        Amr_moAkad.add(sr7);
                    } else {
                        String sr7 = st7 + "\t\t\t" + "";
                        Amr_moAkad.add(sr7);
                    }

                } while (cursor7.moveToNext());

            }
        }*/
// Header, Child data

        listDataChild.put(listDataHeader.get(0), madi);
        listDataChild.put(listDataHeader.get(1), modariE);
        listDataChild.put(listDataHeader.get(2), modariE_mansoub);
        listDataChild.put(listDataHeader.get(3), modariE_majzoum);
        listDataChild.put(listDataHeader.get(4), modariE_moAkad);
        listDataChild.put(listDataHeader.get(5), Amr_list);
        listDataChild.put(listDataHeader.get(6), Amr_moAkad_list);

        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);


        expListView.setAdapter(listAdapter);

    }

      public void ListDataPassive(ExpandableListView expListView, int verb) {

        expListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {


                prop_dialog(groupPosition, childPosition);


                return false;
            }
        });


        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<>();

        // Adding child data
        listDataHeader.add(getString(R.string.PassivePast));
        listDataHeader.add(getString(R.string.PassiveFuture));
        listDataHeader.add(getString(R.string.PassiveSubjunctiveFuture));
        listDataHeader.add(getString(R.string.PassiveJussiveFuture));
        listDataHeader.add(getString(R.string.PassiveConfirmedFuture));
        String str = edit_verbs.getText().toString();

        // Adding child data
        List<String> madi = new ArrayList<String>();
        // Cursor cursor1= dbhelp.quer("SELECT pronoun_name,name_conjugate_verb FROM pronouns,conjugate_verbs,verbs,tense where verbs.unvocalized = '"+"أكل"+"'   and verbs.idverbs = conjugate_verbs.verbs_idverbs and pronouns.idpronouns=pronouns_idpronouns and tense.idtense=tense_idtense and tense.idtense= 2   ");
        Cursor cursor1 = dbhelp.quer("SELECT pronoun_name,name_conjugate_verb FROM pronouns,conjugate_verbs,verbs,tense where verbs.idverbs = '" + verb + "'   and verbs.idverbs = conjugate_verbs.verbs_idverbs and pronouns.idpronouns=pronouns_idpronouns and tense.idtense=tense_idtense and tense.idtense= 8  order by idpronouns ");

        new Madi_majhol(cursor1,madi);


        List<String> modariE = new ArrayList<String>();
        // Cursor cursor2= dbhelp.quer("SELECT pronoun_name,name_conjugate_verb FROM pronouns,conjugate_verbs,verbs,tense where verbs.unvocalized = '"+"أكل"+"'   and verbs.idverbs = conjugate_verbs.verbs_idverbs and pronouns.idpronouns=pronouns_idpronouns and tense.idtense=tense_idtense and tense.idtense= 6  ");
        Cursor cursor2 = dbhelp.quer("SELECT pronoun_name,name_conjugate_verb FROM pronouns,conjugate_verbs,verbs,tense where verbs.idverbs = '" + verb + "'   and verbs.idverbs = conjugate_verbs.verbs_idverbs and pronouns.idpronouns=pronouns_idpronouns and tense.idtense=tense_idtense and tense.idtense= 9 order by idpronouns ");

       new Modari3_marfou3_majhol(cursor2,modariE);

        List<String> modariE_mansoub = new ArrayList<String>();
        // Cursor cursor2= dbhelp.quer("SELECT pronoun_name,name_conjugate_verb FROM pronouns,conjugate_verbs,verbs,tense where verbs.unvocalized = '"+"أكل"+"'   and verbs.idverbs = conjugate_verbs.verbs_idverbs and pronouns.idpronouns=pronouns_idpronouns and tense.idtense=tense_idtense and tense.idtense= 6  ");
        Cursor cursor6 = dbhelp.quer("SELECT pronoun_name,name_conjugate_verb FROM pronouns,conjugate_verbs,verbs,tense where verbs.idverbs = '" + verb + "'   and verbs.idverbs = conjugate_verbs.verbs_idverbs and pronouns.idpronouns=pronouns_idpronouns and tense.idtense=tense_idtense and tense.idtense= 11 order by idpronouns ");

       new Modari3_mansob_majhol(cursor6,modariE_mansoub);

        List<String> modariE_majzoum = new ArrayList<String>();
        // Cursor cursor2= dbhelp.quer("SELECT pronoun_name,name_conjugate_verb FROM pronouns,conjugate_verbs,verbs,tense where verbs.unvocalized = '"+"أكل"+"'   and verbs.idverbs = conjugate_verbs.verbs_idverbs and pronouns.idpronouns=pronouns_idpronouns and tense.idtense=tense_idtense and tense.idtense= 6  ");
        Cursor cursor5 = dbhelp.quer("SELECT pronoun_name,name_conjugate_verb FROM pronouns,conjugate_verbs,verbs,tense where verbs.idverbs = '" + verb + "'   and verbs.idverbs = conjugate_verbs.verbs_idverbs and pronouns.idpronouns=pronouns_idpronouns and tense.idtense=tense_idtense and tense.idtense= 10  order by idpronouns");

        new Modari3_majzom_majhol(cursor5,modariE_majzoum);

        List<String> modariE_moAkad = new ArrayList<String>();
        // Cursor cursor2= dbhelp.quer("SELECT pronoun_name,name_conjugate_verb FROM pronouns,conjugate_verbs,verbs,tense where verbs.unvocalized = '"+"أكل"+"'   and verbs.idverbs = conjugate_verbs.verbs_idverbs and pronouns.idpronouns=pronouns_idpronouns and tense.idtense=tense_idtense and tense.idtense= 6  ");
        Cursor cursor4 = dbhelp.quer("SELECT pronoun_name,name_conjugate_verb FROM pronouns,conjugate_verbs,verbs,tense where verbs.idverbs = '" + verb + "'   and verbs.idverbs = conjugate_verbs.verbs_idverbs and pronouns.idpronouns=pronouns_idpronouns and tense.idtense=tense_idtense and tense.idtense= 12 order by idpronouns ");

        new Modari3_moAkad_majhol(cursor4,modariE_moAkad);

        listDataChild.put(listDataHeader.get(0), madi);
        listDataChild.put(listDataHeader.get(1), modariE);
        listDataChild.put(listDataHeader.get(2), modariE_mansoub);
        listDataChild.put(listDataHeader.get(3), modariE_majzoum);
        listDataChild.put(listDataHeader.get(4), modariE_moAkad);

        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);

        expListView.setAdapter(listAdapter);

    }

      private boolean isArabic(String text) {
              for (int i = 0; i < text.length();) {
            int c = text.codePointAt(i);

            if (c >= 0x0600 && c <=0x06FF || (c >= 0xFE70 && c<=0xFEFF))
                i += Character.charCount(c);
            else
                return false;
        }
        return true;
    }

      public String getverbs() {
        String verb=edit_verbs.getText().toString();
if(isArabic(verb)){
    if((verb.length()==3 || verb.length()==4) && verb.startsWith("ا")){
       String[] new_verb= verb.split("");
        new_verb[1]="أ";
        verb="";
for(int t=0;t<new_verb.length;t++){
        verb+=new_verb[t];
}
    verb =  delet_techkil(verb);
        return verb;
    }  verb = delet_techkil(verb);
    return verb;
}

        return verb;
    }

      public void Ajouthistory() {



            Date date = new Date();
          SimpleDateFormat simpleDateFormat=new SimpleDateFormat(  "HH"+":"+"mm"+" yyyy "+"MM"+" dd " , Locale.ENGLISH);
            if (ar.size() >= 20) {
                db.delete();
                db.insert(getverbs(), simpleDateFormat.format(date).toString());
                ar = db.arrlist();
            } else {
                db.insert(edit_verbs.getText().toString(), simpleDateFormat.format(date).toString());


                ar = db.arrlist();


        }


    }

      public void butt_conjugate(View view) {




          TextView th=(TextView)findViewById(R.id.hist);
l.setVisibility(View.INVISIBLE);th.setVisibility(View.INVISIBLE);
        //  String verb=edit_verbs.getText().toString();

          if(!(isArabic(getverbs()))|| getverbs().isEmpty() || getverbs().split("").length-1<3 ||
                  getverbs().split("").length-1>7 || getverbs().startsWith("ة")|| getverbs().startsWith("إ")) {


              FragmentManager fr = getFragmentManager();
              CaseExeption caseExeption = new CaseExeption();
              caseExeption.show(fr, null);

          }else{
            //  loadSpinnerData(id_verbs());
              Ajouthistory();
              conj_web();
             }

    }

      public void conj_web() {
          if(  is_existe(getverbs())){
            loadSpinnerData(id_verbs(getverbs()));

        }else {

              AlertDialog.Builder builder = new AlertDialog.Builder(this);
              builder.setTitle(getString(R.string.webconjugate));
              builder.setMessage(getString(R.string.webmessage));
              builder.setCancelable(true);
              builder.setPositiveButton(getString(R.string.button_yes), new DialogInterface.OnClickListener() {
                  @Override
                  public void onClick(DialogInterface dialog, int which) {
                      Intent intent = new Intent(getApplicationContext(), MainIntrnet.class);

                      Bundle bundle = new Bundle();
                      bundle.putString("new_verbs", getverbs());
                      intent.putExtras(bundle);
                      startActivity(intent);


                  }
              });
              builder.setNegativeButton(R.string.button_No, new DialogInterface.OnClickListener() {
                  @Override
                  public void onClick(DialogInterface dialog, int which) {
                  }
              });

              AlertDialog dialog = builder.create();
              dialog.show();;


        }
    }

      private int[] id_verbs(String getverbs) {

        final int[] idverbs = new int[6];
        int i = 0;



        Cursor cu = dbhelp.quer("SELECT idverbs FROM verbs where unvocalized='" + getverbs + "'");


        if (cu.moveToFirst()) {
            array_list2 = new ArrayList<String>();
            do {

                idverbs[i] = Integer.parseInt(cu.getString(0));

                i++;
            } while (cu.moveToNext());
        }

          return  idverbs;
    }

      private void prop_dialog(int groupPosition, int childPosition) {
        String tense = listDataHeader.get(groupPosition);
        String verb_conjug = listDataChild.get(listDataHeader.get(groupPosition)).get(childPosition);
        Bundle bn = new Bundle();

        int pos=bab_sarf.getSelectedItemPosition();
        int[] id_verbs=id_verbs(getverbs());

        Cursor cur = dbhelp.quer("SELECT trans,root FROM verbs where verbs.idverbs= '" + id_verbs[pos] + "'");

        String trans, root;
        if (cur != null) {
            if (cur.moveToFirst()) {
                do {

                    trans = cur.getString(0);
                    root = cur.getString(1);
                    bn.putString("trans", trans);
                    bn.putString("root", root);
                } while (cur.moveToNext());
            }
        }
          bn.putInt("idverbs", id_verbs[pos] );
        bn.putString("tense", tense);
        bn.putString("verb_conj", verb_conjug);


        FragmentManager fr = getFragmentManager();
        verbs_properties st = new verbs_properties();
        st.setArguments(bn);
        st.show(fr, null);
    }

      private void loadSpinnerData( int[] new_tab ) {
        String str1, str2, str3;

        Cursor cu = dbhelp.quer("SELECT idverbs FROM verbs where unvocalized='" + getverbs() + "'");

          array_list2=new ArrayList<String>();

        for (int j = 0; j < cu.getCount(); j++) {
            Cursor cur = dbhelp.quer("SELECT vocalized, name_conjugate_verb FROM tense,pronouns, verbs,conjugate_verbs WHERE verbs.idverbs = conjugate_verbs.verbs_idverbs and pronouns.idpronouns=conjugate_verbs.pronouns_idpronouns and pronouns.idpronouns=9 and tense.idtense=conjugate_verbs.tense_idtense and tense.idtense=2 and verbs.idverbs='" + new_tab[j] + "'");


            if (cur.moveToFirst()) {

                do {

                    str1 = cur.getString(0);
                    str2 = cur.getString(1);

                    str3 = str1 + "\t" + str2;

                    array_list2.add(str3);

                } while (cur.moveToNext());

            }

            ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_spinner_item, array_list2);
            dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            bab_sarf.setAdapter(dataAdapter);

        }

        listner_selectioin(new_tab);

    }

      private void listner_selectioin(final int [] bab  ) {



        bab_sarf.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


                switch (position) {
                    case 0
                            :


                        conjug_verbs(bab[0]);
                        break;

                    case 1:

                        conjug_verbs(bab[1]);
                        break;
                    case 2:

                        conjug_verbs(bab[2]);

                        break;

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }

      private void conjug_verbs(int idverb){
        RelativeLayout choi_voice=(RelativeLayout)findViewById(R.id.choi_layout);
        boolean b=choi_voice.isShown();
         Bundle bn = new Bundle();
        String info=info_voice.getText().toString();

        if(b==false){
            choi_voice.setVisibility(View.VISIBLE);
            info_voice.setText(getString(R.string.Active_voice));
            Fragment fragment = new Active_Fragment();
            bn.putInt("id_verb",idverb);
            fragment.setArguments(bn);
            FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.relative_display, fragment).commit();

        }else {

            if (info == getString(R.string.passive_voice)) {

                Fragment fragment = new Passive_Fragment();
                bn.putInt("id_verb",idverb);
                fragment.setArguments(bn);
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.relative_display, fragment).commit();

            } else {

                info_voice.setText(getString(R.string.Active_voice));
                Fragment fragment = new Active_Fragment();
                bn.putInt("id_verb",idverb);
                fragment.setArguments(bn);
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.relative_display, fragment).commit();
            }
        }
    }

      private boolean is_existe (String verbs){


        try {  Cursor cursor = dbhelp.quer("SELECT idverbs FROM verbs where unvocalized='"+verbs+"'");

            while(cursor.moveToNext()){
                String id=  (cursor.getString(0));
                if(id!=null){
                    return true;}
                else {
                    return false;
                }
            }




        }catch(Exception E){}return  false ;
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

}