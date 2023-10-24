/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dmvtree;

import java.util.ArrayList;
import java.util.List;

import java.util.*;
import java.text.*;

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
        public String getName()
        {
            return name;
        }
        public List<TreeNode> getChildren() {
            return children;
        }
}
