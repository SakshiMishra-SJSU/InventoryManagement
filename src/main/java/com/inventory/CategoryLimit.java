package com.inventory;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryLimit {
    private static CategoryLimit categoryLimit = null;
     static int totalAmount;
     static int totalEssential=5;
     static int totalLuxury=3;
     static int totalMisc=6;

    public static int getTotalAmount() {
        return totalAmount;
    }

    public static int getTotalEssential() {
        return totalEssential;
    }

    public static int getTotalLuxury() {
        return totalLuxury;
    }

    public static int getTotalMisc() {
        return totalMisc;
    }

    public static void setTotalAmount(int totalAmount) {
        CategoryLimit.totalAmount -= totalAmount;
    }

    public static void setTotalEssential(int totalEssential) {
        CategoryLimit.totalEssential -= totalEssential;
    }

    public static void setTotalLuxury(int totalLuxury) {
        CategoryLimit.totalLuxury -= totalLuxury;
    }

    public static void setTotalMisc(int totalMisc) {
        CategoryLimit.totalMisc -= totalMisc;
    }

    // Static method
    // Static method to create instance of Singleton class
    public static CategoryLimit getInstance()
    {
        if (categoryLimit == null)
            categoryLimit = new CategoryLimit();

        return categoryLimit;
    }
}
