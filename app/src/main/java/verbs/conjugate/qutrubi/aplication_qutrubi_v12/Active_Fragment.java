package verbs.conjugate.qutrubi.aplication_qutrubi_v12;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by ahmed   and reodouaneon 06/04/16.
 */
public class Active_Fragment  extends Fragment {


    public Active_Fragment() {
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.active, container,false);
        Conjugate conjugate=(Conjugate)getActivity();

        ExpandableListView  expListViewActive = (ExpandableListView) v.findViewById(R.id.lv_active);

        Bundle bn=getArguments();

      int id_verbs = (int) bn.get("id_verb");
         // String verb=conjugate.getverbs();
        conjugate.ListDataActive(expListViewActive, id_verbs);

        return v;
    }



}

