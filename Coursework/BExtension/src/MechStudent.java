
public class MechStudent extends Student {
	public MechStudent(String inputName) {
		super(inputName, 6, 10, 6, 8, 2);
		//name, hp, atk, def, spd, kp
	}
	int chance;
	/**
	 * Checks if character is alive and has enough KP
	 * Calculates damage done, and applies it to all characters on the battlefield.
	 * It also puts the enemy on 0 HP in case it somehow goes below that.
	 * It throws appropriate exceptions if some conditions are not met.
	 * @param enemyTeam - the damage will be applied to the members of this team.
	 * @throws KPException - exception that occurs when a character tries to use an ability without enough KP
	 * @throws CharacterDeadException - thrown, when the character is dead
	 */
	public void robotInvasion(Team enemyTeam) throws KPException, CharacterDeadException {
		if((this.getHP() > 0) && (getKP() == getMaxKP())) {
			this.increaseEP(4);
			this.zeroKP();
			for (Character friend : getTeam().getMembers()){
				if((friend.getHP() > 0) && (friend != this)) {
					getAttack();
					friend.getDefence();
					int damageDone = (int) Math.round((100 * getAttack()) / (100 + friend.getDefence()));
					friend.decreaseHP(damageDone);
					if (friend.getHP() <= 0) {
						this.increaseEP(4);
					}
					if (friend.getHP() < 0) {
						friend.zeroHP();
					}
				}
			}
			for (Character enemy : enemyTeam.getMembers()) {
				if(enemy.getHP() > 0) {
					enemy.getDefence();
					getAttack();
					int damageDone = (int) Math.round((100 * getAttack()) / (100 + enemy.getDefence()));
					enemy.decreaseHP(damageDone);
					if (enemy.getHP() <= 0) {
						this.increaseEP(4);
					}
					if (enemy.getHP() < 0) {
						enemy.zeroHP();
					}
				}
	        }
		} else if(getKP() != getMaxKP()) {
	           throw new KPException("Not enough KP or Character is Dead");
		} else if(getHP() <= 0) {
			throw new CharacterDeadException("Character is Dead");
		}
	}
	/**
	 *Checks if the player and enemy are alive as well as if the player has enough KP
	 *Then it calculates the damage done, and applies it
	 *It checks whether the character can move again.
	 *It also puts the enemy on 0 HP in case it somehow goes below that.
	 *It throws appropriate exceptions if some conditions are not met.
	 * @param enemy - applies the damage done to this character
	 * @throws Exception - throws CharacterDeadException and KPException
	 */
	public void automation(Character enemy) throws Exception {
		if((this.getHP() > 0) && (getKP() == getMaxKP()) && (enemy.getHP() > 0)) {
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
			chance = getRandomNumber();
			if (chance <= 50) {
				this.getTeam().move(this, enemy.getTeam());
			}
		} else if(getKP() != getMaxKP()) {
	        throw new KPException("Not enough KP");
		} else if(enemy.getHP() <= 0) {
			throw new CharacterDeadException("Enemy is Dead");
		} else if(getHP() <= 0) {
			throw new CharacterDeadException("Character is Dead");
		}
	}
}
