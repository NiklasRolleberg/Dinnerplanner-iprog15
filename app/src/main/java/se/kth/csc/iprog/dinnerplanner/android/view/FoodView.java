package se.kth.csc.iprog.dinnerplanner.android.view;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Observable;

import se.kth.csc.iprog.dinnerplanner.android.R;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import se.kth.csc.iprog.dinnerplanner.model.Dish;
import se.kth.csc.iprog.dinnerplanner.model.Ingredient;

/**
 * Created by Niklas on 2015-02-10.
 */
public class FoodView extends Observable implements View.OnClickListener {

    Dish food;
    DinnerModel model;
    View view;
    Context context;
    Drawable  image;
    boolean red = false;

    public FoodView(DinnerModel model, Dish d, Context context) {
        this.model = model;
        this.food = d;
        this.context = context;

        LinearLayout container = new LinearLayout(context);
        container.setOrientation(LinearLayout.VERTICAL);

        ImageView IV = new ImageView(context);
        TextView text = new TextView(context);
        text.setTextSize(12);

        if(food != null) {
            //TODO fixa fulhacket
            String imageName = food.getImage();

            if(imageName == "bakedbrie.jpg")
                image = context.getResources().getDrawable(R.drawable.bakedbrie);
            else if(imageName == "icecream.jpg")
                image = context.getResources().getDrawable(R.drawable.icecream);
            else if(imageName == "meatballs.jpg")
                image = context.getResources().getDrawable(R.drawable.meatballs);
            else if(imageName == "sourdough.jpg")
                image = context.getResources().getDrawable(R.drawable.sourdough);
            else if(imageName == "toast.jpg")
                image = context.getResources().getDrawable(R.drawable.toast);
            else if(imageName == "icecream.jpg")
                image = context.getResources().getDrawable(R.drawable.icecream);
            else
                image = context.getResources().getDrawable(R.drawable.ic_launcher);



            IV.setImageDrawable(image);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(220, 220);
            IV.setLayoutParams(layoutParams);
            text.setText(food.getName());
            text.setTextColor(Color.BLACK);
        }


        //enkelt exempel
        else {
            IV.setImageResource(R.drawable.sourdough);
            text.setTextColor(Color.BLACK);
            text.setText("glass");
        }

        container.addView(IV);
        container.addView(text);
        container.setPadding(5, 5, 5, 5);

        view = container;
        view.setOnClickListener(this);

    }

    public boolean isSelected() {
        return red;
    }

    public void setSelected(boolean selected) {
        red = selected;
        if(red)
            view.setBackgroundColor(Color.RED);
        else
            view.setBackgroundColor(Color.TRANSPARENT);
    }


    @Override
    public void onClick(View v) {

        LinearLayout layout = new LinearLayout(context);
        layout.setOrientation(LinearLayout.HORIZONTAL);
        layout.setHorizontalGravity(Gravity.CENTER_HORIZONTAL);

        String title = "MAT";

        ImageView imageV = new ImageView(context);
        imageV.setImageDrawable(image);
        layout.addView(imageV);

        TextView info = new TextView(context);
        info.setText("Cost: 500kr\n50kr/liter");
        if(food != null) {

            title = food.getName();
            int price = 0;

            for(Ingredient I : food.getIngredients())
            {
                if(I!= null)
                {
                    price += I.getPrice();
                }
            }
            info.setText("Cost: " + price*model.getNumberOfGuests() + "\n" + price + "kr/person");
        }
        layout.addView(info);

        AlertDialog alertDialog = new AlertDialog.Builder(context).create();
        alertDialog.setTitle(title);
        alertDialog.setView(layout);

        if(!red) {
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "Choose",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            view.setBackgroundColor(Color.RED);
                            red = true;

                            setChanged();
                            notifyObservers();
                            dialog.dismiss();
                        }
                    });
        }

        else {
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "Remove",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            view.setBackgroundColor(Color.TRANSPARENT);
                            red = false;

                            setChanged();
                            notifyObservers();
                            dialog.dismiss();
                        }
                    });
        }

        alertDialog.show();
    }
}
