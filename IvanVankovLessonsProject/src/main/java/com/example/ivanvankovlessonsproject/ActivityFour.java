package com.example.ivanvankovlessonsproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by Hello on 6/24/13.
 */
public class ActivityFour extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layoutfour);
        Button buttonRelative = (Button)findViewById(R.id.bRelativeTest);
        buttonRelative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ActivityFour.this, RelativeLayoutExample.class));
            }
        });
    }
}
