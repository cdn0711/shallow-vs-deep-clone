package com.mikonogroup.service;

import com.mikonogroup.model.Address;
import com.mikonogroup.model.Person;

public class CopyService {

    public static Person shallowCopy(Person original) {
        return (Person) original.clone();
    }

    public static Person deepCopy(Person original) {
        Address clonedAddress = new Address();
        clonedAddress.setStreet(original.getAddress().getStreet());
        clonedAddress.setStreetNo(original.getAddress().getStreetNo());
        clonedAddress.setCity(original.getAddress().getCity());
        clonedAddress.setPostalCode(original.getAddress().getPostalCode());
        clonedAddress.setCountry(original.getAddress().getCountry());

        Person clonedPerson = new Person();
        clonedPerson.setName(original.getName());
        clonedPerson.setAge(original.getAge());
        clonedPerson.setAddress(clonedAddress);
        return clonedPerson;
    }
}
