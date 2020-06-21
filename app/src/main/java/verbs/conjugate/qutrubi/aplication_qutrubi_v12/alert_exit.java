package verbs.conjugate.qutrubi.aplication_qutrubi_v12;

import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;

import java.nio.charset.MalformedInputException;

/**
 * Created by ahmed on 30/04/16.
 */
public class alert_exit extends DialogFragment {

    View v;
    Button yes_button,no_button;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
     v=inflater.inflate(R.layout.exit_activity,container,false);
        getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        getDialog().getWindow().setBackgroundDrawableResource(
                android.R.color.transparent);
        yes_button=(Button)v.findViewById(R.id.butt_Yes);
        no_button=(Button)v.findViewById(R.id.butt_NO);

        yes_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.exit(0);
            }
        });

        no_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              getDialog().dismiss();
            }
        });
        return v;
    }
}
