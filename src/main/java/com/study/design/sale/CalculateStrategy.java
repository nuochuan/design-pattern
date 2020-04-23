package com.study.design.sale;

/**
 * @author mc
 * @title: CalculateStrategy
 * @projectName design
 * @description: TODO
 * @date 2020-04-2222:23
 */
public interface CalculateStrategy {

    public String userType();
    public double discount(double fee);
}
