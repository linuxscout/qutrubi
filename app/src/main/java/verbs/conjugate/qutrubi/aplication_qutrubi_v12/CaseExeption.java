package verbs.conjugate.qutrubi.aplication_qutrubi_v12;

import android.app.DialogFragment;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by ahmed and redoune on 2016.
 */
public class CaseExeption extends DialogFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.exeption_case, container,false);
        getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        getDialog().getWindow().setBackgroundDrawableResource(
                android.R.color.transparent);
        TextView message=(TextView)v.findViewById(R.id.message_error);
        String the_message=getString(R.string.text_note)+"\n"+
                getString(R.string.text_note2)+"\n"+getString(R.string.text_note3)+"\n"+getString(R.string.text_note4)+"\n"+"\n"+getString(R.string.text_note5);
        message.setText(the_message);
        Button button=(Button)v.findViewById(R.id.butt_ok);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDialog().dismiss();
            }
        });

        return v;
    }
}
