package com.nuochuan.design.service;



import org.springframework.ui.Model;


/*
 *
 * @author Noel
 * @date 2020/10/27
 */


public interface GetUserInfoService {

    void getUserInfoById(String id, Model model);

}
