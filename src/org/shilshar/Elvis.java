package org.practice;

public enum Elvis {
    INSTANCE;
    
    public void leaveTheBuilding(){
        System.out.println("leave");
    }
    
    public static void main(String[] args){
        Elvis.INSTANCE.leaveTheBuilding();
    }

}
