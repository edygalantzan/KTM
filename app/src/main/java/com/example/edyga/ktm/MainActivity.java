package com.example.edyga.ktm;

import android.icu.text.DecimalFormat;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import java.io.OutputStream;


public class MainActivity extends AppCompatActivity {

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button convertKmToMiles = (Button) findViewById(R.id.buttonConvertKmToMiles);
        convertKmToMiles.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {
                EditText editTextKm = (EditText) findViewById(R.id.editTextKm);
                EditText editTextMiles = (EditText) findViewById(R.id.editTextMiles);
                double km;
                try {
                    km = Double.valueOf(editTextKm.getText().toString());
                }
                catch (NumberFormatException e)
                {
                    km = 0;
                }
                double miles = km / 0.62137;
                System.out.print(km);
                System.out.print(miles);
                DecimalFormat format = new DecimalFormat("##.##");
                editTextMiles.setText(format.format(miles));
            }
        });

        Button convertMilesToKm = (Button) findViewById(R.id.buttonConvertMileasToKm);
        convertMilesToKm.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {
                EditText editTextKm = (EditText) findViewById(R.id.editTextKm);
                EditText editTextMiles = (EditText) findViewById(R.id.editTextMiles);
                double miles;
                try {
                    miles = Double.valueOf(editTextMiles.getText().toString());
                }
                catch (NumberFormatException e){
                    miles = 0;
                }
                double km = miles * 0.62137;
                System.out.print(km);
                System.out.print(miles);
                DecimalFormat format = new DecimalFormat("##.##");
                editTextKm.setText(format.format(km));
            }
        });

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Main Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }
}
