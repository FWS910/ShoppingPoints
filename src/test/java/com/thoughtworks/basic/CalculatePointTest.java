package com.thoughtworks.basic;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;


public class CalculatePointTest {

    @Test
    public void should_return_120_point_when_calculate_given_amount_is_120() {
        //given
        Calculateintegral calculatePoint = new Calculateintegral();
        ArrayList<Goods> goodsList = new ArrayList<Goods>();
        Goods cucumber = new Goods("tomato", new BigDecimal(50));
        Goods orange = new Goods("watermelon", new BigDecimal(70));
        goodsList.add(cucumber);
        goodsList.add(orange);
        //when
        int totalPoint = calculatePoint.calculate(goodsList);
        //then
        Assert.assertEquals(totalPoint, 120);
    }


}
