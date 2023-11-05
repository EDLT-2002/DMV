package dmvtree;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class User {
        private Queue<String> info;
        private List<Fee> receipt;
        private double percentage;
        private double sum;
        private NumberFormat currency;
        
        public User(Queue<String> info) {
            this.sum = 0;
            this.info = info;
            this.receipt  = new ArrayList<>();
            percentage = 0.0;
        }
        
        public void addFee(Fee transaction) {
            String percent1 = "< 1 month";
            String percent2 = "> 1 month";
            
            if(transaction.getName().equals(percent1) || transaction.getName().equals(percent2)){
                percentage = transaction.getAmount() / 100;
            }
            else
                this.sum += transaction.getAmount();
            
            receipt.add(transaction);
        }
        
        public Queue<String> getInfo(){
        return info;
        }
        
        public void displayReceipt() {
            currency = NumberFormat.getCurrencyInstance();
            for (Fee f : receipt) {
                System.out.println(f.getName() + ": ");
                if(f.getName().equals("< 1 month") || f.getName().equals("> 1 month"))
                {
                    System.out.println(f.getAmount() + "%");
                }
                else
                     System.out.println(currency.format(f.getAmount()));
            }
            double total = sum * (1 + percentage);
            System.out.println("Total: " + currency.format(total) + "\n");
        }
    }
