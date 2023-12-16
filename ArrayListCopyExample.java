
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
    	
//    	
//    	 // Create a matrix
//        int[][] originalMatrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
//
//        // Copy the matrix
//        int[][] copiedMatrix = deepCopyMatrix(originalMatrix);
//
//        // Modify the original matrix
//        originalMatrix[0][0] = 99;
//
//        // Print both matrices
//        System.out.println("Original Matrix:");
//        printMatrix(originalMatrix);
//
//        System.out.println("Copied Matrix:");
//        printMatrix(copiedMatrix);
//    }
//
//    // Function to deep copy a matrix
//    public static int[][] deepCopyMatrix(int[][] matrix) {
//        int rows = matrix.length;
//        int cols = matrix[0].length;
//        int[][] copy = new int[rows][cols];
//
//        for (int i = 0; i < rows; i++) {
//            System.arraycopy(matrix[i], 0, copy[i], 0, cols);
//        }
//
//        return copy;
//    }
//
//    // Function to print a matrix
//    public static void printMatrix(int[][] matrix) {
//        for (int[] row : matrix) {
//            for (int value : row) {
//                System.out.print(value + " ");
//            }
//            System.out.println();
//        }
//        System.out.println();
//    	
    }
}