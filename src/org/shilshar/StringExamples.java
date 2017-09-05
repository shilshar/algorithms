package org.practice;

public class StringExamples {
    public static void main (String args[]){
        getMostFrequentChar("crocodile");
    }

    private static void getMostFrequentChar(String text){
       int[] charCount = new int[26];
       char[] charText = text.toLowerCase().toCharArray();
       char mostFrequentChar = charText[0];
       for (int i=0; i<charText.length ; i++){
           charCount[charText[i]-97]++;
       }
       int maxCharPos = 0;
       for (int i=0; i<charCount.length; i++){
           if (charCount[maxCharPos] < charCount[i])
               maxCharPos = i;
       }
       mostFrequentChar = (char)(97+maxCharPos);
       System.out.println(mostFrequentChar);
           
    }
}
