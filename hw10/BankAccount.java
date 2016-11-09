// Team JAY - Jason Lam, Angela Kim, Yedoh Kang
// APCS1 pd5
// HW#10 -- CMYM
// 2016-09-27

public class BankAccount {
	
	// instance variables
	private String fullName;
	private String password;
	private int pin;
	private int accountNumber;
	public float accountBalance;
	

	// set each attribute
	public static String ownerName (String name) {
		String fullName;
		fullName = name;
		return fullName;
	}
	public static String accountPassword (String passwordtext) {
		String password;
		password = passwordtext;
		return password;
	}
	public static int pinNumber (int fourdigit) {
		int pin;
		pin = fourdigit;
		return pin;
	}
	public static int acctNmbr (int ninedigit) {
		int accountNumber;
		accountNumber = ninedigit;
		return accountNumber;
	}
	public static int balance (int total) {
		int accountBalance;
		accountBalance = total;
		return accountBalance;
	}
	// print out all of an account's info at once
	public static void main (String [] args) {
		System.out.println(ownerName(//enter full name in double quotes));
		System.out.println(accountPassword(//enter password in double quotes));
		System.out.println(pinNumber(//enter four digit number));
		System.out.println(acctNmbr(//enter nine digit number));
		System.out.println(balance(//enter integer for account balance));
	}

	// depositing money
	/*
	public static float deposit (float amount) {
		accountBalance = total + amount;
		return accountBalance;
	}
	
	// withdrawing money
	public static float withdrawal (float amount) {
		accountBalance = total - amount;
		return accountBalance;
	}
	
	*/
	
}