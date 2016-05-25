package org.microbroker.server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

import org.glassfish.tyrus.server.Server;
import org.microbroker.server.config.EndpointConfig;

public class BrokerServer {

	public static void main(String[] args) {
		runServer();

	}
	
	private static void runServer(){
		Set<Class<?>> configSet = new HashSet<Class<?>>(1);
		configSet.add(EndpointConfig.class);
		Server server = new Server("localhost", 8085, "/microbroker", null, configSet);
		try{
			server.start();
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Press any key to stop the server");
			reader.readLine();
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			server.stop();
		}
	}

}
