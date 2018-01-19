package org.shilshar;

public class BinaryTree {
    
    private class Node {
        private int value;
        private Node leftChild;
        private Node rightChild;
        
        public Node(int value){
            this.value = value; 
        }
    }
    
    Node root;

    public void insert(int value){
        insertIter(root, value);
        //root = insertRec(root, value);
    }
    
    private Node insertRec(Node node, int value) {
        if (node == null)
            node = new Node(value);
        else if (value < node.value)
            node.leftChild = insertRec(node.leftChild, value);
        else if (value > node.value)
            node.rightChild = insertRec(node.rightChild, value);
        return node;
    }

    private void insertIter(Node root, int value) {
        Node newNode = new Node(value);
        Node parentNode = null;
        while (root != null) {
            parentNode = root;
            if (value < root.value)
                root = root.leftChild;
            else if (value > root.value)
                root = root.rightChild;
        }
        if (parentNode == null)
            this.root = newNode;
        else if (value > parentNode.value)
            parentNode.rightChild = newNode;
        else
            parentNode.leftChild = newNode;
    }

    public int getDepth() {
        return getDepthRec(root, 0);
    }

    private int getDepthRec(Node node, int depth) {
        if (node == null)
            return depth;
        depth++;
        int leftChildDepth = getDepthRec(node.leftChild, depth);
        int rightChildDepth = getDepthRec(node.rightChild, depth);
        return (leftChildDepth > rightChildDepth) ? leftChildDepth : rightChildDepth;
    }
    
    public boolean checkIfBST(){
        boolean isBST = true;
        isBST = checkIfBSTRec(root);
        return isBST;
    }
    
    private boolean checkIfBSTRec(Node node){
        boolean isBST = true;
        if (node != null){
            if (node.leftChild != null && node.leftChild.value > node.value) isBST = false;
            if (node.rightChild != null && node.rightChild.value < node.value) isBST = false;
            if (isBST)
                isBST = checkIfBSTRec(node.leftChild);
            if (isBST)
                checkIfBSTRec(node.rightChild);
        }
        return isBST;
    }
    
    public void traverse(){
        traverseRec(root);
    }
    
    private void traverseRec(Node node){
        if (node != null){
            traverseRec(node.leftChild);
            System.out.println(node.value);
            traverseRec(node.rightChild);
        }
    }
    
    public static void main(String[] args){
        BinaryTree myTree = new BinaryTree();
        myTree.insert(5);
        myTree.insert(3);
        myTree.insert(8);
        myTree.insert(1);
        
        myTree.traverse();

        System.out.println(myTree.getDepth());
        
        System.out.println(myTree.checkIfBST());
    }

}
