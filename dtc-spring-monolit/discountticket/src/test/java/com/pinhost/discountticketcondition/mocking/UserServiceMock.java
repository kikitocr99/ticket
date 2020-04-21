package com.pinhost.discountticketcondition.mocking;

import com.pinhost.mm.dtcdatabase.model.UserModel;
import org.springframework.stereotype.Service;

@Service
public class UserServiceMock {


    public UserModel getUserModel(String name){
        UserModel userModel = new UserModel();
        userModel.setId(1065L);
        userModel.setName("lnaranjo");
        userModel.setFirstName("luis");
        userModel.setDescription("testing user");
        userModel.setEnabled(true);
        userModel.setFamilyName("guerra");
        userModel.setRoleId(40L);
        userModel.setPassword("$2y$14$.SFdaOyjdQxQr7wm5ZcrzuTT8PU9XonmmRQpPIyi0QDmtykUGUs4S");
        return userModel;
    }
}
