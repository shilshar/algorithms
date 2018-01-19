package org.shilshar;

public class Stack<T> {
    
    private class Element{
        private T data;
        private Element next;
        
        public Element(T data, Element next){
            this.data = data;
            this.next = next;
        }
    }
    
    Element head;
    
    public void deleteStack(){
        while (head!=null){
            head = head.next;
        }
    }
    
    public void push(T data){
        if (head == null)
            head = new Element(data, null);
        else{
            head = new Element(data, head);
        }
    }
    
    public T pop(){
        T data = null;
        if (head != null){
            data = head.data;
            head = head.next;
        }
        return data;
    }
    
    public static void main(String args[]){
        Stack<Integer> myStack =  new Stack<>();
        
        myStack.push(5);
        myStack.push(3);
        myStack.push(1);
        
        System.out.println(myStack.pop());
        myStack.push(2);
        System.out.println(myStack.pop());
    }
    
}
