package com.pinhost.discountticketcondition.services;

import com.pinhost.mm.dtcdatabase.model.RoleModel;
import com.pinhost.mm.dtcdatabase.model.UserModel;
import com.pinhost.mm.dtcdatabase.repositories.RoleRepositoryH2;
import com.pinhost.mm.dtcdatabase.repositories.UserRepositoryH2;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserLoginService implements UserDetailsService {
    private static  final Log LOG = LogFactory.getLog(UserLoginService.class);

    private UserRepositoryH2 userRepositoryH2;

    private RoleRepositoryH2 roleRepositoryH2;

    public UserLoginService() {

        this.userRepositoryH2 = new UserRepositoryH2();
        this.roleRepositoryH2 = new RoleRepositoryH2();
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        LOG.info("Method: loadUserByUserName() --> Params: " + username);
        com.pinhost.mm.dtcdatabase.model.UserModel userModel = this.userRepositoryH2.getUserByName(username);
        if (userModel != null)
        {
            userModel = this.getUserWithRoles(userModel);
            List<GrantedAuthority> authorities = this.buildAuthorities(userModel);
            return this.buildUser(userModel, authorities);
        }
        return null;
    }

    private UserDetails buildUser(com.pinhost.mm.dtcdatabase.model.UserModel user, List<GrantedAuthority> authorities)
    {
        UserLoginService.LOG.info("Method: buildUser() --> Params: " + user.toString() + "--> And --> " + authorities);
        return new org.springframework.security.core.userdetails.User(user.getName(), user.getPassword(), user.isEnabled(), true, true, true, authorities);
    }

    private List<GrantedAuthority> buildAuthorities(UserModel user)
    {
        List<GrantedAuthority> auths = new ArrayList<>();
        for (RoleModel role : user.getUserRoles())
        {
            auths.add(new SimpleGrantedAuthority(role.getName()));
        }
        return new ArrayList<>(auths);
    }

    private com.pinhost.mm.dtcdatabase.model.UserModel getUserWithRoles(com.pinhost.mm.dtcdatabase.model.UserModel user){
        List<com.pinhost.mm.dtcdatabase.model.RoleModel> userRoles = new ArrayList<>();
        List<com.pinhost.mm.dtcdatabase.model.UserModel> userList = userRepositoryH2.getUserModelListByName(user.getName());
        if (!userList.isEmpty()){
            for (com.pinhost.mm.dtcdatabase.model.UserModel userModel: userList) {
                userRoles.add(roleRepositoryH2.getUserRoleByRoleId(userModel.getRoleId()));
            }
            user.setUserRoles(userRoles);
        }
        return user;
    }
}
