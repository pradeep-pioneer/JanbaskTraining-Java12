package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Account account1 = new Account("First Customer", true, 300);
        Account account2 = new Account("Second Customer", true, 0);
        Account account3 = new Account("third Customer", false, 0);
        //xfer from account 1 to account 2
        try{
            Account.Transfer(account1, account2, 200.00f);
            Account.Transfer(account1, account3, 400f);
            Account.Transfer(account2, account3, 100f);
            System.out.println("Account 1 balance: " + account1.getBalance());
            System.out.println("Account 2 balance: " + account2.getBalance());
            System.out.println("Account 3 balance: " + account3.getBalance());
        }
        catch (InvalidAccountStateException ex){
            System.out.println("There was an exception details mentioned below:");
            System.out.println(ex.getMessage());
            System.out.println("Account 1 balance: " + account1.getBalance());
            System.out.println("Account 2 balance: " + account2.getBalance());
            System.out.println("Account 3 balance: " + account3.getBalance());
        }
    }
}
