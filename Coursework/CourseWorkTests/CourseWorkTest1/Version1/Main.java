public class Main {
	public static void main(String[] args) {
		Character firstCharacter = new Character("Adolf",10,10,10,10);
		Character secondCharacter = new Character("Benito",10,10,10,10);
		Character thirdCharacter = new Character("Castro",10,10,10,10);
		Character forthCharacter = new Character("Daniel",10,10,10,10);
		Character fifthCharacter = new Character("Elemer",10,10,10,10);
		Character sixthCharacter = new Character("Francis",10,10,10,10);
		Team firstTeam = new Team("Nazis");
		//firstCharacter.increaseEP(12);
		System.out.println("Max HP = " + firstCharacter.getMaxHP());
		System.out.println("Attack = " + firstCharacter.getAttack());
		System.out.println("Defence = " + firstCharacter.getDefence());
		System.out.println("Speed = " + firstCharacter.getSpeed());
		System.out.println("Target EP = " + firstCharacter.getTargetEP());
		System.out.println("Increase EP");
		firstCharacter.increaseEP(12);
		System.out.println("Max HP = " + firstCharacter.getMaxHP());
		System.out.println("Attack = " + firstCharacter.getAttack());
		System.out.println("Defence = " + firstCharacter.getDefence());
		System.out.println("Speed = " + firstCharacter.getSpeed());
		System.out.println("Target EP = " + firstCharacter.getTargetEP());
		System.out.println("Current EP = " + firstCharacter.getEP());
		System.out.println("Current HP before increase = " + firstCharacter.getHP());
		System.out.println("Increase HP ");
		firstCharacter.increaseHP(5);
		System.out.println("Current HP after increase = " + firstCharacter.getHP());
		System.out.println("Decrease HP ");
		firstCharacter.decreaseHP(25);
		System.out.println("Current HP after decrease = " + firstCharacter.getHP());
		System.out.println("Increase HP ");
		firstCharacter.increaseHP(6);
		System.out.println("Current HP after increase = " + firstCharacter.getHP());
		
		System.out.println("Characters team = " + firstCharacter.getTeam());
		System.out.println("Team members before adding = " + firstTeam.getMembers());
		System.out.println("Which member = " + firstTeam.addMember(firstCharacter));
		System.out.println("Team members after adding = " + firstTeam.getMembers());
		firstCharacter.setTeam(firstTeam);
		System.out.println("Characters team = " + firstCharacter.getTeam());
		System.out.println("Try to add member again = " + firstTeam.addMember(firstCharacter));
		//System.out.println("Which member = " + firstTeam.addMember(firstCharacter));
		System.out.println("Which member = " + firstTeam.addMember(secondCharacter));
		System.out.println("Which member = " + firstTeam.addMember(thirdCharacter));
		System.out.println("Which member = " + firstTeam.addMember(forthCharacter));
		System.out.println("Which member = " + firstTeam.addMember(fifthCharacter));
		System.out.println("Add sixth member = " + firstTeam.addMember(sixthCharacter));
	}
}
