package com.lftechnology.java.training.niraj.linkedlist;

import java.util.List;

/**
 * Implementation of services related to list
 * 
 * @author Niraj Rajbhandari <nirajrajbhandari@lftechnology.com>
 */
public class ListServiceImpl implements ListService {

    @Override
    public void merge(List<String> firstList, List<String> secondList) {

        firstList.addAll(secondList);
    }

    @Override
    public void remove(List<String> itemList, Parity p) {

        int i = (p == Parity.EVEN) ? 0 : 1;
        for (; i < itemList.size(); i++) {
            itemList.remove(i);
        }
    }

    @Override
    public void remove(List<String> itemList, List<String> listToRemove) {

        itemList.removeAll(listToRemove);
    }

}
