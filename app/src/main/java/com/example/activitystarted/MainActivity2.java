package com.example.activitystarted;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        //sobrecarga del metodo onCreate() para trasmitir el texto de la vista MainActivity de EditText a MainActivity2
        TextView textview = (TextView) findViewById(R.id.textView_text);
        if(getIntent()!= null && getIntent().hasExtra(Intent.EXTRA_TEXT)){
            textview.setText(getIntent().getStringExtra(Intent.EXTRA_TEXT));
        }
    }
    //cerrar vista act2
    public void onClickClose(){
        Intent returnIntent = new Intent();
        returnIntent.putExtra(MainActivity.REQUEST_RESULT, 42);
        setResult(RESULT_OK, returnIntent);
        finish();
    }
}