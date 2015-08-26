
package com.lftechnology.java.training.niraj.shuffle;

import java.util.Collections;
import java.util.List;

public class ShuffleIntListImpl implements ShuffleList<Integer> {

	@Override
	public List<Integer> shuffleList(List<Integer> itemList) {

		Collections.shuffle(itemList);
		return itemList;
	}

	@Override
	public List<Integer> getSubList(List<Integer> itemList, int subListLength) {

		return itemList.subList(0, subListLength);
	}

	@Override
	public List<Integer> sortList(List<Integer> itemList) {

		Collections.sort(itemList);
		return itemList;
	}

}
