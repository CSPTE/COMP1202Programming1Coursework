
public class SEStudent extends Student {
	public SEStudent (String inputName) {
		super(inputName, 8, 5, 8, 4, 10);
		//name, hp, atk, def, spd, kp
	}
	/**
	 * Checks if the character and enemy are alive as well as if the player has enough KP
	 * Then it calculates the damage done for each team mate alive, and applies it.
	 * It also puts the enemy on 0 HP in case it somehow goes below that.
	 * It throws appropriate exceptions if some conditions are not met.
	 * @param enemy - applies the damage done to this character
	 * @throws KPException - exception that occurs when a character tries to use an ability without enough KP
	 * @throws CharacterDeadException - thrown, when the character, their friend or the enemy is dead
	 */
	public void groupWork(Character enemy) throws KPException, CharacterDeadException {
		if((this.getHP() > 0) && (getKP() == getMaxKP()) && (enemy.getHP() > 0)) { 
			this.increaseEP(4);
			for (Character friend : getTeam().getMembers()){
				if(friend.getHP() > 0) {
					friend.getAttack();
					enemy.getDefence();
					int damageDone = (int) Math.round(((100 * friend.getAttack())/(100 + enemy.getDefence())));
					enemy.decreaseHP(damageDone);
				}
	        }
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
	 * Checks if player and team mates are alive and has enough KP
	 * Calculates amount to heal, and applies it
	 * It throws appropriate exceptions if some conditions are not met.
	 * @throws KPException - exception that occurs when a character tries to use an ability without enough KP
	 * @throws CharacterDeadException - thrown, when the character, their friend or the enemy is dead
	 */
	public void groupDiscussion() throws KPException, CharacterDeadException {
		if((this.getHP() > 0) && (getKP() == getMaxKP())) {
			this.increaseEP(4);
			for (Character friend : getTeam().getMembers()){
				if(friend.getHP() > 0) {
					getDefence();
					friend.increaseHP((getDefence()/2));
				}
			}
			this.zeroKP();
		} else if(getKP() != getMaxKP()) {
	        throw new KPException("Not enough KP");
		} else if(getHP() <= 0) {
			throw new CharacterDeadException("Character is Dead");
		}
	}
}
