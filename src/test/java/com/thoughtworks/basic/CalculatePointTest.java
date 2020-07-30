package com.thoughtworks.basic;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;


public class CalculatePointTest {

// 需求一
    @Test
    public void should_return_120_point_when_calculate_given_amount_is_120() {
        //given
        Calculateintegral calculatePoint = new Calculateintegral();
        ArrayList<Goods> goodsList = new ArrayList<Goods>();
        Goods cucumber = new Goods("TOMATO", new BigDecimal(50));
        Goods orange = new Goods("WATERMELON", new BigDecimal(70));
        goodsList.add(cucumber);
        goodsList.add(orange);
        //when
        int totalPoint = calculatePoint.calculate(goodsList);
        //then
        Assert.assertEquals(totalPoint, 120);
    }
// 需求二
    @Test
    public void should_return_190_point_when_calculate_given_include_promotions_goods_and_amount_is_100() {
        //given
        Calculateintegral calculatePoint = new Calculateintegral();
        ArrayList<Goods> goodsList = new ArrayList<Goods>();
        Goods WATERMELON = new Goods("WATERMELON", new BigDecimal(70));
        Goods APPLE = new Goods("APPLE", new BigDecimal(20));
        Goods Detergent = new Goods("TOMATO", new BigDecimal(10));
        goodsList.add(WATERMELON);
        goodsList.add(APPLE);
        goodsList.add(Detergent);
        //when
        int totalPoint = calculatePoint.calculate(goodsList);
        //then
        Assert.assertEquals(totalPoint, 190);
    }
    //    需求三
    @Test
    public void should_return_1067_point_when_calculate_given_amount_is_2350() {
        //given
        Calculateintegral calculatePoint = new Calculateintegral();
        ArrayList<Goods> goodsList = new ArrayList<Goods>();
        Goods WATERMELON = new Goods("REFRIGERATOR", new BigDecimal(2350));
        goodsList.add(WATERMELON);
        //when
        int totalPoint = calculatePoint.calculate(goodsList);
        //then
        Assert.assertEquals(totalPoint, 1067);
    }





}
