
public class AIStudent extends Student {
	public AIStudent (String inputName) {
		super(inputName, 6, 7, 7, 5, 3);
		//name, hp, atk, def, spd, kp
	}
	/**
	 *Checks if the player and enemy are alive as well as if the player has enough KP
	 *Then it calculates the damage done, and applies it
	 *It also puts the enemy on 0 HP in case it somehow goes below that.
	 *It throws appropriate exceptions if some conditions are not met.
	 * @param enemy - applies the damage done to this character
	 * @throws KPException - exception that occurs when a character tries to use an ability without enough KP
	 * @throws CharacterDeadException - thrown, when the character or the enemy is dead
	 */
	public void machineLearning(Character enemy) throws KPException, CharacterDeadException {
		if((this.getHP() > 0) && (getKP() == getMaxKP()) && (enemy.getHP() > 0)) {
			this.increaseEP(4);
			this.getAttack();
			enemy.getDefence();
			int damageDone = (int) Math.round(((100 * getAttack()) / (100 + enemy.getDefence()))*2);
			enemy.decreaseHP(damageDone);
			this.zeroKP();
			if (enemy.getHP() <= 0) {
				this.increaseEP(4);
			}
			if (enemy.getHP() < 0) {
				enemy.zeroHP();
			}
		} else if(getKP() != getMaxKP()) {
	        throw new KPException("Not enough KP");
		} else if(enemy.getHP() <= 0) {
			throw new CharacterDeadException("Enemy is Dead");
		} else if(getHP() <= 0) {
			throw new CharacterDeadException("Character is Dead");
		}
	}
	/**
	 * Checks if player is alive and has enough KP
	 * Calculates amount to heal, and applies it
	 * It throws appropriate exceptions if some conditions are not met.
	 * @throws KPException - exception that occurs when a character tries to use an ability without enough KP
	 * @throws CharacterDeadException - thrown, when the character is dead
	 */
	public void naturalLanguageProcessing() throws KPException, CharacterDeadException {
		if((getHP() > 0) && (getKP() == getMaxKP())) {
			getDefence();
			increaseHP(getDefence());
			this.increaseEP(4);
			zeroKP();
		} else if(getKP() != getMaxKP()) {
	           throw new KPException("Not enough KP");
		} else if(getHP() <= 0) {
			throw new CharacterDeadException("Character is Dead");
		}
	}
}

