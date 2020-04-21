package com.pinhost.mm.userrabbitmqservice.service;

import com.pinhost.mm.dtcdatabase.model.RoleModel;
import com.pinhost.mm.dtcdatabase.model.UserModel;
import com.pinhost.mm.dtcdatabase.repositories.RoleRepositoryH2;
import com.pinhost.mm.dtcdatabase.repositories.UserRepositoryH2;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private static final Log LOG = LogFactory.getLog(UserService.class);

    private RoleRepositoryH2 roleRepositoryH2;

    private UserRepositoryH2 userRepositoryH2;

    @Autowired
    public UserService() {
        this.userRepositoryH2 = new UserRepositoryH2();
        roleRepositoryH2 = new RoleRepositoryH2();
    }

    public UserModel getUserByName(final String name){
        com.pinhost.mm.dtcdatabase.model.UserModel user = userRepositoryH2.getUserByName(name);
        if (user != null){
            List<com.pinhost.mm.dtcdatabase.model.UserModel> userModelList = userRepositoryH2.getUserModelListByName(name);
            LOG.info("Es wurden " + userModelList.size() + " user gefunden.");
            List<RoleModel> roleModelList = new ArrayList<>();
            for (com.pinhost.mm.dtcdatabase.model.UserModel userModel: userModelList) {
                roleModelList.add(roleRepositoryH2.getUserRoleByRoleId(userModel.getRoleId()));
            }
            LOG.info("Es wurden " + roleModelList.size() + " role gefunden.");
            user.setUserRoles(roleModelList);
        }
        return user;
    }

    public Long getUserIdByName(final String name){
        return userRepositoryH2.getUserIdByName(name);
    }
}
