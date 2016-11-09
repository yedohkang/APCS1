// Team JAY - Jason Lam, Angela Kim, Yedoh Kang
// APCS1 pd5
// HW#11 -- Iterative Improvement
// 2016-09-29

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
		fullName = "Name goes here";
		password = "apcs1";
		pin = 1234;
		accountNumber = 123456789;
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
	
	// print out all of an account's info at once
	public void accountInfo () {
		System.out.print("Full Name: ");
		System.out.println(fullName);
		System.out.print("Password: ");
		System.out.println(password);
		System.out.print("PIN: ");
		System.out.println(pin);
		System.out.print("Account Number: ");
		System.out.println(accountNumber);
		System.out.print("Account Balance: ");
		System.out.println(accountBalance);
	}
	
    //deposit money
    public void deposit (float amount) {
		accountBalance += amount;
    }
	
    //withdraw money
    public void withdraw (float amount) {
		accountBalance -= amount;
    }
    
    //show everything
    public static void main (String [] args){
		BankAccount person = new BankAccount("John Smith", "ihatemyname", 4892, 152343678, 5.67f);
		person.deposit(30.47f);
		person.withdraw(10.47f);
		person.accountInfo();
    }
}