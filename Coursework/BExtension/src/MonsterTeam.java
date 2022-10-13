
public class MonsterTeam extends Team{
	public MonsterTeam(String inputName) {
		super(inputName);
	}
	/**
	 * This method will make each character use an ability.
	 * First it selects a random enemy,
	 * Then it selects the weakest enemy by comparing all enemy characters to the randomly selected one
	 * It throws an exception if the selected enemy is somehow dead
	 * The character uses an ability
	 * The program writes out the name and currentHP of the attacked enemy
	 * @param member - the member which uses their ability
	 * @param enemyTeam - the team on which the ability is used
	 * @throws Exception - throws KPException, SameCharacterException or CharacterDeadException
	 */
    void move(Character member, Team enemyTeam) throws Exception {
    	//Checks if character is alive and selects weakest enemy
    	if (member.getHP() > 0) {
    		Character target = null;
    		//Selects a random enemy
    		for (Character enemy : enemyTeam.getMembers()) { 
				if(enemy.getHP() > 0) {
					target = enemy;
				}
			}
    		//Finds the weakest enemy
    		for (Character enemy2 : enemyTeam.getMembers()) {
				if(enemy2.getHP() > 0) {
					if(enemy2.getHP() < target.getHP()) {
						target = enemy2;
					}
				}
			}
    		//Throws exception if target is somehow dead
    		if (target.getHP() <= 0) { 
				throw new CharacterDeadException("Enemy is Dead");
			}
    		//Strikes and writes enemy that was attacked + their HP
    		((Monster) member).strike(target);
    		System.out.println(target.getName() + " Current HP " + target.getHP());
    	} else if(member.getHP() <= 0) {
			throw new CharacterDeadException("Character is Dead");
		}
	}
}
