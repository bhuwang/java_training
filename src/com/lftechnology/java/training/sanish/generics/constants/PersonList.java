package com.lftechnology.java.training.sanish.generics.constants;

/**
 * Provide person information
 *
 * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
 */
public enum PersonList {
    ID_1(new Person("Sanish Maharjan", "Panga, Kirtipur", "9841115968")),
    ID_2(new Person("Manish Maharjan", "Panga, Kirtipur", "9841908956")),
    ID_3(new Person("Dinesh", "Satungal, Kathmandu", "9841418393")),
    ID_4(new Person("Pradeep Maharjan", "Kupu", "9841881359"));
    private Person person;

    PersonList(Person person) {
        this.person = person;
    }

    public String getName() {
        return person.getName();
    }

    public String getAddress() {
        return person.getAddress();
    }

    public String getContactNumber() {
        return person.getContactNumber();
    }
}
