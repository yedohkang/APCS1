// Team DoReMi (Kenny Chen, Lisa Eng, Yedoh Kang)
// Yedoh Kang
// APCS1 -- pd5
// HW#31 -- Ye Olde Role Playing Game, Improved
// 2016-11-18

// Character is a superclass
public class Character {

	// instance variables
	protected int hp; // number of health points
	protected int strength;
	protected int defense;
	protected double attackRating;

	// methods
	
	public boolean isAlive() {
		return hp > 0;
	}
	
	public int getDefense() {
		return defense;
	}

	public void lowerHP (int amount) {
		hp -= amount;
	}
	
	// attacks and calculates damage
	public int attack (Character character) {
		int damage = (int)(strength * attackRating) - character.getDefense();
		if (damage < 0) {
			damage = 0;
		}
		character.lowerHP(damage);
		return damage;
	}
}
