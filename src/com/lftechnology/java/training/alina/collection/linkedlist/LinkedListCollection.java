package com.lftechnology.java.training.alina.collection.linkedlist;

import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * a. Create a linked list named one and two. b. Add some elements to both one (one, two, three, four, five) and two (six, seven, eight,
 * nine, and ten). c. Merge the words from two into one. d. Remove every second word from two. e. Remove all words in two from one. f. Print
 * the value after each operation.
 * 
 * @author Alina Shakya <alinashakya@lftechnology.com>
 */
public class LinkedListCollection {

    private static final Logger LOGGER = Logger.getLogger(LinkedListCollection.class.getName());
    private static List<String> one = new LinkedList<String>();
    private static List<String> two = new LinkedList<String>();

    private LinkedListCollection() {
    }

    public static void main(String[] args) {

        addElements();
        mergeElements();
        removeSecondWord();
        removeAllWords();
    }

    /**
     * Used to add elements to linked list named one & two
     * 
     * @author Alina Shakya <alinashakya@lftechnology.com>
     */
    private static void addElements() {

        one.add("one");
        one.add("two");
        one.add("three");
        one.add("four");
        one.add("five");
        LOGGER.log(Level.INFO, "Elements in linked list one are : {0}", one);

        two.add("six");
        two.add("seven");
        two.add("eight");
        two.add("nine");
        two.add("ten");
        LOGGER.log(Level.INFO, "Elements in linked list two are : {0}", two);
    }

    /**
     * Used to merge the words from two into one
     * 
     * @author Alina Shakya <alinashakya@lftechnology.com>
     */
    private static void mergeElements() {

        one.addAll(two);
        LOGGER.log(Level.INFO, "Elements in linked list one after merging from two are : {0}", one);
    }

    /**
     * Used to remove every second word from two.
     * 
     * @author Alina Shakya <alinashakya@lftechnology.com>
     */
    private static void removeSecondWord() {

        for (int i = 1; i < two.size(); i++) {
            two.remove(i);
        }
        LOGGER.log(Level.INFO, "Elements in linked list two after removing every second word are : {0}", two);
    }

    /**
     * Used to remove all words in two from one.
     * 
     * @author Alina Shakya <alinashakya@lftechnology.com>
     */
    private static void removeAllWords() {

        one.removeAll(two);
        LOGGER.log(Level.INFO, "Elements in linked list one after removing all words in two are : {0}", one);
    }

}
