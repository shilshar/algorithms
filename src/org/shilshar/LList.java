package org.practice;

public class LList<T> {
    
    private class Node{
        private T value;
        private Node nextNode;
    }
    
    private Node head;
    
    public void insert(T value){
        head = insertRec(head, value);
    }
    
    public Node insertRec(Node node, T value){
        if (node == null){
            node = new Node();
            node.value = value;
        } else{
            node.nextNode = insertRec(node.nextNode, value);
        }
        return node;
    }
    
    public void print(){
        printNode(head);
    }
    
    private void printNode(Node node){
        if (node != null){
            System.out.println(node.value);
            printNode(node.nextNode);
        }
    }
    
    public void reverse(){
        reverseNode(head, null);
    }
    
    private void reverseNode(Node node, Node prevNode){
        if (node != null){
            Node nextNode = node.nextNode;
            node.nextNode = prevNode;
            reverseNode(nextNode, node);
        } else
            this.head = prevNode;
    }
    
    public Node getMidNode(){
        Node oneStepNode = head;
        Node twoStepsNode = head;
        while (twoStepsNode != null && twoStepsNode.nextNode != null){
            oneStepNode = oneStepNode.nextNode;
            twoStepsNode = twoStepsNode.nextNode.nextNode;
        }
        return oneStepNode;
    }
    
    public static void main(String args[]){
        LList<Integer> myList = new LList<>();
        myList.insert(5);
        myList.insert(3);
        myList.insert(7);
        myList.insert(2);
        myList.insert(1);

        myList.print();
        myList.reverse();
        //myList.print();
        
        System.out.println(myList.getMidNode().value);
    }

}
