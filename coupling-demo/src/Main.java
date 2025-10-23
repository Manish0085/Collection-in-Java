import loose.EmailNotificationService;
import loose.SMSNotificationService;
import tight.UserService;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        // Tight Coupling
        UserService service = new UserService();
        service.notifyUser("Order Placed!");

        // Loose Coupling
        loose.UserService service1 = new loose.UserService(new SMSNotificationService());
        service1.notifyUser("Order Processed!");

        loose.UserService service2 = new loose.UserService();
        service2.setNotificationService(new EmailNotificationService());
        service2.notifyUser("Order is packed!");


    }

    /*

    Dependency Injection
    --------------------

    Constructor Injection: dependency is provided via constructor
    Setter Injection: dependency is provided via setter method
    Field Injection: dependency is assigned directly to a field
     */
}