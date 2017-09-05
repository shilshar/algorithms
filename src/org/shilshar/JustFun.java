package org.practice;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class JustFun {

    public static void main(String[] args) {
        String[] magazine = {"give","me","one","grand","today","night"};
        String ransom[] = {"give","me","one","grand","today",};

        System.out.print(isReplicable(magazine,ransom));
    }
    
    private static String isReplicable(String[] magazine, String[] ransom){
        if (magazine.length < ransom.length)
            return "No";
        Map<String, Integer> magMap = new HashMap<>();
        for (String word : magazine){
            if (magMap.containsKey(word)){
                int count = magMap.get(word);
                magMap.put(word,++count);
            }
            else
                magMap.put(word,0);
        }
        for (String word : ransom ){
            if (!magMap.containsKey(word) || magMap.get(word)==-1){
                return "No";
            }
            else{
                int count = magMap.get(word);
                magMap.put(word,--count);
            }
        }
        return "Yes";
    }
}
