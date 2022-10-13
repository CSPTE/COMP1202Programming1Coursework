
public class Boss extends Character implements Monster{
	String name;
	int chance;
	public Boss(String inputName) {
		super(inputName, 8, 7, 8, 7);
		//name, hp, atk, def, spd
	}
	/**
	 * Checks if the player and enemy are alive
	 * Creates random number between 1 and 100 and uses one attack based on their likelihood
	 * @param enemy - applies the damage done to this character, or their team
	 * @throws CharacterDeadException - thrown, when the character or the enemy is dead
	 */
    public void strike(Character enemy) throws CharacterDeadException {
    	if((enemy.getHP() > 0) && (getHP() > 0)) {
    		chance = getRandomNumber();
    		if (chance <= 50) {
    			SyntaxError(enemy);
    			System.out.println(this.getName() + " Used Syntax Error on " + enemy.getName());
    		} else if (chance <= 65) {
    			NullPointerException();
    			System.out.println(this.getName() + " Used Null Pointer Exception (heal) ");
    		} else if (chance <= 80) {
    			ArrayIndexOutOfBoundException(enemy);
    			System.out.println(this.getName() + " Used Array Index out of bounds on " + enemy.getName());
    		} else if (chance <= 90) {
    			NoneTermination();
    			System.out.println(this.getName() + " Used None Termination (revive) ");
    		} else {
    			ConcurrentModificationException(enemy.getTeam());
    			System.out.println(this.getName() + " Used Concurrent Modification Exception on enemy team");
    		}
    	}  else if (getHP() <= 0){
    		throw new CharacterDeadException("Character is Dead");
    	} else if(enemy.getHP() <= 0) {
			throw new CharacterDeadException("Enemy is Dead");
    	}
	}
    /**
     * Checks if the player and enemy are alive
     * Then it calculates the damage done, and applies it
     * It also puts the enemy on 0 HP in case it somehow goes below that.
     * It throws appropriate exceptions if some conditions are not met.
     * @param enemy - applies the damage done to this character
	 * @throws CharacterDeadException - thrown, when the character or the enemy is dead
     */
    public void SyntaxError(Character enemy) throws CharacterDeadException {
    	if ((this.getHP() > 0) && (enemy.getHP() > 0)) {
    		increaseEP(3);
    		enemy.increaseEP(3);
    		getAttack();
    		enemy.getDefence();
    		if (enemy instanceof Student) {
				((Student) enemy).increaseKP(3);
			}
    		int damageDone = (int) Math.round((100 * getAttack()) / (100 + enemy.getDefence()));
    		enemy.decreaseHP(damageDone);
    		if (enemy.getHP() <= 0) {
				this.increaseEP(4);
			}
			if (enemy.getHP() < 0) {
				enemy.zeroHP();
			}
    	} else if(getHP() <= 0) {
    		throw new CharacterDeadException("Character is Dead");
    	} else if(enemy.getHP() <= 0) {
			throw new CharacterDeadException("Enemy is Dead");
    	}
	}
    /**
     * Checks if player is alive
     * Calculates amount to heal, and applies it
     * It throws appropriate exceptions if some conditions are not met.
     * @throws CharacterDeadException - thrown, when the character is dead
     */
    public void NullPointerException() throws CharacterDeadException {
    	if (this.getHP() > 0) {
    		increaseEP(3);
    		getDefence();
    		increaseHP(getDefence());
    	} else if(getHP() <= 0) {
    		throw new CharacterDeadException("Character is Dead");
    	}
    }
    /**
     * Checks if character is alive
     * Calculates damage done, and applies it to the enemy
     * It also puts the enemy on 0 HP in case it somehow goes below that.
     * It throws appropriate exceptions if some conditions are not met.
     * @param enemy - applies the damage done to this character
	 * @throws CharacterDeadException - thrown, when the character or the enemy is dead
     */
    public void ArrayIndexOutOfBoundException(Character enemy) throws CharacterDeadException {
    	if ((this.getHP() > 0) && (enemy.getHP() > 0)) {
    		increaseEP(3);
    		enemy.increaseEP(3);
    		getAttack();
    		enemy.getDefence();
    		if (enemy instanceof Student) {
				((Student) enemy).increaseKP(3);
			}
    		int damageDone = (int) Math.round(((100 * getAttack()) / (100 + enemy.getDefence()))*2);
    		enemy.decreaseHP(damageDone);
    		if (enemy.getHP() <= 0) {
				this.increaseEP(4);
			}
			if (enemy.getHP() < 0) {
				enemy.zeroHP();
			}
    	} else if(getHP() <= 0) {
    		throw new CharacterDeadException("Character is Dead");
    	} else if(enemy.getHP() <= 0) {
			throw new CharacterDeadException("Enemy is Dead");
    	}
    }
    /**
     * Checks if character is alive
     * Revives every dead team mate
     * It throws appropriate exceptions if some conditions are not met.
     * @throws CharacterDeadException - thrown, when the character is dead
     */
    public void NoneTermination() throws CharacterDeadException {
    	if (this.getHP() > 0) {
    		increaseEP(3);
    		for (Character friend : getTeam().getMembers()) {
    			if(friend.getHP() <= 0) {
    				friend.increaseHP(1);
    			}
    		}
    	} else if (getHP() <= 0){
    		throw new CharacterDeadException("Character is Dead");
    	}
    }
    /**
     * Checks if character is alive
     * Calculates damage done, and applies it to all enemies
     * It also puts the enemy on 0 HP in case it somehow goes below that.
     * It throws appropriate exceptions if some conditions are not met.
     * @param enemyTeam - applies the damage done to the characters in this team
	 * @throws CharacterDeadException - thrown, when the character is dead
     */
    public void ConcurrentModificationException(Team enemyTeam) throws CharacterDeadException {
    	if (this.getHP() > 0) {
    		increaseEP(3);
    		for (Character enemy : enemyTeam.getMembers()) {
    			enemy.increaseEP(3);
        		getAttack();
        		enemy.getDefence();
        		if (enemy instanceof Student) {
    				((Student) enemy).increaseKP(3);
    			}
        		int damageDone = (int) Math.round((100 * getAttack()) / (100 + enemy.getDefence()));
        		if (enemy.getHP() > 0) {
        			enemy.decreaseHP(damageDone);
        		}
        		if (enemy.getHP() <= 0) {
    				this.increaseEP(4);
    			}
    			if (enemy.getHP() < 0) {
    				enemy.zeroHP();
    			}
    		}
    	} else if (getHP() <= 0){
    		throw new CharacterDeadException("Character is Dead");
    	}
    }
}
