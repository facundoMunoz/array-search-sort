package searchSort;

public class Search {

    // Brute force
    public int linear(int[] array, int key) {
        // Returns the position of the element or -1
        int pos, finalPos, len;
        boolean flag = false;
        finalPos = -1;
        pos = 0;
        len = array.length;

        while (!flag && pos < len) {
            if (array[pos] == key) {
                flag = true;
                finalPos = pos;
            } else {
                pos++;
            }
        }

        return finalPos;
    }

    // Decrease and conquer
    public int binary(int[] array, int key) {
        int lowest, highest, finalPos, mid;
        finalPos = -1;
        lowest = 0;
        highest = array.length - 1;

        while (lowest <= highest) {
            mid = (int) Math.floor((lowest + highest) / 2);
            if (array[mid] == key) {
                lowest = highest + 1;
                finalPos = mid;
            } else {
                if (key < array[mid]) {
                    highest = mid - 1;
                } else {
                    lowest = mid + 1;
                }
            }
        }

        return finalPos;
    }

}
