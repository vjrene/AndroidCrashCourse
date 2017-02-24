package com.example.parallel.coffeemaker;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Let's drink some coffee!", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        Button getCoffee = (Button) findViewById(R.id.button2);
        final ImageView coffee = (ImageView) findViewById(R.id.imageView);

        //anonymous class
        getCoffee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Log.i("main", "did this work?"); //logs information for debugging. shows up in the console.

                Context context = getApplicationContext(); //the context of the app
                CharSequence text = "A nice cup of Java!"; //the text that will show up in the toast
                int duration = Toast.LENGTH_LONG; //the length of time the toast will appear on the screen

                Toast toast = Toast.makeText(context, text, duration); //makeToast takes 3 arguments: Context, a String or CharSequence, and an integer
                toast.show();

                coffee.setImageResource(R.drawable.enjoy);

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        } else if ( id == R.id.action_about) {
            Intent intent = new Intent (this, About.class); //navigates within thie app, from this (MainActivity class) to the About activity class
            //Intent intent = new Intent (Intent.ACTION_VIEW, Uri.parse("http://pace.edu")); //navigates outside of the app, into the browser
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }
}
