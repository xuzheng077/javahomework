package lecture13_functional_programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Example code for lecture 13 (Functional Programming).
 * @author Jeffrey Eppinger & Terry Lee
 */
public class UserTestFP {

    /**
     * Simple program to demo lambda expressions to replace Comparator nested
     * classes.
     * @param args arguments
     */
    public static void main(String[] args) {
        List<ImmutableUser> list = buildUserList();

        System.out.println("Before sort");
        list.forEach(e -> System.out.println(e));

        // demonstrate different ways of using lambda expressions
        Collections.sort(list,
                (ImmutableUser u1, ImmutableUser u2) -> u1.getLastName().compareTo(u2.getLastName()));
        System.out.println("\nAfter sort by last name");
        list.forEach(e -> System.out.println(e));
        
        list.sort((ImmutableUser u1, ImmutableUser u2) -> u1.getFirstName().compareTo(u2.getFirstName()));
        System.out.println("\nAfter sort by first name");
        list.forEach(e -> System.out.println(e));

        list.sort((u1, u2) -> Integer.compare(u2.getListOfFriends().size(), u1.getListOfFriends().size()));
        System.out.println("\nAfter sort by number of friends");
        list.forEach(e -> System.out.println(e));
    }

    /**
     * Builds a user list.
     * @return list of user objects
     */
    private static List<ImmutableUser> buildUserList() {
        List<ImmutableUser> list = new ArrayList<>();
        List<String> gbFriends = Arrays.asList("Jeb Bush", "John Wang");
        List<String> boFriends = Arrays.asList("Michell Obama", "Joe Biden", "Michael Jordan");
        List<String> bcFriends = Arrays.asList("Hillary Clinton");
        List<String> jbFriends = Arrays.asList("George Bush");
        List<String> hcFriends = Arrays.asList("Bill Clinton", "Barack Obama", "Joe Biden");
        list.add(new ImmutableUser("George", "Bush", gbFriends));
        list.add(new ImmutableUser("Barack", "Obama", boFriends));
        list.add(new ImmutableUser("Bill", "Clinton", bcFriends));
        list.add(new ImmutableUser("Jeb", "Bush", jbFriends));
        list.add(new ImmutableUser("Hillary", "Clinton", hcFriends));
        return list;
    }

}
