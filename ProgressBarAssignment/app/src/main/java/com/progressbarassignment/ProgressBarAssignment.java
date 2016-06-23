package com.progressbarassignment;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class ProgressBarAssignment extends AppCompatActivity implements View.OnClickListener {

    private ProgressBar mProgressBar1;
    private ProgressBar mProgressBar2;
    private ProgressBar mProgressBar3;
    private ProgressBar mProgressBar4;

    Integer count = 1;

    private Button mStartDownload;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_bar_assignment);

        mProgressBar1 = (ProgressBar) findViewById(R.id.progressBar1);
        mProgressBar1.setMax(10);
        mProgressBar2 = (ProgressBar) findViewById(R.id.progressBar2);
        mProgressBar2.setMax(10);
        mProgressBar3 = (ProgressBar) findViewById(R.id.progressBar3);
        mProgressBar3.setMax(20);
        mProgressBar4 = (ProgressBar) findViewById(R.id.progressBar4);
        mProgressBar4.setMax(20);

        mStartDownload = (Button) findViewById(R.id.start_download);


        mStartDownload.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        count = 1;
        new Downloader().execute(10);
        count = 1;
        new Downloader1().execute(20);

    }

    class Downloader extends AsyncTask<Integer, Integer, String>{

        @Override
        protected void onPreExecute() {

            mProgressBar1.setProgress(0);
            mProgressBar2.setProgress(0);
            count = 1;
            Log.e("Status",count.toString());
        }

        @Override
        protected void onProgressUpdate(Integer... values) {

            mProgressBar1.setProgress(values[0]);
            mProgressBar2.setProgress(values[0]);
            Log.e("Status","Running");

        }

        @Override
        protected String doInBackground(Integer... integers) {

            for(;count<=integers[0];count++){

                try {

                    Thread.sleep(1000);
                    publishProgress(count);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

            return "Download Complete.";
        }

        @Override
        protected void onPostExecute(String s) {

            count = 1;
        }
    }

    class Downloader1 extends AsyncTask<Integer, Integer, String>{

        @Override
        protected void onPreExecute() {

            mProgressBar3.setProgress(0);
            mProgressBar4.setProgress(0);
            count = 1;


        }

        @Override
        protected void onProgressUpdate(Integer... values) {

            mProgressBar3.setProgress(values[0]);
            mProgressBar4.setProgress(values[0]);

        }

        @Override
        protected String doInBackground(Integer... integers) {

            for(;count<=integers[0];count++){

                try {

                    Thread.sleep(2000);
                    publishProgress(count);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

            return "Download Complete.";
        }

        @Override
        protected void onPostExecute(String s) {

            count = 1;
        }
    }
}
