package org.shilshar;

public class BST {
    
        private int value;
        private BST left;
        private BST right;
        
        public BST(int value){
            this.value = value; 
        }
        
        public void insert(int value){
            if (value < value){
                if (left == null)
                    left = new BST(value);
                else
                    left.insert(value);
            }
            else if (value > value){
                if (right == null)
                    right = new BST(value);
                else
                    right.insert(value);
            }
        }
        
    private int count = 0;
    

    public int kSmallestElementSum(BST root, int k){
        int sum = kSmallestElementSumRec(root, k);
        count = 0;
        return sum;
    }
    
    private int kSmallestElementSumRec(BST node, int k){
        int sum = 0;
        if (node == null)
            return 0;
        //recurse over left children
        sum += kSmallestElementSumRec(node.left, k);
        //if at any time during left recursion, count is met then break
        if (count >= k)
            return sum;
        //collect in sum as the nodes are traversed in-order
        sum += node.value;  
        count++;
        //break if count is met at current node
        if (count >= k)
            return sum;
        //recurse over right children
        sum += kSmallestElementSumRec(node.right, k); 
        
        return sum;
    }
    
    public static void main(String args[]){
        BST test = new BST(5);
        test.insert(3);
        test.insert(14);
        test.insert(7);
        System.out.println(test.kSmallestElementSum(test,3));
    }

}
