package com.study.design.sale;

import org.springframework.stereotype.Service;

/**
 * @title: VipStrategy
 * @projectName design
 * @description: TODO
 * @author mc
 * @date 2020-04-2222:26
 */
@Service
public class SVipStrategy implements CalculateStrategy {
    @Override
    public String userType() {
        return "svip";
    }

    @Override
    public double discount(double fee) {
        return fee * 0.7;
    }
}
