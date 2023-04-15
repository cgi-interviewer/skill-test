package com.cgi.boat.interview;

import java.util.List;

public class Counted implements Comparable<Counted> {

	private String key;

	private int count;

	public Counted(String key, int count) {
		super();
		this.key = key;
		this.count = count;
	}

	public Counted(String key, List<String> list) {
		super();
		this.key = key;
		if (list == null) {
			this.count = 0;
		} else {
			this.count = list.size();
		}
	}

	public String getKey() {
		return key;
	}

	public int getCount() {
		return count;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + count;
		result = prime * result + ((key == null) ? 0 : key.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Counted other = (Counted) obj;
		if (count != other.count) {
			return false;
		}
		if (key == null) {
			if (other.key != null) {
				return false;
			}
		} else if (!key.equals(other.key)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return key + ": " + count;
	}

	@Override
	public int compareTo(Counted arg0) {
		if(arg0==null) {
			return Integer.MAX_VALUE;
		}
		return arg0.getCount()-getCount();
	}

}
