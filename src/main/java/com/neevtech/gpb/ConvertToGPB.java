package com.neevtech.gpb;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashSet;
import java.util.Set;

import com.neevtech.gpb.CollaborationRequestProtos.CollaborationRequestProtoObject;
import com.neevtech.gpb.CustomerProtos.CustomerProtoObject;
import com.neevtech.voldemort.ClientExample;

class ConvertToGPB {
	
	public static void main(String[] args) throws Exception {
		
		if (args.length != 1) {
			System.err.println("Usage:  Please pass the class name which you want to test");
			System.exit(-1);
		}
		
        String className = args[0];
        Object objJava = null;
        Object objGPB = null;
        
        if (className.equals("CollaborationRequest"))
        	objJava = createInstanceOfJava(className);
        else
        	objJava = createInstanceOfJava(className);
		
		FileOutputStream output = new FileOutputStream(className);
	    try {
	    	if (className.equals("CollaborationRequest")) {
	    		CollaborationRequestProtoObject gpbInstance = createGPBInstanceOfCollaborationRequest(objJava);
	    		System.out.println("GPB instance of CollaborationRequest:\n\n"+gpbInstance);
	    		new ClientExample().storeProtobufIntoDB(gpbInstance);
		    	gpbInstance.writeTo(output);
	    	} else {
	    		CustomerProtoObject gpbInstance = createGPBInstanceOfCustomer(objJava);
	    		System.out.println("GPB instance of Customer:\n"+gpbInstance);
	        	gpbInstance.writeTo(output);
	    	}
	    } finally {
	      output.close();
	    }
	    
	    if (className.equals("CollaborationRequest")) {
	    	objGPB = CollaborationRequestProtoObject
					.parseFrom(new FileInputStream(className));
	    } else {
	    	objGPB = CustomerProtoObject
					.parseFrom(new FileInputStream(className));
	    }
		
		Object newObjJava = convertGPBToJava(objGPB, className);
		
		if (className.equals("CollaborationRequest")) {
			System.out.println("Java instance of CollaborationRequest:\n");
			CollaborationRequest javaInstance = (CollaborationRequest) newObjJava;
			
			System.out.println("ServiceRequestId: "+javaInstance.getServiceRequestId());
			System.out.println("CollaborationType: "+javaInstance.getCollaborationType());
			System.out.println("CollabOwner: "+javaInstance.getCollabOwner());
			System.out.println("CollCreateDate: "+javaInstance.getCollCreateDate());
			System.out.println("CollSubTechId: "+javaInstance.getCollSubTechId());
			System.out.println("Requester: "+javaInstance.getRequester());
			System.out.println("Severity: "+javaInstance.getSeverity());
	    } else {
	    	System.out.println("Java instance of Customer:\n");
	    	Customer javaInstance = (Customer) newObjJava;
	    	
	    	System.out.println("CustomerId: "+javaInstance.getCustomerId());
	    	System.out.println("City: "+javaInstance.getCity());
	    	System.out.println("Country: "+javaInstance.getCountry());
	    	System.out.println("CustomerName: "+javaInstance.getCustomerName());
	    	System.out.println("CustomerType: "+javaInstance.getCustomerType());
	    	System.out.println("Cisco30: "+javaInstance.isCisco30());
	    	System.out.println("ContractValue: "+javaInstance.getContractValue());
	    	int i = 0;
			for (int firedSet: javaInstance.getFiredSet()) {
				System.out.println("FiredSet " + i++ + " => " + firedSet);
			}
			i = 0;
			for (String valueRulesFired: javaInstance.getValueRulesFired()) {
				System.out.println("ValueRulesFired "+ i++ +" => " + valueRulesFired);
			}
	    }
	}
	
	static Object createInstanceOfJava(String className) {
		
		if (className.equals("CollaborationRequest")) {
			CollaborationRequest javaInstance = new CollaborationRequest();
			
			javaInstance.setServiceRequestId("value123");
			javaInstance.setCollaborationType("value 1");
			javaInstance.setCollabOwner("ABC");
			javaInstance.setCollCreateDate("12/12/2012");
			javaInstance.setCollSubTechId("value 2");
			javaInstance.setRequester("XYZ");
			javaInstance.setSeverity(123);
			
			return javaInstance;
		} else {
			Customer javaInstance = new Customer();
			
			javaInstance.setCustomerId("v321");
			javaInstance.setCity("Bangalore");
			javaInstance.setCountry("India");
			javaInstance.setCustomerName("XYZ");
			javaInstance.setCustomerType("v3");
			javaInstance.setCisco30(true);
			javaInstance.setContractValue(100000);
			Set<Integer> firedSet = new HashSet<Integer>();
			firedSet.add(1);
			firedSet.add(2);
			firedSet.add(3);
			firedSet.add(4);
			javaInstance.setFiredSet(firedSet);
			javaInstance.addFiredRule("rule1");
			javaInstance.addFiredRule("rule2");
			javaInstance.addFiredRule("rule3");
			
			return javaInstance;
		}
	}
	
	static CollaborationRequestProtoObject createGPBInstanceOfCollaborationRequest(Object objJava) {
		
		CollaborationRequestProtoObject.Builder gpbInstance = CollaborationRequestProtoObject.newBuilder();
		CollaborationRequest javaInstance = (CollaborationRequest) objJava;
		
		gpbInstance.setServiceRequestId(javaInstance.getServiceRequestId());
		gpbInstance.setCollaborationType(javaInstance.getCollaborationType());
		gpbInstance.setCollabOwner(javaInstance.getCollabOwner());
		gpbInstance.setCollCreateDate(javaInstance.getCollCreateDate());
		gpbInstance.setCollSubTechId(javaInstance.getCollSubTechId());
		gpbInstance.setRequester(javaInstance.getRequester());
		gpbInstance.setSeverity(javaInstance.getSeverity());
		
		return gpbInstance.build();
	}
	
	static CustomerProtoObject createGPBInstanceOfCustomer(Object objJava) {
		
		CustomerProtoObject.Builder gpbInstance = CustomerProtoObject.newBuilder();
		Customer javaInstance = (Customer) objJava;
		
		gpbInstance.setCustomerId(javaInstance.getCustomerId());
		gpbInstance.setCity(javaInstance.getCity());
		gpbInstance.setCountry(javaInstance.getCountry());
		gpbInstance.setCustomerName(javaInstance.getCustomerName());
		gpbInstance.setCustomerType(javaInstance.getCustomerType());
		gpbInstance.setCisco30(javaInstance.isCisco30());
		gpbInstance.setContractValue(javaInstance.getContractValue());
		for (int firedSet: javaInstance.getFiredSet())
			gpbInstance.addFiredSet(firedSet);
		for (String valueRulesFired: javaInstance.getValueRulesFired()) {
			gpbInstance.addValueRulesFired(valueRulesFired);
		}
		
		return gpbInstance.build();
	}
	
	static Object convertGPBToJava(Object objGPB, String className) {
		
		if (className.equals("CollaborationRequest")) {
			CollaborationRequestProtoObject gpbInstance = (CollaborationRequestProtoObject) objGPB;
			CollaborationRequest javaInstance = new CollaborationRequest();
			
			javaInstance.setServiceRequestId(gpbInstance.getServiceRequestId());
			javaInstance.setCollaborationType(gpbInstance.getCollaborationType());
			javaInstance.setCollabOwner(gpbInstance.getCollabOwner());
			javaInstance.setCollCreateDate(gpbInstance.getCollCreateDate());
			javaInstance.setCollSubTechId(gpbInstance.getCollSubTechId());
			javaInstance.setRequester(gpbInstance.getRequester());
			javaInstance.setSeverity(gpbInstance.getSeverity());
			
			return javaInstance;
		} else {
			CustomerProtoObject gpbInstance = (CustomerProtoObject) objGPB;
			Customer javaInstance = new Customer();
			
			javaInstance.setCustomerId(gpbInstance.getCustomerId());
			javaInstance.setCity(gpbInstance.getCity());
			javaInstance.setCountry(gpbInstance.getCountry());
			javaInstance.setCustomerName(gpbInstance.getCustomerName());
			javaInstance.setCustomerType(gpbInstance.getCustomerType());
			javaInstance.setCisco30(gpbInstance.getCisco30());
			javaInstance.setContractValue(gpbInstance.getContractValue());
			Set<Integer> firedSet = new HashSet<Integer>();
			for(int i = 0; i < gpbInstance.getFiredSetCount(); i++)
				firedSet.add(gpbInstance.getFiredSet(i));
			javaInstance.setFiredSet(firedSet);
			for(int i = 0; i < gpbInstance.getValueRulesFiredCount(); i++)
				javaInstance.addFiredRule(gpbInstance.getValueRulesFired(i));
			
			return javaInstance;
		}
	}
}
