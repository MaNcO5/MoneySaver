package com.example.manco.moneysaver1;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by MANCO on 9/21/2016.
 */
public class SharedPrefs extends Activity implements View.OnClickListener {

    EditText sharedData;
    TextView dataResults;
    public static String filename = "MySharedString";
    SharedPreferences someData;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sharedpreferences);
        setupVariables();
        someData = getSharedPreferences(filename, 0);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int) (width * .8), (int) (height * .35));

        final Button ok = (Button) findViewById(R.id.btnOk);

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent registerIntent = new Intent(SharedPrefs.this, MainActivity.class);
                SharedPrefs.this.startActivity(registerIntent);

            }
        });


    }

    private void setupVariables(){
        Button save = (Button)findViewById(R.id.bSave);
        sharedData = (EditText)findViewById(R.id.etSharedPrefs);
        dataResults = (TextView) findViewById(R.id.tvLoadSheredPrefs);
        save.setOnClickListener(this);
    }

    public void onClick(View v){
        switch (v.getId()){
            case R.id.bSave:
                String stringData = sharedData.getText().toString();
                SharedPreferences.Editor editor = someData.edit();
                editor.putString("sharedString", stringData);
                editor.commit();
                someData = getSharedPreferences(filename, 0);
                String dataReturned = someData.getString("sharedString", "Couldn't Load Data");
                dataResults.setText(dataReturned);
                break;


        }
    }
}
