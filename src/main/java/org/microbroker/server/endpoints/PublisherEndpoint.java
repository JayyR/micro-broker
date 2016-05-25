package org.microbroker.server.endpoints;

import java.util.logging.Logger;

import javax.websocket.CloseReason;
import javax.websocket.Endpoint;
import javax.websocket.EndpointConfig;
import javax.websocket.MessageHandler;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.Session;

public class PublisherEndpoint extends Endpoint {
	
	private Logger logger = Logger.getLogger(PublisherEndpoint.class.getClass().getName());
	@Override
	public void onOpen(final Session session, EndpointConfig endpointConfig) {
		
		logger.info("PublisherEndpoint Connected... "+ session.getId());
		session.addMessageHandler(new MessageHandler.Whole<String>() {

			public void onMessage(String message) {
				
				logger.info("Recived ... "+ session.getId() +" : "+ message);
			}
		});

	}
	
	@OnError
	public void onError(Throwable t){
		t.printStackTrace();
	}
	
	@Override
	public void onClose(Session session, CloseReason closeReason){
		logger.info("EchoEndpoint Closed.. "+ session.getId());
	}

}
