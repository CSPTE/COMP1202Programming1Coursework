
public class Character {
	String name;
	int baseHP, baseAtk, baseDef, baseSpd;
	int currentHP, currentAtk, currentDef, currentSpd;
	int maxHP;
	int currentEP, nextLevelEP;
	int level = 1;
	Team hisTeam;
	public Character (String inputName, int inputBaseHP, int inputBaseAtk, int inputBaseDef, int inputBaseSpd) {
		name = inputName;
		baseHP = inputBaseHP;
		baseAtk = inputBaseAtk;
		baseDef = inputBaseDef;
		baseSpd = inputBaseSpd;
		currentHP = baseHP;
		maxHP = baseHP;
	}
	public String getName() {
		return name;
	}
	/**
	 * Calculates max HP, unless it is level one in which case baseHP
	 * @return - the maxHP
	 */
	public int getMaxHP() {
		if(level>1) {
			maxHP = (int) Math.round(baseHP*(Math.pow(level, 1.2)));
			return maxHP;
		} else {
			return baseHP;
		}
	}
	/**
	 * Calculates Attack
	 * @return - the currentAttack
	 */
	public int getAttack() {
		currentAtk = (int) Math.round(baseAtk*(Math.pow(level, 1.2)));
		return currentAtk;
	}
	/**
	 * Calculates Defence
	 * @return - the currentDefence
	 */
	public int getDefence() {
		currentDef = (int) Math.round(baseDef*(Math.pow(level, 1.2)));
		return currentDef;
	}
	/**
	 * Calculates Speed
	 * @return - the currentSpeed
	 */
	public int getSpeed() {
		currentSpd = (int) Math.round(baseSpd*(Math.pow(level, 1.2)));
		return currentSpd;
	}
	/**
	 * Calculates EP required for next level
	 * @return - the EP required for next level
	 */
	public int getTargetEP() {
		nextLevelEP = (int) Math.round(10*(Math.pow(level, 1.5)));
		return nextLevelEP;
	}
	public int getHP() {
		return currentHP;
	}
	public int getEP() {
		return currentEP;
	}
	/**
	 * Makes sure the currentHP is not greater than MaxHP, and heals character
	 * @param hpIncreaseAmmount - the amount by which the currentHP is increased
	 * @return - the currentHP
	 */
	public int increaseHP(int hpIncreaseAmmount) {
		//if(currentHP > 0) {
			if ((hpIncreaseAmmount > 0) && (currentHP + hpIncreaseAmmount <= maxHP )){
				currentHP = currentHP + hpIncreaseAmmount;
			} else if ((hpIncreaseAmmount > 0) && (currentHP + hpIncreaseAmmount > maxHP )) {
				currentHP = maxHP;
			}
		//}
		return currentHP;
	}
	/**
	 * Makes sure, characters HP does not drop below 0, and decreases health
	 * @param hpDecreaseAmmount - the amount by which the currentHP is decreased
	 * @return - the currentHP
	 */
	public int decreaseHP(int hpDecreaseAmmount) {
		if ((currentHP - hpDecreaseAmmount > 0) && (hpDecreaseAmmount > 0 )){
			currentHP = currentHP - hpDecreaseAmmount;
		} else if ((currentHP - hpDecreaseAmmount <= 0) && (hpDecreaseAmmount > 0 )) {
			currentHP = 0;
		}
		return currentHP;
	}
	/**
	 * Increases the characters EP, and levels up if target EP reached
	 * @param epIncreaseAmmount - the amount by which the currentEP is increased
	 * @return - the currentEP
	 */
	public int increaseEP(int epIncreaseAmmount) {
		getTargetEP();
		if(currentEP + epIncreaseAmmount < nextLevelEP) {
			currentEP = currentEP + epIncreaseAmmount;
		} else {
			level = level + 1;
			currentEP = 0;
			getTargetEP();
			getMaxHP();
			getAttack();
			getDefence();
			getSpeed();
			currentHP = maxHP;
		}
		return currentEP;
	}
	/**
	 * Sets the characters Team
	 * @param team - the team to which we want to add the character
	 * @return - the Team of the character
	 */
	public Team setTeam(Team team) {
		team.addMember(this);
		hisTeam = team;
		return hisTeam;
	}
	public Team getTeam() {
		return hisTeam;
	}
	/**
	 * Random number generator, between 1 and 100 - used for percentage calculator
	 * @return - a random number between 1 and 100
	 */
	public int getRandomNumber() {
		int min = 1;
		int max = 100;
		int b = (int)(Math.random()*(max-min+1)+min);  
		return b;  
	}
	/**
	 * Sets currentHP to 0
	 */
	public void zeroHP() {
		currentHP = 0;
	}
}
