// Yedoh Kang
// APCS1 -- pd5
// HW#07 -- On BigSib Individuality and the Elimination of Radio Fuzz
// 2016-09-23

public class BigSib {
	
	// instance variable
	private String helloMsg;
	
	// methods
	public String setHelloMsg (String newMsg){
		helloMsg = "";
		helloMsg += newMsg;
		return helloMsg;
	}
	public String greet (String name){
		helloMsg += " ";
		helloMsg += name;
		return helloMsg;
		
	}
}