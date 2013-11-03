package com.example.ivanvankovlessonsproject;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends Activity implements View.OnClickListener {


    public static final String PREFS = "examplePrefs";
    Button buttonClick;
    Button buttonClick2;
    TextView textView;
    private int cc = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_home);
        buttonClick = (Button) findViewById(R.id.bClick);
        buttonClick2 = (Button) findViewById(R.id.bClick2);
        textView = (TextView) findViewById(R.id.tvClicked);

        SharedPreferences example = getSharedPreferences(PREFS, 0);
        String userString = example.getString("userMessage", "Nothing found");
        textView.setText(userString);




        buttonClick.setOnClickListener(this);
        buttonClick2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bClick:
                cc++;
                textView.setText("Hello " + cc);
                break;
            case R.id.bClick2:
                Intent in = new Intent(this, HelloSecond.class);
                in.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                in.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                startActivity(in);
                //finish();
                break;
        }
    }



    @Override
    protected void onResume() {
        super.onResume();
        overridePendingTransition(0, 0);

    }

    @Override
    protected void onPause() {
        super.onPause();
        overridePendingTransition(0, 0);
    }
}
