package com.livebet.domain;

import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

public class Quote {
	private Integer id;
	private String outcome;
	private AtomicInteger value;
	private AtomicInteger version;
	private Date validityTimestamp;
	
	public Quote(Integer id, String outcome, AtomicInteger value,
			AtomicInteger version, Date validityTimestamp) {
		super();
		this.id = id;
		this.outcome = outcome;
		this.value = value;
		this.version = version;
		this.validityTimestamp = validityTimestamp;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getOutcome() {
		return outcome;
	}
	public void setOutcome(String outcome) {
		this.outcome = outcome;
	}
	public AtomicInteger getValue() {
		return value;
	}
	public void setValue(AtomicInteger value) {
		this.value = value;
	}
	public AtomicInteger getVersion() {
		return version;
	}
	public void setVersion(AtomicInteger version) {
		this.version = version;
	}
	public Date getValidityTimestamp() {
		return validityTimestamp;
	}
	public void setValidityTimestamp(Date validityTimestamp) {
		this.validityTimestamp = validityTimestamp;
	}
	@Override
	public String toString() {
		return "Quote [id=" + id + ", outcome=" + outcome + ", value=" + value
				+ ", version=" + version + ", validityTimestamp="
				+ validityTimestamp + "]";
	}
}
