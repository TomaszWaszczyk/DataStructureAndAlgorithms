package com.waszczyk.threads2;

//http://www.linkedin.com/groups/what-is-ThreadLocal-Thread-local-3983267.S.5911252856748392452?view=&item=5911252856748392452&type=member&gid=3983267&trk=eml-b2_anet_digest-hero-7-hero-disc-disc-0&midToken=AQE1l_-qnkcqnA&fromEmail=fromEmail&ut=3ImNkq5HUDrCo1

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		final ThreadLocalExample tExample = new ThreadLocalExample();
		tExample.setNonTLocalVar(10);
		tExample.gettLocal().set(5);
		System.out.println("Non thread local variable value : " + tExample.getNonTLocalVar());
		System.out.println("Thread local variable value in current thread :" + tExample.gettLocal().get());

		System.out.println("------------------------------------------ Creating a different thread here ---------------------------------------");
		Thread t = new Thread() {

			@Override
			public void run() {

				System.out.println("Non thread local variable value :" + tExample.getNonTLocalVar());
				System.out.println("Thread local variable value : " + tExample.gettLocal().get());
			}
		};

		System.out.println();
		t.start();
	}

}