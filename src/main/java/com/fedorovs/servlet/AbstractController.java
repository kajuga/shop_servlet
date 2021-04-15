package com.fedorovs.servlet;

import com.fedorovs.service.BusinessService;
import com.fedorovs.service.ServiceManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public abstract class AbstractController extends HttpServlet {

    private BusinessService businessService;


    @Override
    public final void init() throws ServletException {
        businessService = ServiceManager.getInstance(getServletContext()).getBusinessService();
    }


    public final BusinessService getBusinessService() {
        return businessService;
    }
}


















