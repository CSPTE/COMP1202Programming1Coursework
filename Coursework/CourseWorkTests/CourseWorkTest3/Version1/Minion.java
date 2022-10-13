
public class Minion extends Character implements Monster{
	String name;
	int chance;
	public Minion(String inputName) {
		super(inputName, 5, 5, 5, 5);
	}
	public void strike(Character enemy) {
		chance = getRandomNumber();
		if (chance <= 75) {
			SyntaxError(enemy);
		} else if (chance <= 90) {
			NullPointerException();
		} else {
			ArrayIndexOutOfBoundException(enemy);
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
}
