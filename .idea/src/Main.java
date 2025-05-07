
//Joel Maldonado
  //     Cop3330C
    //   2/20/25
import java.util.*;

public class Main {
    public static void main(String[] args) {
        //PART 1
        // Create a scanner for user input
        Scanner scanner = new Scanner(System.in);

        // Declare an ArrayList of Strings
        List<String> strings = new ArrayList<>();

        System.out.println("Enter 8 unique words:");

        while (strings.size() < 8) {
            System.out.print("Enter word #" + (strings.size() + 1) + ": ");
            String input = scanner.nextLine().trim(); // Read input and remove extra spaces

            // Check if the input is empty
            if (input.isEmpty()) {
                System.out.println("Empty input is not allowed. Please enter a valid word.");
                continue;
            }

            // Check if the word already exists (ignoring case)
            boolean isDuplicate = false;
            for (String s : strings) {
                if (s.equalsIgnoreCase(input)) {
                    isDuplicate = true;
                    break;
                }
            }

            // If the word is a duplicate, prompt the user to enter another word
            if (isDuplicate) {
                System.out.println("Duplicate word: " + input + ". Please enter another word.");
            } else {
                strings.add(input);
            }
        }

        //PART 2
        // Print the final list using an enhanced for loop
        System.out.println("\nlist of unique words:");
        for (String s : strings) {
            System.out.println(s);
        }

        // Find the longest and shortest words in the list
        String longestWord = strings.get(0);
        String shortestWord = strings.get(0);

        for (String s : strings) {
            if (s.length() > longestWord.length()) {
                longestWord = s;
            }
            if (s.length() < shortestWord.length()) {
                shortestWord = s;
            }
        }


        // Print results
        System.out.println("\nTotal number of entries: " + strings.size());
        System.out.println("Longest entry: " + longestWord);
        System.out.println("Shortest entry: " + shortestWord);

        // PART 3

        // Sort the list
        Collections.sort(strings);
        // Print the sorted list with a header
        System.out.println("\nSorted list of unique words:");
        for (String s : strings) {
            System.out.println(s);
        }

        //PART 4
        // sort the listing using a custom method, a comparator

        Collections.sort(strings, new Comparator<String>() {  //implementing the Comparator<String> interface.
            @Override
            public int compare(String o1, String o2) {
                return Integer.compare(o1.length(), o2.length());
            }
        });
        //print the shorted list with header
        System.out.println("\nSorted list of unique words , character length (shortest to longest):");
        for (String s : strings) {
            System.out.println(s);
        }
        //PART 5
        //Shuffle the list

        Collections.shuffle(strings);
        //header
        System.out.println("\nShuffled list of unique words:");
        for (String s : strings) {
            System.out.println(s);
        }

        // PART 6
        // search list for word user wants
        System.out.print("\nEnter a word to search for: ");
        String word = scanner.nextLine().trim();

        //create an attribute variable
        boolean found = false;
        int index = -1;

        // create a loop so word is found, if not console will end even if any word is entered
        while (true) {
            System.out.print("\nEnter another word to search for: ");
            String searchWord = scanner.nextLine().trim(); // Read the word to search for

            // Reset found and index for each search attempt
            found = false;
            index = -1;


            //loop through array to find word
            for (int i = 0; i < strings.size(); i++) {
                if (strings.get(i).equalsIgnoreCase(searchWord)) {
                    index = i;   // update the index of the array and are attribute is now true
                    found = true;
                    break;
                }
            }
            // print results
            if (!found) {
                System.out.println("\nWord not found: " + word);

            }
            if (found) {
                System.out.println("\nWord found: " + searchWord);
                break;
            }
        }

        //PART 7
        // Implement at least 2 other static methods from the Collections class
        Collections.reverse(strings);
        System.out.println("\nReversed list of unique words:");
        for (String s : strings) {
            System.out.println(s);
        }

        System.out.println("\nSwapping elements at index 0 and index 1...");
        Collections.swap(strings, 0, 1); // Swap the first and second elements
        // Print the list after swapping
        System.out.println("\nList after swapping:");
        for (String s : strings) {
            System.out.println(s);

    }
    //  PART 8
        //convert list to array ... toArray()
        String[] stringsArray = strings.toArray(new String[0]);
        //output array
        System.out.println("\nArray of strings: " );
        for (String s : stringsArray) {
            System.out.println(s);
        }

        //PART 9
        //convert array back to list .. Arrays.asList()

        List<String> stringsList = Arrays.asList(stringsArray);
        System.out.println("\nList of Elements: " );
        for (String s : stringsList) {
            System.out.println(s);
        }

        /* PART 10 !!!!!!!
         * Difference between Collections and Collection:
         *
         * 1. Collections:
         *    - `Collections` is a utility class in Java (java.util.Collections).
         *    - It provides static methods to perform operations on collections, such as sorting, shuffling, reversing, etc.
         *    - Examples of methods: Collections.sort(), Collections.shuffle(), Collections.reverse().
         *    - It cannot be instantiated (its constructor is private), and all its methods are static.
         *
         * 2. Collection:
         *    - `Collection` is an interface in Java (java.util.Collection).
         *    - It represents a group of objects (elements) and defines the basic operations that all collections should support,
         *      such as adding, removing, and iterating over elements.
         *    - Examples of methods: add(), remove(), contains(), size().
         *    - It is the root interface for all collection types, such as List, Set, and Queue.
         *
         * Difference between a Class and an Interface:
         *
         * 1. Class:
         *    - A class is a blueprint for creating objects (instances).
         *    - It can have fields (variables), methods, constructors, and implement interfaces.
         *    - A class can be instantiated using the `new` keyword.
         *    - Example: ArrayList is a class that implements the List interface.
         *
         * 2. Interface:
         *    - An interface is a contract that defines a set of methods that a class must implement.
         *    - It cannot be instantiated directly and does not contain method implementations (except for default methods in Java 8+).
         *    - A class can implement multiple interfaces, enabling polymorphism.
         *    - Example: Collection is an interface that defines methods like add(), remove(), and size().
         *
         * Sources:
         * - Oracle Java Documentation: https://docs.oracle.com/javase/8/docs/api/java/util/Collections.html
         * - Oracle Java Documentation: https://docs.oracle.com/javase/8/docs/api/java/util/Collection.html
         * - GeeksforGeeks: https://www.geeksforgeeks.org/collections-in-java-2/
         */

    }

}