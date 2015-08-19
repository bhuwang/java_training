package com.lftechnology.java.training.sanish.stemleaf;

public class StemLeaf {
	private int stem;
	private int leaf;
	private int count;

	public int getStem() {
		return stem;
	}

	public void setStem(int stem) {
		this.stem = stem;
	}

	public int getLeaf() {
		return leaf;
	}

	public void setLeaf(int leaf) {
		this.leaf = leaf;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return count + "\t\t" + stem + "\t" + leaf;
	}
}
