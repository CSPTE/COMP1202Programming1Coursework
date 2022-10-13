
public class Character {
	String name;
	int baseHP, baseAtk, baseDef, baseSpd;
	int currentHP, currentAtk, currentDef, currentSpd;
	int maxHP;
	//int maxAtk, maxDef, maxSpd;
	int currentEP = 0, nextLevelEP;
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
	protected int getMaxHP() {
		if(level>1) {
			maxHP = (int) Math.round(baseHP*(Math.pow(level, 1.2)));
			return maxHP;
		} else {
			return baseHP;
		}
	}
	protected int getAttack() {
		currentAtk = (int) Math.round(baseAtk*(Math.pow(level, 1.2)));
		return currentAtk;
	}
	protected int getDefence() {
		currentDef = (int) Math.round(baseDef*(Math.pow(level, 1.2)));
		return currentDef;
	}
	protected int getSpeed() {
		currentSpd = (int) Math.round(baseSpd*(Math.pow(level, 1.2)));
		return currentSpd;
	}
	protected int getTargetEP() {
		nextLevelEP = (int) Math.round(10*(Math.pow(level, 1.5)));
		return nextLevelEP;
	}
	public int getHP() {
		return currentHP;
	}
	public int getEP() {
		return currentEP;
	}
	public int increaseHP(int hpIncreaseAmmount) {
		if(currentHP > 0) {
			if ((hpIncreaseAmmount > 0) && (currentHP + hpIncreaseAmmount <= maxHP )){
				currentHP = currentHP + hpIncreaseAmmount;
			} else if ((hpIncreaseAmmount > 0) && (currentHP + hpIncreaseAmmount > maxHP )) {
				currentHP = maxHP;
			}
		}
		return currentHP;
	}
	public int decreaseHP(int hpDecreaseAmmount) {
		if ((currentHP - hpDecreaseAmmount > 0) && (hpDecreaseAmmount > 0 )){
			currentHP = currentHP - hpDecreaseAmmount;
		} else if ((currentHP - hpDecreaseAmmount <= 0) && (hpDecreaseAmmount > 0 )) {
			currentHP = 0;
			System.out.println("You died");
		}
		return currentHP;
	}
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
	public Team setTeam(Team team) {
		/*if(team.members.contains(this)) {
			hisTeam = team;
			return hisTeam;
		} else {
			return null;
		}*/
		team.addMember(this);
		hisTeam = team;
		return hisTeam;
	}
	public Team getTeam() {
		return hisTeam;
	}
}
