package org.pengu.service;

import org.pengu.model.Cake;
import org.pengu.model.CakeValueOverWeight;
import org.pengu.model.DuffelBag;

import java.util.Collections;
import java.util.List;

public class CakeService {


    public int maxDuffelBagValue(List<Cake> cakeList, int weight) {
        DuffelBag duffelBag = new DuffelBag(weight);
        Collections.sort(cakeList, new CakeValueOverWeight());

        for (Cake cake : cakeList) {
            while (duffelBag.tryToAddCakeToBag(cake)) ;

        }

        int totalValue = 0;
        for (Cake cake : duffelBag.getCakesInBag()) {
            totalValue = totalValue + cake.getValue();
        }
        return totalValue;
    }
}
