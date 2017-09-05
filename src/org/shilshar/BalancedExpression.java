package org.practice;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class BalancedExpression {
    
/*
 * Complete the function below.
 */

     static String[] is_balanced(String[] expression) {
               int expression_size = expression.length;
               String[] checks = new String[expression_size];
               
               for (int i=0; i<expression_size; i++){
                  checks[i] =  is_balanced(expression[i]);
               }
                   
               return checks;

   }
    
   private static String is_balanced(String expression){

       String check = "YES";
       int expression_len = expression.length();
       if (expression_len == 0)
           return check;
       
       char[] expressionChars = expression.toCharArray();
       // balanceParantheses will be incremented for opening and decremented for closing parentheses
       int balanceParantheses = 0;
       int smileys = 0;
       int frownies = 0;
       
       for (int i=0; i<expression_len && check == "YES"; i++){
               
               if (expressionChars[i] == '('){
                   // If an opening parentheses but also a frownie, increment frownies count.
                   // If previous character was a : then it's a frownie.
                   if (i>0 && expressionChars[i-1] == ':'){
                       frownies++;
                   }else{ 
                       balanceParantheses++;
                       // Also reset smileys as smileys before an opening parentheses cannot be used to balance out
                       smileys = 0;
                   }
               } else if (expressionChars[i] == ')'){ 
                   // If a closing parentheses but also a smiley, increment smileys count.
                   // If previous character was a : then it's a smiley.
                   if (i>0 && expressionChars[i-1] == ':')
                       smileys++;
                   else
                       balanceParantheses--;
                   // If the balanceParantheses count is -ve, there is an extra closing parentheses.
                   // If there are frownies before this, decrement frownies count,
                   // and the freed up opening parentheses balances the extra closing parentheses.
                   if (balanceParantheses == -1){
                       if (frownies > 0){
                           frownies--;
                           balanceParantheses = 0; 
                       } else check = "NO";
                   }// If the character is anything other than the valid characters set check to No.
               } else if (!((expressionChars[i] >= 'a' && expressionChars[i] <= 'z') ||
                       expressionChars[i] == ':' ||
                       expressionChars[i] == ' ')){
                      check = "NO";
               }
               
       }      
       // If there are extra opening parentheses, then free up the parantheses from the smileys,
       // to make balancing closing parantheses. If still unbalanced, then check is set to NO.
       if (balanceParantheses > 0 && (balanceParantheses-smileys)!=0)
           check = "NO";
       
       
       return check;
   }
   
   public static void main(String[] args) throws IOException{
       Scanner in = new Scanner(System.in);
       String[] res;
       
       int _expression_size = 0;
       _expression_size = Integer.parseInt(in.nextLine().trim());
       String[] _expression = new String[_expression_size];
       String _expression_item;
       for(int _expression_i = 0; _expression_i < _expression_size; _expression_i++) {
           try {
               _expression_item = in.nextLine();
           } catch (Exception e) {
               _expression_item = null;
           }
           _expression[_expression_i] = _expression_item;
       }
       
       res = is_balanced(_expression);
       for(int res_i=0; res_i < res.length; res_i++) {
           System.out.println(String.valueOf(res[res_i]));
       }
       
   }
}