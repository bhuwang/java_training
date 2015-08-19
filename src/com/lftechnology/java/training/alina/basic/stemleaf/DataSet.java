package com.lftechnology.java.training.alina.basic.stemleaf;

/**
 * Class DataSet consists of data points to display stem and leaf
 * 
 * @author Alina Shakya <alinashakya@lftechnology.com>
 */
public class DataSet implements Comparable<DataSet> {
	public int dataSet;

	public DataSet(int dataSet) {
		this.dataSet = dataSet;
	}

	public int getDataSet() {
		return dataSet;
	}

	public void setDataSet(int dataSet) {
		this.dataSet = dataSet;
	}

	@Override
	public int compareTo(DataSet data) {
		return Integer.compare(this.dataSet, data.dataSet);
	}

	@Override
	public String toString() {
		return "" + dataSet;
	}
}
