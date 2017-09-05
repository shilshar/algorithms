package org.shilshar;

public class FirstMissingPositiveNumber {

    public static void main(String[] args) {
	    int[] input = new int[]{-5,-1,1,2,46};
        String message = "First missing positive number is ";
        System.out.println(message + findFirstMissingPositiveNumber(input));
    }

    private static int findFirstMissingPositiveNumber(int[] input) {
        int key = 1;

        // Use binary search to find index of 1
        int index = binarySearch(input, key);

        // If 1 was not found then that's the missing number
        if (index == -1)
            return key;

        // Else now look sequentially from this index for 2,3,4 and so on until a gap is found
        do {
            if (input[++index] != ++key)
                break;
            } while (index < input.length);
        // The key at the start of the gap is the first missing number
        return key;
    }

    private static int binarySearch(int[] input, int key){
        // Return the index where key is found else return -1
        int index = -1;
        int highIndex = input.length-1;
        int lowIndex = 0;
        int mid;
        do{
            mid = (lowIndex+highIndex)/2;
            int value = input[mid];
            if ( value == key) break;
            else if (key < value) highIndex = mid;
            else lowIndex = mid+1;
        } while ((highIndex-lowIndex)>=0);
        if ((highIndex-lowIndex)>=0)
            return mid;
        else
            return -1;
    }
}
