package dmvtree;

import java.util.*;
import java.text.*;
import java.util.Scanner;

public class DMVTree {
    
    public static void main(String[] args) {
        DMVTree tree = new DMVTree();
        tree.run();
    }
    
    public void run() {
         TreeNode baseFees = initializeTree();
         
        Queue<String> info1 = new LinkedList<>(Arrays.asList("inState", "lateReg"));
        User user1 = new User(info1);
        traverse(baseFees, user1);
        user1.displayReceipt();
        
        Queue<String> info2 = new LinkedList<>(Arrays.asList("outState", "notLateReg"));
        User user2 = new User(info2);
        traverse(baseFee, user2);
        user2.displayReceipt();
    }

    TreeNode baseFee;
    TreeNode inState;
    TreeNode outState;
    TreeNode lateReg;
    TreeNode notLateReg;
    
    private TreeNode initializeTree() {
        baseFee = new TreeNode(100, "baseFee");
        inState = new TreeNode(10, "inState");
        outState = new TreeNode(50, "outState");
        lateReg = new TreeNode(25, "lateReg");
        notLateReg = new TreeNode(0, "notLateReg");
        
        baseFee.addChild(inState);
        baseFee.addChild(outState);
        inState.addChild(lateReg);
        inState.addChild(notLateReg);
        outState.addChild(lateReg);
        outState.addChild(notLateReg);
        
        return baseFee;
    }
     
    public void traverse(TreeNode node, User user) {
        if (node == null) return;
        user.addFee(new Fee(node.getName(), node.getValue()));
        
        String nextStep = user.getInfo().poll();
        TreeNode nextNode = null;
        for (TreeNode child : node.getChildren()) {
            if (child.getName().equals(nextStep)) {
                nextNode = child;
                break;
            }
        }
        
        traverse(nextNode, user);
    }
    
    
}