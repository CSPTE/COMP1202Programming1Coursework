
public class CSStudent extends Student {
	public CSStudent (String inputName) {
		super(inputName, 7, 6, 6, 6, 4);
		//name, hp, atk, def, spd, kp
	}
	public int pairWorking(Character friend, Character enemy) throws KPException {
		if((this.currentHP > 0) && (currentKP == maxKP)) {
			this.increaseEP(4);
			getAttack();
			friend.getAttack();
			enemy.getDefence();
			//int damageDone = (int) Math.round((100 * this.currentAtk)/(100 + enemy.currentDef)) + (int) Math.round((100 * friend.currentAtk)/(100 + enemy.currentDef));
			//System.out.println("Damage done = " + damageDone);
			enemy.currentHP =  enemy.currentHP - (int) Math.round((100 * this.currentAtk)/(100 + enemy.currentDef));
			enemy.currentHP = enemy.currentHP - (int) Math.round((100 * friend.currentAtk)/(100 + enemy.currentDef));
			this.currentKP = 0;
			if (enemy.currentHP <= 0) {
				this.increaseEP(4);
			}
			if (enemy.currentHP < 0) {
				enemy.currentHP = 0;
			}
		} else {
	           throw new KPException("Not enough KP or Character is Dead");
		}
		return enemy.currentHP;
	}
	public void support(Character friend) throws KPException {
		if((this.currentHP > 0) && (currentKP == maxKP) && (friend.currentHP > 0)) {
			this.increaseEP(4);
			getDefence();
			friend.increaseHP(currentDef);
			this.currentKP = 0;
		} else {
	           throw new KPException("Not enough KP, Character is Dead or Friend is Dead");
		}
	}
}
