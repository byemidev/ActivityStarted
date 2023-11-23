package com.example.activitystarted;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btn1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = (Button) findViewById(R.id.button_marca);
        btn1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                Intent i=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.marca.com"));
                startActivity(i);
            }
        });
    }

    public void launchIntent(View view){
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse("https://www.google.com/"));
        startActivity(i);
    }
    //Devolver el resultado de una actividad
    public static final String REQUEST_RESULT= "REQUEST_RESULT";
    public void switch_act2(View view){
        EditText editText = (EditText) findViewById(R.id.edit_text_data);
        String text = editText.getText().toString();

        Intent i = new Intent(this, MainActivity2.class);
        i.putExtra(Intent.EXTRA_TEXT, text);
        startActivityForResult(i, 1);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==RESULT_OK){
            Toast.makeText(this, Integer.toString(data.getIntExtra(REQUEST_RESULT, 0)), Toast.LENGTH_LONG).show();
        }
    }



}