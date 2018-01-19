package org.shilshar;

public class AB {
    public String createString(int n, int k){
        
        String myString = null;
        char[] chArray = new char[n];
        
        if (!(n<2 || n>50 || k<0 || k> n*(n-1)/2)){
            for (int i=0; i<n; i++){
                for (int j=0; j<n; j++){
                    chArray[i] = 'A';
                    chArray[j] = 'B';
                }
            }
        
        }
        return myString;
        
    }
}
