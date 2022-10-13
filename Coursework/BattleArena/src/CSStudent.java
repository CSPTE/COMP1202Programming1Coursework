
public class CSStudent extends Student {
	public CSStudent (String inputName) {
		super(inputName, 7, 6, 6, 6, 4);
		//name, hp, atk, def, spd, kp
	}
	public int pairWorking(Character friend, Character enemy) throws KPException, CharacterDeadException, SameCharacterException {
		if((this.currentHP > 0) && (currentKP == maxKP) && (enemy.currentHP > 0) && (friend.currentHP > 0) && (friend != this)) {
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
		} else if(currentKP != maxKP) {
	           throw new KPException("Not enough KP");
		} else if(enemy.currentHP <= 0) {
			throw new CharacterDeadException("Enemy is Dead");
		} else if(currentHP <= 0) {
			throw new CharacterDeadException("Character is Dead");
		} else if(friend.currentHP <= 0) {
			throw new CharacterDeadException("Friend is Dead");
		} else if(friend == this) {
			throw new SameCharacterException("Character and Friend are the same character");
		}
		return enemy.currentHP;
	}
	public void support(Character friend) throws KPException, CharacterDeadException, SameCharacterException {
		if((this.currentHP > 0) && (currentKP == maxKP) && (friend.currentHP > 0) && (friend != this)) {
			this.increaseEP(4);
			getDefence();
			friend.increaseHP(currentDef);
			this.currentKP = 0;
		} else if (currentKP != maxKP) {
	           throw new KPException("Not enough KP, Character is Dead or Friend is Dead");
		} else if(friend.currentHP <= 0) {
			throw new CharacterDeadException("Friend is Dead");
		} else if(currentHP <= 0) {
			throw new CharacterDeadException("Character is Dead");
		} else if(friend == this) {
			throw new SameCharacterException("Character and Friend are the same character");
		}
	}
}
