package com.neevtech.gpb;

public class CollaborationRequest {
	//private String collId; = workItemId;
	private String serviceRequestId;
	private String indicator;
	private String requester;
	private String collaborationType;
	private String collTechId;
	private String collSubTechId;
	private String collProbCode;
	private String collCreateDate;
	private String initiator;
	private String collExtId;
	private String collabOwner;
	private int severity;	
	private String breTransactionId;
	private String skillId;
	private String collaborationSubType;
	
	public String getCollaborationSubType() {
		return collaborationSubType;
	}
	public void setCollaborationSubType(String collaborationSubType) {
		this.collaborationSubType = collaborationSubType;
	}
	public String getSkillId() {
		return skillId;
	}
	public void setSkillId(String skillId) {
		this.skillId = skillId;
	}
	
	public String getBreTransactionId() {
		return breTransactionId;
	}
	public void setBreTransactionId(String breTransactionId) {
		this.breTransactionId = breTransactionId;
	}
	public int getSeverity() {
		return severity;
	}
	public void setSeverity(int severity) {
		this.severity = severity;
	}
	public String getCollaborationType() {
		return collaborationType;
	}
	public void setCollaborationType(String collaborationType) {
		this.collaborationType = collaborationType;
	}
	public String getCollTechId() {
		return collTechId;
	}
	public void setCollTechId(String collTechId) {
		this.collTechId = collTechId;
	}
	public String getCollSubTechId() {
		return collSubTechId;
	}
	public void setCollSubTechId(String collSubTechId) {
		this.collSubTechId = collSubTechId;
	}
	public String getCollProbCode() {
		return collProbCode;
	}
	public void setCollProbCode(String collProbCode) {
		this.collProbCode = collProbCode;
	}
	public String getCollCreateDate() {
		return collCreateDate;
	}
	public void setCollCreateDate(String collCreateDate) {
		this.collCreateDate = collCreateDate;
	}
	public String getInitiator() {
		return initiator;
	}
	public void setInitiator(String initiator) {
		this.initiator = initiator;
	}
	public String getCollExtId() {
		return collExtId;
	}
	public void setCollExtId(String collExtId) {
		this.collExtId = collExtId;
	}
	public String getCollabOwner() {
		return collabOwner;
	}
	public void setCollabOwner(String collabOwner) {
		this.collabOwner = collabOwner;
	}
	public String getServiceRequestId() {
		return serviceRequestId;
	}
	public void setServiceRequestId(String serviceRequestId) {
		this.serviceRequestId = serviceRequestId;
	}
	public String getIndicator() {
		return indicator;
	}
	public void setIndicator(String indicator) {
		this.indicator = indicator;
	}
	public String getRequester() {
		return requester;
	}
	public void setRequester(String requester) {
		this.requester = requester;
	}	
}
