package com.inventory;

import java.util.HashMap;
import java.util.Set;

public class Luxury implements CategoryChain {

    private CategoryChain nextInCategoryChain;

    @Override
    public void setNextCategory(CategoryChain nextCategoryChain) {
        nextInCategoryChain = nextCategoryChain;
    }

    @Override
    public double calculatePrice(HashMap<String, Items> inventory , String item , int quantity, Set<String> error,
                            Set<String> essentialsSeen,Set<String> luxurySeen,Set<String> MissSeen)  {
        Items items = inventory.get(item);
        if(items.Category == Category.LUXURY){
            luxurySeen.add(item);
            if( quantity<=items.getQuantity()){
                CategoryLimit.setTotalLuxury(quantity);
                items.setQuantity(quantity);
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
