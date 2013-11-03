package com.example.ivanvankovlessonsproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by Hello on 6/25/13.
 */
public class RelativeLayoutExample extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.relative);
        Button buttonTable = (Button) findViewById(R.id.bTableLayout);
        buttonTable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RelativeLayoutExample.this, TableLayout.class));
            }
        });
        Button buttonGrid = (Button) findViewById(R.id.bGridLayout);
        buttonGrid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RelativeLayoutExample.this, GridLayout.class));

            }
        });
    }
}
