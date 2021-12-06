package com.inventory;

import java.util.HashMap;
import java.util.Set;

public class Essentials implements CategoryChain {

    private CategoryChain nextInCategoryChain;

    // Defines the next Object to receive the
    // data if this one can't use it

    public void setNextCategory(CategoryChain nextCategoryChain) {

        nextInCategoryChain = nextCategoryChain;

    }


    // Tries to calculate the data, or passes it
    // to the Object defined in method setNextChain()

    public double calculatePrice(HashMap<String, Items> inventory , String item , int quantity, Set<String> error,
          Set<String> essentialsSeen,Set<String> luxurySeen,Set<String> MissSeen) {
        Items items = inventory.get(item);

        if(items.Category == Category.ESSENTIALS){
            essentialsSeen.add(item);
            if(quantity<=items.getQuantity()){
                CategoryLimit.setTotalEssential(quantity);
                items.setQuantity(items.getQuantity()-quantity);
                return quantity* items.getPrice();
            }
			else{
                error.add(item);
                return 0;
            }
        }
        else {
            return nextInCategoryChain.calculatePrice(inventory,item , quantity,error,essentialsSeen,luxurySeen,MissSeen);
        }
    }
}