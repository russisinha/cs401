package com.couponworld.common;

import java.util.*;
import org.springframework.web.servlet.view.InternalResourceView;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JstlView extends InternalResourceView {
    @Override
    protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        String dispatcherPath = prepareForRendering(request, response);
        
        // set original view being asked for as a request parameter
        request.setAttribute("partial", dispatcherPath.substring(dispatcherPath.lastIndexOf("/") + 1));
        
        // force everything to be template.jsp
        String template = "/WEB-INF/views/template.jsp";
        if(request.getAttribute("partial").equals("welcome.jsp") || request.getAttribute("partial").equals("login.jsp")) {
            request.setAttribute("headerhide", "hidden");
            request.setAttribute("footerhide", "hidden");
        	//template = "/WEB-INF/views/welcome.jsp";
        }
        
        RequestDispatcher rd = request.getRequestDispatcher(template);
        rd.include(request, response);
    }
}
