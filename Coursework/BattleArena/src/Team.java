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
	public Character[] getMembers() {
		//for (Character[] teamMembers : members)
		Character[] array = members.toArray(new Character[0]);
		return array;
	}
	public int addMember(Character member) {
		if(members.contains(member)) {
			return -1;
		} else if (numberOfCharacters >= 5) {
			return -2;
		} else {
			members.add(member);
			member.hisTeam = this;
			//for(Character teamMates : members) {
			//	teamMates.getTeam();
			//}
			numberOfCharacters = numberOfCharacters + 1;
			return numberOfCharacters;
		}
	}
	//public ArrayList<Character> returnMembers() {
	//	return members;
	//}
	public void clearTeam() {
		numberOfCharacters = 0;
		members.clear();
	}
	abstract void move(Character member, Team enemyTeam) throws Exception;
}
