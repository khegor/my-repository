package com.rocksoft.LogStr.deadLock;

public class DeadLockSynchr extends Thread{

	private int number;
	public DeadLockSynchr(int d) {
		this.number = d;
	}
	
	public int getNumber() {
		return number;
	}
	
	public synchronized void waiting (DeadLockSynchr d) {
		System.out.println(d.getNumber());
		d.tooWait(this);
	}
	public synchronized void tooWait(DeadLockSynchr d) {
		System.out.println(d.getNumber());
		d.waiting(this);
	}
}
