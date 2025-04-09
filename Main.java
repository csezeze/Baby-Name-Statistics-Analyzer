import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * The application's starting point is the
 * main method. A file name is requested from
 * the user, data is read from that file, sorted
 * and searched as necessary, and offers users interactive
 * suggestions to look up data for specific baby names.
 */
public class Main {
    public static void main(String[] args) {
        /* This program prompts the user to enter a file name,
         * reads the user's input from the console using Scanner,
         * and stores the input as a String.
         */
        Scanner scanner = new Scanner(System.in);
        System.out.println("** Please write the name of the file containing baby names on the computer(e.x. names2002.csv) **");
        System.out.println("Enter a file name:");
        String fileName = scanner.nextLine(); //variable called fileName

        /* This program creates two ArrayLists to hold PopularName objects for male and female names respectively.
         * Java's version of resizable arrays supports dynamic array sizing through the use of the ArrayList class.
         * It creates two ArrayLists, one for female names and one for male names, and populates each list with PopularName.
         */
        ArrayList<PopularName> maleNames = new ArrayList<>();
        ArrayList<PopularName> femaleNames = new ArrayList<>();

        try {
            File file = new File(fileName);
            Scanner fileScanner = new Scanner(file);
            //Reading  data from the file
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] data = line.split(","); // Splits a String into an array of substrings using the comma separator

                /*
                 * The elements of the array are then parsed into the appropriate data types and used to create PopularName objects for male and female names.
                 * These objects are added to their respective ArrayLists.
                 * The maleNames and femaleNames ArrayLists are then sorted alphabetically by name using selection sort,
                 * which is a simple sorting algorithm that iterates through the list and swaps adjacent elements if they are out of order.
                 */
                Integer rank = Integer.parseInt(data[0]);
                String maleName = data[1];
                Integer maleNumber = Integer.parseInt(data[2]);
                String femaleName = data[3];
                Integer femaleNumber = Integer.parseInt(data[4]);
                PopularName male = new PopularName(maleName, rank, maleNumber);
                PopularName female = new PopularName(femaleName, rank, femaleNumber);
                maleNames.add(male);
                femaleNames.add(female);
            }

            fileScanner.close();
            System.out.println("Congratulations,File is uploaded :)");
            //Sorting the ArrayLists by name using selection sort
            Util.selectionSortByName(maleNames);
            Util.selectionSortByName(femaleNames);


            String searchGender;
            String searchName;
            // Providing interactive prompts
            // for users to search for baby name statistics
            do {
                System.out.println("Do you want to search for a name and see its statistics? (y/n)");
                String choice = scanner.nextLine();

                if (choice.equalsIgnoreCase("y")) {
                    System.out.println("Please enter a gender: (male/female)");
                    searchGender = scanner.nextLine();

                    ArrayList<PopularName> searchList;
                    // Selecting the appropriate ArrayList based on the
                    // user's gender input

                    if (searchGender.equalsIgnoreCase("male")) {
                        searchList = maleNames;
                    } else if (searchGender.equalsIgnoreCase("female")) {
                        searchList = femaleNames;
                    } else {
                        System.out.println("Invalid gender. Please try again :( ");
                        continue;
                    }

                    System.out.println("Please enter a name:");
                    searchName = scanner.nextLine();

                    //Using binary search, locate the search name's index in
                    // the sorted ArrayList.
                    int index = Util.findIndexByName(searchList, searchName);

                    if (index != -1) {
                        // Getting the PopularName object associated with the index
                        PopularName result = searchList.get(index);
                        // Display the name, index, rank, number of babies, and percentage
                        System.out.println(result.getName() + ":");
                        System.out.println("index in sorted list: " + index);
                        System.out.println("rank in popularity: " + result.getRank());
                        System.out.println("number of babies: " + result.getTotalBabies());

                        double percentage = (result.getTotalBabies() * 100.0) / Util.getTotalBabiesByGender(searchList);
                        //Prints a formatted message to the console with the percentage of babies represented by a given number.
                        //This method takes a double parameter representing the percentage of babies and formats it as a string with
                        //two decimal places and a percent sign. The formatted percentage is then included in a message printed to
                        //the console.
                        System.out.println("percentage of babies: " + String.format("%.2f%%", percentage));
                    } else {
                        //Printing a message if we cannot find the name
                        System.out.println("Name not found: :( ");
                    }
                } else if (choice.equalsIgnoreCase("n")) {
                    System.out.println(" * Thank you for using the program * ");
                    break;
                } else {
                    System.out.println("Invalid choice. Please try again.");
                }
            } while (true);

        } catch (Exception e) {
            System.out.println("File not found. Please try again.");
        }

        scanner.close();
    }


}
