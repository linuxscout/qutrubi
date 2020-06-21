package verbs.conjugate.qutrubi.aplication_qutrubi_v12;

/*
 * Created by ahmed and redouane 2016.
 */

import android.app.DialogFragment;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.RadioButton;
import java.util.Locale;


public class setting_dialog extends DialogFragment implements View.OnClickListener {


   private RadioButton arabRadioButton,englichRadioButton;

   private  Locale myLocale;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View   v=inflater.inflate(R.layout.setting, container,false);

        getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        getDialog().getWindow().setBackgroundDrawableResource(
                android.R.color.transparent);


       arabRadioButton=(RadioButton)v.findViewById(R.id.arab_rad);
      englichRadioButton=(RadioButton)v.findViewById(R.id.eng_rad);


       if(getString(R.string.arab_language).equals("Arabic")){
           englichRadioButton.setChecked(true);
       }else
      {
           arabRadioButton.setChecked(true);
        }

        arabRadioButton.setOnClickListener(this);
        englichRadioButton.setOnClickListener(this);


        return v;

    }


    public void setLocale(String lang) {

        myLocale = new Locale(lang);
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.locale = myLocale;
        res.updateConfiguration(conf, dm);
         this.getActivity().finish();

      Intent refresh = new Intent(this.getActivity(), MainActivity.class);
         startActivity(refresh);



    }


    @Override
    public void onClick(View v) {
        boolean checked = ((RadioButton) v).isChecked();
        switch(v.getId()) {
            case R.id.arab_rad:
                if (checked) {
                    Log.i("MENU", (String) ((RadioButton)v).getText());
                    setLocale("ar");
                }
                break;
            case R.id.eng_rad:
                if (checked) {
                    Log.i("MENU", (String) ((RadioButton) v).getText());
                    setLocale("en");
                }
                break;

        }

    }
}
