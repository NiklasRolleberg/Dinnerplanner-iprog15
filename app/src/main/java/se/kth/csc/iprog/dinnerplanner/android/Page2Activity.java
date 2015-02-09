package se.kth.csc.iprog.dinnerplanner.android;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;


public class Page2Activity extends Activity implements AdapterView.OnItemSelectedListener, View.OnClickListener {

    //for the dropdown
    private Spinner dropdown;
    private String[] items;

    //button
    private Button create;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page02_layout);

        getActionBar().setDisplayHomeAsUpEnabled(true);

        create = (Button)findViewById(R.id.createButton);
        create.setOnClickListener(this);

        dropdown = (Spinner)findViewById(R.id.spinner1);
        items = new String[]{"1", "2", "3","4","5"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, items);
        dropdown.setAdapter(adapter);
        dropdown.setOnItemSelectedListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_page2, menu);
        return false;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
        }
        return super.onOptionsItemSelected(item);
    }


    /**Listener methods for spinner*/
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        System.out.println("Nu valdes: "+ items[position] + " participants" );

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        System.out.println("inget valt");
    }


    /** Onclicklistener for the button*/
    @Override
    public void onClick(View v) {
        System.out.println("KLICK!");
    }
}
