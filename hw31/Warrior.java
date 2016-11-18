// Team DoReMi (Kenny Chen, Lisa Eng, Yedoh Kang)
// Yedoh Kang
// APCS1 -- pd5
// HW#31 -- Ye Olde Role Playing Game, Improved
// 2016-11-18

// Warrior is a subclass of superclass Character
public class Warrior extends Character{

	// instance variables
	private String name;

	// constructor
	public Warrior (String newName) {
		name = newName;
		hp = 125;
		strength = 100;
		defense = 40;
		attackRating = 0.4;
	}

	// methods
	
	public String getName() {
		return name;
	}
	
	// prepares the Warrior to perform a special attack
	public void specialize() {
		
		int decreaseDefense = 10; 
		double increaseAttack = .2;

		defense -= decreaseDefense;
		attackRating += increaseAttack;
	}
	
	// prepares the Warrior to perform a normal attack; rests values
	public void normalize() {
		defense = 40;
		attackRating = .4;
	}
}
