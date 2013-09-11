package com.neevtech.voldemort;

import voldemort.client.ClientConfig;
import voldemort.client.SocketStoreClientFactory;
import voldemort.client.StoreClient;
import voldemort.client.StoreClientFactory;
import voldemort.versioning.Versioned;

import com.neevtech.gpb.CollaborationRequestProtos.CollaborationRequestProtoObject;

public class ClientExample {

	static String bootstrapUrl = "tcp://localhost:6666";
	static StoreClientFactory factory = new SocketStoreClientFactory(new ClientConfig().setBootstrapUrls(bootstrapUrl));
	
	static StoreClient<String, String> client = null;
	static StoreClient<String, CollaborationRequestProtoObject> client1 = null;
	
	static{
		client = factory.getStoreClient("test");
		client1 = factory.getStoreClient("collaboration-request-store");
	}

	public static void main(String[] args) {

		client.put("hello", "world");
		
		Versioned<String> version = client.get("hello");
		System.out.println("Value of key 'hello': "+version.getValue());
		
		version.setObject(version.getValue().toUpperCase());
		client.put("HELLO", version);
		
		System.out.println("Value of key 'HELLO': "+version.getValue());
	}
	
	public void storeProtobufIntoDB(CollaborationRequestProtoObject gpbInstance){
		System.out.println("GPBInstance(in ClientExample):\n");
		client1.put(gpbInstance.getServiceRequestId(), gpbInstance);
		Versioned<CollaborationRequestProtoObject> version = client1.get(gpbInstance.getServiceRequestId());
		System.out.println(version.getValue());
	}
}
