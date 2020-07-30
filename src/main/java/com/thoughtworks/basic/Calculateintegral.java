package com.thoughtworks.basic;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Calculateintegral {
    public int calculate(ArrayList<Goods> goodsList){
        List<String> promotionNameList = getPromotion();
        BigDecimal promotionTotalCost = BigDecimal.ZERO;
        BigDecimal normalTotalCost = BigDecimal.ZERO;
        BigDecimal totalCost = getTotalCost(goodsList);
        int promotionTotalPoint = 0;
        int normalTotalPoint = 0;
        int totalPoint = 0 ;
        boolean totalCostGreter1000 = totalCost.compareTo(Integral_price.integralRule1000) == 1;
        for(int num=0;num<goodsList.size();num++){
            Goods goods = goodsList.get(num);
            if(promotionNameList.contains(goods.getName())){
                promotionTotalCost = promotionTotalCost.add(goods.getCost());
            }else{
                normalTotalCost = normalTotalCost.add(goods.getCost());
            }
        }

        if(!totalCostGreter1000){
            totalPoint = promotionTotalCost.intValue()*2 + normalTotalCost.intValue();
        }else{
            if(promotionTotalCost.intValue() < 1000){
                promotionTotalPoint = promotionTotalCost.setScale(0,BigDecimal.ROUND_DOWN).intValue()*2;
                normalTotalPoint = Integral_price.integralRule1000.subtract(promotionTotalCost).intValue() +
                        totalCost.subtract(Integral_price.integralRule1000).divide(Integral_price.integralRule20).setScale(0,BigDecimal.ROUND_DOWN).intValue();
            }else{
                promotionTotalPoint = 1000*2  +  promotionTotalCost.subtract(Integral_price.integralRule1000).setScale(0,BigDecimal.ROUND_DOWN).intValue();
                normalTotalPoint = totalCost.subtract(promotionTotalCost).divide(Integral_price.integralRule20).setScale(0,BigDecimal.ROUND_DOWN).intValue();
            }
            totalPoint = promotionTotalPoint + normalTotalPoint ;
        }
        return totalPoint;
    }

    private BigDecimal getTotalCost(ArrayList<Goods>  goodsList) {
        BigDecimal totalCost = new BigDecimal(0) ;
        for(int num=0;num<goodsList.size();num++){
            totalCost = totalCost.add(goodsList.get(num).getCost());
        }
        return totalCost;
    }

    public  List<String> getPromotion(){
        List<String> goodsTypeList = new ArrayList<>();
        for(Promotion_Item promotion: Promotion_Item.values()){
            goodsTypeList.add(promotion.name());
        }
        return goodsTypeList;
    }
}
