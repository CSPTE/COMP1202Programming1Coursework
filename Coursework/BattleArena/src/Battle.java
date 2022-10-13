import java.util.*;
public class Battle {
	Team playerTeam;
	Team enemyTeam;
	//Team allCharacters;
	ArrayList<Character> allCharacters = new ArrayList<Character>();
	Team winningTeam;
	int howManyEnemyDead = 0;
	int howManyPlayerDead = 0;
	public Battle (Team inputPlayerTeam, Team inputEnemyTeam) {
		playerTeam = inputPlayerTeam;
		enemyTeam = inputEnemyTeam;
	}
	public Team fight() {
		//sortTeam(playerTeam);
		//sortTeam(enemyTeam);
		//allCharacters.addAll(playerTeam.members);
		allCharacters.addAll(enemyTeam.members);
		allCharacters.addAll(playerTeam.members);
		sortTeam(allCharacters);
		//System.out.println("");
		for(int i=0; i<30; i++) {
			//System.out.println(i);
			for(Character character : allCharacters) {
				/*for(character.getTeam() == playerTeam) {
					System.out.println(character.name);
				}*/
				//System.out.println(character.name + " HP " + character.currentHP);
				if(character.currentHP > 0) {
					//System.out.println(character.name + " HP " + character.currentHP);
					if(character.getTeam() == playerTeam) {
						int enemiesAlive = 0;
						for (Character chara : enemyTeam.members) {
							if (chara.getHP() > 0) {
								enemiesAlive = enemiesAlive + 1;
							}
						}
						//System.out.println(character.name + " Speed " + character.currentSpd);
						if (enemiesAlive > 0) {
							try {
								character.getTeam().move(character, enemyTeam);
								//System.out.println(character.name + " moved");
							} catch (Exception e) {
								System.out.println("Exception occured: "+e);
							}
						}
						/*try {
							character.getTeam().move(character, enemyTeam);
							//System.out.println(character.name + " moved");
						} catch (Exception e) {
							System.out.println("Exception occured: "+e);
						}*/
					} if(character.getTeam() == enemyTeam) {
						int playersAlive = 0;
						for (Character chara : playerTeam.members) {
							if (chara.getHP() > 0) {
								playersAlive = playersAlive + 1;
							}
						}
						//System.out.println(character.name + " Speed " + character.currentSpd);
						if (playersAlive > 0) {
							try {
								character.getTeam().move(character, playerTeam);
								//System.out.println(character.name + " moved");
							} catch (Exception e) {
								System.out.println("Exception occured: "+e);
							}
						}
						/*try {
							character.getTeam().move(character, playerTeam);
							//System.out.println(character.name + " moved");
						} catch (Exception e) {
							System.out.println("Exception occured: "+e);
						}*/
					}
				}
			}
			System.out.println();
			System.out.println("Round " + (i+1));
			System.out.println("Monster Team");
			for(Character character : enemyTeam.members) {
				if(character.currentHP == 0) {
					System.out.println(character.name + " is dead");
				} else {
					System.out.println(character.name + " has " + character.currentHP + " HP");
				}
			}
			System.out.println();
			System.out.println("Student Team");
			for(Character character : playerTeam.members) {
				if(character.currentHP == 0) {
					System.out.println(character.name + " is dead");
				} else {
					System.out.println(character.name + " has " + character.currentHP + " HP");
				}
			}
			System.out.println();
			for(Character character : enemyTeam.members) {
				if(character.currentHP <= 0) {
					howManyEnemyDead = howManyEnemyDead + 1;
				}
			}
			if(howManyEnemyDead == 5) {
				winningTeam = playerTeam;
				break;
			} else {
				howManyEnemyDead = 0;
			}
			for(Character character : playerTeam.members) {
				if(character.currentHP > 0) {
					howManyPlayerDead = howManyPlayerDead + 1;
				}
			}
			if(howManyPlayerDead <= 0) {
				winningTeam = enemyTeam;
				break;
			} else {
				howManyPlayerDead = 0;
			}
			if(i == 29) { //need to add 1 more condition: if both teams are alive. Goes to end of loop. Maybe make it else if?
				return null;
			}
		}
		System.out.println("The winner is " + winningTeam);
		return winningTeam;
	}
	public void sortTeam(ArrayList<Character> sortThis) {
		//Collections.sort(sortThis);
		Collections.sort(sortThis, new SpeedComparator());
		Collections.reverse(sortThis);
		//System.out.println(sortThis.members);
	}
}