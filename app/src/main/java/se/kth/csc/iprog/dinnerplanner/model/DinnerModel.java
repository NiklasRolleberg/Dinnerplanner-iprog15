package se.kth.csc.iprog.dinnerplanner.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Observable;
import java.util.Set;

public class DinnerModel extends Observable  implements IDinnerModel{
    private int nGuests = 1;

    Set<Dish> dishes = new HashSet<Dish>();
    Set<Dish> menu = new HashSet<Dish>();
    Set<Ingredient> allIngredients = new HashSet<Ingredient>();


    /**
     * The constructor of the overall model. Set the default values here
     */
    public DinnerModel() {

        //Adding some example data, you can add more
        Dish dish1 = new Dish("French toast",Dish.STARTER,"toast.jpg","In a large mixing bowl, beat the eggs. Add the milk, brown sugar and nutmeg; stir well to combine. Soak bread slices in the egg mixture until saturated. Heat a lightly oiled griddle or frying pan over medium high heat. Brown slices on both sides, sprinkle with cinnamon and serve hot.");
        Ingredient dish1ing1 = new Ingredient("eggs",0.5,"",1);
        Ingredient dish1ing2 = new Ingredient("milk",30,"ml",6);
        Ingredient dish1ing3 = new Ingredient("brown sugar",7,"g",1);
        Ingredient dish1ing4 = new Ingredient("ground nutmeg",0.5,"g",12);
        Ingredient dish1ing5 = new Ingredient("white bread",2,"slices",2);
        dish1.addIngredient(dish1ing1);
        dish1.addIngredient(dish1ing2);
        dish1.addIngredient(dish1ing3);
        dish1.addIngredient(dish1ing4);
        dish1.addIngredient(dish1ing5);
        dishes.add(dish1);

        Dish dish2 = new Dish("Meat balls",Dish.MAIN,"meatballs.jpg","Preheat an oven to 400 degrees F (200 degrees C). Place the beef into a mixing bowl, and season with salt, onion, garlic salt, Italian seasoning, oregano, red pepper flakes, hot pepper sauce, and Worcestershire sauce; mix well. Add the milk, Parmesan cheese, and bread crumbs. Mix until evenly blended, then form into 1 1/2-inch meatballs, and place onto a baking sheet. Bake in the preheated oven until no longer pink in the center, 20 to 25 minutes.");
        Ingredient dish2ing1 = new Ingredient("extra lean ground beef",115,"g",20);
        Ingredient dish2ing2 = new Ingredient("sea salt",0.7,"g",3);
        Ingredient dish2ing3 = new Ingredient("small onion, diced",0.25,"",2);
        Ingredient dish2ing4 = new Ingredient("garlic salt",0.6,"g",3);
        Ingredient dish2ing5 = new Ingredient("Italian seasoning",0.3,"g",3);
        Ingredient dish2ing6 = new Ingredient("dried oregano",0.3,"g",3);
        Ingredient dish2ing7 = new Ingredient("crushed red pepper flakes",0.6,"g",3);
        Ingredient dish2ing8 = new Ingredient("Worcestershire sauce",16,"ml",7);
        Ingredient dish2ing9 = new Ingredient("milk",20,"ml",4);
        Ingredient dish2ing10 = new Ingredient("grated Parmesan cheese",5,"g",8);
        Ingredient dish2ing11 = new Ingredient("seasoned bread crumbs",115,"g",4);
        dish2.addIngredient(dish2ing1);
        dish2.addIngredient(dish2ing2);
        dish2.addIngredient(dish2ing3);
        dish2.addIngredient(dish2ing4);
        dish2.addIngredient(dish2ing5);
        dish2.addIngredient(dish2ing6);
        dish2.addIngredient(dish2ing7);
        dish2.addIngredient(dish2ing8);
        dish2.addIngredient(dish2ing9);
        dish2.addIngredient(dish2ing10);
        dish2.addIngredient(dish2ing11);
        dishes.add(dish2);

        Dish dish3 = new Dish("Sourdough",Dish.DESERT,"sourdough.jpg","improvise");
        Ingredient dish3ing1 = new Ingredient("extra large ground beef",2,"kg",200);
        Ingredient dish3ing2 = new Ingredient("sea water",5,"liters",1);

        dish3.addIngredient(dish3ing1);
        dish3.addIngredient(dish3ing2);
        dishes.add(dish3);

        Dish dish4 = new Dish("icecream",Dish.DESERT,"icecream.jpg","boil for 10 mins");
        Ingredient dish4ing1 = new Ingredient("ice",3,"dl",3);
        Ingredient dish4ing2 = new Ingredient("cream",1,"dl",10);

        dish4.addIngredient(dish4ing1);
        dish4.addIngredient(dish4ing2);
        dishes.add(dish4);

        Dish dish5 = new Dish("Berry cake",Dish.DESERT,"berrycake.jpg","mix stuff");
        Ingredient dish5ing1 = new Ingredient("Berry",3,"dl",3);
        Ingredient dish5ing2 = new Ingredient("cake",1,"dl",10);

        dish5.addIngredient(dish5ing1);
        dish5.addIngredient(dish5ing2);
        dishes.add(dish5);

        Dish dish6 = new Dish("chicken",Dish.MAIN,"chicken.jpg","put the chicken i a frying pan and wait");
        Ingredient dish6ing1 = new Ingredient("chickens",2,"st",55);
        Ingredient dish6ing2 = new Ingredient("rice",1,"kg",10);

        dish6.addIngredient(dish6ing1);
        dish6.addIngredient(dish6ing2);
        dishes.add(dish6);

        Dish dish7 = new Dish("chocolate cake",Dish.DESERT,"chocolatecake.jpg","eat");
        Ingredient dish7ing1 = new Ingredient("chocolate",2,"st",55);
        Ingredient dish7ing2 = new Ingredient("cake",1,"kg",10);

        dish7.addIngredient(dish7ing1);
        dish7.addIngredient(dish7ing2);
        dishes.add(dish7);

        Dish dish8 = new Dish("crostini",Dish.STARTER,"crostini.jpg","put the chicken i a frying pan and wait");
        Ingredient dish8ing1 = new Ingredient("chocolate",2,"st",55);
        Ingredient dish8ing2 = new Ingredient("cake",1,"kg",10);

        dish8.addIngredient(dish8ing1);
        dish8.addIngredient(dish8ing2);
        dishes.add(dish8);

        Dish dish9 = new Dish("meat",Dish.MAIN,"meat.jpg","just eat it raw");
        Ingredient dish9ing1 = new Ingredient("meat",2,"Kg",100);
        Ingredient dish9ing2 = new Ingredient("more meat",1,"kg",50);

        dish9.addIngredient(dish9ing1);
        dish9.addIngredient(dish9ing2);
        dishes.add(dish9);

        Dish dish10 = new Dish("mushroom tart",Dish.STARTER,"mushroomtart.jpg","run around in the room for 10 min");
        Ingredient dish10ing1 = new Ingredient("tart",2,"Kg",100);
        Ingredient dish10ing2 = new Ingredient("no meat",1,"kg",20);

        dish10.addIngredient(dish10ing1);
        dish10.addIngredient(dish10ing2);
        dishes.add(dish10);

        Dish dish11 = new Dish("shrimp plate",Dish.MAIN,"shrimpplate.jpg","walk around in the room for 10 min");
        Ingredient dish11ing1 = new Ingredient("shrimp",2,"Kg",100);
        Ingredient dish11ing2 = new Ingredient("plate",1,"kg",20);

        dish11.addIngredient(dish11ing1);
        dish11.addIngredient(dish11ing2);
        dishes.add(dish11);


        Dish dish12 = new Dish("shrimpsalad",Dish.STARTER,"shrimpsalad.jpg","walk around in the room for 10 min");
        Ingredient dish12ing1 = new Ingredient("shrimp",2,"Kg",100);
        Ingredient dish12ing2 = new Ingredient("green stuff",14,"kg",20);

        dish12.addIngredient(dish12ing1);
        dish12.addIngredient(dish12ing2);
        dishes.add(dish12);


        Dish dish13 = new Dish("tuna",Dish.MAIN,"tuna.jpg","open the can and eat");
        Ingredient dish13ing1 = new Ingredient("tuna",2,"Kg",100);
        Ingredient dish13ing2 = new Ingredient("nothing",14,"kg",20);

        dish13.addIngredient(dish13ing1);
        dish13.addIngredient(dish13ing2);
        dishes.add(dish13);


        Dish dish14 = new Dish("starter",Dish.STARTER,"start.jpg","eat");
        Ingredient dish14ing1 = new Ingredient("metal",2,"Kg",70);
        Ingredient dish14ing2 = new Ingredient("other stuff",14,"kg",20);

        dish14.addIngredient(dish14ing1);
        dish14.addIngredient(dish14ing2);
        dishes.add(dish14);


        Dish dish15 = new Dish("KAKA",Dish.DESERT,"kakor.jpg","it's good for you");
        Ingredient dish15ing1 = new Ingredient("kaka",2,"Kg",100);
        Ingredient dish15ing2 = new Ingredient("mjöl",14,"kg",20);

        dish15.addIngredient(dish15ing1);
        dish15.addIngredient(dish15ing2);
        dishes.add(dish15);

    }

    /**
     * Returns the set of dishes of specific type. (1 = starter, 2 = main, 3 = desert).
     */
    public Set<Dish> getDishes(){
        return dishes;
    }

    /**
     * Returns the set of dishes of specific type. (1 = starter, 2 = main, 3 = desert).
     */
    public Set<Dish> getDishesOfType(int type){
        Set<Dish> result = new HashSet<Dish>();
        for(Dish d : dishes){
            if(d.getType() == type){
                result.add(d);
            }
        }
        return result;
    }

    /**
     * Returns the set of dishes of specific type, that contain filter in their name
     * or name of any ingredient.
     */
    public Set<Dish> filterDishesOfType(int type, String filter){
        Set<Dish> result = new HashSet<Dish>();
        for(Dish d : dishes){
            if(d.getType() == type && d.contains(filter)){
                result.add(d);
            }
        }
        return result;
    }


    @Override
    public int getNumberOfGuests() {
        return nGuests;
    }

    @Override
    public void setNumberOfGuests(int numberOfGuests) {
        nGuests = numberOfGuests;
        setChanged();
        notifyObservers();
    }

    @Override
    public Dish getSelectedDish(int type) {
        Dish result = null;
        for (Dish d : menu){
            if (d.type == type){
                result = d;
            }
        }
        return result;
    }

    @Override
    public Set<Dish> getFullMenu() {
        return menu;
    }

    @Override
    public Set<Ingredient> getAllIngredients() {
        for (Dish d : menu) {
            for (Ingredient i : d.ingredients) {
                allIngredients.add(i);
            }
        }
        return allIngredients;
    }

    @Override
    public float getTotalMenuPrice() {
        float totPrice = 0;
        if (allIngredients == null || allIngredients.isEmpty()){
            getAllIngredients();
        }

        for (Ingredient i : allIngredients){
            totPrice += i.price;
        }
        return totPrice*nGuests;
    }

    @Override
    public void addDishToMenu(Dish dish) {

        //System.out.println("Adding " + dish.getName() + " to menu");

        menu.add(dish); //enough?!?!

        /*
        System.out.println("Menu is: ");
        for(Dish d : menu) {
            System.out.println(d.getName());
        }*/
    }

    @Override
    public void removeDishFromMenu(Dish dish) {
        menu.remove(dish); //enough?!?!?
    }

    @Override
    public void removeTypeFromMenu(int type) {
        //System.out.println("Removing type " + type + " from menu");
        ArrayList<Dish> remove = new ArrayList<Dish>();
        for (Dish d : menu){
            if(d != null) {
                if (d.type == type) {
                    remove.add(d);
                    //menu.remove(d); //enough?!?!?!?
                    //nej det är dumt att plocka bort saker ur samma set som om ittererar över
                }
            }
        }
        menu.removeAll(remove);
        allIngredients.clear();

        /*
        System.out.println("Menu is: ");
        for(Dish d : menu) {
            System.out.println(d.getName());
        }*/
    }
}
