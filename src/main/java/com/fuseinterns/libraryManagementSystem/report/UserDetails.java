package com.fuseinterns.libraryManagementSystem.report;

import com.fuseinterns.libraryManagementSystem.user.User;

import java.util.List;

public class UserDetails {
    private List<User> activeUser;
    private int totalUsers;

    public UserDetails(List<User> activeUser) {
        this.activeUser = activeUser;
        this.totalUsers = activeUser.size();
    }

    public List<User> getActiveUser() {
        return activeUser;
    }



    public int getTotalUsers() {
        return totalUsers;
    }


}
