//import java.util.*;
public class CyberStudent extends Student {
	public CyberStudent (String inputName) {
		super(inputName, 7, 7, 5, 6, 6);
		//name, hp, atk, def, spd, kp
	}
	public void cyberAttack(Team enemyTeam) throws KPException, CharacterDeadException {
		if((this.currentHP > 0) && (currentKP == maxKP)) {
			this.increaseEP(4);
			this.currentKP = 0;
			for (Character enemy : enemyTeam.getMembers()) {
				if(enemy.currentHP > 0) {
					enemy.getDefence();
					getAttack();
					int damageDone = (int) Math.round((100 * currentAtk) / (100 + enemy.currentDef));
					enemy.currentHP = enemy.currentHP - damageDone;
					if (enemy.currentHP <= 0) {
						this.increaseEP(4);
					}
					if (enemy.currentHP < 0) {
						enemy.currentHP = 0;
					}
				}
	        }
		} else if(currentKP != maxKP) {
	           throw new KPException("Not enough KP or Character is Dead");
		} else if(currentHP <= 0) {
			throw new CharacterDeadException("Character is Dead");
		}
	}
}
