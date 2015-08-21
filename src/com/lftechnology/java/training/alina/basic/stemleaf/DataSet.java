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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + dataValue;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DataSet other = (DataSet) obj;
		if (dataValue != other.dataValue)
			return false;
		return true;
	}
	
}
