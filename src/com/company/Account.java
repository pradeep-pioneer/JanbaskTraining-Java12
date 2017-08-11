package com.company;

/**
 * Created by prade on 8/11/2017.
 */
public class Account {

    private String customerName;
    public String getCustomerName(){
        return customerName;
    }

    private boolean isActive;
    public boolean getIsActive(){
        return isActive;
    }

    private float balance;
    public float getBalance(){
        return balance;
    }

    private void debit(float amount){
        balance-=amount;
    }
    private void credit(float amount){
        balance+=amount;
    }

    public Account(String customerName, boolean isActive, float initialBalance){
        this.customerName=customerName;
        this.isActive=isActive;
        this.balance=initialBalance;
    }

    public static void Transfer(Account from, Account to, float amount) throws InvalidAccountStateException{
        //preconditions
        if(from==null)
            throw new IllegalArgumentException("from account cannot be null");
        if(to==null)
            throw new IllegalArgumentException("to account cannot be null");
        if(!from.getIsActive())
            throw new InvalidAccountStateException("the source account is inactive");
        if(!to.getIsActive())
            throw new InvalidAccountStateException("the destination account is inactive");
        if(from.getBalance()<=amount)
            throw new InvalidAccountStateException("insufficient funds in source account");
        if(amount<=0)
            throw new IllegalArgumentException("amount cannot be zero or less");
        float sourceBalance = from.getBalance();
        float destinationBalance = to.getBalance();
        from.debit(amount);
        to.credit(amount);
        //post-conditions
        if(sourceBalance-amount!=from.getBalance())
            throw new InvalidAccountStateException("The source account not debited!");
        if(destinationBalance+amount!=to.getBalance())
            throw new InvalidAccountStateException("The source account not credited!");
    }
}
