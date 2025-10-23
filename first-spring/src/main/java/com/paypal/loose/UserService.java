package com.paypal.loose;

public class UserService {

    private NotificationService notificationService;

    public UserService() {
    }

    public UserService(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    public void notifyUser(String msg){
        notificationService.send(msg);
    }

    public void setNotificationService(NotificationService notificationService) {
        this.notificationService = notificationService;
    }
}
