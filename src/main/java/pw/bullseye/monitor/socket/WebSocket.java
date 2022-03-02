package pw.bullseye.monitor.socket;

import pw.bullseye.monitor.socket.handler.MessageHandler;

import javax.websocket.*;
import java.net.URI;
import java.util.*;

/**
 * @author Brennan / skateboard
 * @since 3/2/2022
 **/
@ClientEndpoint(configurator = Configurator.class)
public class WebSocket {
    private Session session = null;
    private MessageHandler messageHandler;

    private final boolean verbose;

    public WebSocket(boolean verbose) {
        try {
            this.verbose = verbose;

            WebSocketContainer client = ContainerProvider.getWebSocketContainer();
            client.connectToServer(this, new URI("ws://api.bullseye.pw/v1/ws/"));

            // ping every 10 seconds
            final Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    if (session != null && session.isOpen()) {
                        session.getAsyncRemote().sendText("PING_MONITOR");
                    }
                }
            }, 0, 10000);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    @OnOpen
    public void onOpen(Session userSession) {
        if (verbose) {
            System.out.println("Connected to bullseye monitor.");
        }
        this.session = userSession;
    }

    @OnClose
    public void onClose(Session userSession, CloseReason reason) {
        if (verbose) {
            System.out.println("Disconnected from bullseye monitor.");
        }
        this.session = null;
    }

    @OnMessage
    public void onMessage(String message) {
        if (this.messageHandler != null) {
            this.messageHandler.handleMessage(message);
        }
    }

    public void addMessageHandler(MessageHandler msgHandler) {
        this.messageHandler = msgHandler;
    }
}
