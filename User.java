package dmvtree;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

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
            this.sum += transaction.getAmount();
            receipt.add(transaction);
        }
        
        public Queue<String> getInfo(){
        return info;
        }
        
        public void displayReceipt() {
            currency = NumberFormat.getCurrencyInstance();
            for (Fee f : receipt) {
                System.out.println(f.getName() + ": " + currency.format(f.getAmount()));
            }
            System.out.println("Total: " + currency.format(this.sum) + "\n");
        }
    }
