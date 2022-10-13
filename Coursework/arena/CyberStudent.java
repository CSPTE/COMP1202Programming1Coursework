//import java.util.*;
public class CyberStudent extends Student {
	public CyberStudent (String inputName) {
		super(inputName, 7, 7, 5, 6, 6);
		//name, hp, atk, def, spd, kp
	}
	/**
	 * Checks if character is alive and has enough KP
	 * Calculates damage done, and applies it to all enemies
	 * It also puts the enemy on 0 HP in case it somehow goes below that.
	 * It throws appropriate exceptions if some conditions are not met.
	 * @param enemyTeam - the damage will be applied to the members of this team.
	 * @throws KPException - exception that occurs when a character tries to use an ability without enough KP
	 * @throws CharacterDeadException - thrown, when the character is dead
	 */
	public void cyberAttack(Team enemyTeam) throws KPException, CharacterDeadException {
		if((this.getHP() > 0) && (getKP() == getMaxKP())) {
			this.increaseEP(4);
			this.zeroKP();
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
}
