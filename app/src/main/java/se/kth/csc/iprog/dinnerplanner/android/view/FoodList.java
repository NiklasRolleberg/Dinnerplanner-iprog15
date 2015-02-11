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
        view.removeAllViews();
    }

    public void add(FoodView FV) {
        view.addView(FV.view);
        view.invalidate();
    }
}
