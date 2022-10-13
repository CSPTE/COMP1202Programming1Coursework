
public class BEStudent extends Student{
	public BEStudent(String inputName) {
		super(inputName, 8, 2, 6, 4, 8);
		//name, hp, atk, def, spd, kp
	}
	/**
	 * Checks if character is alive.
     * Revives every dead team mate.
     * It throws appropriate exceptions if some conditions are not met.
	 * @throws KPException - exception that occurs when a character tries to use an ability without enough KP
	 * @throws CharacterDeadException - thrown, when the character or the enemy is dead
	 */
	public void secondChance() throws KPException, CharacterDeadException {
		if((getHP() > 0) && (getKP() == getMaxKP())) {
			this.increaseEP(4);
			for (Character friend : getTeam().getMembers()) {
    			if(friend.getHP() <= 0) {
    				friend.increaseHP(1);
    			}
    		}
			zeroKP();
		} else if(getKP() != getMaxKP()) {
	           throw new KPException("Not enough KP");
		} else if(getHP() <= 0) {
			throw new CharacterDeadException("Character is Dead");
		}
	}
	/**
	 * Checks if character is alive.
	 * Calculates amount to heal, and applies it to himself.
	 * It throws appropriate exceptions if some conditions are not met.
	 * @param friend - character which is going to be healed
	 * @throws KPException - exception that occurs when a character tries to use an ability without enough KP
	 * @throws CharacterDeadException - thrown, when the character or the enemy is dead
	 */
	public void doubleHeal() throws KPException, CharacterDeadException {
		if((this.getHP() > 0) && (getKP() == getMaxKP())) {
			this.increaseEP(4);
			getDefence();
			this.increaseHP(getMaxHP());
			this.zeroKP();
		} else if (getKP() != getMaxKP()) {
	           throw new KPException("Not enough KP, Character is Dead or Friend is Dead");
		} else if(getHP() <= 0) {
			throw new CharacterDeadException("Character is Dead");
		}
	}
}
