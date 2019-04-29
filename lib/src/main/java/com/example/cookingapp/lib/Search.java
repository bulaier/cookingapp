package com.example.cookingapp.lib;

import java.net.URL;
import java.util.ArrayList;

import static com.example.cookingapp.lib.Testing.store;

public class Search {
    private static int number = store.length;

    /**
     *  This function returns a list of URLs of the recipes we show on the UI. The recipes depend on the ingredients the user enters, so ideally use with search method.
     * @param recipes The recipes we return. It should be the result (output) of the Search.search function.
     * @return an arraylist of URLs.
     */
    public ArrayList<URL> getImages(ArrayList<Recipe> recipes) {
        ArrayList<URL> urls = new ArrayList<>();
        if (recipes == null) {
            return urls;
        }
        for (int i = 0; i < recipes.size(); i++) {
            urls.add(recipes.get(i).getImage());
        }
        return urls;
    }

    /**
     *   seperate the ingredients with " ," and all small case letters. No plurals please.
     * @param str the string entered by UI interface. (ingredients the user have)
     * @return an arraylist of recipes.
     */
    public static ArrayList<Recipe> search(String str) {
        if (str == null) {
            return null;
        }
        ArrayList<String> ingredients = new ArrayList<>();
        ArrayList<Recipe> recipes = new ArrayList<>();
        String[] s = str.split(", ");
        for (int i = 0; i < s.length; i++) {
            ingredients.add(s[i]);
        }
        for (int i = 0; i < number; i++) {
            boolean b = true;
            for (String name : store[i].getIngredients()) {
                if (!ingredients.contains(name)) {
                    b = false;
                    break;
                }
            }
            if (b) {
                recipes.add(store[i]);
            }
        }
        return recipes;
    }
}