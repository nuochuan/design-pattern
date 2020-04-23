package com.study.design.sale;

import org.springframework.stereotype.Service;

/**
 * @title: NormalStrategy
 * @projectName design
 * @description: TODO
 * @author mc
 * @date 2020-04-2222:27
 */

@Service
public class NormalStrategy implements CalculateStrategy {
    @Override
    public String userType() {
        return "normal";
    }

    @Override
    public double discount(double fee) {
        return fee * 0.9;
    }
}
