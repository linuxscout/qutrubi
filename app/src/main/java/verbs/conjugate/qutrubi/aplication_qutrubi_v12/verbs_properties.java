package verbs.conjugate.qutrubi.aplication_qutrubi_v12;

import android.app.DialogFragment;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;



/**
 * Created by ahmed on 01/07/16.
 */
public class verbs_properties extends DialogFragment {

    public static final  String hamza="أ";
    public static final  String hamza1="ء";
    public static final  String hamza2="ئ";
    public static final  String hamza3="ؤ";


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View    v=inflater.inflate(R.layout.propirite_activity, container,false);
        getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        getDialog().getWindow().setBackgroundDrawableResource(
                android.R.color.transparent);

        TextView name_verbs,type_verb,verb_root,verbs_conj,verb_conj2,verb_form,verb_trans;
        Button b_cancel;


        Conjugate conjugate=(Conjugate)getActivity();
        String verb=conjugate.getverbs();
        verbs_prop prop= new verbs_prop();

        name_verbs=(TextView)v.findViewById(R.id.verbs_name);
        verbs_conj=(TextView)v.findViewById(R.id.verbs_conj);
        verb_conj2=(TextView)v.findViewById(R.id.verbs_conj2);
        type_verb=(TextView)v.findViewById(R.id.verbs_type);
        verb_root=(TextView)v.findViewById(R.id.verb_root);
        verb_trans=(TextView)v.findViewById(R.id.verbs_trans);
        verb_form=(TextView)v.findViewById(R.id.verbs_form);

        b_cancel=(Button)v.findViewById(R.id.butt_cancel);

        b_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDialog().dismiss();
            }
        });

        Bundle bn=getArguments();
        String tense= (String) bn.get("tense");
        int id= (int) bn.get("idverbs");
        String verb_conj= (String) bn.get("verb_conj");
        String trans = (String) bn.get("trans");
        if(trans.equals("م")){
            trans="متعدي";
        }if(trans.equals("ل")){
            trans="لازم";
        }
        String root = (String) bn.get("root");
        name_verbs.setText(getString(R.string.name_verbs) + " " + verb);
        if (verb_conj != null) {
            verbs_conj.setLines(2);
            verbs_conj.setEms(27);
            verbs_conj.setText(getString(R.string.verb_conjugué) + " " +getString(R.string.vrb_in)+" "+ tense);

        }


        verb_conj2.setText(verb_conj);
        verb_trans.setText(getString(R.string.trans) + " " + trans);
        verb_root.setText(getString(R.string.root)+" "+root);
        verb_form.setText(getString(R.string.lettre) + " "+prop.is_trilitaire(verb));

        boolean illa=  prop.isMoutel(verb);
        if (illa==true){
            type_verb.setText(getString(R.string.verb_type)+" "+prop.NouA_ila(verb));
        }else{
            type_verb.setText(getString(R.string.verb_type)+" "+prop.Noua_Sahih(verb,root_hamza(id)));
        }




        return v;

    }

    private String root_verbs(int id_verbs) {


        databasehelper dbhelp=new databasehelper(getActivity());


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



}

