package org.microbroker.server.endpoints;

import java.util.logging.Logger;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint(value = "/echo")
public class EchoEndpoint {
	private Logger logger = Logger.getLogger(EchoEndpoint.class.getClass().getName());
	
	@OnOpen
	public void onOpen(Session session){
		logger.info("EchoEndpoint Connected... "+ session.getId());
		logger.info("Query String... "+ session.getQueryString());
		logger.info("Path String... "+ session.getPathParameters().toString());
	}
	
	@OnMessage
	public void onMessage(Session session,String message){
		logger.info("Recived ... "+ session.getId() +" : "+ message);
		logger.info("Query String... "+ session.getQueryString());
		logger.info("Path String... "+ session.getPathParameters().toString());
	}
	
	@OnError
	public void onError(Throwable t){
		t.printStackTrace();
	}
	
	@OnClose
	public void onClose(Session session){
		logger.info("EchoEndpoint Closed.. "+ session.getId());
	}
}
