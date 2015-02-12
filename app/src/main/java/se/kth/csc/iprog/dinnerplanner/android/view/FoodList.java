package se.kth.csc.iprog.dinnerplanner.android.view;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import se.kth.csc.iprog.dinnerplanner.model.Dish;

/**
 * Created by Niklas on 2015-02-10.
 */
public class FoodList extends Observable implements Observer{

    LinearLayout view;
    ArrayList<FoodView> foods;
    FoodView selected;


    public FoodList(LinearLayout LL) {

        // store in the class the reference to the Android View
        this.view = LL;
        view.removeAllViews();
        foods = new ArrayList<FoodView>();
    }

    public void add(FoodView FV) {
        FV.addObserver(this);
        view.addView(FV.view);
        view.invalidate();
        foods.add(FV);

    }

    public Dish getSelected() {
        if (selected != null)
            return selected.food;
        return null;
    }

    @Override
    public void update(Observable observable, Object data) {

        if (observable instanceof FoodView) {
            //System.out.println("its a FoodView");
            FoodView temp = (FoodView) observable;

            if (temp.isSelected()) {
                for(FoodView f : foods)
                {
                    if(!f.equals(temp))
                    {
                        f.setSelected(false);
                    }
                }
                selected = temp;
            }
            else {
                selected = null;
            }
            setChanged();
        }
        notifyObservers();
    }
}
