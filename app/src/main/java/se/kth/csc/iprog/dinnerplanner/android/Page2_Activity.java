package se.kth.csc.iprog.dinnerplanner.android;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Observable;
import java.util.Observer;
import java.util.Set;

import se.kth.csc.iprog.dinnerplanner.android.view.FoodList;
import se.kth.csc.iprog.dinnerplanner.android.view.FoodView;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import se.kth.csc.iprog.dinnerplanner.model.Dish;
import se.kth.csc.iprog.dinnerplanner.model.Ingredient;


public class Page2_Activity extends Activity implements AdapterView.OnItemSelectedListener, View.OnClickListener, Observer {

    //for the dropdown
    private Spinner dropdown;
    private String[] items;

    //button
    private Button create;

    //textView
    private TextView totalCost;

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

        totalCost = (TextView)findViewById(R.id.textView2);

        dropdown = (Spinner)findViewById(R.id.spinner1);
        items = new String[]{"1", "2", "3", "4", "5"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, items);
        dropdown.setAdapter(adapter);
        dropdown.setOnItemSelectedListener(this);

        //Model
        model = ((DinnerPlannerApplication) this.getApplication()).getModel();

        //starter
        starter = new FoodList((LinearLayout) findViewById(R.id.foodlist01));
        Set<Dish> dishes01 = model.getDishes();
        for(Dish d : dishes01) {
            FoodView temp = new FoodView(model,d,Page2_Activity.this);
            starter.add(temp);
        }
        starter.addObserver(this);

        //main
        main = new FoodList((LinearLayout) findViewById(R.id.foodlist02));
        Set<Dish>dishes02 = model.getDishes();
        for(Dish d : dishes02) {
            FoodView temp = new FoodView(model,d,Page2_Activity.this);
            main.add(temp);
        }
        main.addObserver(this);

        //dessert
        dessert = new FoodList((LinearLayout) findViewById(R.id.foodlist03));
        Set<Dish> dishes03 = model.getDishes();
        for(Dish d : dishes03) {
            FoodView temp = new FoodView(model,d,Page2_Activity.this);
            dessert.add(temp);
        }
        dessert.addObserver(this);
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
        model.setNumberOfGuests(Integer.parseInt(items[position]));

        update(null,null);

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

    /**OBSERVER
     * @param observable
     * @param data
     */
    @Override
    public void update(Observable observable, Object data) {

        //TODO fixa så man kan ta bort saker från menyn
        if (observable instanceof FoodList) {
            //System.out.println("its a FoodView");
            FoodList temp = (FoodList) observable;

            if(temp.equals(starter)) {
                System.out.println("Starter");
                //model.removeTypeFromMenu(1);
                //model.addDishToMenu(starter.getSelected());
            }
            else if (temp.equals(main)) {
                System.out.println("Main");
                //model.removeTypeFromMenu(2);
                //model.addDishToMenu(main.getSelected());
            }
            else if (temp.equals(dessert)) {
                System.out.println("Dessert");
                //model.removeTypeFromMenu(3);
                //model.addDishToMenu(dessert.getSelected());
            }
        }

        //TODO Byta ut detta till model.gettotlafmenupricetrorjagdetheter()
        float price = 0;//model.getTotalMenuPrice();

        if(starter.getSelected() != null) {
            price += calculatePrice(starter.getSelected()) * model.getNumberOfGuests();
        }

        if(main.getSelected() != null) {
            price += calculatePrice(main.getSelected()) * model.getNumberOfGuests();
        }

        if(dessert.getSelected() != null) {
            price += calculatePrice(dessert.getSelected()) * model.getNumberOfGuests();
        }


        totalCost.setText("Total Cost: " + (float)((int) (price*100))/100 + "kr");
    }

    //calculate price for 1p
    private int calculatePrice(Dish d) {
        int price = 0;
        for(Ingredient I : d.getIngredients()) {
            if(I != null)
                price += I.getPrice();
        }
        return price;
    }
}
