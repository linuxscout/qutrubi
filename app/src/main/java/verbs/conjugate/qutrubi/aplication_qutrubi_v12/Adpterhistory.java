package verbs.conjugate.qutrubi.aplication_qutrubi_v12;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by ahmed on 08/05/16.
 */
public class Adpterhistory extends ArrayAdapter<verbs_itm> {
    ArrayList<verbs_itm> verbs_itm;
    int i;
    private Activity activity;

    public Adpterhistory(Activity context, int resource, ArrayList<verbs_itm> objects) {
        super(context, resource, objects);
        this.i=resource;
        this.activity=context;
        this.verbs_itm=objects;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null){
            LayoutInflater inflater=activity.getLayoutInflater();
            convertView=inflater.inflate(i,null);
        }


        verbs_itm verb= verbs_itm.get(position);

        TextView tvverb =(TextView)convertView.findViewById(R.id.verbs);
        TextView  tvdate =(TextView)convertView.findViewById(R.id.date);


        tvverb.setText(verb.getVerbs());
        tvdate.setText(verb.getDate());





        return convertView;




    }

}
