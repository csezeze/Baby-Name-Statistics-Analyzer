import java.util.ArrayList;

/**
 Working with an ArrayList of PopularName
 objects is made possible by the utility methods
 in this class.
 */

public class Util {
    //Sorts an ArrayList of PopularName objects by name
    // in alphabetical order using selection sort.
    public static void selectionSortByName(ArrayList<PopularName> names) {
        //  Returns the total number of babies represented by an ArrayList of PopularName objects.
        for (int i = 0; i < names.size() - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < names.size(); j++) {
                String currentName = names.get(j).getName();
                String minName = names.get(minIndex).getName();
                if (currentName.compareTo(minName) < 0) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                PopularName temp = names.get(i);
                names.set(i, names.get(minIndex));
                names.set(minIndex, temp);
            }
        }
    }

    public static int getTotalBabiesByGender(ArrayList<PopularName> names) {
        // Searches an ArrayList of
        // PopularName objects for a name and returns its index if found.
        int totalBabies = 0;
        for (PopularName name : names) {
            totalBabies += name.getTotalBabies();
        }
        return totalBabies;
    }

    public static int findIndexByName(ArrayList<PopularName> names, String name) {
        //depending on the name,
        //locates the PopularName object's index in an ArrayList.
        for (int i = 0; i < names.size(); i++) {
            if (names.get(i).getName().equalsIgnoreCase(name)) {
                return i;
            }
        }
        return -1;
    }
}
