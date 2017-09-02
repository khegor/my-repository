package com.rocksoft.LogStr.deadLock;

public class DeadLock {

	public static void main(String[] args) {

		DeadLockSynchr d1 = new DeadLockSynchr(1);
		DeadLockSynchr d2 = new DeadLockSynchr(2);
		
		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				d1.waiting(d2);
			}
		};
		Thread t1 = new Thread(runnable);
		t1.start();
		
		new Thread(() -> d1.waiting(d2));
		
		
		new Thread (new Runnable() {
			@Override
			public void run() {
				d2.tooWait(d1);
			}
			}).start();

	}

}
