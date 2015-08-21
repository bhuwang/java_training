package com.lftechnology.java.training.alina.basic.stemleaf;

/**
 * Class DataSet consists of data points to display stem and leaf
 * 
 * @author Alina Shakya <alinashakya@lftechnology.com>
 */
public class DataSet implements Comparable<DataSet> {
	private int dataValue;

	public DataSet(int dataValue) {
		this.dataValue = dataValue;
	}

	public int getDataSet() {
		return dataValue;
	}

	public void setDataSet(int dataSet) {
		this.dataValue = dataSet;
	}

	@Override
	public int compareTo(DataSet data) {
		return this.dataValue - data.dataValue;
	}

	@Override
	public String toString() {
		return Integer.toString(dataValue);
	}
}
