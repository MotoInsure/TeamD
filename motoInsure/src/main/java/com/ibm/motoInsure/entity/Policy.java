package com.ibm.motoInsure.entity;

import java.util.Date;

import javax.persistence.*;

@Entity
@SequenceGenerator(name="policyseq", sequenceName="seq_policy", initialValue =10001)
@Table(name="policy_details")
public class Policy {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "policyseq")
	@Column(name="policy_id")
	private int id;
	private String type;
	private double idv;
	private double policyAmount;
	private double maxClaimAmount;
	private Date purchasedDate;
	private Date expiryDate;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getIdv() {
		return idv;
	}
	public void setIdv(double idv) {
		this.idv = idv;
	}
	public double getPolicyAmount() {
		return policyAmount;
	}
	public void setPolicyAmount(double policyAmount) {
		this.policyAmount = policyAmount;
	}
	public double getMaxClaimAmount() {
		return maxClaimAmount;
	}
	public void setMaxClaimAmount(double maxClaimAmount) {
		this.maxClaimAmount = maxClaimAmount;
	}
	
	public Date getPurchasedDate() {
		return purchasedDate;
	}
	public void setPurchasedDate(Date purchasedDate) {
		this.purchasedDate = purchasedDate;
	}
	public Date getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}
	
	
}
