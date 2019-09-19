package org.pengu.service;

import org.pengu.model.Cake;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

 class CakeService {
     private ArrayList<Cake> sortedCakes;
     int maxDuffelBagValue(List<Cake> cakeList, int weight) {
         //sort cakes by order
        class sortByValue implements Comparator<Cake> {
            @Override
            public int compare(Cake a, Cake b) {
                return a.getValue() / a.getWeight() - b.getValue() / b.getWeight();
            }
        }
        sortedCakes = new ArrayList<>(cakeList);
        sortedCakes.sort(new sortByValue());
        /*System.out.println("cakes sorted by value density");
        for(Cake cake : sortedCakes){
            System.out.println(cake);
        }*/


        return maxValue(weight,1);
     }
     private int maxValue(int space,int index) {
         Cake cake = sortedCakes.get(sortedCakes.size()-index);
         int extraSpace = space % cake.getWeight();
         int value = space / cake.getWeight() * cake.getValue();
         if(extraSpace != 0 && sortedCakes.size() - index != 0 && extraSpace != space){
             int multipleCakesValue = maxValue(extraSpace + cake.getWeight(),index + 1);
             if(multipleCakesValue >= cake.getValue()) return value - cake.getValue() + multipleCakesValue;
         }
         return extraSpace == 0 || sortedCakes.size() - index == 0 ? value: value + maxValue(extraSpace,index + 1);
     }
 }

