/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dmvtree;

public class Fee {
        private String name;
        private double amount;
        
        public Fee(String name, double amount) {
            this.name = name;
            this.amount = amount;
        }
        
        public double getAmount(){
            return amount;
        }
        
        public String getName(){
            return name;
        }
    }
