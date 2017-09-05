package org.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ListBinarySearch {

    public static void main(String[] args) {
        int key = 5;
        boolean search = true;
        List<Integer> inputList =  Arrays.asList(new Integer[]{0,1,2,3,4,5});
        //int index = Collections.binarySearch(inputList,key);
        int highIndex = inputList.size()-1;
        int lowIndex = 0; 
        int mid;
        do{    
            mid = (lowIndex+highIndex)/2;
            int value = inputList.get(mid);
            if ( value == key) break;
            else if (key < value) highIndex = mid;
            else lowIndex = mid+1;
        } while ((highIndex-lowIndex)>=0);
        if ((highIndex-lowIndex)>=0)
            System.out.println("found at " + mid);
        else
            System.out.println("not found!");
    }
    
}
