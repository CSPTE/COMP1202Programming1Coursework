
public class Minion extends Character implements Monster{
	String name;
	int chance;
	public Minion(String inputName) {
		super(inputName, 5, 5, 5, 5);
		//name, hp, atk, def, spd
	}
	/**
	 * Checks if the player and enemy are alive
	 * Creates random number between 1 and 100 and uses one attack based on their likelihood
	 * @param enemy - applies the damage done to this character, or their team
	 * @throws CharacterDeadException - thrown, when the character or the enemy is dead
	 */
	public void strike(Character enemy) throws CharacterDeadException {
		if((enemy.getHP() > 0) && (getHP() > 0)) {
			chance = getRandomNumber();
			if (chance <= 75) {
				SyntaxError(enemy);
				System.out.println(this.getName() + " Used Syntax Error on " + enemy.getName());
			} else if (chance <= 90) {
				NullPointerException();
				System.out.println(this.getName() + " Used Null Pointer Exception (heal) ");
			} else {
				ArrayIndexOutOfBoundException(enemy);
				System.out.println(this.getName() + " Used Array Index out of bounds on " + enemy.getName());
			}
		} else if (getHP() <= 0){
    		throw new CharacterDeadException("Character is Dead");
    	} else if(enemy.getHP() <= 0) {
			throw new CharacterDeadException("Enemy is Dead");
    	}
	}
	/**
     * Checks if the player and enemy are alive
     * Then it calculates the damage done, and applies it
     * It also puts the enemy on 0 HP in case it somehow goes below that.
     * It throws appropriate exceptions if some conditions are not met.
     * @param enemy - applies the damage done to this character
	 * @throws CharacterDeadException - thrown, when the character or the enemy is dead
     */
    public void SyntaxError(Character enemy) throws CharacterDeadException {
    	if ((this.getHP() > 0) && (enemy.getHP() > 0)) {
    		increaseEP(3);
    		enemy.increaseEP(3);
    		getAttack();
    		enemy.getDefence();
    		if (enemy instanceof Student) {
				((Student) enemy).increaseKP(3);
			}
    		int damageDone = (int) Math.round((100 * getAttack()) / (100 + enemy.getDefence()));
    		enemy.decreaseHP(damageDone);
    		if (enemy.getHP() <= 0) {
				this.increaseEP(4);
			}
			if (enemy.getHP() < 0) {
				enemy.zeroHP();
			}
    	} else if(getHP() <= 0) {
    		throw new CharacterDeadException("Character is Dead");
    	} else if(enemy.getHP() <= 0) {
			throw new CharacterDeadException("Enemy is Dead");
    	}
	}
    /**
     * Checks if player is alive
     * Calculates amount to heal, and applies it
     * It throws appropriate exceptions if some conditions are not met.
     * @throws CharacterDeadException - thrown, when the character is dead
     */
    public void NullPointerException() throws CharacterDeadException {
    	if (this.getHP() > 0) {
    		increaseEP(3);
    		getDefence();
    		increaseHP(getDefence());
    	} else if(getHP() <= 0) {
    		throw new CharacterDeadException("Character is Dead");
    	}
    }
    /**
     * Checks if character is alive
     * Calculates damage done, and applies it to the enemy
     * It also puts the enemy on 0 HP in case it somehow goes below that.
     * It throws appropriate exceptions if some conditions are not met.
     * @param enemy - applies the damage done to this character
	 * @throws CharacterDeadException - thrown, when the character or the enemy is dead
     */
    public void ArrayIndexOutOfBoundException(Character enemy) throws CharacterDeadException {
    	if ((this.getHP() > 0) && (enemy.getHP() > 0)) {
    		increaseEP(3);
    		enemy.increaseEP(3);
    		getAttack();
    		enemy.getDefence();
    		if (enemy instanceof Student) {
				((Student) enemy).increaseKP(3);
			}
    		int damageDone = (int) Math.round(((100 * getAttack()) / (100 + enemy.getDefence()))*2);
    		enemy.decreaseHP(damageDone);
    		if (enemy.getHP() <= 0) {
				this.increaseEP(4);
			}
			if (enemy.getHP() < 0) {
				enemy.zeroHP();
			}
    	} else if(getHP() <= 0) {
    		throw new CharacterDeadException("Character is Dead");
    	} else if(enemy.getHP() <= 0) {
			throw new CharacterDeadException("Enemy is Dead");
    	}
    }
}
