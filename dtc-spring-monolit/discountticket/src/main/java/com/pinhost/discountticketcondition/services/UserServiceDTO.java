package com.pinhost.discountticketcondition.services;

import com.pinhost.mm.dtcdatabase.model.RoleModel;
import com.pinhost.mm.dtcdatabase.model.UserModel;
import com.pinhost.mm.dtcdatabase.repositories.RoleRepositoryH2;
import com.pinhost.mm.dtcdatabase.repositories.UserRepositoryH2;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceDTO {
    private static final Log LOG = LogFactory.getLog(UserServiceDTO.class);

    private UserRepositoryH2 userRepositoryH2;

    private RoleRepositoryH2 roleRepositoryH2;

    public UserServiceDTO() {

        this.userRepositoryH2 = new UserRepositoryH2();
        this.roleRepositoryH2 = new RoleRepositoryH2();
    }

    public UserModel getUserByName(String name) {
        com.pinhost.mm.dtcdatabase.model.UserModel user = userRepositoryH2.getUserByName(name);
        if (user != null) {
            List<UserModel> userList = userRepositoryH2.getUserModelListByName(name);
            LOG.info("Es wurden " + userList.size() + " user gefunden.");
            List<RoleModel> roleList = new ArrayList<>();
            for (UserModel userModel: userList) {
                roleList.add(roleRepositoryH2.getUserRoleByRoleId(userModel.getRoleId()));
            }
            LOG.info("Es wurden " + roleList.size() + " role gefunden.");
            user.setUserRoles(roleList);
        }

        return user;
    }

}
