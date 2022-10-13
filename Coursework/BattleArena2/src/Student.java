
public class Student extends Character {
	int maxKP;
	int currentKP = 0;
	public Student(String inputName, int inputBaseHP, int inputBaseAtk, int inputBaseDef, int inputBaseSpd, int inputMaxKP) {
		super(inputName, inputBaseHP, inputBaseAtk, inputBaseDef, inputBaseSpd);
		maxKP = inputMaxKP;
	}
	/**
	 * Makes sure the currentKP is not greater than MaxMax, and then increases KP
	 * @param kpIncreaseAmmount - the amount by which the currentKP is increased
	 * @return - the current KP
	 */
	public int increaseKP(int kpIncreaseAmmount) {
		if ((kpIncreaseAmmount > 0) && (currentKP + kpIncreaseAmmount <= maxKP )) {
			currentKP = currentKP + kpIncreaseAmmount;
		} else if ((kpIncreaseAmmount > 0) && (currentKP + kpIncreaseAmmount > maxKP )) {
			currentKP = maxKP;
		}
		return currentKP;
	}
	/**
	 * Checks if the player and enemy are alive
	 * Then it calculates the damage done, and applies it
	 * It also puts the enemy on 0 HP in case it somehow goes below that.
	 * @param enemy - applies the damage done to this character
	 */
	public void javaProgramming(Character enemy) {
		if ((this.getHP() > 0) && (enemy.getHP() > 0)) {
			this.increaseEP(3);
			this.increaseKP(1);
			getAttack();
			enemy.getDefence();
			int damageDone = (int) Math.round((100 * getAttack()) / (100 + enemy.getDefence()));
			enemy.decreaseHP(damageDone);
			if (enemy instanceof Student) {
				((Student) enemy).increaseKP(3);
			}
			if (enemy.getHP() <= 0) {
				this.increaseEP(4);
			} else if (enemy.getHP() > 0) {
				enemy.increaseEP(2);
			}
			if (enemy.getHP() < 0) {
				enemy.zeroHP();
			}
		}
	}
	/**
	 * Checks if player is alive, and increases what is necessary
	 */
	public void selfStudy() {
		if (getHP() > 0) {
			increaseHP(2);
			increaseEP(6);
			increaseKP(2);
		}
	}
	public int getKP() {
		return currentKP;
	}
	public int getMaxKP() {
		return maxKP;
	}
	/**
	 * Sets KP to 0
	 */
	public void zeroKP() {
		currentKP = 0;
	}
}

