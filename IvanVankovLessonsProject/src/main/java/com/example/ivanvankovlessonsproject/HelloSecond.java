package com.example.ivanvankovlessonsproject;

import android.app.ActionBar;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Hello on 6/21/13.
 */
public class HelloSecond extends Activity implements View.OnClickListener {

    Button buttonCheck, buttonCheckAsync, buttonThirdAct;
    EditText editTextCheck;
    public static final String PREFS = "examplePrefs";
    ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        buttonCheck = (Button) findViewById(R.id.bCheckAsync);
        buttonCheckAsync = (Button) findViewById(R.id.bCheckAsyncTask);
        buttonThirdAct = (Button) findViewById(R.id.bThirdAct);
        editTextCheck = (EditText) findViewById(R.id.etCheckAsync);

        buttonCheck.setOnClickListener(this);
        buttonCheckAsync.setOnClickListener(this);
        buttonThirdAct.setOnClickListener(this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent intent = new Intent(this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP |
                        Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.bCheckAsync:
                String message = editTextCheck.getText().toString();
                SharedPreferences examplePrefs = getSharedPreferences(PREFS, 0);
                SharedPreferences.Editor editor = examplePrefs.edit();
                editor.putString("userMessage", message);
                editor.commit();

                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP |
                        Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
                break;
            case R.id.bCheckAsyncTask:
                MyTask task = new MyTask();
                dialog = ProgressDialog.show(HelloSecond.this, "Downloading", "Preparing..");
                task.execute(4);
                break;
            case R.id.bThirdAct:
                Intent in = new Intent(this, ThirdActivity.class);
                in.putExtra("USER_NAME", "vanio");
                startActivity(in);


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

    private class MyTask extends AsyncTask<Integer, Integer, Void> {

        @Override
        protected Void doInBackground(Integer... objects) {
            try {
                for (int i = 1; i <= objects[0]; i++) {
                    Thread.sleep(1000);
                    Integer dt[] = new Integer[2];
                    dt[0] = i;
                    dt[1] = objects[0];
                    publishProgress(dt);
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            try {
                Thread.sleep(700);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                dialog.hide();
            }

        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            dialog.setMessage("Done:" + values[0].toString() + "from " +
                    values[1].toString());
        }
    }


}
