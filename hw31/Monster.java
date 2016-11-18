// Team DoReMi (Kenny Chen, Lisa Eng, Yedoh Kang)
// Yedoh Kang
// APCS1 -- pd5
// HW#31 -- Ye Olde Role Playing Game, Improved
// 2016-11-18

// Monster is a subclass of superclass Character
public class Monster extends Character {

    // constructor
    public Monster() {
    	hp = 150;
    	// random num from [20, 65)
    	strength = (int)(Math.random() * 45) + 20;
    	defense = 20;
    	attackRating = 1;
    }
	
    // methods
	
    public String getName() {
    	return "Sully";
    }

}
