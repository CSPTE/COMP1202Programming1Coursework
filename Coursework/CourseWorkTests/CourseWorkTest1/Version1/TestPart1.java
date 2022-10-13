import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

/**
 * Full Unit Tests for Part 1 of Coursework.
 * 
 * @author htson
 * @version 1.0
 */
public class TestPart1 {

	private abstract class AbstractTestCharacter extends AbstractTestClass {
		/**
		 * We are testing {@link Character} class.
		 */
		protected Class<?> getTestClass() {
			return Character.class;
		}
	}
	
	@Nested
	class TestCharacterSignature extends AbstractTestCharacter {

		/**
		 * Test {@link Character#name}.
		 */
		@Test
		@DisplayName("Test Character's name member variable")
		public void testCharacter_name() {
			assertField("", "name");
		}

		/**
		 * Test {@link Character#baseHP}.
		 */
		@Test
		@DisplayName("Test Character's baseHP member variable")
		public void testCharacter_baseHP() {
			assertField("", "baseHP");
		}

		/**
		 * Test {@link Character#baseAtk}.
		 */
		@Test
		@DisplayName("Test Character's baseAtk member variable")
		public void testCharacter_baseAtk() {
			assertField("", "baseAtk");
		}

		/**
		 * Test {@link Character#baseDef}.
		 */
		@Test
		@DisplayName("Test Character's baseDef member variable")
		public void testCharacter_baseDef() {
			assertField("", "baseDef");
		}

		/**
		 * Test {@link Character#level}.
		 */
		@Test
		@DisplayName("Test Character's level member variable")
		public void testCharacter_level() {
			assertField("", "level");
		}
		
		/**
		 * Test {@link Character#Character(String, int, int, int, int)}.
		 */
		@Test
		@DisplayName("Test Character's constructor")
		public void testCharacter_constructor() {
			assertConstructor("", String.class, int.class, int.class, int.class, int.class);
		}
		
		/**
		 * Test {@link Character#getName()}.
		 */
		@Test
		@DisplayName("Test Character's getName() method")
		public void testCharacter_getName() {
			assertMethod("", "getName");
		}

		/**
		 * Test {@link Character#getMaxHP()}.
		 */
		@Test
		@DisplayName("Test Character's getMaxHP() method")
		public void testCharacter_getMaxHP() {
			assertMethod("", "getMaxHP");
		}

		/**
		 * Test {@link Character#getAttack()}.
		 */
		@Test
		@DisplayName("Test Character's getAttack() method")
		public void testCharacter_getAttack() {
			assertMethod("", "getAttack");
		}

		/**
		 * Test {@link Character#getDefence()}.
		 */
		@Test
		@DisplayName("Test Character's getDefence() method")
		public void testCharacter_getDefence() {
			assertMethod("", "getDefence");
		}

		/**
		 * Test {@link Character#getSpeed()}.
		 */
		@Test
		@DisplayName("Test Character's getSpeed() method")
		public void testCharacter_getSpeed() {
			assertMethod("", "getSpeed");
		}

		/**
		 * Test {@link Character#getTargetEP()}.
		 */
		@Test
		@DisplayName("Test Character's getTargetEP() method")
		public void testCharacter_getTargetEP() {
			assertMethod("", "getTargetEP");
		}
		
		/**
		 * Test {@link Character#currentHP}.
		 */
		@Test
		@DisplayName("Test Character's currentHP member variable")
		public void testCharacter_currentHP() {
			assertField("", "currentHP");
		}

		/**
		 * Test {@link Character#currentEP}.
		 */
		@Test
		@DisplayName("Test Character's currentEP member variable")
		public void testCharacter_currentEP() {
			assertField("", "currentEP");
		}

		/**
		 * Test {@link Character#getHP()}.
		 */
		@Test
		@DisplayName("Test Character's getHP() method")
		public void testCharacter_getHP() {
			assertMethod("", "getHP");
		}

		/**
		 * Test {@link Character#getEP()}.
		 */
		@Test
		@DisplayName("Test Character's getEP() method")
		public void testCharacter_getEP() {
			assertMethod("", "getEP");
		}

		/**
		 * Test {@link Character#increaseHP()}.
		 */
		@Test
		@DisplayName("Test Character's increaseHP() method")
		public void testCharacter_increaseHP() {
			assertMethod("", "increaseHP", int.class);
		}

		/**
		 * Test {@link Character#decreaseHP()}.
		 */
		@Test
		@DisplayName("Test Character's decreaseHP() method")
		public void testCharacter_decreaseHP() {
			assertMethod("", "decreaseHP", int.class);
		}

		/**
		 * Test {@link Character#increaseEP()}.
		 */
		@Test
		@DisplayName("Test Character's increaseEP() method")
		public void testCharacter_increaseEP() {
			assertMethod("", "increaseEP", int.class);
		}

		/**
		 * Test {@link Character#setTeam(Team)}.
		 */
		@Test
		@DisplayName("Test Character's setTeam(Team) method")
		public void testCharacter_setTeam() {
			assertMethod("", "setTeam", Team.class);
		}

		/**
		 * Test {@link Character#getTeam()}.
		 */
		@Test
		@DisplayName("Test Character's getTeam() method")
		public void testCharacter_getTeam() {
			assertMethod("", Team.class, "getTeam");
		}

	}

	private abstract class TestCharacter extends AbstractTestCharacter {
		
		protected Character character;
		
		protected Team team;
		
		@BeforeEach
		public void setup() {
			super.setup();
			assertConstructor("", String.class, int.class, int.class, int.class, int.class);
			assertMethod("", "getName");
			assertMethod("", "getMaxHP");
			assertMethod("", "getAttack");
			assertMethod("", "getDefence");
			assertMethod("", "getSpeed");
			assertMethod("", "getTargetEP");
			assertMethod("", "increaseHP", int.class);
			assertMethod("", "decreaseHP", int.class);
			assertMethod("", "increaseEP", int.class);
			assertConstructor(Team.class, "", String.class);
			character = getCharacter();
			team = new Team("ECS Team");
		}

		public abstract Character getCharacter();
	}
	
	@Nested
	class TestCharacterLevel1 extends TestCharacter {

		public Character getCharacter() {
			Character character = new Character("Level 1", 10, 8, 6, 4);
			return character;
		}
		
		/**
		 * Test {@link Character#getName()}.
		 */
		@Test
		@DisplayName("Test Level 1 Character's getName()")
		public void testCharacter_Level1_getName() {
			assertEquals("Level 1", character.getName(), "Incorrect name for Level 1 Character");
		}
	
		/**
		 * Test {@link Character#getMaxHP()}.
		 */
		@Test
		@DisplayName("Test Level 1 Character's getMaxHP()")
		public void testCharacter_Level1_getMaxHP() {
			assertEquals(10, character.getMaxHP(), "Incorrect max HP for Level 1 Character");
		}

		/**
		 * Test {@link Character#getAttack()}.
		 */
		@Test
		@DisplayName("Test Level 1 Character's getAttack()")
		public void testCharacter_Level1_getAttack() {
			assertEquals(8, character.getAttack(), "Incorrect attack for Level 1 Character");
		}

		/**
		 * Test {@link Character#getDefence()}.
		 */
		@Test
		@DisplayName("Test Level 1 Character's getDefence()")
		public void testCharacter_Level1_getDefence() {
			assertEquals(6, character.getDefence(), "Incorrect defence for Level 1 Character");
		}

		/**
		 * Test {@link Character#getSpeed()}.
		 */
		@Test
		@DisplayName("Test Level 1 Character's getSpeed()")
		public void testCharacter_Level1_getSpeed() {
			assertEquals(4, character.getSpeed(), "Incorrect speed for Level 1 Character");
		}

		/**
		 * Test {@link Character#getTargetEP()}.
		 */
		@Test
		@DisplayName("Test Level 1 Character's getTargetEP()")
		public void testCharacter_Level1_getTargetEP() {
			assertEquals(10, character.getTargetEP(), "Incorrect target EP for Level 1 Character");
		}

		/**
		 * Test {@link Character#getHP()}.
		 */
		@Test
		@DisplayName("Test Level 1 Character's getHP()")
		public void testCharacter_Level1_getHP() {
			assertEquals(10, character.getHP(), "Incorrect HP for Level 1 Character");
		}

		/**
		 * Test {@link Character#getEP()}.
		 */
		@Test
		@DisplayName("Test Level 1 Character's getEP()")
		public void testCharacter_Level1_getEP() {
			assertEquals(0, character.getEP(), "Incorrect EP for Level 1 Character");
		}

		/**
		 * Test {@link Character#decreaseHP()}.
		 */
		@Test
		@DisplayName("Test Level 1 Character's decreaseHP()")
		public void testCharacter_Level1_decreaseHP() {
			character.decreaseHP(5);
			assertEquals(5, character.getHP(), "Incorrect HP for Level 1 Character");
		}

		/**
		 * Test {@link Character#decreaseHP()}.
		 */
		@Test
		@DisplayName("Test Level 1 Character's decreaseHP() to zero")
		public void testCharacter_Level1_decreaseHPZero() {
			character.decreaseHP(10);
			assertEquals(0, character.getHP(), "Incorrect HP for Level 1 Character");
		}

		/**
		 * Test {@link Character#decreaseHP()}.
		 */
		@Test
		@DisplayName("Test Level 1 Character's decreaseHP() over the limit")
		public void testCharacter_Level1_decreaseHPOver() {
			character.decreaseHP(12);
			assertEquals(0, character.getHP(), "Incorrect HP for Level 1 Character");
		}

		/**
		 * Test {@link Character#increaseHP()}.
		 */
		@Test
		@DisplayName("Test Level 1 Character's increaseHP()")
		public void testCharacter_Level1_increaseHP() {
			character.decreaseHP(5);
			character.increaseHP(2);
			assertEquals(7, character.getHP(), "Incorrect HP for Level 1 Character");
		}

		/**
		 * Test {@link Character#increaseHP()}.
		 */
		@Test
		@DisplayName("Test Level 1 Character's increaseHP() to maximum")
		public void testCharacter_Level1_increaseHPMax() {
			character.decreaseHP(5);
			character.increaseHP(5);
			assertEquals(10, character.getHP(), "Incorrect HP for Level 1 Character");
		}

		/**
		 * Test {@link Character#increaseHP()}.
		 */
		@Test
		@DisplayName("Test Level 1 Character's increaseHP() over the limit")
		public void testCharacter_Level1_increaseHPOver() {
			character.decreaseHP(5);
			character.increaseHP(7);
			assertEquals(10, character.getHP(), "Incorrect HP for Level 1 Character");
		}

		/**
		 * Test {@link Character#increaseEP()}.
		 */
		@Test
		@DisplayName("Test Level 1 Character's increaseEP()")
		public void testCharacter_Level1_increaseEP() {
			character.increaseEP(6);
			assertEquals(6, character.getEP(), "Incorrect EP for Level 1 Character");
		}

		/**
		 * Test {@link Character#increaseEP()}.
		 */
		@Test
		@DisplayName("Test Level 1 Character's increaseEP() to maximum")
		public void testCharacter_Level1_increaseEPMax() {
			character.increaseEP(10);
			assertEquals(0, character.getEP(), "Incorrect EP for Level 1 Character");
		}

		/**
		 * Test {@link Character#increaseEP()}.
		 */
		@Test
		@DisplayName("Test Level 1 Character's increaseEP() over the limit")
		public void testCharacter_Level1_increaseEPOver() {
			character.increaseEP(12);
			assertEquals(0, character.getEP(), "Incorrect EP for Level 1 Character");
		}

		/**
		 * Test {@link Character#setTeam(Team)} and {@link Character#getTeam()}.
		 */
		@Test
		@DisplayName("Test Level 1 Character's setTeam(Team) and getTeam()")
		public void testCharacter_Level1_setTeam_getTeam() {
			character.setTeam(team);
			assertEquals(team, character.getTeam(), "Incorrect Team for Level 1 Character");
		}
	}

	@Nested
	class TestCharacterLevel2 extends TestCharacter {

		public Character getCharacter() {
			Character character = new Character("Level 2", 10, 8, 6, 4); 
			character.increaseEP(10);
			return character;
		}
		
		/**
		 * Test {@link Character#getName()}.
		 */
		@Test
		@DisplayName("Test Level 2 Character's getName()")
		public void testCharacter_Level2_getName() {
			assertEquals("Level 2", character.getName(), "Incorrect name for Level 2 Character");
		}

		/**
		 * Test {@link Character#getMaxHP()}.
		 */
		@Test
		@DisplayName("Test Level 2 Character's getMaxHP()")
		public void testCharacter_Level2_getMaxHP() {
			assertEquals(23, character.getMaxHP(), "Incorrect max HP for Level 2 Character");
		}

		/**
		 * Test {@link Character#getAttack()}.
		 */
		@Test
		@DisplayName("Test Level 2 Character's getAttack()")
		public void testCharacter_Level2_getAttack() {
			assertEquals(18, character.getAttack(), "Incorrect attack for Level 2 Character");
		}

		/**
		 * Test {@link Character#getDefence()}.
		 */
		@Test
		@DisplayName("Test Level 2 Character's getDefence()")
		public void testCharacter_Level2_getDefence() {
			assertEquals(14, character.getDefence(), "Incorrect defence for Level 2 Character");
		}

		/**
		 * Test {@link Character#getSpeed()}.
		 */
		@Test
		@DisplayName("Test Level 2 Character's getSpeed()")
		public void testCharacter_Level2_getSpeed() {
			assertEquals(9, character.getSpeed(), "Incorrect speed for Level 2 Character");
		}

		/**
		 * Test {@link Character#getTargetEP()}.
		 */
		@Test
		@DisplayName("Test Level 2 Character's getTargetEP()")
		public void testCharacter_Level2_getTargetEP() {
			assertEquals(28, character.getTargetEP(), "Incorrect target EP for Level 2 Character");
		}

		/**
		 * Test {@link Character#getHP()}.
		 */
		@Test
		@DisplayName("Test Level 2 Character's getHP()")
		public void testCharacter_Level2_getHP() {
			assertEquals(23, character.getHP(), "Incorrect HP for Level 2 Character");
		}

		/**
		 * Test {@link Character#getEP()}.
		 */
		@Test
		@DisplayName("Test Level 2 Character's getEP()")
		public void testCharacter_Level2_getEP() {
			assertEquals(0, character.getEP(), "Incorrect EP for Level 2 Character");
		}

		/**
		 * Test {@link Character#decreaseHP()}.
		 */
		@Test
		@DisplayName("Test Level 2 Character's decreaseHP()")
		public void testCharacter_Level2_decreaseHP() {
			character.decreaseHP(5);
			assertEquals(18, character.getHP(), "Incorrect HP for Level 2 Character");
		}

		/**
		 * Test {@link Character#decreaseHP()}.
		 */
		@Test
		@DisplayName("Test Level 2 Character's decreaseHP() to zero")
		public void testCharacter_Level2_decreaseHPZero() {
			character.decreaseHP(23);
			assertEquals(0, character.getHP(), "Incorrect HP for Level 2 Character");
		}

		/**
		 * Test {@link Character#decreaseHP()}.
		 */
		@Test
		@DisplayName("Test Level 2 Character's decreaseHP() over the limit")
		public void testCharacter_Level2_decreaseHPOver() {
			character.decreaseHP(25);
			assertEquals(0, character.getHP(), "Incorrect HP for Level 2 Character");
		}

		/**
		 * Test {@link Character#increaseHP()}.
		 */
		@Test
		@DisplayName("Test Level 2 Character's increaseHP()")
		public void testCharacter_Level2_increaseHP() {
			character.decreaseHP(5);
			character.increaseHP(2);
			assertEquals(20, character.getHP(), "Incorrect HP for Level 2 Character");
		}

		/**
		 * Test {@link Character#increaseHP()}.
		 */
		@Test
		@DisplayName("Test Level 2 Character's increaseHP() to maximum")
		public void testCharacter_Level2_increaseHPMax() {
			character.decreaseHP(5);
			character.increaseHP(5);
			assertEquals(23, character.getHP(), "Incorrect HP for Level 2 Character");
		}

		/**
		 * Test {@link Character#increaseHP()}.
		 */
		@Test
		@DisplayName("Test Level 2 Character's increaseHP() over the limit")
		public void testCharacter_Level2_increaseHPOver() {
			character.decreaseHP(5);
			character.increaseHP(7);
			assertEquals(23, character.getHP(), "Incorrect HP for Level 2 Character");
		}

		/**
		 * Test {@link Character#increaseEP()}.
		 */
		@Test
		@DisplayName("Test Level 2 Character's increaseEP()")
		public void testCharacter_Level2_increaseEP() {
			character.increaseEP(6);
			assertEquals(6, character.getEP(), "Incorrect EP for Level 2 Character");
		}

		/**
		 * Test {@link Character#increaseEP()}.
		 */
		@Test
		@DisplayName("Test Level 2 Character's increaseEP() to maximum")
		public void testCharacter_Level2_increaseEPMax() {
			character.increaseEP(28);
			assertEquals(0, character.getEP(), "Incorrect EP for Level 2 Character");
		}

		/**
		 * Test {@link Character#increaseEP()}.
		 */
		@Test
		@DisplayName("Test Level 2 Character's increaseEP() over the limit")
		public void testCharacter_Level2_increaseEPOver() {
			character.increaseEP(30);
			assertEquals(0, character.getEP(), "Incorrect EP for Level 2 Character");
		}

		/**
		 * Test {@link Character#setTeam(Team)} and {@link Character#getTeam()}.
		 */
		@Test
		@DisplayName("Test Level 2 Character's setTeam(Team) and getTeam()")
		public void testCharacter_Level2_setTeam_getTeam() {
			character.setTeam(team);
			assertEquals(team, character.getTeam(), "Incorrect Team for Level 2 Character");
		}
	}

	@Nested
	class TestCharacterLevel3 extends TestCharacter {

		public Character getCharacter() {
			Character character = new Character("Level 3", 10, 8, 6, 4); 
			character.increaseEP(10);
			character.increaseEP(28);
			return character;
		}
		
		/**
		 * Test {@link Character#getName()}.
		 */
		@Test
		@DisplayName("Test Level 3 Character's getName()")
		public void testCharacter_Level3_getName() {
			assertEquals("Level 3", character.getName(), "Incorrect name for Level 3 Character");
		}
	
		/**
		 * Test {@link Character#getMaxHP()}.
		 */
		@Test
		@DisplayName("Test Level 3 Character's getMaxHP()")
		public void testCharacter_Level3_getMaxHP() {
			assertEquals(37, character.getMaxHP(), "Incorrect max HP for Level 3 Character");
		}

		/**
		 * Test {@link Character#getAttack()}.
		 */
		@Test
		@DisplayName("Test Level 3 Character's getAttack()")
		public void testCharacter_Level3_getAttack() {
			assertEquals(30, character.getAttack(), "Incorrect attack for Level 3 Character");
		}

		/**
		 * Test {@link Character#getDefence()}.
		 */
		@Test
		@DisplayName("Test Level 3 Character's getDefence()")
		public void testCharacter_Level3_getDefence() {
			assertEquals(22, character.getDefence(), "Incorrect defence for Level 3 Character");
		}

		/**
		 * Test {@link Character#getSpeed()}.
		 */
		@Test
		@DisplayName("Test Level 3 Character's getSpeed()")
		public void testCharacter_Level3_getSpeed() {
			assertEquals(15, character.getSpeed(), "Incorrect speed for Level 3 Character");
		}

		/**
		 * Test {@link Character#getTargetEP()}.
		 */
		@Test
		@DisplayName("Test Level 3 Character's getTargetEP()")
		public void testCharacter_Level3_getTargetEP() {
			assertEquals(52, character.getTargetEP(), "Incorrect target EP for Level 3 Character");
		}

		/**
		 * Test {@link Character#getHP()}.
		 */
		@Test
		@DisplayName("Test Level 3 Character's getHP()")
		public void testCharacter_Level3_getHP() {
			assertEquals(37, character.getHP(), "Incorrect HP for Level 3 Character");
		}

		/**
		 * Test {@link Character#getEP()}.
		 */
		@Test
		@DisplayName("Test Level 3 Character's getEP()")
		public void testCharacter_Level3_getEP() {
			assertEquals(0, character.getEP(), "Incorrect EP for Level 3 Character");
		}

		/**
		 * Test {@link Character#decreaseHP()}.
		 */
		@Test
		@DisplayName("Test Level 3 Character's decreaseHP()")
		public void testCharacter_Level3_decreaseHP() {
			character.decreaseHP(5);
			assertEquals(32, character.getHP(), "Incorrect HP for Level 3 Character");
		}

		/**
		 * Test {@link Character#decreaseHP()}.
		 */
		@Test
		@DisplayName("Test Level 3 Character's decreaseHP() to zero")
		public void testCharacter_Level3_decreaseHPZero() {
			character.decreaseHP(37);
			assertEquals(0, character.getHP(), "Incorrect HP for Level 3 Character");
		}

		/**
		 * Test {@link Character#decreaseHP()}.
		 */
		@Test
		@DisplayName("Test Level 3 Character's decreaseHP() over the limit")
		public void testCharacter_Level3_decreaseHPOver() {
			character.decreaseHP(40);
			assertEquals(0, character.getHP(), "Incorrect HP for Level 3 Character");
		}

		/**
		 * Test {@link Character#increaseHP()}.
		 */
		@Test
		@DisplayName("Test Level 3 Character's increaseHP()")
		public void testCharacter_Level3_increaseHP() {
			character.decreaseHP(5);
			character.increaseHP(2);
			assertEquals(34, character.getHP(), "Incorrect HP for Level 3 Character");
		}

		/**
		 * Test {@link Character#increaseHP()}.
		 */
		@Test
		@DisplayName("Test Level 3 Character's increaseHP() to maximum")
		public void testCharacter_Level3_increaseHPMax() {
			character.decreaseHP(5);
			character.increaseHP(5);
			assertEquals(37, character.getHP(), "Incorrect HP for Level 3 Character");
		}

		/**
		 * Test {@link Character#increaseHP()}.
		 */
		@Test
		@DisplayName("Test Level 3 Character's increaseHP() over the limit")
		public void testCharacter_Level3_increaseHPOver() {
			character.decreaseHP(5);
			character.increaseHP(7);
			assertEquals(37, character.getHP(), "Incorrect HP for Level 3 Character");
		}

		/**
		 * Test {@link Character#increaseEP()}.
		 */
		@Test
		@DisplayName("Test Level 3 Character's increaseEP()")
		public void testCharacter_Level3_increaseEP() {
			character.increaseEP(6);
			assertEquals(6, character.getEP(), "Incorrect EP for Level 3 Character");
		}

		/**
		 * Test {@link Character#increaseEP()}.
		 */
		@Test
		@DisplayName("Test Level 3 Character's increaseEP() to maximum")
		public void testCharacter_Level3_increaseEPMax() {
			character.increaseEP(52);
			assertEquals(0, character.getEP(), "Incorrect EP for Level 3 Character");
		}

		/**
		 * Test {@link Character#increaseEP()}.
		 */
		@Test
		@DisplayName("Test Level 3 Character's increaseEP() over the limit")
		public void testCharacter_Level3_increaseEPOver() {
			character.increaseEP(55);
			assertEquals(0, character.getEP(), "Incorrect EP for Level 3 Character");
		}

		/**
		 * Test {@link Character#setTeam(Team)} and {@link Character#getTeam()}.
		 */
		@Test
		@DisplayName("Test Level 3 Character's setTeam(Team) and getTeam()")
		public void testCharacter_Level3_setTeam_getTeam() {
			character.setTeam(team);
			assertEquals(team, character.getTeam(), "Incorrect Team for Level 3 Character");
		}
	}
	
	private abstract class AbstractTestTeam extends AbstractTestClass {
		/**
		 * We are testing {@link Team} class.
		 */
		protected Class<?> getTestClass() {
			return Team.class;
		}

	}

	@Nested
	class TestTeamSignature extends AbstractTestTeam  {

		/**
		 * Test {@link Team#name}.
		 */
		@Test
		@DisplayName("Test Team's name member variable")
		public void testTeam_name() {
			assertField("", "name");
		}

		/**
		 * Test {@link Team#name}.
		 */
		@Test
		@DisplayName("Test Team's members member variable")
		public void testTeam_members() {
			assertField("", "members", ArrayList.class);
		}

		/**
		 * Test {@link Team#Team(String)}.
		 */
		@Test
		@DisplayName("Test Team's constructor")
		public void testTeam_constructor() {
			assertConstructor("", String.class);
		}
		
		/**
		 * Test {@link Team#getName()}.
		 */
		@Test
		@DisplayName("Test Team's getName() method")
		public void testTeam_getName() {
			assertMethod("", "getName");
		}

		/**
		 * Test {@link Team#getMembers()}.
		 */
		@Test
		@DisplayName("Test Team's getMembers() method")
		public void testTeam_getMembers() {
			assertMethod("", Character[].class, "getMembers");
		} 

		/**
		 * Test {@link Team#addMembers()}.
		 */
		@Test
		@DisplayName("Test Team's addMember() method")
		public void testTeam_addMember() {
			assertMethod("", int.class, "addMember", Character.class);
		} 
	}

	@Nested
	class TestTeam extends AbstractTestTeam {
		
		private Team team;
		private Character character1;
		private Character character2;
		private Character character3;
		private Character character4;
		private Character character5;
		private Character character6;
		
		@BeforeEach
		public void setup() {
			super.setup();
			assertConstructor("", String.class);
			assertMethod("", "getName");
			assertMethod("", Character[].class, "getMembers");
			assertMethod("", int.class, "addMember", Character.class);
			team = new Team("ECS Team");
			character1 = new Character("Character1", 1, 1, 1, 1);
			character2 = new Character("Character2", 2, 2, 2, 2);
			character3 = new Character("Character3", 3, 3, 3, 3);
			character4 = new Character("Character4", 4, 4, 4, 4);
			character5 = new Character("Character5", 5, 5, 5, 5);
			character6 = new Character("Character6", 6, 6, 6, 6);
		}

		/**
		 * Test {@link Character#getName()}.
		 */
		@Test
		@DisplayName("Test Team's getName()")
		public void testTeam_getName() {
			assertEquals("ECS Team", team.getName(), "Incorrect name for Team");
		}

		/**
		 * Test {@link Character#addMember()}.
		 */
		@Test
		@DisplayName("Test Team's addMember()")
		public void testTeam_addMember() {
			assertEquals(1, team.addMember(character1), "Incorrect add Character1");
			assertEquals(2, team.addMember(character2), "Incorrect add Character2");
			assertEquals(3, team.addMember(character3), "Incorrect add Character3");
			assertEquals(4, team.addMember(character4), "Incorrect add Character4");
			assertEquals(5, team.addMember(character5), "Incorrect add Character5");
			assertEquals(-2, team.addMember(character6), "Incorrect add Character6");
			assertEquals(-1, team.addMember(character1), "Incorrect add Character1 again");
		} 
		
		/**
		 * Test {@link Character#getMembers()}.
		 */
		@Test
		@DisplayName("Test Team's getMembers()")
		public void testTeam_getMembers() {
			Character[] members;
			List<Character> memberList;
			team.addMember(character1);
			members = team.getMembers();
			assertEquals(1, members.length, "Incorrect number of members after adding the first member");
			memberList = Arrays.asList(members);
			assertTrue(memberList.contains(character1), "Character1 is not the member after adding Character1");

			team.addMember(character2);
			members = team.getMembers();
			assertEquals(2, members.length, "Incorrect number of members after adding the first member");
			memberList = Arrays.asList(members);
			assertTrue(memberList.contains(character1), "Character1 is not the member after adding Character2");
			assertTrue(memberList.contains(character2), "Character1 is not the member after adding Character2");

			team.addMember(character3);
			members = team.getMembers();
			assertEquals(3, members.length, "Incorrect number of members after adding the first member");
			memberList = Arrays.asList(members);
			assertTrue(memberList.contains(character1), "Character1 is not the member after adding Character2");
			assertTrue(memberList.contains(character2), "Character1 is not the member after adding Character2");
			assertTrue(memberList.contains(character3), "Character1 is not the member after adding Character2");

			team.addMember(character4);
			members = team.getMembers();
			assertEquals(4, members.length, "Incorrect number of members after adding the first member");
			memberList = Arrays.asList(members);
			assertTrue(memberList.contains(character1), "Character1 is not the member after adding Character2");
			assertTrue(memberList.contains(character2), "Character1 is not the member after adding Character2");
			assertTrue(memberList.contains(character3), "Character1 is not the member after adding Character2");
			assertTrue(memberList.contains(character4), "Character1 is not the member after adding Character2");

			team.addMember(character5);
			members = team.getMembers();
			assertEquals(5, members.length, "Incorrect number of members after adding the first member");
			memberList = Arrays.asList(members);
			assertTrue(memberList.contains(character1), "Character1 is not the member after adding Character2");
			assertTrue(memberList.contains(character2), "Character1 is not the member after adding Character2");
			assertTrue(memberList.contains(character3), "Character1 is not the member after adding Character2");
			assertTrue(memberList.contains(character4), "Character1 is not the member after adding Character2");
			assertTrue(memberList.contains(character5), "Character1 is not the member after adding Character2");

			team.addMember(character6);
			members = team.getMembers();
			assertEquals(5, members.length, "Incorrect number of members after adding the first member");
			memberList = Arrays.asList(members);
			assertTrue(memberList.contains(character1), "Character1 is not the member after adding Character2");
			assertTrue(memberList.contains(character2), "Character1 is not the member after adding Character2");
			assertTrue(memberList.contains(character3), "Character1 is not the member after adding Character2");
			assertTrue(memberList.contains(character4), "Character1 is not the member after adding Character2");
			assertTrue(memberList.contains(character5), "Character1 is not the member after adding Character2");

			team.addMember(character1);
			members = team.getMembers();
			assertEquals(5, members.length, "Incorrect number of members after adding the first member");
			memberList = Arrays.asList(members);
			assertTrue(memberList.contains(character1), "Character1 is not the member after adding Character2");
			assertTrue(memberList.contains(character2), "Character1 is not the member after adding Character2");
			assertTrue(memberList.contains(character3), "Character1 is not the member after adding Character2");
			assertTrue(memberList.contains(character4), "Character1 is not the member after adding Character2");
			assertTrue(memberList.contains(character5), "Character1 is not the member after adding Character2");
		}
	} 

}