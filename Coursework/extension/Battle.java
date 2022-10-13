import java.util.*;
public class Battle {
	Team playerTeam;
	Team enemyTeam;
	ArrayList<Character> allCharacters = new ArrayList<Character>();
	Team winningTeam;
	int howManyEnemyDead = 0;
	int howManyPlayerDead = 0;
	public Battle (Team inputPlayerTeam, Team inputEnemyTeam) {
		playerTeam = inputPlayerTeam;
		enemyTeam = inputEnemyTeam;
	}
	/**
	 * Creates a battle between two teams, a student and a monster team
	 * The battle ends if one team is defeated
	 * If no team is defeated in 30 rounds it is a draw
	 * @return - the winning team
	 */
	public Team fight() {
		allCharacters.addAll(enemyTeam.returnMembers());
		allCharacters.addAll(playerTeam.returnMembers());
		sortTeam(allCharacters);
		for(int i=0; i<30; i++) {
			for(Character character : allCharacters) {
				if(character.getHP() > 0) {
					if(character.getTeam() == playerTeam) {
						studentMove(character);
					} if(character.getTeam() == enemyTeam) {
						monsterMove(character);
					}
				}
			}
			charactersHP(i);
			enemiesDead();
			if(howManyEnemyDead == 5) {
				winningTeam = playerTeam;
				break;
			} else {
				howManyEnemyDead = 0;
			}
			studentsDead();
			if(howManyPlayerDead <= 0) {
				winningTeam = enemyTeam;
				break;
			} else {
				howManyPlayerDead = 0;
			}
			if(i == 29) { 
				return null;
			}
		}
		System.out.println("The winner is " + winningTeam);
		return winningTeam;
	}
	/**
	 * Counts how many students are dead in the student team
	 */
	private void studentsDead() {
		for(Character character : playerTeam.returnMembers()) {
			if(character.getHP() > 0) {
				howManyPlayerDead = howManyPlayerDead + 1;
			}
		}
	}
	/**
	 * Counts how many monsters are dead in the monster team
	 */
	private void enemiesDead() {
		for(Character character : enemyTeam.returnMembers()) {
			if(character.getHP() <= 0) {
				howManyEnemyDead = howManyEnemyDead + 1;
			}
		}
	}
	/**
	 * Counts the number of enemies alive
	 * Checks if there are enemies alive
	 * If there are enemies alive the monster moves
	 * @param character - which character moves
	 */
	private void monsterMove(Character character) {
		int playersAlive = 0;
		for (Character chara : playerTeam.returnMembers()) {
			if (chara.getHP() > 0) {
				playersAlive = playersAlive + 1;
			}
		}
		if (playersAlive > 0) {
			try {
				character.getTeam().move(character, playerTeam);
			} catch (Exception e) {
				System.out.println("Exception occured: "+e);
			}
		}
	}
	/**
	 * Counts the number of enemies alive
	 * Checks if there are enemies alive
	 * If there are enemies alive the student moves
	 * @param character - which character moves
	 */
	private void studentMove(Character character) {
		int enemiesAlive = 0;
		for (Character chara : enemyTeam.returnMembers()) {
			if (chara.getHP() > 0) {
				enemiesAlive = enemiesAlive + 1;
			}
		}
		if (enemiesAlive > 0) {
			try {
				character.getTeam().move(character, enemyTeam);
			} catch (Exception e) {
				System.out.println("Exception occured: "+e);
			}
		}
	}
	/**
	 * Types out the HP of each character
	 * If they are dead, it types out dead
	 * @param i - which round we are in
	 */
	private void charactersHP(int i) {
		System.out.println();
		System.out.println("Round " + (i+1));
		System.out.println("Monster Team");
		for(Character character : enemyTeam.returnMembers()) {
			if(character.getHP() == 0) {
				System.out.println(character.getName() + " is dead");
			} else {
				System.out.println(character.getName() + " has " + character.getHP() + " HP");
			}
		}
		System.out.println();
		System.out.println("Student Team");
		for(Character character : playerTeam.returnMembers()) {
			if(character.getHP() == 0) {
				System.out.println(character.getName() + " is dead");
			} else {
				System.out.println(character.getName() + " has " + character.getHP() + " HP");
			}
		}
		System.out.println();
	}
	/**
	 * Sorts the characters in an ArrayList in descending order based on their speed
	 * @param sortThis - the characters in this ArrayList will be sorted
	 */
	public void sortTeam(ArrayList<Character> sortThis) {
		Collections.sort(sortThis, new SpeedComparator());
		Collections.reverse(sortThis);
	}
}