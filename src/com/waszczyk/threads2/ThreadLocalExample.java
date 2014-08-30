package com.waszczyk.threads2;

class ThreadLocalExample {

	public ThreadLocal<Integer> gettLocal() {
		if (tLocal == null) {
			tLocal = new ThreadLocal<Integer>();
		}
		return tLocal;
	}

	private ThreadLocal<Integer> tLocal;

	public int getNonTLocalVar() {
		return nonTLocalVar;
	}

	public void setNonTLocalVar(int nonTLocalVar) {
		this.nonTLocalVar = nonTLocalVar;
	}

	private int nonTLocalVar;

}