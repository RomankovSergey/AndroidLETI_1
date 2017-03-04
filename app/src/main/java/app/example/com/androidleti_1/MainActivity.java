package app.example.com.androidleti_1;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button btnSecondActivity;
    Button btnSecondError;
    Button btnSecondFocus;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSecondActivity = (Button) findViewById(R.id.btnSecondActivity);
        btnSecondError = (Button) findViewById(R.id.btnError);
        btnSecondFocus = (Button)findViewById(R.id.btnFocus);

        btnSecondActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pushSecondActivity();
            }
        });

        btnSecondFocus = (Button)findViewById(R.id.btnFocus);
        btnSecondFocus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeRandomColor();
            }
        });

        btnSecondError = (Button) findViewById(R.id.btnError);
        btnSecondError.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAlert("Возникла ошибка");
            }
        });
    }


    private void changeRandomColor(){
        Random rnd = new Random();
        int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
        View view = this.getWindow().getDecorView();
        view.setBackgroundColor(color);
    }

    private void pushSecondActivity(){
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);

    }

    private void showAlert(String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Важное сообщение!")
                .setMessage(message)
                .setCancelable(false)
                .setNegativeButton("ОК",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
        AlertDialog alert = builder.create();
        alert.show();
    }

}
