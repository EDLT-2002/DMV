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
         
        Queue<String> info1 = new LinkedList<>(Arrays.asList("inState", "LateReg", "< 1 month", "motorcycle"));
        User user1 = new User(info1);
        traverse(baseFees, user1);
        user1.displayReceipt();
        
        Queue<String> info2 = new LinkedList<>(Arrays.asList("outState", "notLateReg", "car"));
        User user2 = new User(info2);
        traverse(baseFees, user2);
        user2.displayReceipt();
    }

    TreeNode baseFee;
    TreeNode inState;
    TreeNode outState;
    TreeNode lateReg;
    TreeNode notLateReg;
    TreeNode lateReg1;
    TreeNode lateReg2;
    TreeNode car;
    TreeNode commercial;
    TreeNode motorcycle;
    
    private TreeNode initializeTree() {
        baseFee = new TreeNode(100, "baseFee");
        inState = new TreeNode(10, "inState");
        outState = new TreeNode(50, "outState");
        lateReg = new TreeNode(0, "LateReg");
        lateReg2 = new TreeNode(50, "> 1 month");
        lateReg1 = new TreeNode(20, "< 1 month");
        notLateReg = new TreeNode(0, "notLateReg");
        car = new TreeNode(30, "car");
        commercial = new TreeNode(35, "commercial");
        motorcycle = new TreeNode(25, "motorcycle");
        
        
        baseFee.addChild(inState);
        baseFee.addChild(outState);
        inState.addChild(lateReg);
        inState.addChild(notLateReg);
        outState.addChild(lateReg);
        outState.addChild(notLateReg);
        lateReg.addChild(lateReg1);
        lateReg.addChild(lateReg2);
        lateReg1.addChild(car);
        lateReg1.addChild(commercial);
        lateReg1.addChild(motorcycle);
        lateReg2.addChild(car);
        lateReg2.addChild(commercial);
        lateReg2.addChild(motorcycle);
        notLateReg.addChild(car);
        notLateReg.addChild(commercial);
        notLateReg.addChild(motorcycle);
        
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