package com.gmail.eulertech.smcs2022.invitedstudentopenhousescheduler;

public class InvitedStudent {
	private boolean smcs;
	private boolean glob;
	private boolean hum;
	private String name;
	private int num;
	private String[] schedule = new String[4];
	
	public void setSchedule(int session, String room) {
		schedule[session] = room;
	}
	
	private int calc() {
		int count = 0;
		if(smcs) {
			count++;
		}
		if(glob) {
			count++;
		}
		if(hum) {
			count++;
		}
		return count;
	}

	public int getNumberOfInvitations() {
		return num;
	}
	
	public boolean isSmcs() {
		return smcs;
	}

	public boolean isGlob() {
		return glob;
	}

	public boolean isHum() {
		return hum;
	}

	public String getName() {
		return name;
	}

	public String getSession(int i) {
		return schedule[i];
	}
	
	public InvitedStudent(boolean smcs, boolean glob, boolean hum, String name) {
		this.smcs = smcs;
		this.glob = glob;
		this.hum = hum;
		this.name = name;
		this.num = calc();
	}
	
	public String toString() {
		return name;
	}
}
