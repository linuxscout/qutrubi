package verbs.conjugate.qutrubi.aplication_qutrubi_v12;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

/**
 * Created by ahmed on 19/07/16.
 */
public class level_class extends Activity {
    boolean verru1 =false;
    boolean verru2 =false;
    boolean verru3 =false;
    public static int note1 = 0;
    public static int note2 = 0;
    public static int note3 = 0;


    LinearLayout lL1 ;LinearLayout lL2 ;LinearLayout lL3 ;LinearLayout lL4 ;LinearLayout lL5 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.level);
        /*if (note1==5) verru1=true;
        if (note2==5) verru2=true;
        if (note3==5) verru3=true;







        lL1 =(LinearLayout)findViewById(R.id.Ln1);
        lL2 =(LinearLayout)findViewById(R.id.Ln2);
        lL3 =(LinearLayout)findViewById(R.id.Ln3);
        lL4 =(LinearLayout)findViewById(R.id.Ln4);
//        lL5 =(LinearLayout)findViewById(R.id.linear5);
*/
    }


   /* public void Lvel1(View view) {
        lL1.setBackgroundResource(R.drawable.unlok);

    }

    public void Lvel2(View view) {
        lL2.setBackgroundResource(R.drawable.unlok);
    }

    public void Lvel3(View view) {
        lL3.setBackgroundResource(R.drawable.unlok);
    }

    public void Lvel4(View view) {
        lL4.setBackgroundResource(R.drawable.unlok);
    }

    public void Lvel5(View view) {
        lL5.setBackgroundResource(R.drawable.unlok);
    }*/
}
