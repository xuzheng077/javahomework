package lecture13_functional_programming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Example code for lecture 13 (Functional Programming).
 * @author Jeffrey Eppinger & Terry Lee
 */
public final class ImmutableUser {

    /**
     * first name of User.
     */
    private final String firstName;
    /**
     * last name of User.
     */
    private final String lastName;
    /**
     * list of friends of User.
     */
    private final List<String> listOfFriends;

    /**
     * Constructor with first, last names and list of friends.
     * @param first first name
     * @param last last name
     * @param friends list of friends
     */
    public ImmutableUser(String first, String last, List<String> friends) {
        firstName = first;
        lastName = last;
        // Creates a new list (make a defensive copy).
        listOfFriends = new ArrayList<>(friends);
    }

    /**
     * Returns first name of User.
     * @return first name value
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Returns last name of User.
     * @return last name value
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Returns unmodifiable list of friends.
     * @return unmodifiable list of friends
     */
    public List<String> getListOfFriends() {
        return Collections.unmodifiableList(listOfFriends);
    }

    /**
     * Returns string representation of User.
     * @return string representation
     */
    @Override
    public String toString() {
        return "User (" + firstName + " " + lastName + ") has " + listOfFriends.size() + " friends";
    }

}
