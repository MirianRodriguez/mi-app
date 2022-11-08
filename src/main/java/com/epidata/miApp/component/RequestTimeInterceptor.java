package com.epidata.miApp.component;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.lang.Nullable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.epidata.miApp.repository.LogRepository;

@Component("requestTimeInterceptor")
public class RequestTimeInterceptor implements HandlerInterceptor{

    private static final Log LOGGER = LogFactory.getLog(RequestTimeInterceptor.class);

    @Autowired
    @Qualifier("logRepository")
    private LogRepository logRepository;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        request.setAttribute("timeStart", System.currentTimeMillis());
        return true;
    }
    
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
            @Nullable Exception ex) throws Exception {
        long timeStart = (long) request.getAttribute("timeStart");
        String url = request.getRequestURL().toString();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = "";
        if(auth != null && auth.isAuthenticated()){
            username = auth.getName();
        }
        logRepository.save(new com.epidata.miApp.entity.Log(new Date(), auth.getDetails().toString(), username, url));
        LOGGER.info("REQUEST URL: '" + request.getRequestURL() + "' -- TOTAL TIME: '" + (System.currentTimeMillis() - timeStart) +"' ms.");
    }

    
}
