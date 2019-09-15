package org.pengu.service;

import org.junit.Assert;
import org.junit.Test;
import org.pengu.model.Cake;

import java.util.Arrays;
import java.util.List;

public class CakeServiceTest {

    @Test
    public void maxDuffelBagValue() {
        CakeService cakeService = new CakeService();
        
        List<Cake> generatedCakeList = Arrays.asList(
                new Cake(7, 160),
                new Cake(3, 90),
                new Cake(2, 15));
        int weight = 20;
        int maximumValue = 555;

        Assert.assertEquals(cakeService.maxDuffelBagValue(generatedCakeList, weight), maximumValue);
    }

}