

import java.util.Scanner;

class Bank {
    private String accno;
    private String name;
    private long balance;
    int previousTransaction;

    Scanner sc = new Scanner(System.in);

    //method to open an account
    void openAccount() {
        System.out.print("\nEnter Account Number: ");
        accno = sc.next();
        System.out.print("Enter Name: ");
        name = sc.next();
        System.out.print("Enter Balance: ");
        balance = sc.nextLong();
    }

    //method to display account details
    void showAccount() {
        System.out.println("Account Number: " + accno + "\n" + "Name: "+ name+ "\n" + "Balance: " + balance);
    }

    //method to deposit money
    void deposit() {
        long amt;
        System.out.println("Enter Amount You Want to Deposit : ");
        amt = sc.nextLong();
        balance = balance + amt;
    }

    //method to withdraw money
    void withdrawal() {
        long amt;
        System.out.println("Enter Amount You Want to withdraw : ");
        amt = sc.nextLong();
        if (balance >= amt) {
            balance = balance - amt;
        } else {
            System.out.println("Less Balance..Transaction Failed..");
        }
    }

    //method to search an account number
    boolean search(String acn) {
        if (accno.equals(acn)) {
            showAccount();
            return (true);
        }
        return (false);
    }
    
    
}

public class ExBank {
    public static void main(String arg[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("      WELCOME TO BANK JAVA      ");
        //create initial accounts
        System.out.print("\nHow Many Customer You Want to Input : ");
        int n = sc.nextInt();
        Bank C[] = new Bank[n];
        for (int i = 0; i < C.length; i++) {
            C[i] = new Bank();
            C[i].openAccount();
        }

        //run loop until menu 5 is not pressed
        int ch;
        do {
        	System.out.println("\n=======================");
            System.out.println("       Main Menu       ");
            System.out.println("=======================");
            System.out.println(" 1. Display All\n 2. Search By Account\n 3. Deposit\n 4. Withdrawal\n 5. Exit ");
                System.out.println("Enter Your Choice :"); 
                ch = sc.nextInt();
                System.out.println(); 
                switch (ch) {
                    case 1:
                        for (int i = 0; i < C.length; i++) {
                            C[i].showAccount();
                            System.out.println();
                        }
                        break;

                    case 2:
                        System.out.print("Enter Account No You Want to Search...: ");
                        String acn = sc.next();
                        boolean found = false;
                        for (int i = 0; i < C.length; i++) {
                            found = C[i].search(acn);
                            if (found) {
                                break;
                            }
                        }
                        if (!found) {
                            System.out.println("Search Failed..Account Not Exist..");
                        }
                        break;

                    case 3:
                        System.out.print("Enter Account Number : ");
                        acn = sc.next();
                        found = false;
                        for (int i = 0; i < C.length; i++) {
                            found = C[i].search(acn);
                            if (found) {
                                C[i].deposit();
                                break;
                            }
                        }
                        if (!found) {
                            System.out.println("Search Failed..Account Not Exist..");
                        }
                        break;

                    case 4:
                        System.out.print("Enter Account Number : ");
                        acn = sc.next();
                        found = false;
                        for (int i = 0; i < C.length; i++) {
                            found = C[i].search(acn);
                            if (found) {
                                C[i].withdrawal();
                                break;
                            }
                        }
                        if (!found) {
                            System.out.println("Search Failed..Account Not Exist..");
                        }
                        break;

                    case 5:
                        System.out.println(".....THANKS FOR VISITING.....");
                        break;
                        
                    
                        
                    default:
                    	System.out.println("Invalid Choice!!.Please enter again.");
                    	break;
                }
            }
            while (ch != 5);
        }
    }