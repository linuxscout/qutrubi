package verbs.conjugate.qutrubi.aplication_qutrubi_v12;


import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class Adapter extends ArrayAdapter<Item> {
    private TextView t1,t2,t3,t4;
    private Activity activity;
    int id;
    private ArrayList<Item> item;

    public Adapter(Activity context, int resource, ArrayList<Item> objects) {
        super(context, resource, objects);
        this.activity=context;    this.id=resource;   this.item=objects;
    }

    @Override
    public View getView(int position, View v, ViewGroup parent) {

       if(v == null){
           LayoutInflater inf=activity.getLayoutInflater();

            v=inf.inflate(id,null);

        }
      //  v=View.inflate(activity,R.layout.list_item,null);
        Item itm=item.get(position);


         t2=  (TextView) v.findViewById(R.id.verb);
         t1=  (TextView) v.findViewById(R.id.pronoun);
        t3=  (TextView) v.findViewById(R.id.tense);



      t3.setText(itm.getTense());
            t1.setText(String.valueOf(itm.getVerb()));
           t2.setText(itm.getPronoun());


        return  v;
    }


}
