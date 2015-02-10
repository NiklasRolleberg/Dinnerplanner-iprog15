package se.kth.csc.iprog.dinnerplanner.android.view;

import android.graphics.Color;
import android.widget.LinearLayout;

/**
 * Created by Niklas on 2015-02-10.
 */
public class FoodList {
    LinearLayout view;

    public FoodList(LinearLayout LL) {

        // store in the class the reference to the Android View
        this.view = LL;

        LL.setBackgroundColor(Color.RED);
    }

    public void AddFood(FoodView FV) {
        view.addView(FV.food);
    }
}
