package com.neevtech.voldemort;

import voldemort.server.VoldemortConfig;
import voldemort.server.VoldemortServer;

public class ServerExample {

	public static void main(String[] args) {

		String voldemortHome = System.getenv("VOLDEMORT_HOME");
		VoldemortConfig config = VoldemortConfig.loadFromVoldemortHome(
				voldemortHome, voldemortHome
						+ "/config/single_node_cluster/config");
		VoldemortServer server = new VoldemortServer(config);
		server.start();
		System.out.println("Server started...");
	}
}
