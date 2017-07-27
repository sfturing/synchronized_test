package cn.sfturing.account;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Account account = new Account("zhang san", 10000.0f);
		AccountOperator accountOperator = new AccountOperator(account);

		final int THREAD_NUM = 5;
		Thread threads[] = new Thread[THREAD_NUM];
		for (int i = 0; i < THREAD_NUM; i++) {
			threads[i] = new Thread(accountOperator, "Thread" + i);
			threads[i].start();
		}

		/**
		 * 在AccountOperator 类中的run方法里，我们用synchronized
		 * 给account对象加了锁。这时，当一个线程访问account对象时，其他试图访问account对象的线程将会阻塞，
		 * 直到该线程访问account对象结束。也就是说谁拿到那个锁谁就可以运行它所控制的那段代码。
		 * 当有一个明确的对象作为锁时，就可以用类似下面这样的方式写程序。
		 * 
		 */
		/*
		 * public void method3(SomeObject obj) { //obj 锁定的对象 synchronized(obj) {
		 * // todo } }
		 * 
		 */
		/**
		 * 当没有明确的对象作为锁，只是想让一段代码同步时，可以创建一个特殊的对象来充当锁：
		 * 说明：零长度的byte数组对象创建起来将比任何对象都经济――查看编译后的字节码：生成零长度的byte[]对象只需3条操作码，而Object
		 * lock = new Object()则需要7行操作码。
		 */
		/*
		 * Class Test implements Runnable { private byte[] lock = new byte[0];
		 * // 特殊的instance变量 public void method() { synchronized(lock) { // todo
		 * 同步代码块 } }
		 * 
		 * public void run() {
		 * 
		 * } }
		 */
	}

}
