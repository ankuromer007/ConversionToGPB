package com.neevtech.gpb;

import java.util.HashSet;
import java.util.Set;

public class Customer {
	private String city;
	private int classificationPoints;		//@persist
	private String country;					//@persist
	private String customerId;				//@persist
	private String customerName;			//@persist
	private String customerType;			//@persist
	private String territory;				//@persist
	private int valuePoint;					//@persist
	private String classLabel = "NONE";		//@persist
	private boolean cisco30;				//@persist
	private boolean relationship;			//@persist
	private boolean differentiated;			//@persist
	private int contractValue;				//@persist
	private int loyaltyDuration;			//@persist
	private boolean onCap;					//@persist
	private Set<String> valueRulesFired;
	private Set<Integer> firedSet;
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getClassificationPoints() {
		return classificationPoints;
	}
	public void setClassificationPoints(int classificationPoints) {
		this.classificationPoints = classificationPoints;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerType() {
		return customerType;
	}
	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}
	public String getTerritory() {
		return territory;
	}
	public void setTerritory(String territory) {
		this.territory = territory;
	}
	public int getValuePoint() {
		return valuePoint;
	}
	public void setValuePoint(int valuePoint) {
		this.valuePoint = valuePoint;
	}
	public String getClassLabel() {
		return classLabel;
	}
	public void setClassLabel(String classLabel) {
		this.classLabel = classLabel;
	}
	public boolean isCisco30() {
		return cisco30;
	}
	public void setCisco30(boolean cisco30) {
		this.cisco30 = cisco30;
	}
	public boolean isRelationship() {
		return relationship;
	}
	public void setRelationship(boolean relationship) {
		this.relationship = relationship;
	}
	public boolean isDifferentiated() {
		return differentiated;
	}
	public void setDifferentiated(boolean differentiated) {
		this.differentiated = differentiated;
	}
	public int getContractValue() {
		return contractValue;
	}
	public void setContractValue(int contractValue) {
		this.contractValue = contractValue;
	}
	public int getLoyaltyDuration() {
		return loyaltyDuration;
	}
	public void setLoyaltyDuration(int loyaltyDuration) {
		this.loyaltyDuration = loyaltyDuration;
	}
	public boolean isOnCap() {
		return onCap;
	}
	public void setOnCap(boolean onCap) {
		this.onCap = onCap;
	}
	public Set<String> getValueRulesFired() {
		return valueRulesFired == null? (valueRulesFired = new HashSet<String>()) : valueRulesFired;
	}
	public void setValueRulesFired(Set<String> valueRulesFired) {
		this.valueRulesFired = valueRulesFired;
	}
	public Set<Integer> getFiredSet() {
		return firedSet;
	}
	public void setFiredSet(Set<Integer> firedSet) {
		this.firedSet = firedSet;
	}
	
	public void addFiredRule(String rule) {
		getValueRulesFired().add(rule);
	}
}
