package pw.bullseye.monitor;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import pw.bullseye.monitor.callback.NotificationHandler;
import pw.bullseye.monitor.product.Product;
import pw.bullseye.monitor.socket.WebSocket;
import pw.bullseye.monitor.util.EncryptionUtil;

/**
 * @author Brennan / skateboard
 * @since 3/2/2022
 **/
public class BullseyeMonitor {
    private static String API_KEY;
    private static String[] SCOPES;

    private final String decryptionKey;
    private final NotificationHandler notificationHandler;

    private final Gson GSON = new GsonBuilder().create();

    private boolean verbose;

    public BullseyeMonitor(String apiKey, String decryptionKey, String[] scopes, NotificationHandler handler) {
        API_KEY = apiKey;
        SCOPES = scopes;

        this.decryptionKey = decryptionKey;
        this.notificationHandler = handler;
    }

    public void setVerbose(boolean verbose) {
        this.verbose = verbose;
    }

    public void connect() {
        final WebSocket webSocket = new WebSocket(verbose);
        webSocket.addMessageHandler(message -> {
            final String decryptedMessage = EncryptionUtil.decrypt(message, decryptionKey);
            final Product product = GSON.fromJson(decryptedMessage, Product.class);

            notificationHandler.onMonitorNotification(product);
        });
    }

    public static String getApiKey() {
        return API_KEY;
    }

    public static String[] getScopes() {
        return SCOPES;
    }
}
