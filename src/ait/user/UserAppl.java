package ait.user;

import ait.user.model.User;

public class UserAppl {
    public static void main(String[] args) {
        User user=new User("peter@gmx.de","1234");
        System.out.println(user);
        user.setEmail("peter@web.de");
        System.out.println(user);
        System.out.println("======================Homework========================");
        user.setPassword("1234De!fff");
        System.out.println(user);

    }

}
