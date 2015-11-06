import java.util.*;

/*  A Bank holds a list of BankAccounts. */

public class Bank {
    //instance variables
    private ArrayList<BankAccount> list;
    
    //constructor
    public Bank() {
        list = new ArrayList<BankAccount>();
    }

    //query methods
    public int getNum(){
        return list.size();
    }
    
    public double avgBalance(){
        if(list.size() < 1) return 0;
        double total = 0;
        for(BankAccount b: list){
            total += b.getBalance();
        }
        return total / list.size();
    }
    
    public BankAccount getAcct(String ID){
        BankAccount output = null;
        for(BankAccount b: list){
            if(b.getID().equals(ID))
                output = b;
        }
        return output;
    }
    
    public BankAccount getRichest(){
        BankAccount output = null;
        double richest = 0;
        for(BankAccount b: list){
            if(b.getBalance() > richest) {
                richest = b.getBalance();
                output = b;
            }
        }
        return output;
    }
    
    //mutators
    public void addAccount(BankAccount b){
        list.add(b);
    }
}

/**
 * Complete this class by implementing the following behaviors. A client should be able to:
 * 1. add a BankAccount to this Bank.
 * 2. query for the number of BankAccounts at this Bank
 * 3. query for the average balance of all BankAccounts at this Bank. Return 0 if there are no accounts.
 * 4. query for a BankAccount based on ID (that is a String).  Return the BankAccount, or null if it isn't found
 * 5. query for the BankAccount with the largest balance (return null if the Bank has no accounts).
 */
