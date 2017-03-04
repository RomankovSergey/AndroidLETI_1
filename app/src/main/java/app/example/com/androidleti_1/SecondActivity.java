package app.example.com.androidleti_1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by romankov on 04.03.17.
 */

public class SecondActivity extends AppCompatActivity {

        Button btnExtit;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_second);

            btnExtit = (Button) findViewById(R.id.btnExit);
            btnExtit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    exitActivity();
                }
            });
        }


         private void exitActivity(){
             finish();
         }


}
