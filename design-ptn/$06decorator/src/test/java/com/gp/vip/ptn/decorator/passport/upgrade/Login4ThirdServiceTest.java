package com.gp.vip.ptn.decorator.passport.upgrade;

import com.gp.vip.ptn.decorator.passport.old.SigninService;
import org.junit.Test;

public class Login4ThirdServiceTest {

    @Test
    public void loginForQQ() {
        ILogin4ThirdService login4ThirdService;

        //满足is-a关系
        login4ThirdService= new Login4ThirdService(new SigninService());

        login4ThirdService.loginForQQ("0987654356879");


        //For Instance
        //1,BufferedReader
        //2,TransactionAwareCacheDecorator
        //3，HttpHeadResponseDecorator
        //4，org.apache.ibatis.cache.Cache



    }
}