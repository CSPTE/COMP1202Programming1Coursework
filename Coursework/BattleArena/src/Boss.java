
public class Boss extends Character implements Monster{
	String name;
	int chance;
	public Boss(String inputName) {
		super(inputName, 8, 7, 8, 7);
		//name, hp, atk, def, spd
	}
    public void strike(Character enemy) throws CharacterDeadException {
    	if((enemy.currentHP > 0) && (currentHP > 0)) {
    		chance = getRandomNumber();
    		if (chance <= 50) {
    			SyntaxError(enemy);
    			//System.out.println("Syntax Error");
    			System.out.println(this.getName() + " Used Syntax Error on " + enemy.getName());
    		} else if (chance <= 65) {
    			NullPointerException();
    			//System.out.println("Null Pointer Exception");
    			System.out.println(this.getName() + " Used Null Pointer Exception (heal) ");
    		} else if (chance <= 80) {
    			ArrayIndexOutOfBoundException(enemy);
    			System.out.println(this.getName() + " Used Array Index out of bounds on " + enemy.getName());
    			//System.out.println("Array Index Out Of Bound Exception");
    		} else if (chance <= 90) {
    			NoneTermination();
    			System.out.println(this.getName() + " Used None Termination (revive) ");
    			//System.out.println("None Termination");
    		} else {
    			ConcurrentModificationException(enemy.getTeam());
    			System.out.println(this.getName() + " Used Concurrent Modification Exception on enemy team");
    			//System.out.println("Concurrent Modification Exception");
    		}
    	}  else if (currentHP <= 0){
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
    	} else if (currentHP <= 0){
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
			if (enemy.currentHP < 0) {
				enemy.currentHP = 0;
			}
    	} else if (currentHP <= 0){
    		throw new CharacterDeadException("Character is Dead");
    	} else if(enemy.currentHP <= 0) {
			throw new CharacterDeadException("Enemy is Dead");
    	}
    }
    public void NoneTermination() throws CharacterDeadException {
    	if (this.currentHP > 0) {
    		increaseEP(3);
    		for (Character friend : hisTeam.getMembers()) {
    			if(friend.currentHP <= 0) {
    				friend.increaseHP(1);
    			}
    		}
    	} else if (currentHP <= 0){
    		throw new CharacterDeadException("Character is Dead");
    	}
    }
    public void ConcurrentModificationException(Team enemyTeam) throws CharacterDeadException {
    	if (this.currentHP > 0) {
    		increaseEP(3);
    		for (Character enemy : enemyTeam.getMembers()) {
    			enemy.increaseEP(3);
        		getAttack();
        		enemy.getDefence();
        		if (enemy instanceof Student) {
    				((Student) enemy).increaseKP(3);
    			}
        		int damageDone = (int) Math.round((100 * currentAtk) / (100 + enemy.currentDef));
        		if (enemy.currentHP > 0) {
        			enemy.currentHP = enemy.currentHP - damageDone;
        		}
        		if (enemy.currentHP <= 0) {
    				this.increaseEP(4);
    			}
    			if (enemy.currentHP < 0) {
    				enemy.currentHP = 0;
    			}
    		}
    	} else if (currentHP <= 0){
    		throw new CharacterDeadException("Character is Dead");
    	}
    }
}
