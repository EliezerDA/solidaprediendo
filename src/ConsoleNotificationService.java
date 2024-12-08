public class ConsoleNotificationService implements INotificationService {
    public void notify(String message) {
        System.out.println("Notificación: " + message);
    }
}
