import java.util.*;
public abstract class Team {
	String name;
	ArrayList<Character> members = new ArrayList<Character>();
	int numberOfCharacters;
	public Team(String inputName) {
		name = inputName;
	}
	public String getName() {
		return name;
	}
	/**
	 * @return the members of the Team in an array
	 */
	public Character[] getMembers() {
		Character[] array = members.toArray(new Character[0]);
		return array;
	}
	/**
	 * Adds members to the team if they are not already in the team, and there is still room for them
	 * @param member - the member which is being added to the team
	 * @return - the number of characters in the team or a negative number if the caracter was no added
	 */
	public int addMember(Character member) {
		if(members.contains(member)) {
			return -1;
		} else if (numberOfCharacters >= 5) {
			return -2;
		} else {
			members.add(member);
			member.hisTeam = this;
			numberOfCharacters = numberOfCharacters + 1;
			return numberOfCharacters;
		}
	}
	/**
	 * Removes all members of the team, and resets the member counter
	 */
	public void clearTeam() {
		numberOfCharacters = 0;
		members.clear();
	}
	public ArrayList<Character> returnMembers() {
		return members;
	}
	/**
	 * This method will make each character use an ability
	 * @param member - the member which uses their ability
	 * @param enemyTeam - the team on which the ability is used
	 * @throws Exception - throws KPException, SameCharacterException or CharacterDeadException
	 */
	abstract void move(Character member, Team enemyTeam) throws Exception;
}
