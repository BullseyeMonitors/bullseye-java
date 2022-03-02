package pw.bullseye.monitor.socket;

import pw.bullseye.monitor.BullseyeMonitor;

import javax.websocket.ClientEndpointConfig;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * @author Brennan / skateboard
 * @since 3/2/2022
 **/
public class Configurator extends ClientEndpointConfig.Configurator{

    @Override
    public void beforeRequest(Map<String, List<String>> headers) {
        headers.put("Authorization", Collections.singletonList(BullseyeMonitor.getApiKey()));
        headers.put("scopes", Collections.singletonList(String.join(",", BullseyeMonitor.getScopes())));
        super.beforeRequest(headers);
    }
}
