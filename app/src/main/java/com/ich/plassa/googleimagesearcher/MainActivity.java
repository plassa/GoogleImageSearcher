package com.ich.plassa.googleimagesearcher;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    public FilterModel filter;
    public static final int FILTER_RESULT = 50;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        filter = new FilterModel();
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
        //if (id == R.id.action_settings) {
        //        return true;
        // }

        if (id == R.id.miFilter) {
            Toast.makeText(this, "Clicked",
                    Toast.LENGTH_SHORT).show();
            // Navigate to the new activity
            // Create your intent
            Intent i = new Intent(this, FilterActivity.class);
            // Bundle "extra"
            i.putExtra("filter", filter);
            // Run the startActivity
            startActivityForResult(i, FILTER_RESULT);
            // Pass the current value

        }


        return super.onOptionsItemSelected(item);
    }

    /// Fires automatically when "form data" is posted
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // Handle the form data
        if (requestCode == FILTER_RESULT) {
            if (resultCode == RESULT_OK) {
                // Toast YES or NO based on if age is greater than 21
                // Get the age out of the form data
                filter = (FilterModel) data.getSerializableExtra("filter");
                // Check the age
                String message;
                if (filter.size == "small") {
                    message = "Small image";
                } else {
                    message = "Not Small image";
                }
                // Toast
                Toast.makeText(this, message,Toast.LENGTH_SHORT).show();
            }
        }
    }

}
