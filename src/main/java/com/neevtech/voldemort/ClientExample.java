package com.neevtech.voldemort;

import voldemort.client.ClientConfig;
import voldemort.client.SocketStoreClientFactory;
import voldemort.client.StoreClient;
import voldemort.client.StoreClientFactory;
import voldemort.versioning.Versioned;

public class ClientExample {

	static String bootstrapUrl = "tcp://localhost:6666";
	static StoreClientFactory factory = new SocketStoreClientFactory(new ClientConfig().setBootstrapUrls(bootstrapUrl));
	
	static StoreClient<String, String> client = null;
	
	static{
		client = factory.getStoreClient("test");
	}

	public static void main(String[] args) {

		client.put("hello", "world");
		
		Versioned<String> version = client.get("hello");
		System.out.println("Value of key 'hello': "+version.getValue());
		
		version.setObject(version.getValue().toUpperCase());
		client.put("HELLO", version);
		
		System.out.println("Value of key 'HELLO': "+version.getValue());
	}
	
	public void storeProtobufIntoDB(String byteString){
		System.out.println("ByteString(in ClientExample): "+byteString);
	}
}
