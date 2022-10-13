
public class Minion extends Character implements Monster{
	String name;
	int chance;
	public Minion(String inputName) {
		super(inputName, 5, 5, 5, 5);
		//name, hp, atk, def, spd
	}
	public void strike(Character enemy) throws CharacterDeadException {
		if((enemy.currentHP > 0) && (currentHP > 0)) {
			chance = getRandomNumber();
			//System.out.println(chance);
			if (chance <= 75) {
				SyntaxError(enemy);
				System.out.println(this.getName() + " Used Syntax Error on " + enemy.getName());
			} else if (chance <= 90) {
				NullPointerException();
				System.out.println(this.getName() + " Used Null Pointer Exception (heal) ");
			} else {
				ArrayIndexOutOfBoundException(enemy);
				System.out.println(this.getName() + " Used Array Index out of bounds on " + enemy.getName());
			}
		} else if (currentHP <= 0){
    		throw new CharacterDeadException("Character is Dead");
    	} else if(enemy.currentHP <= 0) {
			throw new CharacterDeadException("Enemy is Dead");
    	}
	}
    public void SyntaxError(Character enemy) throws CharacterDeadException {
    	if ((this.currentHP > 0) && (enemy.currentHP > 0)) {
    		increaseEP(3);
    		enemy.increaseEP(3);
    		getAttack();
    		enemy.getDefence();
    		if (enemy instanceof Student) {
				((Student) enemy).increaseKP(3);
			}
    		int damageDone = (int) Math.round((100 * currentAtk) / (100 + enemy.currentDef));
    		enemy.currentHP = enemy.currentHP - damageDone;
    		if (enemy.currentHP <= 0) {
				this.increaseEP(4);
			}
			if (enemy.currentHP < 0) {
				enemy.currentHP = 0;
			}
    	} else if(currentHP <= 0) {
    		throw new CharacterDeadException("Character is Dead");
    	} else if(enemy.currentHP <= 0) {
			throw new CharacterDeadException("Enemy is Dead");
    	}
	}
    public void NullPointerException() throws CharacterDeadException {
    	if (this.currentHP > 0) {
    		increaseEP(3);
    		getDefence();
    		increaseHP(currentDef);
    	} else if(currentHP <= 0) {
    		throw new CharacterDeadException("Character is Dead");
    	}
    }
    public void ArrayIndexOutOfBoundException(Character enemy) throws CharacterDeadException {
    	if ((this.currentHP > 0) && (enemy.currentHP > 0)) {
    		increaseEP(3);
    		enemy.increaseEP(3);
    		getAttack();
    		enemy.getDefence();
    		if (enemy instanceof Student) {
				((Student) enemy).increaseKP(3);
			}
    		int damageDone = (int) Math.round(((100 * currentAtk) / (100 + enemy.currentDef))*2);
    		enemy.currentHP = enemy.currentHP - damageDone;
    		if (enemy.currentHP <= 0) {
				this.increaseEP(4);
			}
    		//System.out.println(enemy.currentHP);
			if (enemy.currentHP < 0) {
				enemy.currentHP = 0;
			}
    	} else if(currentHP <= 0) {
    		throw new CharacterDeadException("Character is Dead");
    	} else if(enemy.currentHP <= 0) {
			throw new CharacterDeadException("Enemy is Dead");
    	}
    }
}
