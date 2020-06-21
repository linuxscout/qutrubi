package verbs.conjugate.qutrubi.aplication_qutrubi_v12;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

/**
 * Created by ahmed and redouane on 2016.
 */
public class Games extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_games);
        TextView back = (TextView) findViewById(R.id.Back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        TextView pronoun=(TextView)findViewById(R.id.butt_pronom);
        TextView verb=(TextView)findViewById(R.id.butt_primary);
        TextView prop=(TextView)findViewById(R.id.butt_avdance);

        pronoun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Games.this,pronoungame.class));
            }
        });
        verb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Games.this,verbsgame.class));
//                startActivity(new Intent(Games.this,level_class.class));
            }
        });
        prop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Games.this,propgame.class));

            }
        });

    }
}

