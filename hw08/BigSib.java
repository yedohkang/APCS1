// Yedoh Kang
// APCS1 -- period5
// HW#08 -- On the Origins of a Big Sib
// 2016-9-26

public class BigSib {
	
	// instance variable
	private String helloMsg;
	
	// constructors
	public BigSib () {
		System.out.println("Hey, nice to meet ya!");
	}
	public BigSib (String newMsg) {
		helloMsg = "";
		helloMsg += newMsg;
	}
	
	// method
	public String greet (String name) {
		helloMsg += " ";
		helloMsg += name;
		return helloMsg;
	}
	
}