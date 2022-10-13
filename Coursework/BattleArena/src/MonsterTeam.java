
public class MonsterTeam extends Team{
	public MonsterTeam(String inputName) {
		super(inputName);
	}
    void move(Character member, Team enemyTeam) throws Exception {
    	if (member.currentHP > 0) {
    		Character target = null;
    		for (Character enemy : enemyTeam.getMembers()) { //select random enemy alive
				if(enemy.currentHP > 0) {
					target = enemy;
				}
			}
    		for (Character enemy2 : enemyTeam.getMembers()) { //find boss or weakest minion alive
				if(enemy2.currentHP > 0) {
					if(enemy2.currentHP < target.currentHP) {
						target = enemy2;
					}
				}
			}
    		if (target.currentHP <= 0) { //enemy is dead exception
				throw new CharacterDeadException("Enemy is Dead");
			}
    		((Monster) member).strike(target);
    		System.out.println(target.getName() + " Current HP " + target.getHP());
    	} else if(member.currentHP <= 0) {
			throw new CharacterDeadException("Character is Dead");
		}
	}
}
