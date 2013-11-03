package com.example.ivanvankovlessonsproject;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Hello on 6/22/13.
 */
public class ThirdActivity extends Activity implements View.OnClickListener {

    TextView textViewShared;
    Button buttonCheckAlert;
    Button buttonTestContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sharedexample);
        textViewShared = (TextView) findViewById(R.id.tvShared);
        buttonCheckAlert = (Button) findViewById(R.id.bCheckAlert);
        buttonCheckAlert.setOnClickListener(this);
        buttonTestContext = (Button) findViewById(R.id.bTestContext);
        buttonTestContext.setOnClickListener(this);

    }

    @Override
    protected void onResume() {
        super.onResume();
        String data = getIntent().getStringExtra("USER_NAME");
        textViewShared.setText(data);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bCheckAlert:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage("Should I do it..?");
                builder.setPositiveButton("Do it!", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast t = Toast.makeText(ThirdActivity.this, "OK, ready", Toast.LENGTH_LONG);
                        t.show();
                    }
                });
                builder.setNegativeButton("Don't do it!", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast t = Toast.makeText(ThirdActivity.this, "No problem", Toast.LENGTH_LONG);
                        t.show();
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
                break;
            case R.id.bTestContext:
                startActivity(new Intent(this, ActivityFour.class));
                break;
        }


    }


}
