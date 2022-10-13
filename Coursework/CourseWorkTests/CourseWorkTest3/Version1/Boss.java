
public class Boss extends Character implements Monster{
	String name;
	int chance;
	public Boss(String inputName) {
		super(inputName, 8, 7, 8, 7);
	}
    public void strike(Character enemy) {
    	chance = getRandomNumber();
		if (chance <= 50) {
			SyntaxError(enemy);
		} else if (chance <= 65) {
			NullPointerException();
		} else if (chance <= 80) {
			ArrayIndexOutOfBoundException(enemy);
		} else if (chance <= 90) {
			NoneTermination();
		} else {
			ConcurrentModificationException(enemy.getTeam());
		}
	}
    public void SyntaxError(Character enemy) {
    	if (this.currentHP > 0) {
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
    	}
	}
    public void NullPointerException() {
    	if (this.currentHP > 0) {
    		increaseEP(3);
    		getDefence();
    		increaseHP(currentDef);
    	}
    }
    public void ArrayIndexOutOfBoundException(Character enemy) {
    	if (this.currentHP > 0) {
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
    	}
    }
    public void NoneTermination() {
    	if (this.currentHP > 0) {
    		increaseEP(3);
    		for (Character friend : hisTeam.getMembers()) {
    			if(friend.currentHP <= 0) {
    				friend.increaseHP(1);
    			}
    		}
    	}
    }
    public void ConcurrentModificationException(Team enemyTeam) {
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
    	}
    }
}
