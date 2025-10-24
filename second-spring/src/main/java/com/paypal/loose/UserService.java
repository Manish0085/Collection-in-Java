package com.paypal.loose;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("UserSMSService")
public class UserService {

    private NotificationService notificationService;

    public UserService() {
    }

//    @Autowired
//    public UserService(@Qualifier("emailService") NotificationService notificationService) {
//        this.notificationService = notificationService;
//    }

    @Autowired
    public UserService(NotificationService service){
        this.notificationService = service;
    }

    public void notifyUser(String msg){
        notificationService.send(msg);
    }

    public void setNotificationService(NotificationService notificationService) {
        this.notificationService = notificationService;
    }
}
