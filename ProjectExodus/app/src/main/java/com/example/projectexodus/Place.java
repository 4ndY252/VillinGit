package com.example.projectexodus;

/**
 * Place class
 * Represents one parsed object from JSON file
 */

public class Place {

    private String name, group, category, description, date_from, date_to, actualization_date, contact, street, address;

    public Place() {
    }

    public String getName() {
        return name;
    }

    public String getGroup() {
        return group;
    }

    public String getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }

    public String getDate_from() {
        return date_from;
    }

    public String getDate_to() {
        return date_to;
    }

    public String getActualization_date() {
        return actualization_date;
    }

    public String getContact() {
        return contact;
    }

    public String getStreet() {
        return street;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "Place{" +
                "name='" + name + '\'' +
                ", group='" + group + '\'' +
                ", category='" + category + '\'' +
                ", description='" + description + '\'' +
                ", date_from='" + date_from + '\'' +
                ", date_to='" + date_to + '\'' +
                ", actualization_date='" + actualization_date + '\'' +
                ", contact='" + contact + '\'' +
                ", street='" + street + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
