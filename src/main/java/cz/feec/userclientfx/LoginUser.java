/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.feec.userclientfx;

import cz.feec.userclientfx.entity.User;

/**
 *
 * @author vendy
 */
public class LoginUser extends User {

    private static volatile LoginUser loginUser = null;

    private LoginUser(User user) {
        id = user.getId();
        email = user.getEmail();
        password = user.getPassword();
        age = user.getAge();
        workPosition = user.getWorkPosition();
        data = user.getData();
        address = user.getAddress();
        roles = user.getRoles();
    }

    public static void loginUser(User user) {

        if (loginUser == null) {
            synchronized (LoginUser.class) {
                if (loginUser == null) {
                    loginUser = new LoginUser(user);
                }
            }
        }
    }

    public static LoginUser getLoginUser() {
        return loginUser;
    }

    public void logoutUser() {
        synchronized (LoginUser.class) {
            loginUser = null;
        }
    }

}
