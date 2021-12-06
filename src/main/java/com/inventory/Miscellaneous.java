package com.inventory;

import java.util.HashMap;
import java.util.Set;

public class Miscellaneous implements CategoryChain {

    private CategoryChain nextInCategoryChain;

    @Override
    public void setNextCategory(CategoryChain nextCategoryChain) {
        nextInCategoryChain = nextCategoryChain;
    }

    @Override
    public double calculatePrice(HashMap<String, Items> inventry , String item , int quantity, Set<String> error,
                            Set<String> essentialsSeen,Set<String> luxurySeen,Set<String> MissSeen)  {
        Items items = inventry.get(item);
        if(items.Category == Category.MISCELLENEOUS){
            MissSeen.add(item);
            if(quantity<=items.getQuantity()){
                CategoryLimit.setTotalMisc(quantity);
                items.setQuantity(quantity);
                return quantity* items.getPrice();
            }
            else{
                error.add(item);
                return 0;
            }
        }
        else
        {
            return 0;
        }
    }
}
