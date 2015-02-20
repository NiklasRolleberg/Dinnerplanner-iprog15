package se.kth.csc.iprog.dinnerplanner.android;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.renderscript.Type;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;

import java.util.Set;

import se.kth.csc.iprog.dinnerplanner.android.view.FoodView;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import se.kth.csc.iprog.dinnerplanner.model.Dish;
import se.kth.csc.iprog.dinnerplanner.model.IDinnerModel;
import se.kth.csc.iprog.dinnerplanner.model.Ingredient;


public class Page3_Activity extends Activity implements View.OnClickListener{

    //Model
    IDinnerModel model;
    TextView info;
    TextView people;
    TextView type;
    TextView totalcost;
    LinearLayout list;

    Dish starter;
    Dish main;
    Dish dessert;

    CustomView ingredientsCV;
    CustomView starterCV;
    CustomView mainCV;
    CustomView dessertCV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page03_layout);
        getActionBar().setDisplayHomeAsUpEnabled(true);

        model = ((DinnerPlannerApplication) this.getApplication()).getModel();

        info = (TextView) findViewById(R.id.P3_infotext);
        totalcost = (TextView) findViewById(R.id.P3_totalcost);
        people = (TextView) findViewById(R.id.peopleText);
        type = (TextView) findViewById(R.id.typeText);

        list = (LinearLayout) findViewById(R.id.P3_list);

        //TextViews
        totalcost.setText("Total cost:" + model.getTotalMenuPrice() + "kr");
        info.setText("Klicka på något");
        people.setText(model.getNumberOfGuests()+ " pers");
        type.setText("");


        //ImageViews
        list.removeAllViews();

        //Ingredients
        ingredientsCV = new CustomView(Page3_Activity.this,null,0);
        ingredientsCV.setOnClickListener(this);


        //starter
        starter = model.getSelectedDish(1);
        starterCV = new CustomView(Page3_Activity.this, starter, 1);
        starterCV.setOnClickListener(this);

        //Main
        main = model.getSelectedDish(2);
        mainCV = new CustomView(Page3_Activity.this, main, 2);
        mainCV.setOnClickListener(this);

        //dessert
        dessert = model.getSelectedDish(3);
        dessertCV = new CustomView(Page3_Activity.this, dessert,3);
        dessertCV.setOnClickListener(this);

        list.addView(ingredientsCV);
        list.addView(starterCV);
        list.addView(mainCV);
        list.addView(dessertCV);
    }

    @Override
    protected void onStart() {
        super.onStart();
        totalcost.setText("Total cost:" + model.getTotalMenuPrice() + "kr");
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

    @Override
    public void onClick(View v) {
        System.out.println("KLICK");

        if( !(v instanceof CustomView))
            return;

        CustomView clicked = (CustomView) v;

        //ingredients
        if(clicked.equals(ingredientsCV)) {
            ingredientsCV.setBackgroundColor(Color.RED);
            starterCV.setBackgroundColor(Color.TRANSPARENT);
            mainCV.setBackgroundColor(Color.TRANSPARENT);
            dessertCV.setBackgroundColor(Color.TRANSPARENT);

            type.setText("INGREDIENTS");

            String s = "";
            for(Ingredient i : model.getAllIngredients()) {
                if(i != null)
                    s += i.getName() + "  " + i.getQuantity()*model.getNumberOfGuests() + " " + i.getUnit() + "\n";
            }

            info.setText(s);

        }
        //stater
        else if(clicked.equals(starterCV)) {
            ingredientsCV.setBackgroundColor(Color.TRANSPARENT);
            starterCV.setBackgroundColor(Color.RED);
            mainCV.setBackgroundColor(Color.TRANSPARENT);
            dessertCV.setBackgroundColor(Color.TRANSPARENT);

            type.setText("STARTER");
            if (starter != null)
                info.setText(starter.getName() +"\n\n" + starter.getDescription());
            else
                info.setText("");
        }
        //main
        else if (clicked.equals(mainCV)) {
            ingredientsCV.setBackgroundColor(Color.TRANSPARENT);
            starterCV.setBackgroundColor(Color.TRANSPARENT);
            mainCV.setBackgroundColor(Color.RED);
            dessertCV.setBackgroundColor(Color.TRANSPARENT);

            type.setText("MAIN");
            if (main != null)
                info.setText(main.getName() +"\n\n" + main.getDescription());
            else
                info.setText("");
        }
        //dessert
        else if (clicked.equals(dessertCV)) {
            ingredientsCV.setBackgroundColor(Color.TRANSPARENT);
            starterCV.setBackgroundColor(Color.TRANSPARENT);
            mainCV.setBackgroundColor(Color.TRANSPARENT);
            dessertCV.setBackgroundColor(Color.RED);

            type.setText("DESSERT");
            if(dessert != null)
                info.setText(dessert.getName() +"\n\n" + dessert.getDescription());
            else
                info.setText("");
        }
    }

    class CustomView extends LinearLayout {

        ImageView IV;
        TextView TV;
        Context context;

        public CustomView(Context context, Dish dish, int type) {
            super(context);
            this.context = context;

            IV = new ImageView(context);
            TV = new TextView(context);

            //ingredients
            if(type == 0) {
                IV.setImageResource(R.drawable.ingredientsicon);
                TV.setText("Ingredients");
            }
            //food of some sort
            else {
                if(dish != null) {

                    String imageName = dish.getImage();
                    Drawable image;
                    if(imageName.contains(".jpg")) {
                        imageName = imageName.substring(0,imageName.length()-4);
                    }
                    image = context.getResources().getDrawable(context.getResources()
                            .getIdentifier(imageName, "drawable", context.getPackageName()));

                    IV.setImageDrawable(image);

                    switch (type) {
                        case 1:
                            TV.setText("Starter");
                            break;
                        case 2:
                            TV.setText("Main");
                            break;
                        case 3:
                            TV.setText("Dessert");
                            break;
                    }
                }
                else {
                    IV.setVisibility(INVISIBLE);
                }
            }

            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(210, 210);
            IV.setLayoutParams(layoutParams);

            this.setOrientation(VERTICAL);
            this.addView(IV);
            this.addView(TV);
            this.setPadding(5,5,5,5);
        }
    }
}
