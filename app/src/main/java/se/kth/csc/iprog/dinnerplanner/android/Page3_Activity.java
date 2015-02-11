package se.kth.csc.iprog.dinnerplanner.android;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.Set;

import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import se.kth.csc.iprog.dinnerplanner.model.Dish;


public class Page3_Activity extends Activity {

    //Model
    DinnerModel model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page03_layout);
        getActionBar().setDisplayHomeAsUpEnabled(true);

        model = ((DinnerPlannerApplication) this.getApplication()).getModel();

        //model test
        System.out.println("Test av model");

        Set<Dish> dishes = model.getDishes();

        System.out.println("Guests: " + model.getNumberOfGuests());
        System.out.println("Dishes: "+ dishes.size());

        for(Dish itterator : dishes)
        {
            System.out.println(itterator.getName());
            System.out.println(itterator.getDescription());
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_page3_, menu);
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
}
