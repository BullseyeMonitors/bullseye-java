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
                "API_KEY",
                "DECRYPT_KEY",
                scopes, product -> System.out.println("Product: " + product.getTitle()));
        monitor.setVerbose(true);
        monitor.connect();
    }
}
