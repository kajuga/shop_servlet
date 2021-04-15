package com.fedorovs.shop.listener;

import com.fedorovs.shop.service.BusinessService;
import com.fedorovs.shop.service.ServiceManager;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;


@WebListener
public class SessionListener implements HttpSessionListener {
    private BusinessService businessService;
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        businessService = ServiceManager.getInstance(
                se.getSession().getServletContext()).getBusinessService();
        businessService.doSomething();
    }
    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        businessService.doSomething();
    }
}