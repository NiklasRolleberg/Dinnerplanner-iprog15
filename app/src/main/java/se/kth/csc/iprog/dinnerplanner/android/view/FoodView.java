package se.kth.csc.iprog.dinnerplanner.android.view;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.media.Image;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import se.kth.csc.iprog.dinnerplanner.android.R;
import se.kth.csc.iprog.dinnerplanner.model.Dish;

/**
 * Created by Niklas on 2015-02-10.
 */
public class FoodView implements View.OnClickListener{

    Dish food;
    View view;
    Context context;
    ImageView  image;

    boolean red = false;

    public FoodView(Dish d, Context context) {
        this.food = d;
        this.context = context;

        //enkelt exempel
        if(d == null) {
            LinearLayout container = new LinearLayout(context);
            container.setOrientation(LinearLayout.VERTICAL);

            ImageView IV = new ImageView(context);

            IV.setImageResource(R.drawable.sourdough);

            TextView text = new TextView(context);
            text.setTextColor(Color.BLACK);
            text.setText("glass");

            container.addView(IV);
            container.addView(text);
            container.setPadding(5, 5, 5, 5);

            view = container;
            view.setOnClickListener(this);
        }
        //fixa massa med maten
        System.out.println("FoodView Object created");
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
