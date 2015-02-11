package se.kth.csc.iprog.dinnerplanner.android;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import se.kth.csc.iprog.dinnerplanner.android.view.FoodList;
import se.kth.csc.iprog.dinnerplanner.android.view.FoodView;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;


public class Page2_Activity extends Activity implements AdapterView.OnItemSelectedListener, View.OnClickListener {

    //for the dropdown
    private Spinner dropdown;
    private String[] items;

    //button
    private Button create;

    //food stuff
    private FoodList starter;
    private FoodList main;
    private FoodList dessert;

    //Model
    DinnerModel model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page02_layout);

        getActionBar().setDisplayHomeAsUpEnabled(true);

        create = (Button)findViewById(R.id.createButton);
        create.setOnClickListener(this);

        dropdown = (Spinner)findViewById(R.id.spinner1);
        items = new String[]{"1", "2", "3", "4", "5"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, items);
        dropdown.setAdapter(adapter);
        dropdown.setOnItemSelectedListener(this);

        //Model
        model = ((DinnerPlannerApplication) this.getApplication()).getModel();


        //TODO skapa en View som visar bilden och texten för mat (för all mat)

        //starter
        starter = new FoodList((LinearLayout) findViewById(R.id.foodlist01));

        /*
        FoodView test1 = new FoodView(null, Page2_Activity.this);
        starter.add(test1);

        FoodView test2 = new FoodView(null, Page2_Activity.this);
        starter.add(test2);

        FoodView test3 = new FoodView(null, Page2_Activity.this);
        starter.add(test3);

        FoodView test4 = new FoodView(null, Page2_Activity.this);
        starter.add(test4);

        FoodView test5 = new FoodView(null, Page2_Activity.this);
        starter.add(test5);
        */

        //main
        main = new FoodList((LinearLayout) findViewById(R.id.foodlist02));

        FoodView test6 = new FoodView(null, Page2_Activity.this);
        main.add(test6);

        FoodView test7 = new FoodView(null, Page2_Activity.this);
        main.add(test7);

        FoodView test8 = new FoodView(null, Page2_Activity.this);
        main.add(test8);

        FoodView test9 = new FoodView(null, Page2_Activity.this);
        main.add(test9);

        FoodView test10 = new FoodView(null, Page2_Activity.this);
        main.add(test10);

        //dessert
        dessert = new FoodList((LinearLayout) findViewById(R.id.foodlist03));

        FoodView test11 = new FoodView(null, Page2_Activity.this);
        dessert.add(test11);

        FoodView test12 = new FoodView(null, Page2_Activity.this);
        dessert.add(test12);

        FoodView test13 = new FoodView(null, Page2_Activity.this);
        dessert.add(test13);

        FoodView test14 = new FoodView(null, Page2_Activity.this);
        dessert.add(test14);

        FoodView test15 = new FoodView(null, Page2_Activity.this);
        dessert.add(test15);
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
        Intent intent = new Intent(this, Page3_Activity.class);
        startActivity(intent);
    }
}
