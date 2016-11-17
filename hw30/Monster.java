// Team DoReMi (Kenny Chen, Lisa Eng, Yedoh Kang)
// Yedoh Kang
// APCS1 -- pd5
// HW#30 -- Ye Olde Role Playing Game . . .
// 2016-11-17

public class Monster {
	
	// instance variables
	
	private int hp; // health points
	private int strength;
	private int defense;
	private double attackRating;

	// constructor
	public Monster() {
    	hp = 150;
    	// random num from [20, 65)
    	strength = (int)(Math.random() * 45) + 20;
    	defense = 20;
    	attackRating = 1;
	}
	
	// methods
	
	public boolean isAlive() {
    	return hp > 0;
	}
	
	public int getDefense() {
    	return defense;
	}
	
	public String getName() {
    	return "Sully";
	}
	
	public void lowerHP (int amount) {
    	hp -= amount;
	}
	
	// attacks and calculates damage
	public int attack (Warrior warrior) {
    	int damage = (int)(strength * attackRating) - warrior.getDefense();
    	warrior.lowerHP(damage);
    	return damage;
	}
}
