package org.rumter.chj.framework.execute.profiling;

import java.util.ArrayList;

public class ProfileManager {

	private ArrayList<Long> t;
	private long tStart;

	public ProfileManager() {
		t = new ArrayList<Long>();
	}

	public void startTimer() {
		tStart = System.currentTimeMillis();
	}

	public void saveResult() {
		t.add(System.currentTimeMillis() - tStart);
	}

	public long getAverageResult() {
		Long sum = 0L;
		for (Long _t : t) {
			sum += _t;
		}
		if (t != null && t.size() > 0) {
			return sum / (long) t.size();
		}
		return 0;
	}

	public long getMemoryUsed() {
		return (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1024 / 1024;
	}
}
