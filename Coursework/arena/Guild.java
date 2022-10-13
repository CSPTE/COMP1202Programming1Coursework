import java.util.ArrayList;

public class Guild {
	//String name;
	ArrayList<Character> guildMembers = new ArrayList<Character>();
	StudentTeam studentTeam = new StudentTeam("GuildTeam");
	int numberOfMembers = 0;
	int numberOfSE = 0, numberOfCyber = 0, numberOfCS = 0, numberOfAI = 0;
	int seInTeam = 0, cyberInTeam = 0, csInTeam = 0, aiInTeam = 0;
	int aiNeeded = 1, cyberNeeded = 2, csNeeded = 1, seNeeded = 1;
	int membersInTeam = 0;
	int membersDead = 0;
	int aiDead = 0, csDead = 0, cyberDead = 0, seDead = 0;
	public Guild() {
		
	}
	/**
	 * Adds a character to the guild if the character is not already in the guild
	 * @param addition - the character that is being added to the team
	 * @throws SameCharacterException - thrown when the character is already in the team
	 */
	public void addMember(Character addition) throws SameCharacterException{
		if(guildMembers.contains(addition)) {
			throw new SameCharacterException("Character is already in the team, was not added");
		} else {
			guildMembers.add(addition);
			numberOfMembers = numberOfMembers + 1;
		}
	}
	public ArrayList<Character> getMembers() {
		return guildMembers;
	}
	/**
	 * Checks how many members of the guild are Dead
	 */
	public void membersAlive() {
		for (Character ch : guildMembers) {
			if(ch.getHP() <= 0) {
				membersDead = membersDead + 1;
			}
		}
	}
	public int returnMembersDead() {
		return membersDead;
	}
	public int returnNumberOfMembers() {
		return numberOfMembers;
	}
	/**
	 * The members of the guild are not removed
	 * However the members of the studentTeam are
	 * It also resets the number of members required, that are in the team, the total number of characters, and the number of dead characters
	 */
	public void resetGuild() {
		membersDead = 0;
		numberOfSE = 0;
		numberOfCyber = 0;
		numberOfCS = 0;
		numberOfAI = 0;
		seInTeam = 0;
		cyberInTeam = 0;
		csInTeam = 0;
		aiInTeam = 0;
		cyberNeeded = 2;
		aiNeeded = 1;
		csNeeded = 1;
		seNeeded = 1;
		membersInTeam = 0;
		aiDead = 0;
		csDead = 0;
		cyberDead = 0;
		seDead = 0;
		studentTeam.clearTeam();
	}
	/**
	 * Creates a team based on the characters in the guild
	 * @param enemyTeam - creates team based on enemy team, although this method does not take the enemy team into consideration
	 * @return - returns the created team
	 */
	public Team getTeam(Team enemyTeam) {
		membersAlive();
		if(numberOfMembers <= 5) {
			lessThanFiveMembers();
		} else if((numberOfMembers - membersDead) <= 5) {
			lessThanSixAlive();
		} else {
			presentOfEachType();
			deadOfEach();
			idealTeam();
			while (membersInTeam < 5) {
				if (aiNeeded > 0) {
					aiNeeded();
				}
				if (csNeeded > 0) {
					csNeeded();
				}
				if (seNeeded > 0) {
					seNeeded();
				}
				if (cyberNeeded > 0) {
					cyberNeeded();
				}
			}
		}
		return studentTeam;
	}
	/**
	 * Counts the amount of Students dead of each type
	 */
	private void deadOfEach() {
		for(Character chara : guildMembers) {
			if (chara.getHP() <= 0) {
				if (chara instanceof AIStudent) {
					aiDead = aiDead + 1;
				}
				if (chara instanceof CSStudent) {
					csDead = csDead + 1;
				}
				if (chara instanceof SEStudent) {
					seDead = seDead + 1;
				}
				if (chara instanceof CyberStudent) {
					cyberDead = cyberDead + 1;
				}
			}
		}
	}
	/**
	 * If there weren't enough CyberStudents to create the ideal team, they are gradually replaced by less and less similar characters
	 */
	private void cyberNeeded() {
		if (numberOfAI > (aiInTeam + aiDead)) {
			int didWeAdd = 0;
			for (Character charact : guildMembers) {
				if ((charact instanceof AIStudent) && (didWeAdd == 0) && (!(studentTeam.returnMembers().contains(charact))) && (charact.getHP() > 0)) {
					studentTeam.addMember(charact);
					didWeAdd = didWeAdd + 1;
					membersInTeam = membersInTeam + 1;
					aiInTeam = aiInTeam + 1;
					cyberNeeded = cyberNeeded - 1;
				}
			}
		} else if (numberOfCS > (csInTeam + csDead)) {
			int didWeAdd = 0;
			for (Character charact : guildMembers) {
				if ((charact instanceof CSStudent) && (didWeAdd == 0) && (!(studentTeam.returnMembers().contains(charact))) && (charact.getHP() > 0)) {
					studentTeam.addMember(charact);
					didWeAdd = didWeAdd + 1;
					membersInTeam = membersInTeam + 1;
					csInTeam = csInTeam + 1;
					cyberNeeded = cyberNeeded - 1;
				}
			}
		} else if (numberOfSE > (seInTeam + seDead)) {
			int didWeAdd = 0;
			for (Character charact : guildMembers) {
				if ((charact instanceof SEStudent) && (didWeAdd == 0) && (!(studentTeam.returnMembers().contains(charact))) && (charact.getHP() > 0)) {
					studentTeam.addMember(charact);
					didWeAdd = didWeAdd + 1;
					membersInTeam = membersInTeam + 1;
					seInTeam = seInTeam + 1;
					cyberNeeded = cyberNeeded - 1;
				}
			}
		}
	}
	/**
	 * If there weren't enough SEStudents to create the ideal team, they are gradually replaced by less and less similar characters
	 */
	private void seNeeded() {
		if (numberOfCS > (csInTeam + csDead)) {
			int didWeAdd = 0;
			for (Character charact : guildMembers) {
				if ((charact instanceof CSStudent) && (didWeAdd == 0) && (!(studentTeam.returnMembers().contains(charact))) && (charact.getHP() > 0)) {
					studentTeam.addMember(charact);
					didWeAdd = didWeAdd + 1;
					membersInTeam = membersInTeam + 1;
					csInTeam = csInTeam + 1;
					seNeeded = seNeeded - 1;
				}
			}
		} else if (numberOfAI > (aiInTeam + aiDead)) {
			int didWeAdd = 0;
			for (Character charact : guildMembers) {
				if ((charact instanceof AIStudent) && (didWeAdd == 0) && (!(studentTeam.returnMembers().contains(charact))) && (charact.getHP() > 0)) {
					studentTeam.addMember(charact);
					didWeAdd = didWeAdd + 1;
					membersInTeam = membersInTeam + 1;
					aiInTeam = aiInTeam + 1;
					seNeeded = seNeeded - 1;
				}
			}
		} else if (numberOfCyber > (cyberInTeam + cyberDead)) {
			int didWeAdd = 0;
			for (Character charact : guildMembers) {
				if ((charact instanceof CyberStudent) && (didWeAdd == 0) && (!(studentTeam.returnMembers().contains(charact))) && (charact.getHP() > 0)) {
					studentTeam.addMember(charact);
					didWeAdd = didWeAdd + 1;
					membersInTeam = membersInTeam + 1;
					cyberInTeam = cyberInTeam + 1;
					seNeeded = seNeeded - 1;
				}
			}
		}
	}
	/**
	 * If there weren't enough CSStudents to create the ideal team, they are gradually replaced by less and less similar characters
	 */
	private void csNeeded() {
		if (numberOfSE > (seInTeam + seDead)) {
			int didWeAdd = 0;
			for (Character charact : guildMembers) {
				if ((charact instanceof SEStudent) && (didWeAdd == 0) && (!(studentTeam.returnMembers().contains(charact))) && (charact.getHP() > 0)) {
					studentTeam.addMember(charact);
					didWeAdd = didWeAdd + 1;
					membersInTeam = membersInTeam + 1;
					seInTeam = seInTeam + 1;
					csNeeded = csNeeded - 1;
				}
			}
		} else if (numberOfAI > (aiInTeam + aiDead)) {
			int didWeAdd = 0;
			for (Character charact : guildMembers) {
				if ((charact instanceof AIStudent) && (didWeAdd == 0) && (!(studentTeam.returnMembers().contains(charact))) && (charact.getHP() > 0)) {
					studentTeam.addMember(charact);
					didWeAdd = didWeAdd + 1;
					membersInTeam = membersInTeam + 1;
					aiInTeam = aiInTeam + 1;
					csNeeded = csNeeded - 1;
				}
			}
		} else if (numberOfCyber > (cyberInTeam + cyberDead)) {
			int didWeAdd = 0;
			for (Character charact : guildMembers) {
				if ((charact instanceof CyberStudent) && (didWeAdd == 0) && (!(studentTeam.returnMembers().contains(charact))) && (charact.getHP() > 0)) {
					studentTeam.addMember(charact);
					didWeAdd = didWeAdd + 1;
					membersInTeam = membersInTeam + 1;
					cyberInTeam = cyberInTeam + 1;
					csNeeded = csNeeded - 1;
				}
			}
		}
	}
	/**
	 * If there weren't enough AIStudents to create the ideal team, they are gradually replaced by less and less similar characters
	 */
	private void aiNeeded() {
		if (numberOfCyber > (cyberInTeam + cyberDead)) {
			int didWeAdd = 0;
			for (Character charact : guildMembers) {
				if ((charact instanceof CyberStudent) && (didWeAdd == 0) && (!(studentTeam.returnMembers().contains(charact))) && (charact.getHP() > 0)) {
					studentTeam.addMember(charact);
					didWeAdd = didWeAdd + 1;
					membersInTeam = membersInTeam + 1;
					cyberInTeam = cyberInTeam + 1;
					aiNeeded = aiNeeded - 1;
				}
			}
		} else if (numberOfCS > (csInTeam + csDead)) {
			int didWeAdd = 0;
			for (Character charact : guildMembers) {
				if ((charact instanceof CSStudent) && (didWeAdd == 0) && (!(studentTeam.returnMembers().contains(charact))) && (charact.getHP() > 0)) {
					studentTeam.addMember(charact);
					didWeAdd = didWeAdd + 1;
					membersInTeam = membersInTeam + 1;
					csInTeam = csInTeam + 1;
					aiNeeded = aiNeeded - 1;
				}
			}
		} else if (numberOfSE > (seInTeam + seDead)) {
			int didWeAdd = 0;
			for (Character charact : guildMembers) {
				if ((charact instanceof SEStudent) && (didWeAdd == 0) && (!(studentTeam.returnMembers().contains(charact))) && (charact.getHP() > 0)) {
					studentTeam.addMember(charact);
					didWeAdd = didWeAdd + 1;
					membersInTeam = membersInTeam + 1;
					seInTeam = seInTeam + 1;
					aiNeeded = aiNeeded - 1;
				}
			}
		}
	}
	/**
	 * Tries to create the ideal team consisting of 2 Cyber-, 1 SE-, 1 CS- and 1 AIStudent
	 */
	private void idealTeam() {
		for (Character characters : guildMembers){
			if ((characters instanceof CyberStudent) && (cyberNeeded > 0) && (!(studentTeam.returnMembers().contains(characters))) && (characters.getHP() > 0)) {
				studentTeam.addMember(characters);
				cyberInTeam = cyberInTeam + 1;
				membersInTeam = membersInTeam + 1;
				cyberNeeded = cyberNeeded - 1;
			} else if ((characters instanceof SEStudent) && (seNeeded > 0) && (!(studentTeam.returnMembers().contains(characters))) && (characters.getHP() > 0)) {
				studentTeam.addMember(characters);
				seInTeam = seInTeam + 1;
				membersInTeam = membersInTeam + 1;
				seNeeded = seNeeded - 1;
			} else if ((characters instanceof CSStudent) && (csNeeded > 0) && (!(studentTeam.returnMembers().contains(characters))) && (characters.getHP() > 0)) {
				studentTeam.addMember(characters);
				csInTeam = csInTeam + 1;
				membersInTeam = membersInTeam + 1;
				csNeeded = csNeeded - 1;
			} else if ((characters instanceof AIStudent) && (aiNeeded > 0) && (!(studentTeam.returnMembers().contains(characters))) && (characters.getHP() > 0)) {
				studentTeam.addMember(characters);
				aiInTeam = aiInTeam + 1;
				membersInTeam = membersInTeam + 1;
				aiNeeded = aiNeeded - 1;
			}
		}
	}
	/**
	 * Calculates how many Students of each type are present in the guild
	 */
	private void presentOfEachType() {
		for (Character characters : guildMembers){
			if (characters instanceof CyberStudent) {
				numberOfCyber = numberOfCyber + 1;
			} else if (characters instanceof SEStudent) {
				numberOfSE = numberOfSE + 1;
			} else if (characters instanceof CSStudent) {
				numberOfCS = numberOfCS + 1;
			} else if (characters instanceof AIStudent) {
				numberOfAI = numberOfAI + 1;
			}
		}
	}
	/**
	 * If there are less than six members alive it adds all of them to the team
	 */
	private void lessThanSixAlive() {
		for (Character characte : guildMembers){
			if(characte.getHP() > 0) {
				studentTeam.addMember(characte);
			}
		}
	}
	/**
	 * If there are less than 6 members in the Guild it adds all of them
	 */
	private void lessThanFiveMembers() {
		for (Character character : guildMembers){
			studentTeam.addMember(character);
		}
	}
}
