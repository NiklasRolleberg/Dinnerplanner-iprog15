package se.kth.csc.iprog.dinnerplanner.android;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Set;

import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import se.kth.csc.iprog.dinnerplanner.model.Dish;


public class Page3_Activity extends Activity {

    //Model
    DinnerModel model;
    TextView info;
    TextView totalcost;
    LinearLayout list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page03_layout);
        getActionBar().setDisplayHomeAsUpEnabled(true);

        model = ((DinnerPlannerApplication) this.getApplication()).getModel();

        info = (TextView) findViewById(R.id.P3_infotext);
        totalcost = (TextView) findViewById(R.id.P3_totalcost);
        list = (LinearLayout) findViewById(R.id.P3_list);
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
