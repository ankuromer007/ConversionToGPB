package com.neevtech.voldemort;

import voldemort.client.ClientConfig;
import voldemort.client.SocketStoreClientFactory;
import voldemort.client.StoreClient;
import voldemort.client.StoreClientFactory;
import voldemort.versioning.Versioned;

public class ClientExample {

	public static void main(String[] args) {

		String bootstrapUrl = "tcp://localhost:6666";
		StoreClientFactory factory = new SocketStoreClientFactory(new ClientConfig().setBootstrapUrls(bootstrapUrl));

		StoreClient<String, String> client = factory.getStoreClient("my_store_name");

		Versioned<String> version = client.get("some_key");
		version.setObject("new_value");

		client.put("some_key", version);
	}
}
