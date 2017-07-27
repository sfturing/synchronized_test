package cn.sfturing.test;
/**
 * Synchronized的测试
 * @author sfturing(Shi Xiaohao)
 * @E-mail sfturing@gmail.com
 * @date 2017年7月27日
 */
public class SynchronizedThread implements Runnable {

	private static int count = 0;

	public SynchronizedThread() {
		// TODO Auto-generated constructor stub
		count = 0;
	}

	public int getCount() {
		return count;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		synchronized (this) {
			for (int i = 0; i < 10; i++) {
				System.out.println(Thread.currentThread().getName() + ":" + count++);
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**
		 * 只创建一个对象时，syncronized代码块智能被一个线程执行，另一个线程收到阻塞
		 * 必须等待当前线程执行完这个代码块以后才能执行该代码块。Thread1和thread2是互斥的，
		 * 因为在执行synchronized代码块时会锁定当前的对象，只有执行完该代码块才能释放该对象锁，下一个线程才能执行并锁定该对象。
		 * 
		 */
		/*SynchronizedThread synchronizedThread = new SynchronizedThread();
		Thread t1 = new Thread(synchronizedThread, "s1");
		Thread t2 = new Thread(synchronizedThread, "s2");
		t1.start();
		t2.start();*/
		/**
		 * Synchronized 是锁定对象，当线程访问不同对象的时候，是不互斥的。
		 */
		SynchronizedThread synchronizedThread = new SynchronizedThread();
		SynchronizedThread synchronizedThread2 =new SynchronizedThread();
		Thread t1 = new Thread(synchronizedThread, "s1");
		Thread t2 = new Thread(synchronizedThread2, "s2");
		t1.start();
		t2.start();
	}

}
