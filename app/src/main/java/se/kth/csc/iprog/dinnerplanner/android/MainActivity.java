package se.kth.csc.iprog.dinnerplanner.android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import se.kth.csc.iprog.dinnerplanner.android.view.ExampleView;


public class MainActivity extends Activity implements View.OnClickListener {

    Button start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Default call to load previous state
        super.onCreate(savedInstanceState);

        // Set the view for the main activity screen
        // it must come before any call to findViewById method
        setContentView(R.layout.page01_layout);
        start = (Button)findViewById(R.id.p1_button);
        start.setOnClickListener(this);
        // Creating the view class instance
        //ExampleView mainView = new ExampleView(findViewById(R.id.this_is_example_view_id));
    }

    @Override
    public void onClick(View v) {

        Intent intent = new Intent(this, Page2Activity.class);
        startActivity(intent);
    }
}
