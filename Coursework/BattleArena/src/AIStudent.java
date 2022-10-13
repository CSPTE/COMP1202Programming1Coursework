
public class AIStudent extends Student {
	public AIStudent (String inputName) {
		super(inputName, 6, 7, 7, 5, 3);
		//name, hp, atk, def, spd, kp
		/*this.name = inputName;
		this.baseHP = 6;
		this.baseAtk = 7;
		this.baseDef = 7;
		this.baseSpd = 5;
		this.maxKP = 3;*/
	}
	public void machineLearning(Character enemy) throws KPException, CharacterDeadException {
		if((this.currentHP > 0) && (currentKP == maxKP) && (enemy.currentHP > 0)) {
			this.increaseEP(4);
			this.getAttack();
			enemy.getDefence();
			int damageDone = (int) Math.round(((100 * currentAtk) / (100 + enemy.currentDef))*2);
			enemy.currentHP = enemy.currentHP - damageDone;
			this.currentKP = 0;
			if (enemy.currentHP <= 0) {
				this.increaseEP(4);
			}
			if (enemy.currentHP < 0) {
				enemy.currentHP = 0;
			}
		} else if(currentKP != maxKP) {
	        throw new KPException("Not enough KP");
		} else if(enemy.currentHP <= 0) {
			throw new CharacterDeadException("Enemy is Dead");
		} else if(currentHP <= 0) {
			throw new CharacterDeadException("Character is Dead");
		}
		//return enemy.currentHP;
	}
	public int naturalLanguageProcessing() throws KPException, CharacterDeadException {
		if((currentHP > 0) && (currentKP == maxKP)) {
			//this.getMaxHP();
			getDefence();
			//System.out.println(baseDef);
			increaseHP(currentDef);
			this.increaseEP(4);
			currentKP = 0;
		} else if(currentKP != maxKP) {
	           throw new KPException("Not enough KP");
		} else if(currentHP <= 0) {
			throw new CharacterDeadException("Character is Dead");
		}
		return currentHP;
	}
}
