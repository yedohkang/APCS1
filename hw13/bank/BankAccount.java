// Team JAY - Jason Lam, Angela Kim, Yedoh Kang
// APCS1 pd5
// HW#13 -- Outsourcing
// 2016-10-06

// Reviewing Team ABC's code (Fabiha, Bayan, Kenny)
// Edited a bit of their code because their code for authenticate did not work.

public class BankAccount{

    // this line just names the class- BankAccount. BankAccount matches the file name as well!!
    // the lines below create the instance variables.
    // all the variables are private and cannot be used outside this class
    // they are specified by their type    

    private String name;
    private int PIN;
    private String password;
    private int acctNumber;
    private double acctBalance;


    // setName through setAcctBalance take a parameter and sets it to the instance variables above.
	// This method sets the name (argument) inputted and binds it to the variable name
    public void setName(String newName){
		name = newName;
    }
    
	// This method allows the user to create a new PIN, only if it is in the interval.
    public void setPIN(int newPIN){
		if (1000 <= newPIN && newPIN <= 9998) {
	   		PIN = newPIN;
		} 
		// newPIN is not between [1000,9998]
		else {
			// set PIN to 9999 and display error
	    	PIN = 9999;
	    	System.out.println("New PIN is not between [1000,9998]");
		}
    }
    
	// This method allows the user to set their password.
    public void setPassword(String newPassword){
		password = newPassword;
    }
    
	// This method allows the user to set a new Account Number, but only if it is in the desired interval.
    public void setAcctNumber(int newAcctNumber){
		if (100000000 <= newAcctNumber && newAcctNumber <= 999999998) {
	    	acctNumber = newAcctNumber;
		} 
		// if newAcctNumber is not between [100000000,999999998]
		else {
			// set acctNumber to 999999999 and display error
	    	acctNumber = 999999999;
	    	System.out.println("New account number is not between [100000000,999999998]");
		}
    }
	
	// This method sets the Account Balance.
    public void setAcctBalance(double newBalance){
		acctBalance = newBalance;
    }
 

    // The method printInfo takes no parameters it just prints name,PIN,password,acctNumber,and acctBalance on different lines
    public void printInfo(){
		System.out.println("Name: " + name);
		System.out.println("PIN: " + PIN);
		System.out.println("Password: " + password);
		System.out.println("Account Number: " + acctNumber);
		System.out.println("Balance: " + acctBalance);
    }

    // This method depositMoney takes the parameter amount which can have decimals and adds it to acctBalance.
    public void depositMoney(double amount){
		acctBalance += amount;
    }

    // This method withdrawMoney takes the parameter amount which can have decimals and subtracts it from acctBalance.
    public boolean withdrawMoney(double amount){
		if (acctBalance >= amount) {
	    	acctBalance -= amount;
	    	return true;
		} 
		// if not enough account balance to withdraw
		else {
	    	System.out.println("Account does not have enough money to withdraw that amount");
	    	return false;
		}
    }
	
	// This method authenticate only returns the account information if the Account number and Password matches.
    public boolean authenticate(int authAcctNumber, String authPassword){
		if (authAcctNumber == acctNumber && authPassword == password) {
			System.out.println("Name: " + name);
			System.out.println("PIN: " + PIN);
			System.out.println("Password: " + password);
			System.out.println("Account Number: " + acctNumber);
			System.out.println("Balance: " + acctBalance);
			return true;
		}
		// if not, an Error message is printed out and false is returned.
		else {
			System.out.println("ERROR: Account Number and Password does not match.");
			return false;
		}
    }

	// This is the main method, where we test everything out.
    public static void main(String[] args){
		 BankAccount test = new BankAccount();
		 test.setName("Someone");
		 test.setPIN(287);
		 test.setPIN(1323);
		 test.setPassword("password");
		 test.setAcctNumber(123456);
		 test.setAcctNumber(123456789);
		 test.setAcctBalance(120.0);
		 test.printInfo();
		 test.depositMoney(300.0);
		 test.withdrawMoney(10.0);
		 test.withdrawMoney(1000000.0);
		 test.authenticate(123456789,"password");
		 test.authenticate(12345658,"password");
    }
}