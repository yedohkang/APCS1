// Team DoReMi (Kenny Chen, Lisa Eng, Yedoh Kang)
// Yedoh Kang
// APCS1 -- pd5
// HW#32 -- Ye Olde Role Playing Game, Expanded
// 2016-11-21

public class Character{

	protected static String name;
	protected static int hp; // number of health points
	protected static int strength;
	protected static int defense;
	protected static double attackRating;

	public boolean isAlive() {
		return hp > 0;
	}
    
	public String getName() {
		return name;
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

	// prepares the Warrior to perform a normal attack; rests values
	public void normalize() {
		defense = 40;
		attackRating = .4;
	}

	// prepares the Warrior to perform a special attack
	public void specialize() {
		int decreaseDefense = 10; 
		double increaseAttack = .2;
		defense -= decreaseDefense;
		attackRating += increaseAttack;
	}
    
	public static String about() {
		String output = "Name: " + name + "\nHP: " + hp + "\nStrength: " +
			strength + "\nDefense: " + defense + "\nAttack Rating: " + 
				attackRating;
		return output;
	}
}
