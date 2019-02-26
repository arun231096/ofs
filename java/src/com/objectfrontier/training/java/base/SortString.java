package com.objectfrontier.training.java.base;
import java.util.Arrays;

public class SortString {

    private String[] sortCity(String[] city) {

        Arrays.sort(city, String.CASE_INSENSITIVE_ORDER);
        return city;
    }

    private void displayEvenIndexedCity(String[] city) {

        for (int i = 0; i <= city.length; i++) {
            if (i % 2 == 0 && i != 0 ) {
                System.out.println(city[i].toUpperCase());
            }
        }
    }

    public static void main(String[] args) {

        String[] city = {"Madurai","Thanjavur","TRICHY","Karur","Erode","trichy","Salem"};
        SortString orderCity = new SortString();
        String sortedcity[] = orderCity.sortCity(city);
        orderCity.displayEvenIndexedCity(sortedcity);
    }
}
