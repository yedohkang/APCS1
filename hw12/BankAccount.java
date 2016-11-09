// Team JAY - Jason Lam, Angela Kim, Yedoh Kang
// APCS1 pd5
// HW#12 -- Mo Money Mo Problems
// 2016-10-05

public class BankAccount {
	
	// instance variables
	private String fullName;
	private String password;
	private int pin;
	private int accountNumber;
	private double accountBalance;
	

	// set each inst var's attribute
	// default constructor
	public BankAccount () {
		fullName = "FName LName";
		password = "Password";
		pin = 1000;
		accountNumber = 999999999;
		accountBalance = 0.00;
	}
	
	// overloaded constructor
	public BankAccount (String name, String pwd, int pinNumber, int acctNumber, double acctBalance) {
		fullName = name;
		password = pwd;
		pin = pinNumber;
		accountNumber = acctNumber;
		accountBalance = acctBalance;
	}
	
	// check to see if Account Number is valid
	public void checkacctNumber (int accountNumber) {
		if (accountNumber >= 100000000 && accountNumber <= 999999998) {
		}
		else {
			accountNumber = 999999999;
			System.out.println("Your Account Number was automatically set to 999999999 because it wasn't in between 100000000 and 999999998, inclusive.");
		}
	}
	
	// check to see if PIN is valid
	public void checkPIN (int pin) {
		if (pin > 1000 && pin < 9998) {
		}
		else {
			pin = 9999;
			System.out.println("Your PIN was automatically set to 9999 because it wasn't in between 1000 and 9998.");
		}
	}
	
    // deposit money
    public void deposit (double amount) {
		accountBalance += amount;
    }
	
    // withdraw money
    public void withdraw (double amount) {
		if (amount > accountBalance) {
			accountBalance = accountBalance;
			System.out.println("ERROR: Transaction failed because amount withdrawed is greater than the Account Balance.");
		}
		else {
			accountBalance -= amount;
		}
    }
    
	// authenticate Account Info
	public void checkInfo (int acctNumber, String pwd) {
		if (accountNumber == acctNumber && password == pwd) {
			System.out.println("Full Name: " + fullName);
			System.out.println("Password: " + password);
			System.out.println("PIN: " + pin);
			System.out.println("Account Number: " + accountNumber);
			System.out.println("Account Balance: " + accountBalance);
		}
		else {
			System.out.println ("ERROR: Account Number and/or Password is incorrect. Please try again.");
		}
	}
	
    //show everything
    public static void main (String [] args){
		BankAccount person = new BankAccount("Yedoh Kang", "APCS1", 4892, 152343678, 5.67);
		person.checkacctNumber(152343678);
		person.checkPIN(4892);
		person.deposit(30.47);
		person.withdraw(25.47);
		person.checkInfo(152343678,"APCS1");
    }
}