package org.shilshar;

import java.io.*;
import java.util.*;

public class Pangram {
    
/*
 * Complete the function below.
 */
    static String isPangram(String[] strings) {
        StringBuilder sb = new StringBuilder();
        for (String s : strings){
            char[] marker = new char[26];
            for (char ch : s.toCharArray()) {
                if (ch != ' ')
                    marker[ch-97] = '1';
            }
            char pangramCheck = '1';
            for (char mark : marker){
                if (mark != '1'){
                    pangramCheck = '0';
                    break;
                }
            }
            sb.append(pangramCheck);
        }
        return sb.toString();
    }

    
    public static void main(String[] args) throws IOException{
        Scanner in = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new FileWriter("input.txt"));
        String res;
        
        int _strings_size = 0;
        _strings_size = Integer.parseInt(in.nextLine().trim());
        String[] _strings = new String[_strings_size];
        String _strings_item;
        for(int _strings_i = 0; _strings_i < _strings_size; _strings_i++) {
            try {
                _strings_item = in.nextLine();
            } catch (Exception e) {
                _strings_item = null;
            }
            _strings[_strings_i] = _strings_item;
        }
        
        res = isPangram(_strings);
        bw.write(res);
        bw.newLine();
        
        bw.close();
    }
}