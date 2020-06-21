package verbs.conjugate.qutrubi.aplication_qutrubi_v12;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

/**
 * Created by ahmed and redouane on 2016.
 */
public class Passive_Fragment  extends Fragment {
    public Passive_Fragment() {
    }



    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.passive, container,false);
        Conjugate conjugate=(Conjugate)getActivity();

        ExpandableListView expListViewActive = (ExpandableListView) v.findViewById(R.id.lv_passive);
       // String verb=conjugate.getverbs();

        Bundle bn=getArguments();

        int id_verbs = (int) bn.get("id_verb");

        conjugate.ListDataPassive(expListViewActive,id_verbs);




        return v;
    }


}
