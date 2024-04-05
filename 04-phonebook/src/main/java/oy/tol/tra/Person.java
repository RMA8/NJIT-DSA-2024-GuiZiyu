package oy.tol.tra;

public class Person implements Comparable<Person> {
    private String firstName;
    private String lastName;

    public Person(final Person person) {
        this.firstName = new String(person.firstName);
        this.lastName = new String(person.lastName);
    }
    
    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getFullName() {
        return lastName + " " + firstName;
    }

    @Override
    public String toString() {
        return getFullName();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hash = 5381;
        for (int i = 0; i < firstName.length(); i++) {
            hash = prime * hash + (int) firstName.charAt(i);
        }
        hash = prime * hash + 31;
        for (int i = 0; i < lastName.length(); i++) {
            hash = prime * hash + (int) lastName.charAt(i);
        }
        return hash;
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof Person) {
            return this.getFullName().equals(((Person)other).getFullName());
        }
        return false;
    }


    @Override
    public int compareTo(Person other) {
        return getFullName().compareTo(other.getFullName());
    }
}
