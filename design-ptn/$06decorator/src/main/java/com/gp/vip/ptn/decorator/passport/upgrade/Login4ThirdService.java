package com.gp.vip.ptn.decorator.passport.upgrade;

import com.gp.vip.ptn.decorator.passport.old.ISigninService;
import com.gp.vip.ptn.decorator.passport.old.ResultMsg;

public class Login4ThirdService implements ILogin4ThirdService {
    private ISigninService signinService;

    public Login4ThirdService(ISigninService signinService) {
        this.signinService = signinService;
    }

    @Override
    public ResultMsg loginForQQ(String id) {
        return this.signinService.login("","");
    }

    @Override
    public ResultMsg loginForWechat(String id) {
        return null;
    }

    @Override
    public ResultMsg loginForToken(String token) {
        return null;
    }

    @Override
    public ResultMsg loginForTelphone(String telphone, String code) {
        return null;
    }

    @Override
    public ResultMsg loginForRegist(String username, String passport) {
        return null;
    }

    @Override
    public ResultMsg regist(String username, String password) {
        return signinService.regist(username, password);
    }

    @Override
    public ResultMsg login(String username, String password) {
        return this.signinService.login(username, password);
    }
}
