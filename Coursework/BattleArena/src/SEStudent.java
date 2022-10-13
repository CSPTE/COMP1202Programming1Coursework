
public class SEStudent extends Student {
	public SEStudent (String inputName) {
		super(inputName, 8, 5, 8, 4, 10);
		//name, hp, atk, def, spd, kp
	}
	public int groupWork(Character enemy) throws KPException, CharacterDeadException {
		if((this.currentHP > 0) && (currentKP == maxKP) && (enemy.currentHP > 0)) { 
			this.increaseEP(4);
			for (Character friend : hisTeam.getMembers()){
				if(friend.currentHP > 0) {
					friend.getAttack();
					enemy.getDefence();
					enemy.currentHP = enemy.currentHP - (int) Math.round(((100 * friend.currentAtk)/(100 + enemy.currentDef)));
				}
	        }
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
		return enemy.currentHP;
	}
	public void groupDiscussion() throws KPException, CharacterDeadException {
		if((this.currentHP > 0) && (currentKP == maxKP)) {
			this.increaseEP(4);
			for (Character friend : hisTeam.getMembers()){
				//System.out.println(friend);
				if(friend.getHP() > 0) {
					getDefence();
					friend.increaseHP(currentDef/2);
					//return friend.currentHP;
				}
			}
			this.currentKP = 0;
		} else if(currentKP != maxKP) {
	        throw new KPException("Not enough KP");
		} else if(currentHP <= 0) {
			throw new CharacterDeadException("Character is Dead");
		}
	}
}
