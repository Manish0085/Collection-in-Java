package tight;

public class UserService {

    NotificationService service = new NotificationService();

    public void notifyUser(String message){
        service.send("Notification Hello!");
    }
}
