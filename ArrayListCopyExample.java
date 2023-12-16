
import java.util.ArrayList;

public class ArrayListCopyExample {
    public static void main(String[] args) {
        // Create an ArrayList
        ArrayList<Integer> originalList = new ArrayList<>();
        originalList.add(1);
        originalList.add(2);
        originalList.add(3);

        // Clone the ArrayList
        ArrayList<Integer> copiedList = (ArrayList<Integer>) originalList.clone();

        // Modify the original list
        originalList.add(4);

        // Print both lists
        System.out.println("Original List: " + originalList);
        System.out.println("Copied List: " + copiedList);
    }
}