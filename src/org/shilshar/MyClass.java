package org.practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MyClass {

	public static void main(String[] args) {
	    List<Integer> l1 = new LinkedList<>();

	    l1.add(1);
	    l1.add(4);
	    l1.add(2);
	    for (Integer i : l1){
	        System.out.print(" " + i);
	    }
	    System.out.println();
	    List<Integer> l2 = new ArrayList<>();
	    l2.add(1);
        l2.add(4);
        l2.add(2);
        System.out.println("Now ArrayList");
        for (int j=0; j<10; j++){
            System.out.println("" + j + "times");
            for (Integer i : l2)
                System.out.print(" " + i);
            System.out.println();
        }
	}

}
