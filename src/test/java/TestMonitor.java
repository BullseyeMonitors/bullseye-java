import pw.bullseye.monitor.BullseyeMonitor;
import pw.bullseye.monitor.callback.NotificationHandler;
import pw.bullseye.monitor.product.Product;

/**
 * @author Brennan / skateboard
 * @since 3/2/2022
 **/
public class TestMonitor {

    public static void main(String[] args) {
        final String[] scopes = {"amazon"};
        final BullseyeMonitor monitor = new BullseyeMonitor(
                "sk_ca7799d296994b24caa5bfa42c6b6510",
                "r4u7x!A%D*G-JaNdRgUkXp2s5v8y/B?E",
                scopes, product -> System.out.println("Product: " + product.getTitle()));
        monitor.setVerbose(true);
        monitor.connect();
    }
}
