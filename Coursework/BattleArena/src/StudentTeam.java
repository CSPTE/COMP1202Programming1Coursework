//import java.util.*;
public class StudentTeam extends Team {
	public StudentTeam(String inputName) {
		super(inputName);
	}
	void move(Character member, Team enemyTeam) throws Exception {
		if (member.currentHP > 0) {
			Character target = null;
			Character reserve;
			Character needsHelp = null;
			//Character needsMostHelp = null;
			Character strongestFriend = null;
			int lessThanHalfHP = 0;
			for (Character enemy : enemyTeam.getMembers()) { //select random enemy alive
				if(enemy.currentHP > 0) {
					target = enemy;
				}
			}
			for (Character strongest : member.hisTeam.getMembers()) { //select random friend alive that's not member
				if((member != strongest) && (strongest.currentHP > 0)) {
					strongestFriend = strongest;
					//System.out.println(strongestFriend.name);
				}
			}
			for (Character enemy : enemyTeam.getMembers()) { //find boss or weakest minion alive
				if((enemy instanceof Boss) && (enemy.currentHP > 0)) {
					target = enemy;
					break;
				} else if((!(target instanceof Boss)) && (enemy.currentHP > 0)) {
					reserve = enemy;
					if(reserve.currentHP < target.currentHP) {
						target = reserve;
					}
				}
			}
			//System.out.println("Target = " + target.name);
			if (target.currentHP <= 0) { //enemy is dead exception
				throw new CharacterDeadException("Enemy is Dead");
			}
			//System.out.println(strongestFriend.name);
			for (Character strong : member.hisTeam.getMembers()) { //find strongest friend alive
				//System.out.println(strong.name);
				if ((strong != member) && (strong.currentHP > 0)) {
					//System.out.println(strong.name);
					strong.getAttack();
					strongestFriend.getAttack();
					if (strong.currentAtk > strongestFriend.currentAtk) {
						strongestFriend = strong;
						//System.out.println(strong.name);
					}
				}
			}
			//System.out.println(strongestFriend.name);
			if (member instanceof AIStudent) {
				if(member.currentHP >= (member.maxHP/2)) {
					if(((Student) member).currentKP == ((Student) member).maxKP) {
						((AIStudent) member).machineLearning(target);
						System.out.println(member.getName() + " Used machineLearning on " + target.getName());
						System.out.println(target.getName() + " Current HP " + target.getHP());
					} else {
						((Student) member).javaProgramming(target);
						System.out.println(member.getName() + " Used javaProgramming on " + target.getName());
						System.out.println(target.getName() + " Current HP " + target.getHP());
					}
				} else if(((Student) member).currentKP == ((Student) member).maxKP) {
					((AIStudent) member).naturalLanguageProcessing();
					System.out.println(member.getName() + " Used Natural Language Processing (healing)");
					System.out.println(member.getName() + " Current HP " + member.getHP());
				} else {
					((Student) member).selfStudy();
					System.out.println(member.getName() + " Used Self Study (healing)");
					System.out.println(member.getName() + " Current HP " + member.getHP());
				}
			}
			if (member instanceof CSStudent) {
				if(member.currentHP >= (member.maxHP/2)) {
					if(((Student) member).currentKP == ((Student) member).maxKP) {
						//System.out.println("currentKP " + ((Student) member).currentKP + "maxKP " + ((Student) member).maxKP);
						for (Character friend : member.hisTeam.getMembers()) {
							//System.out.println(friend.name);
							if((friend.currentHP <= (friend.maxHP/2)) && (friend != member) && (friend.currentHP > 0)) {
								needsHelp = friend;
							}
						}
						//System.out.println(needsHelp.name);
						if(needsHelp == member) {
							throw new SameCharacterException("Character and Friend are the same character");
						}
						if(needsHelp != null) {
							((CSStudent) member).support(needsHelp);
							System.out.println(member.getName() + " Used support on " + needsHelp.getName());
							System.out.println(needsHelp.getName() + " Current HP " + needsHelp.getHP());
						} else if (strongestFriend != null){
							if (strongestFriend.currentHP <= 0) { //friend is dead exception
								throw new CharacterDeadException("Friend is Dead");
							}
							((CSStudent) member).pairWorking(strongestFriend, target);
							System.out.println(member.getName() + " Used pair Working on " + target.getName());
							System.out.println(target.getName() + " Current HP " + target.getHP());
							//System.out.println(strongestFriend.name);
						} else {
							((Student) member).javaProgramming(target);
							System.out.println(member.getName() + " Used javaProgramming on " + target.getName());
							System.out.println(target.getName() + " Current HP " + target.getHP());
						}
					} else { //not max KP
						((Student) member).javaProgramming(target);
						System.out.println(member.getName() + " Used javaProgramming on " + target.getName());
						System.out.println(target.getName() + " Current HP " + target.getHP());
					}
				} else { //less Than half HP
					((Student) member).selfStudy();
					System.out.println(member.getName() + " Used Self Study (healing)");
					System.out.println(member.getName() + " Current HP " + member.getHP());
				}
			}
			if (member instanceof SEStudent) {
				for (Character friend : member.hisTeam.getMembers()) {
					if(friend.currentHP <= (friend.maxHP/2)) {
						lessThanHalfHP = lessThanHalfHP + 1;
					}
				}
				if(lessThanHalfHP >= 2) {
					if(((Student) member).currentKP == ((Student) member).maxKP) {
						((SEStudent) member).groupDiscussion();
						System.out.println(member.getName() + " Used Group Discussion (healing)");
					} else if(member.currentHP <= (member.maxHP/2)) {
						((Student) member).selfStudy();
						System.out.println(member.getName() + " Used Self Study (healing)");
						System.out.println(member.getName() + " Current HP " + member.getHP());
					} else {
						((Student) member).javaProgramming(target);
						System.out.println(member.getName() + " Used javaProgramming on " + target.getName());
						System.out.println(target.getName() + " Current HP " + target.getHP());
						//System.out.println("Using JavaProgramming on " + target.name);
					}
				} else if(member.currentHP <= (member.maxHP/2)) {
					((Student) member).selfStudy();
					System.out.println(member.getName() + " Used Self Study (healing)");
					System.out.println(member.getName() + " Current HP " + member.getHP());
				} else if(((Student) member).currentKP == ((Student) member).maxKP) {
					((SEStudent) member).groupWork(target);
					System.out.println(member.getName() + " Used Group Work on " + target.getName());
					System.out.println(target.getName() + " Current HP " + target.getHP());
				} else {
					((Student) member).javaProgramming(target);
					System.out.println(member.getName() + " Used javaProgramming on " + target.getName());
					System.out.println(target.getName() + " Current HP " + target.getHP());
				}
			}
			if (member instanceof CyberStudent) {
				if(member.currentHP >= (member.maxHP/2)) {
					if(((Student) member).currentKP == ((Student) member).maxKP) {
						((CyberStudent) member).cyberAttack(enemyTeam);
						System.out.println(member.getName() + " Used Cyber Attack on enemy team");
					} else {
						((Student) member).javaProgramming(target);
						System.out.println(member.getName() + " Used javaProgramming on " + target.getName());
						System.out.println(target.getName() + " Current HP " + target.getHP());
					}
				} else {
					((Student) member).selfStudy();
					System.out.println(member.getName() + " Used Self Study (healing)");
					System.out.println(member.getName() + " Current HP " + member.getHP());
				}
			}
		} else if(member.currentHP <= 0) {
			throw new CharacterDeadException("Character is Dead");
		}
	}
}
