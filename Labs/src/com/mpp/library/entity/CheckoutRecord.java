package com.mpp.library.entity;

import java.util.ArrayList;
import java.util.List;

public class CheckoutRecord implements Entity {
	private String ID;
	private Person member;
    private List<CheckoutRecordEntry> recordEntries = new ArrayList<CheckoutRecordEntry>();;
    
    public CheckoutRecord() {
    }
    

    public CheckoutRecord(String ID, Person member) {
		super();
		this.ID = ID;
		this.member = member;
	}


	@Override
    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

	public Person getMember() {
		return member;
	}

	public void setMember(Person member) {
		this.member = member;
	}

	public void addRecordEntry(CheckoutRecordEntry recordEntry) {
		recordEntries.add(recordEntry);
	}

	public List<CheckoutRecordEntry> getRecordEntries() {
		return recordEntries;
	}

}
