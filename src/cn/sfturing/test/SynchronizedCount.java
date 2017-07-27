package cn.sfturing.test;

public class SynchronizedCount implements Runnable{
	private int count;

	public SynchronizedCount() {
		// TODO Auto-generated constructor stub
		count = 0;
	}

	// synchronized 代码块
	public void countAdd() {
		synchronized (this) {
			for (int i = 0; i < 5; i++) {
				try {
					System.out.println(Thread.currentThread().getName() + ":" + (count++));
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	// 非synchronized代码块，未对count进行读写操作，所以可以不用synchronized
	public void printCount() {
		for (int i = 0; i < 5; i++) {
			try {
				System.out.println(Thread.currentThread().getName() + " count:" + count);
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void run() {
		String threadName = Thread.currentThread().getName();
		if (threadName.equals("A")) {
			countAdd();
		} else if (threadName.equals("B")) {
			printCount();
		}
	}
	/**
	 * 当一个线程访问对象的一个synchronized(this)同步代码块时，另一个线程仍然可以访问该对象中的非synchronized(this)同步代码块。 
	 * @author sfturing(Shi Xiaohao)
	 * @E-mail sfturing@gmail.com
	 * @date 2017年7月27日
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SynchronizedCount synchronizedCount = new SynchronizedCount();
		Thread thread1 = new Thread(synchronizedCount, "A");
		Thread thread2 = new Thread(synchronizedCount, "B");
		thread1.start();
		thread2.start();
	}

}
