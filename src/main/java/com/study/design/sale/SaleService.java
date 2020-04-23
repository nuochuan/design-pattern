package com.study.design.sale;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * @title: saleService
 * @projectName design
 * @description: TODO
 * @author mc
 * @date 2020-04-2222:17
 */
@Service
public class SaleService {

    @Autowired
    NormalStrategy normalStrategy;

    @Autowired
    VipStrategy vipStrategy;

//    public double sale(String userType,double fee) {
//        if("normal".equals(userType)){
//            return normalStrategy.discount(fee);
//        }else if("vip".equals(userType)){
//            return vipStrategy.discount(fee);
//        }else {
//            return fee;
//        }
//    }

    HashMap<String ,CalculateStrategy> calculateStrategyHashMap = new HashMap<>();

    public SaleService(List<CalculateStrategy> calculateStrategies){
        for (CalculateStrategy calculateStrategy : calculateStrategies) {
            calculateStrategyHashMap.put(calculateStrategy.userType(),calculateStrategy);
        }
    }

    public double sale(String userType,double fee) {
        CalculateStrategy calculateStrategy = calculateStrategyHashMap.get(userType);
        fee = calculateStrategy.discount(fee);
        return fee;
    }
}
