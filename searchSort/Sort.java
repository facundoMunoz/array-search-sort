package searchSort;

public class Sort {

	// Brute force
	public void selection(int[] array) {
		int min, leng, temp;
		leng = array.length - 1;

		for (int i = 0; i < leng; i++) {
			min = i;
			// We look for the smallest element
			for (int j = i + 1; j <= leng; j++) {
				if (array[j] < array[min]) {
					min = j;
				}
			}
			// Exchange smallest element with first disordered position
			temp = array[i];
			array[i] = array[min];
			array[min] = temp;
		}
	}

	public void bubble(int[] array) {
		int leng, temp;
		leng = array.length - 1;

		for (int i = 0; i < leng; i++) {
			for (int j = 0; j < leng - i; j++) {
				if (array[j + 1] < array[j]) {
					temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}
		}
	}

	// Decrease and conquer
	public void insertion(int[] array) {
		int leng, temp, pos;
		leng = array.length;

		for (int i = 1; i < leng; i++) {
			temp = array[i];
			pos = i;
			while (pos > 0 && temp < array[pos - 1]) {
				array[pos] = array[pos - 1];
				pos = pos - 1;
			}
			array[pos] = temp;
		}
	}

	// Divide and conquer
	public void mergeSort(int[] array) {
		this.sort(array, 0, array.length - 1);
	}

	private void sort(int[] array, int left, int right) {
		if (left < right) {
			// Find middle point
			int middle = (left + right) / 2;

			// Split left and right part
			sort(array, left, middle);
			sort(array, middle + 1, right);

			// Merges the two parts
			merge(array, left, middle, right);
		}
	}

	private void merge(int[] array, int left, int middle, int right) {
		// Finds two halfs to join them
		int n1 = middle - left + 1;
		int n2 = right - middle;

		// Temporary vectors
		int leftArray[] = new int[n1];
		int rightArray[] = new int[n2];

		// Copy data from temporary arrays
		for (int i = 0; i < n1; i++) {
			leftArray[i] = array[left + i];
		}
		for (int j = 0; j < n2; j++) {
			rightArray[j] = array[middle + j + 1];
		}
		/* Joins temporary vectors */

		// Initial index of first and second sub-vector.
		int i = 0, j = 0;

		// Initial index of sub-vector arr[].
		int k = left;

		// Order
		while (i < n1 && j < n2) {
			if (leftArray[i] <= rightArray[j]) {
				array[k] = leftArray[i];
				i++;
			} else {
				array[k] = rightArray[j];
				j++;
			}
			k++;
		}

		/* If there are elements left to order */
		// Copy missing elements in leftArray[].
		while (i < n1) {
			array[k] = leftArray[i];
			i++;
			k++;
		}
		// Copy missing elements in rightArray[].
		while (j < n2) {
			array[k] = rightArray[j];
			j++;
			k++;
		}
	}

	public void quickSort(int[] array) {
		sortQ(array, 0, array.length - 1);
	}

	// Sort the array using quickSort
	private void sortQ(int[] array, int low, int high) {
		// Auxillary stack
		int[] intStack = new int[high - low + 1];

		// Top of stack initialized to -1
		int top = -1;

		// Push initial values of low and high to stack
		intStack[++top] = low;
		intStack[++top] = high;

		// Keep popping from stack while is not empty
		while (top >= 0) {
			// Pop h and l
			high = intStack[top--];
			low = intStack[top--];

			// Set pivot element at its correct position
			// In sorted array
			int pivot = partition(array, low, high);

			// If there are elements on left side of pivot,
			// Then push left side to stack
			if (pivot - 1 > low) {
				intStack[++top] = low;
				intStack[++top] = pivot - 1;
			}

			// If there are elements on right side of pivot,
			// Then push right side to stack
			if (pivot + 1 < high) {
				intStack[++top] = pivot + 1;
				intStack[++top] = high;
			}
		}
	}

	// Partitions the array around pivot=> last element
	private int partition(int[] array, int low, int high) {
		int pivot = array[high];
		// Smaller element index
		int i = (low - 1);
		for (int j = low; j <= high - 1; j++) {
			// Check if current element is less than or equal to pivot
			if (array[j] <= pivot) {
				i++;
				// Swap the elements
				int temp = array[i];
				array[i] = array[j];
				array[j] = temp;
			}
		}
		// Swap numArray[i+1] and numArray[high] (or pivot)
		int temp = array[i + 1];
		array[i + 1] = array[high];
		array[high] = temp;
		return i + 1;
	}

}
