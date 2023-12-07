
//კონსოლიდან შეგყვავს n და შემდეგ n ცალი მთელი რიცხვი, დაალაგეთ რიცხვები
//ზრდადობით და დაბეჭდეთ.
import java.util.Arrays;

import acm.program.ConsoleProgram;

public class problem56 extends ConsoleProgram {
	public void run() {
		int n = readInt("Enter n: ");
		int[] nums = new int[n];
		for (int i = 0; i < n; i++) {
			nums[i] = readInt("Enter numbre: ");
		}
		sort(nums);

	}

	private void sort(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			int j = findMinIndex(nums, i);
			swap(nums, i, j);

			String str = Arrays.toString(nums);
		}
		println(nums);
	}

	private void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;

	}

	private int findMinIndex(int[] nums, int i) {
		int minIndex = i;
		for (int j = i; j < nums.length; j++) {
			if (nums[j] < nums[minIndex]) {
				minIndex = j;
			}
		}
		return minIndex;
	}
}
