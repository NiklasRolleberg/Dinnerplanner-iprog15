package se.kth.csc.iprog.dinnerplanner.android.view;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Picture;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Set;

import se.kth.csc.iprog.dinnerplanner.android.R;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import se.kth.csc.iprog.dinnerplanner.model.Dish;
import se.kth.csc.iprog.dinnerplanner.model.Ingredient;

/**
 * Created by Niklas on 2015-02-10.
 */
public class FoodView implements View.OnClickListener{

    Dish food;
    DinnerModel model;
    View view;
    Context context;
    ImageView  image;

    boolean red = false;

    public FoodView(DinnerModel model, Dish d, Context context) {
        this.model = model;
        this.food = d;
        this.context = context;

        LinearLayout container = new LinearLayout(context);
        container.setOrientation(LinearLayout.VERTICAL);

        ImageView IV = new ImageView(context);

        TextView text = new TextView(context);
        //text.setText(d.getName());

        if(food != null) {
            String test  = food.getImage();


            IV.setImageResource(R.drawable.toast);
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
        IV.setMaxHeight(5);
        IV.setMaxWidth(5);

        container.addView(text);
        container.setPadding(5, 5, 5, 5);

        view = container;
        view.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {

        LinearLayout layout = new LinearLayout(context);
        layout.setOrientation(LinearLayout.HORIZONTAL);
        layout.setHorizontalGravity(Gravity.CENTER_HORIZONTAL);

        ImageView image = new ImageView(context);
        image.setImageResource(R.drawable.sourdough);
        layout.addView(image);

        TextView info = new TextView(context);
        info.setText("Cost: 500kr\n50kr/liter");
        if(food != null) {

            int price = 0;

            for(Ingredient I : food.getIngredients())
            {
                if(I!= null)
                {
                    price += I.getPrice();
                }
            }
            //TODO fixa kostnad
            info.setText("Cost: " + price*model.getNumberOfGuests() + "\n" + price + "kr/person");
        }
        layout.addView(info);

        AlertDialog alertDialog = new AlertDialog.Builder(context).create();
        alertDialog.setTitle("MAT");
        alertDialog.setView(layout);

        if(!red) {
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "Choose",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            view.setBackgroundColor(Color.RED);
                            red = true;
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
                            dialog.dismiss();
                        }
                    });
        }

        alertDialog.show();
    }
}
