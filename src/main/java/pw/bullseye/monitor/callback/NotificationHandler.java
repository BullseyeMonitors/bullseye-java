package pw.bullseye.monitor.callback;

import pw.bullseye.monitor.product.Product;

/**
 * @author Brennan / skateboard
 * @since 3/2/2022
 **/
public interface NotificationHandler {

    void onMonitorNotification(Product product);

}
