
public class CSStudent extends Student {
	public CSStudent (String inputName) {
		super(inputName, 7, 6, 6, 6, 4);
		//name, hp, atk, def, spd, kp
	}
	/**
	 * Checks if character, friend and enemy are alive, that the friend isn't the character and that the character has enough KP
	 * Calculates damage done, and applies it
	 * It also puts the enemy on 0 HP in case it somehow goes below that.
	 * It throws appropriate exceptions if some conditions are not met.
	 * @param friend - the character to which is going to attack with the character
	 * @param enemy - applies the damage done to this character
	 * @throws KPException - exception that occurs when a character tries to use an ability without enough KP
	 * @throws CharacterDeadException - thrown, when the character, their friend or the enemy is dead
	 * @throws SameCharacterException - thrown when the character and their friend are the same character
	 */
	public void pairWorking(Character friend, Character enemy) throws KPException, CharacterDeadException, SameCharacterException {
		if((this.getHP() > 0) && (getKP() == getMaxKP()) && (enemy.getHP() > 0) && (friend.getHP() > 0) && (friend != this)) {
			this.increaseEP(4);
			getAttack();
			friend.getAttack();
			enemy.getDefence();
			int damageDone1 = (int) Math.round((100 * this.getAttack())/(100 + enemy.getDefence()));
			int damageDone2 = (int) Math.round((100 * friend.getAttack())/(100 + enemy.getDefence()));
			enemy.decreaseHP(damageDone1);
			enemy.decreaseHP(damageDone2);
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
		} else if(friend.getHP() <= 0) {
			throw new CharacterDeadException("Friend is Dead");
		} else if(friend == this) {
			throw new SameCharacterException("Character and Friend are the same character");
		}
	}
	/**
	 * Checks if character and friend are alive, that the friend isn't the character and that the character has enough KP
	 * Calculates amount to heal, and applies it
	 * It throws appropriate exceptions if some conditions are not met.
	 * @param friend - character which is going to be healed
	 * @throws KPException - exception that occurs when a character tries to use an ability without enough KP
	 * @throws CharacterDeadException - thrown, when the character, their friend or the enemy is dead
	 * @throws SameCharacterException - thrown when the character and their friend are the same character
	 */
	public void support(Character friend) throws KPException, CharacterDeadException, SameCharacterException {
		if((this.getHP() > 0) && (getKP() == getMaxKP()) && (friend.getHP() > 0) && (friend != this)) {
			this.increaseEP(4);
			getDefence();
			friend.increaseHP(getDefence());
			this.zeroKP();
		} else if (getKP() != getMaxKP()) {
	           throw new KPException("Not enough KP, Character is Dead or Friend is Dead");
		} else if(friend.getHP() <= 0) {
			throw new CharacterDeadException("Friend is Dead");
		} else if(getHP() <= 0) {
			throw new CharacterDeadException("Character is Dead");
		} else if(friend == this) {
			throw new SameCharacterException("Character and Friend are the same character");
		}
	}
}
