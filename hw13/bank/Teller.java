// Team JAY - Jason Lam, Angela Kim, Yedoh Kang
// APCS1 pd5
// HW#13 -- Outsourcing
// 2016-10-06

// Reviewing Team ABC's code (Fabiha, Bayan, Kenny)

public class Teller {
	
    public static void main(String[] args){
		// creates a new object called test for the class Bank Account
		 BankAccount test = new BankAccount();
		 // sets the name 
		 test.setName("Someone");
		 // sets an incorrect PIN
		 test.setPIN(287);
		 // sets a correct PIN
		 test.setPIN(1323);
		 // sets a password
		 test.setPassword("password");
		 // sets an incorrect Account Number
		 test.setAcctNumber(123456);
		 // sets a correct Account Number
		 test.setAcctNumber(123456789);
		 // sets the Account Balance
		 test.setAcctBalance(120.0);
		 // prints out the info given so far
		 test.printInfo();
		 // deposists this amount of money
		 test.depositMoney(300.0);
		 // withdraws this amount of money
		 test.withdrawMoney(10.0);
		 // withdraws an incorrect amount of money, will return error
		 test.withdrawMoney(1000000.0);
		 // authenticates with correct info, should print out info
		 test.authenticate(123456789,"password");
		 // authenticates with incorrect info, should print out error
		 test.authenticate(12345658,"password");
    }
	
}