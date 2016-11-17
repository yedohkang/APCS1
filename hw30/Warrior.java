// Team DoReMi (Kenny Chen, Lisa Eng, Yedoh Kang)
// Yedoh Kang
// APCS1 -- pd5
// HW#30 -- Ye Olde Role Playing Game . . .
// 2016-11-17

public class Warrior {

	// instance variables
	
	private String name;
	private int hp; // number of health points
	private int strength;
	private int defense;
	private double attackRating;

	// constructor
	public Warrior (String newName) {
    	name = newName;
    	hp = 125;
    	strength = 100;
    	defense = 40;
    	attackRating = 0.4;
	}

	// methods
	
	public boolean isAlive() {
    	return hp > 0;
	}
	
	public int getDefense() {
    	return defense;
	}
	
	public String getName() {
    	return name;
	}
	
	public void lowerHP (int amount) {
    	hp -= amount;
	}
	
	// attacks and calculates damage
	public int attack (Monster monster) {
    	int damage = (int)(strength * attackRating) - monster.getDefense();
    	monster.lowerHP(damage);
    	return damage;
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
