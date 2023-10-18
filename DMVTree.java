import java.util.*;
import java.text.*;

public class DMVTree {
    public class TreeNode {
        private double value;
        private String name;
        private List<TreeNode> children;
        
        public TreeNode(double value, String name) {
            this.value = value;
            this.name = name;
            children = new ArrayList<>();
        }
        public void addChild(TreeNode child) {
            children.add(child);
        }
        public double getValue() {
            return value;
        }
        public List<TreeNode> getChildren() {
            return children;
        }
    }
    
    public class Fee {
        private String name;
        private double amount;
        public Fee(String name, double amount) {
            this.name = name;
            this.amount = amount;
        }
    }
    
    public class User {
        private Queue<String> info;
        private List<Fee> receipt;
        private double sum;
        private NumberFormat currency;
        
        public User(Queue<String> info) {
            this.sum = 0;
            this.info = info;
            this.receipt  = new ArrayList<>();
        }
        
        public void addFee(Fee transaction) {
            this.sum += transaction.amount;
            receipt.add(transaction);
        }
        
        public void displayReceipt() {
            currency = NumberFormat.getCurrencyInstance();
            for (Fee f : receipt) {
                System.out.println(f.name + ": " + currency.format(f.amount));
            }
            System.out.println("Total: " + currency.format(this.sum) + "\n");
        }
    }

    TreeNode baseFee;
    TreeNode inState;
    TreeNode outState;
    TreeNode lateReg;
    TreeNode notLateReg;
    
    public DMVTree() {
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
    }
     
    public void traverse(TreeNode node, User user) {
        if (node == null) return;
        user.addFee(new Fee(node.name, node.value));
        
        String nextStep = user.info.poll();
        TreeNode nextNode = null;
        for (TreeNode child : node.getChildren()) {
            if (child.name == nextStep) {
                nextNode = child;
                break;
            }
        }
        
        traverse(nextNode, user);
    }
    
    public void run() {
        Queue<String> info1 = new LinkedList<>(Arrays.asList("inState", "lateReg"));
        User user1 = new User(info1);
        traverse(baseFee, user1);
        user1.displayReceipt();
        
        Queue<String> info2 = new LinkedList<>(Arrays.asList("outState", "notLateReg"));
        User user2 = new User(info2);
        traverse(baseFee, user2);
        user2.displayReceipt();
    }
    
    public static void main(String[] args) {
        DMVTree tree = new DMVTree();
        tree.run();
    }
}
