
public class ElectricalStudent extends Student{
	public ElectricalStudent(String inputName) {
		super(inputName, 9, 5, 4, 8, 5);
		//name, hp, atk, def, spd, kp
	}
	/**
	 *Checks if the player and enemy are alive as well as if the player has enough KP
	 *Then it calculates the damage done, and applies it.
	 *The character also heals himself the amount of damage done
	 *It also puts the enemy on 0 HP in case it somehow goes below that.
	 *It throws appropriate exceptions if some conditions are not met.
	 * @param enemy - applies the damage done to this character
	 * @throws KPException - exception that occurs when a character tries to use an ability without enough KP
	 * @throws CharacterDeadException - thrown, when the character or the enemy is dead
	 */
	public void energyTransfer(Character enemy) throws KPException, CharacterDeadException {
		if((getHP() > 0) && (getKP() == getMaxKP()) && (enemy.getHP() > 0)) {
			getDefence();
			increaseHP(getDefence());
			this.increaseEP(4);
			this.getAttack();
			enemy.getDefence();
			int damageDone = (int) Math.round((100 * getAttack()) / (100 + enemy.getDefence()));
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
		} else if(getHP() <= 0) {
			throw new CharacterDeadException("Character is Dead");
		} else if(enemy.getHP() <= 0) {
			throw new CharacterDeadException("Enemy is Dead");
		}
	}
	/**
	 * Checks if character and friend are alive, that the friend isn't the character and that the character has enough KP
	 * Calculates amount to heal, and applies it to friend
	 * It throws appropriate exceptions if some conditions are not met.
	 * @param friend - character which is going to be healed
	 * @throws KPException - exception that occurs when a character tries to use an ability without enough KP
	 * @throws CharacterDeadException - thrown, when the character, their friend or the enemy is dead
	 * @throws SameCharacterException - thrown when the character and their friend are the same character
	 */
	public void lifeEnergy(Character friend) throws KPException, CharacterDeadException, SameCharacterException {
		if((this.getHP() > 0) && (getKP() == getMaxKP()) && (friend.getHP() > 0) && (friend != this)) {
			this.increaseEP(4);
			friend.increaseHP(friend.getMaxHP());
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
