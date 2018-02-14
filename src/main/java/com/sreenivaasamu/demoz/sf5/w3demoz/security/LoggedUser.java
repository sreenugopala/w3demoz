package com.sreenivaasamu.demoz.sf5.w3demoz.security;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

import org.springframework.stereotype.Component;

@Component
public class LoggedUser implements HttpSessionBindingListener {

    private String username;

    public LoggedUser() {
    }

    public LoggedUser(String username) {
        this.username = username;
    }
    
    @Override
    public void valueBound(HttpSessionBindingEvent event) {
        System.out.println("valueBound");
    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent event) {
        System.out.println("valueUnbound");
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}