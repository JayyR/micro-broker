package org.microbroker.server.config;

import java.util.HashSet;
import java.util.Set;

import javax.websocket.Endpoint;
import javax.websocket.server.ServerApplicationConfig;
import javax.websocket.server.ServerEndpointConfig;

import org.microbroker.server.endpoints.EchoEndpoint;
import org.microbroker.server.endpoints.PublisherEndpoint;

public class EndpointConfig implements ServerApplicationConfig {

	public Set<Class<?>> getAnnotatedEndpointClasses(Set<Class<?>> annotatedSet) {
		annotatedSet.add(EchoEndpoint.class);
		return annotatedSet;
	}

	public Set<ServerEndpointConfig> getEndpointConfigs(Set<Class<? extends Endpoint>> endpointSet) {
		Set<ServerEndpointConfig> endpointConfigs = new HashSet<ServerEndpointConfig>(1);
		endpointConfigs.add(ServerEndpointConfig.Builder.create(PublisherEndpoint.class, "/publisher").build());
		return endpointConfigs;
	}

}
