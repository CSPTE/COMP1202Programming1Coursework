import java.io.*;
public class TowerOfMonsters {
	BufferedReader reader;
    String firstLine;
    boolean isItReady = false;
    String name, type, strlevel;
    int level;
    String[] enemies;
    String[] enemyName;
    Minion minion1;
	Minion minion2;
	Minion minion3;
	Minion minion4;
	Minion minion5;
	Boss boss1;
	Boss boss2;
	Boss boss3;
	Boss boss4;
	Boss boss5;
	/**
	 * Creates a guild, a tower of monsters, and a BufferedReader
	 * It creates a new enemy team, for each line in the file
	 * It crates a new Team from the guild for each enemy team
	 * The two teams battle
	 * The fight continues until every student is dead
	 * It counts how many levels were completed
	 * In the end it tells the player which level they got to, and if they won
	 * @param args - the name of the file the program will read from
	 */
	public static void main(String[] args) {
		AIStudent aistudent1 = new AIStudent("AI1");
		CSStudent csstudent1 = new CSStudent("CS1");
		CyberStudent cyberstudent1 = new CyberStudent("Cyber1");
		SEStudent sestudent1 = new SEStudent("SE1");
		AIStudent aistudent2 = new AIStudent("AI2");
		CSStudent csstudent2 = new CSStudent("CS2");
		CyberStudent cyberstudent2 = new CyberStudent("Cyber2");
		SEStudent sestudent2 = new SEStudent("SE2");
		Team playerTeam = new StudentTeam("Fascists");
		Team firstTeam = new MonsterTeam("Communists");
		Guild guild1 = new Guild();
		try {
			guild1.addMember(aistudent1);
			guild1.addMember(csstudent1);
			guild1.addMember(cyberstudent1);
			guild1.addMember(sestudent1);
			guild1.addMember(aistudent2);
			guild1.addMember(csstudent2);
			guild1.addMember(cyberstudent2);
			guild1.addMember(sestudent2);
		} catch (SameCharacterException e) {
			System.out.println("Exception occured: "+e);
		}
		Team chickenDinner;
		int levelCount = 0;
		//--------------------------------------------------------------------------------------------
		playerTeam = guild1.getTeam(firstTeam);
		TowerOfMonsters tom = new TowerOfMonsters();
		tom.fileReader(args[0]);
		chickenDinner = playerTeam;
		while((tom.fileIsReady() == true)&&(guild1.returnMembersDead() < guild1.returnNumberOfMembers())) {
			if (chickenDinner == playerTeam) {
				tom.makeEnemyTeam(firstTeam);
				guild1.resetGuild();
				playerTeam.clearTeam();
				playerTeam = guild1.getTeam(firstTeam);
				Battle battle = new Battle(playerTeam, firstTeam);
				System.out.println("----------------------------------------------------------------------------");
				System.out.println("Level " + (levelCount+1));
				System.out.println("----------------------------------------------------------------------------");
				chickenDinner = battle.fight();
				levelCount = levelCount + 1;
			}
			if (chickenDinner == firstTeam) {
				guild1.resetGuild();
				playerTeam.clearTeam();
				playerTeam = guild1.getTeam(firstTeam);
				Battle battle = new Battle(playerTeam, firstTeam);
				System.out.println("----------------------------------------------------------------------------");
				System.out.println("Level " + (levelCount));
				System.out.println("----------------------------------------------------------------------------");
				chickenDinner = battle.fight();
			}
		}
		System.out.println("Congratulations! You reached level " + levelCount);
		if((tom.fileIsReady() == false) && (chickenDinner.equals(playerTeam))) {
			System.out.println("Congratulations! You won the game");
		}
	}
	/**
	 * Creates a BufferedReader for the file given
	 * @param file - the file for which the BufferedReader is created
	 */
	public void fileReader(String file) {
        try{
           reader = new BufferedReader(new FileReader(file));
        } catch(Exception m){
           System.out.println("Exception occured: "+m);
        }
    }
	/**
	 * @return - the next line of the file
	 */
    public String getLine() {
        try{
            firstLine = reader.readLine();
        } catch(Exception m){
            System.out.println("Exception occured: "+m);
        }
        return firstLine;
    }
    /**
     * Checks whether the file is ready or not
     * @return - whether the file is ready or not
     */
    public boolean fileIsReady() {
        try{
            if(reader.ready()){
                isItReady = true;
            } else {
                isItReady = false;
            }
        } catch(Exception m){
            System.out.println("Exception occured: "+m);
        }
        return isItReady;
    }
    /**
     * Makes an enemy Team for each line of the file
     * @param enemyTeam - this is the team to which the members will be added
     * @return - returns the created team
     */
    public Team makeEnemyTeam(Team enemyTeam){
    	fileIsReady();
    	clearTeam(enemyTeam);
    	if (isItReady == true) {
    		getLine();
            enemies = firstLine.split(";");
            for (int i=0; i<5; i++) {
            	enemyName = enemies[i].split("\\(");
            	name = enemyName[0];
            	enemyName = enemyName[1].split(",");
            	type = enemyName[0];
            	enemyName = enemyName[1].split("\\)");
            	strlevel = enemyName[0];
            	getLevel();
            	if (type.equals("Minion")) {
            		makeMinion(enemyTeam);	
            	}
            	if (type.equals("Boss")) {
            		makeBoss(enemyTeam);
            	}
            }
    	}
        return enemyTeam;
    }
    /**
     * When creating a new team, it clears the previous one
     * @param enemyTeam - the team which gets cleared
     */
	private void clearTeam(Team enemyTeam) {
		minion1 = null;
    	minion2 = null;
    	minion3 = null;
    	minion4 = null;
    	minion5 = null;
    	boss1 = null;
    	boss2 = null;
    	boss3 = null;
    	boss4 = null;
    	boss5 = null;
    	enemyTeam.clearTeam();
	}
	/**
	 * Makes a boss type character
	 * There are five boss type characters available, so that a team with 5 bosses can be created
	 * First it creates a new boss
	 * Then the boss gets added to the team
	 * Finally the boss is leveled up to the needed level
	 * @param enemyTeam - the boss will be added to this team
	 */
	private void makeBoss(Team enemyTeam) {
		if(boss1 == null) {
			boss1 = new Boss(name);
			enemyTeam.addMember(boss1);
			if(level != 1) {
				for(int j=1; j<level;j++) {
					boss1.increaseEP(10000);
				}
			}
		} else if (boss2 == null) {
			boss2 = new Boss(name);
			enemyTeam.addMember(boss2);
			if(level != 1) {
				for(int j=1; j<level;j++) {
					boss2.increaseEP(10000);
				}
			}
		} else if (boss3 == null) {
			boss3 = new Boss(name);
			enemyTeam.addMember(boss3);
			if(level != 1) {
				for(int j=1; j<level;j++) {
					boss3.increaseEP(10000);
				}
			}
		} else if (boss4 == null) {
			boss4 = new Boss(name);
			enemyTeam.addMember(boss4);
			if(level != 1) {
				for(int j=1; j<level;j++) {
					boss4.increaseEP(10000);
				}
			}
		} else if (boss5 == null) {
			boss5 = new Boss(name);
			enemyTeam.addMember(boss5);
			if(level != 1) {
				for(int j=1; j<level;j++) {
					boss5.increaseEP(10000);
				}
			}
		}
	}
	/**
	 * Makes a boss type character
	 * There are five minion type characters available, so that a team with 5 minions can be created
	 * First it creates a new minion
	 * Then the minion gets added to the team
	 * Finally the minion is leveled up to the needed level
	 * @param enemyTeam - the minion will be added to this team
	 */
	private void makeMinion(Team enemyTeam) {
		if(minion1 == null) {
			minion1 = new Minion(name);
			enemyTeam.addMember(minion1);
			if(level != 1) {
				for(int j=1; j<level;j++) {
					minion1.increaseEP(10000);
				}
			}
		} else if (minion2 == null) {
			minion2 = new Minion(name);
			enemyTeam.addMember(minion2);
			if(level != 1) {
				for(int j=1; j<level;j++) {
					minion2.increaseEP(10000);
				}
			}
		} else if (minion3 == null) {
			minion3 = new Minion(name);
			enemyTeam.addMember(minion3);
			if(level != 1) {
				for(int j=1; j<level;j++) {
					minion3.increaseEP(10000);
				}
			}
		} else if (minion4 == null) {
			minion4 = new Minion(name);
			enemyTeam.addMember(minion4);
			if(level != 1) {
				for(int j=1; j<level;j++) {
					minion4.increaseEP(10000);
				}
			}
		} else if (minion5 == null) {
			minion5 = new Minion(name);
			enemyTeam.addMember(minion5);
			if(level != 1) {
				for(int j=1; j<level;j++) {
					minion5.increaseEP(10000);
				}
			}
		}
	}
	/**
	 * Transforms the string into an integer
	 */
	private void getLevel() {
		if(strlevel.equals("1")) {
			level = 1;
		} else if(strlevel.equals("2")){
			level = 2;
		} else if(strlevel.equals("3")){
			level = 3;
		} else if(strlevel.equals("4")){
			level = 4;
		} else if(strlevel.equals("5")){
			level = 5;
		} else if(strlevel.equals("6")){
			level = 6;
		} else if(strlevel.equals("7")){
			level = 7;
		} else if(strlevel.equals("8")){
			level = 8;
		} else if(strlevel.equals("9")){
			level = 9;
		}
	}
}
