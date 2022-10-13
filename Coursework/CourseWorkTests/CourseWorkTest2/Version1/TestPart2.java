import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

/**
 * Unit Tests for Part 2 of Coursework.
 * 
 * @author htson - v1.2 - Put the characters in a team
 * @version 1.2
 */
public class TestPart2 {

	/**
	 * Abstract test class for {@link Character}.
	 * 
	 * @author htson
	 * @version 1.0
	 * @see AbstractTestClass
	 */
	private abstract class AbstractTestCharacter extends AbstractTestClass {
		/**
		 * We are testing {@link Character} class.
		 */
		protected Class<?> getTestClass() {
			return Character.class;
		}
	}

	/**
	 * Test for {@link Character}'s signature.
	 * 
	 * @author htson
	 * @version 1.0
	 * @see AbstractTestCharacter
	 */
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

	/**
	 * Abstract test class for {@link Character}'s functionality.
	 * 
	 * @author htson
	 * @version 1.0
	 * @see AbstractTestCharacter
	 */
	private abstract class TestCharacter extends AbstractTestCharacter {

		// The character under test
		protected Character character;

		// The team for testing
		protected Team team;

		/**
		 * Assert the signature of the classes for testing and create the objects under
		 * test.
		 */
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

		/**
		 * Create the character under test.
		 * 
		 * @return the character under test.
		 */
		public abstract Character getCharacter();
	}

	/**
	 * Test class for Level 1 {@link Character}'s functionality.
	 * 
	 * @author htson
	 * @version 1.0
	 * @see TestCharacter
	 */
	@Nested
	class TestCharacterLevel1 extends TestCharacter {

		/**
		 * Get a Level 1 Character(10, 8, 6, 4)
		 */
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

	/**
	 * Test class for Level 2 {@link Character}'s functionality.
	 * 
	 * @author htson
	 * @version 1.0
	 * @see TestCharacter
	 */
	@Nested
	class TestCharacterLevel2 extends TestCharacter {

		/**
		 * Get a Level 2 Character(10, 8, 6, 4)
		 */
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

	/**
	 * Test class for Level 3 {@link Character}'s functionality.
	 * 
	 * @author htson
	 * @version 1.0
	 * @see TestCharacter
	 */
	@Nested
	class TestCharacterLevel3 extends TestCharacter {

		/**
		 * Get a Level 3 Character(10, 8, 6, 4)
		 */
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

	/**
	 * Abstract Test class for {@link Team}.
	 * 
	 * @author htson
	 * @version 1.0
	 * @see AbstractTestClass
	 */
	private abstract class AbstractTestTeam extends AbstractTestClass {
		/**
		 * We are testing {@link Team} class.
		 */
		protected Class<?> getTestClass() {
			return Team.class;
		}

	}

	/**
	 * Test class {@link Team}'s signature.
	 * 
	 * @author htson
	 * @version 1.0
	 * @see AbstractTestTeam
	 */
	@Nested
	class TestTeamSignature extends AbstractTestTeam {

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

	/**
	 * Test class {@link Team}'s functionalities.
	 * 
	 * @author htson
	 * @version 1.0
	 * @see AbstractTestTeam
	 */
	@Nested
	class TestTeam extends AbstractTestTeam {

		// The team under test.
		private Team team;
		
		// The characters under test.
		private Character character1;
		private Character character2;
		private Character character3;
		private Character character4;
		private Character character5;
		private Character character6;

		/**
		 * Assert the signature of the classes for testing and create the objects under
		 * test.
		 */
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
		 * Test {@link Team#getName()}.
		 */
		@Test
		@DisplayName("Test Team's getName()")
		public void testTeam_getName() {
			assertEquals("ECS Team", team.getName(), "Incorrect name for Team");
		}

		/**
		 * Test {@link Team#addMember()}.
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
		 * Test {@link Team#getMembers()}.
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

	/**
	 * Abstract test class for {@link Student}.
	 * 
	 * @author htson
	 * @version 1.0
	 * @see AbstractTestClass
	 */
	private abstract class AbstractTestStudent extends AbstractTestClass {
		/**
		 * We are testing {@link Team} class.
		 */
		protected Class<?> getTestClass() {
			return Student.class;
		}

	}

	/**
	 * Test class for {@link Student}'s signature.
	 * 
	 * @author htson
	 * @version 1.0
	 * @see AbstractTestStudent
	 */
	@Nested
	class TestStudentSignature extends AbstractTestStudent {

		/**
		 * Test {@link Student} inherits {@link Character}.
		 */
		@Test
		@DisplayName("Test Student inherits Character")
		public void testStudent_inheritCharacter() {
			assertAncestorClass("", Character.class);
		}

		/**
		 * Test {@link Student#maxKP}.
		 */
		@Test
		@DisplayName("Test Student's maxKP member variable")
		public void testStudent_maxKP() {
			assertField("", "maxKP");
		}

		/**
		 * Test {@link Student#currentKP}.
		 */
		@Test
		@DisplayName("Test Student's currentKP member variable")
		public void testStudent_currentKP() {
			assertField("", "currentKP");
		}

		/**
		 * Test {@link Student#Student(String, int, int, int, int, int)}.
		 */
		@Test
		@DisplayName("Test Student's constructor")
		public void testStudent_constructor() {
			assertConstructor("", String.class, int.class, int.class, int.class, int.class, int.class);
		}

		/**
		 * Test {@link Student#increaseKP(int)}.
		 */
		@Test
		@DisplayName("Test Student's increaseKP(int)")
		public void testStudent_increaseKP() {
			assertMethod("", "increaseKP", int.class);
		}

		/**
		 * Test {@link Student#javaProgramming(Character)}.
		 */
		@Test
		@DisplayName("Test Student's javaProgramming(Character)")
		public void testStudent_javaProgramming() {
			assertMethod("", "javaProgramming", Character.class);
		}

		/**
		 * Test {@link Student#selfStudy}.
		 */
		@Test
		@DisplayName("Test Student's selfStudy")
		public void testStudent_selfStudy() {
			assertMethod("", "selfStudy");
		}

	}

	/**
	 * Abstract test class for {@link AIStudent}.
	 * 
	 * @author htson
	 * @version 1.0
	 * @see AbstractTestClass
	 */
	private abstract class AbstractTestAIStudent extends AbstractTestClass {
		/**
		 * We are testing {@link Team} class.
		 */
		protected Class<?> getTestClass() {
			return AIStudent.class;
		}

	}

	/**
	 * Test class for {@link AIStudent}'s signature.
	 * 
	 * @author htson
	 * @version 1.0
	 * @see AbstractTestAIStudent
	 */
	@Nested
	class TestAIStudentSignature extends AbstractTestAIStudent {

		/**
		 * Test {@link AIStudent} inherits {@link Student}.
		 */
		@Test
		@DisplayName("Test AIStudent inherits Student")
		public void testAIStudent_inheritStudent() {
			assertAncestorClass("", Student.class);
		}

		/**
		 * Test {@link AIStudent#AIStudent(String)}.
		 */
		@Test
		@DisplayName("Test AIStudent's constructor")
		public void testAIStudent_constructor() {
			assertConstructor("", String.class);
		}

		/**
		 * Test {@link AIStudent#machineLearning(Character)}.
		 */
		@Test
		@DisplayName("Test AIStudent's machineLearning")
		public void testAIStudent_machineLearning() {
			assertMethod("", "machineLearning", Character.class);
		}

		/**
		 * Test {@link AIStudent#naturalLanguageProcessing()}.
		 */
		@Test
		@DisplayName("Test AIStudent's naturalLanguageProcessing")
		public void testAIStudent_naturalLanguageProcessing() {
			assertMethod("", "naturalLanguageProcessing");
		}
	}

	/**
	 * Test class for {@link AIStudent}'s functionality.
	 * 
	 * @author htson
	 * @version 1.0
	 * @see AbstractTestAIStudent
	 */
	@Nested
	class TestAIStudent extends AbstractTestAIStudent {

		// The student under test
		private AIStudent student;

		// The enemy under test
		private Student enemy1;
		
		// The teams under test
		private Team enemyTeam;
		private Team studentTeam;
		
		/**
		 * Assert the signature of the classes for testing and create the objects under
		 * test.
		 */
		@BeforeEach
		public void setup() {
			super.setup();
			assertMethod(Student.class, "", "increaseKP", int.class);
			assertMethod(Student.class, "", "javaProgramming", Character.class);
			assertMethod(Student.class, "", "selfStudy");
			assertConstructor("", String.class);
			assertMethod("", "machineLearning", Character.class);
			assertMethod("", "naturalLanguageProcessing");
			student = new AIStudent("AI Student");
			studentTeam = new Team("ECS Team");
			studentTeam.addMember(student);
			student.setTeam(studentTeam);
			enemy1 = new AIStudent("Enemy1");
			enemyTeam = new Team("Enemy");
			enemyTeam.addMember(enemy1);
			enemy1.setTeam(enemyTeam);
		}

		/**
		 * Test {@link AIStudent#getMaxHP()}.
		 */
		@Test
		@DisplayName("Test AIStudent's getMaxHP()")
		public void testAIStudent_getMaxHP() {
			assertEquals(6, student.getMaxHP(), "Incorrect max HP for Level 1 AIStudent");
		}

		/**
		 * Test {@link AIStudent#getAttack()}.
		 */
		@Test
		@DisplayName("Test AIStudent's getAttack()")
		public void testAIStudent_getAttack() {
			assertEquals(7, student.getAttack(), "Incorrect attack for Level 1 AIStudent");
		}

		/**
		 * Test {@link AIStudent#getDefence()}.
		 */
		@Test
		@DisplayName("Test AIStudent's getDefence()")
		public void testAIStudent_getDefence() {
			assertEquals(7, student.getDefence(), "Incorrect defence for Level 1 AIStudent");
		}

		/**
		 * Test {@link AIStudent#getSpeed()}.
		 */
		@Test
		@DisplayName("Test AIStudent's getSpeed()")
		public void testAIStudent_getSpeed() {
			assertEquals(5, student.getSpeed(), "Incorrect speed for Level 1 AIStudent");
		}

		/**
		 * Test {@link AIStudent#javaProgramming()}.
		 */
		@Test
		@DisplayName("Test AIStudent's javaProgramming()")
		public void testAIStudent_javaProgramming() {
			student.javaProgramming(enemy1);
			assertEquals(7, student.getEP(), "Incorrect EP for AIStudent after the first Java Programming attack");
			assertEquals(0, enemy1.getHP(), "Incorrect HP for enemy1 after Java Programming attack by AI student");
			assertEquals(2, enemy1.getEP(), "Incorrect EP for enemy1 after Java Programming attack by AI student");
		}

		/**
		 * Test {@link AIStudent#selfStudy()}.
		 */
		@Test
		@DisplayName("Test AIStudent's selfStudy()")
		public void testAIStudent_selfStudy() {
			student.decreaseHP(4);
			student.selfStudy();
			assertEquals(4, student.getHP(), "Incorrect HP for AIStudent after selfStudy");
			assertEquals(6, student.getEP(), "Incorrect EP for AIStudent after selfStudy");
		}

		/**
		 * Test {@link AIStudent#machineLearning(Character)}.
		 */
		@Test
		@DisplayName("Test AIStudent's machineLearning(Character)")
		public void testAIStudent_machineLearning() {
			student.selfStudy();
			student.selfStudy();
			assertEquals(14, student.getHP(), "Incorrect HP for AIStudent before using machine learning");
			assertEquals(16, student.getAttack(), "Incorrect Attack for AIStudent before using machine learning");
			assertEquals(0, student.getEP(), "Incorrect EP for AIStudent before using machine learning");
			try {
				student.machineLearning(enemy1);
				assertEquals(8, student.getEP(), "Incorrect EP for AIStudent after using machine learning");
				assertEquals(0, enemy1.getHP(), "Incorrect HP for Enemy1 after machine learning attack by AIStudent");
				assertEquals(0, enemy1.getEP(),
						"Incorrect EP for Enemy1 after machine learning attack by AIStudent");
			} catch (Exception e) {
				fail("AI Students should have sufficient KPs");
			}
		}

		/**
		 * Test {@link AIStudent#machineLearning(Character)}.
		 */
		@Test
		@DisplayName("Test AIStudent's machineLearning(Character) (Not enough KPs)")
		public void testAIStudent_machineLearningException() {
			assertThrows(Exception.class, () -> {
				student.machineLearning(enemy1);
			}, "Cannot use machine learning skill (not enough KPs)");
		}

		/**
		 * Test {@link AIStudent#naturalLanguageProcessing()}.
		 */
		@Test
		@DisplayName("Test AIStudent's naturalLanguageProcessing()")
		public void testAIStudent_naturalLanguageProcessing() {
			student.selfStudy();
			student.selfStudy();
			assertEquals(14, student.getHP(), "Incorrect HP for AIStudent before using natural language processing");
			assertEquals(16, student.getAttack(),
					"Incorrect Attack for AIStudent before using natural language processing");
			assertEquals(0, student.getEP(), "Incorrect EP for AIStudent before using natural language processing");
			student.decreaseHP(10);
			try {
				student.naturalLanguageProcessing();
				assertEquals(14, student.getHP(), "Incorrect HP for AIStudent after using natural language processing");
			} catch (Exception e) {
				fail("AI Students should have sufficient KPs");
			}
		}

		/**
		 * Test {@link AIStudent#naturalLanguageProcessing()}.
		 */
		@Test
		@DisplayName("Test AIStudent's naturalLanguageProcessing() (Not enough KPs)")
		public void testAIStudent_naturalLanguageProcessingException() {
			assertThrows(Exception.class, () -> {
				student.naturalLanguageProcessing();
			}, "Cannot use natural language skill (not enough KPs)");
		}
	}

	/**
	 * Abstract test class for {@link CSStudent}.
	 * 
	 * @author htson
	 * @version 1.0
	 * @see AbstractTestClass
	 */
	private abstract class AbstractTestCSStudent extends AbstractTestClass {
		/**
		 * We are testing {@link Team} class.
		 */
		protected Class<?> getTestClass() {
			return CSStudent.class;
		}

	}

	/**
	 * Test class for {@link CSStudent}'s signature.
	 * 
	 * @author htson
	 * @version 1.0
	 * @see AbstractTestCSStudent
	 */
	@Nested
	class TestCSStudentSignature extends AbstractTestCSStudent {

		/**
		 * Test {@link CSStudent} inherits {@link Student}.
		 */
		@Test
		@DisplayName("Test CSStudent inherits Student")
		public void testCSStudent_inheritStudent() {
			assertAncestorClass("", Student.class);
		}

		/**
		 * Test {@link CSStudent#CSStudent(String)}.
		 */
		@Test
		@DisplayName("Test CSStudent's constructor")
		public void testCSStudent_constructor() {
			assertConstructor("", String.class);
		}

		/**
		 * Test {@link CSStudent#pairWorking(Character)}.
		 */
		@Test
		@DisplayName("Test CSStudent's pairWorking")
		public void testCSStudent_pairWorking() {
			assertMethod("", "pairWorking", Character.class, Character.class);
		}

		/**
		 * Test {@link CSStudent#support(Character)}.
		 */
		@Test
		@DisplayName("Test CSStudent's support(Character)")
		public void testCSStudent_support() {
			assertMethod("", "support", Character.class);
		}
	}

	/**
	 * Test class for {@link CSStudent}'s functionality.
	 * 
	 * @author htson
	 * @version 1.0
	 * @see AbstractTestCSStudent
	 */
	@Nested
	class TestCSStudent extends AbstractTestCSStudent {

		// Students under test
		private CSStudent student;
		private CSStudent friend;

		// Enemies under test
		private Student enemy1;

		// The teams under test
		private Team enemyTeam;
		private Team studentTeam;
		
		/**
		 * Assert the signature of the classes for testing and create the objects under
		 * test.
		 */
		@BeforeEach
		public void setup() {
			super.setup();
			assertMethod(Student.class, "", "increaseKP", int.class);
			assertMethod(Student.class, "", "javaProgramming", Character.class);
			assertMethod(Student.class, "", "selfStudy");
			assertConstructor("", String.class);
			assertMethod("", "pairWorking", Character.class, Character.class);
			assertMethod("", "support", Character.class);
			student = new CSStudent("CSStudent");
			friend = new CSStudent("Friend");
			studentTeam = new Team("ECS Team");
			studentTeam.addMember(student);
			student.setTeam(studentTeam);
			studentTeam.addMember(friend);
			friend.setTeam(studentTeam);
			enemy1 = new CSStudent("Enemy1");
			enemyTeam = new Team("Enemy");
			enemyTeam.addMember(enemy1);
			enemy1.setTeam(enemyTeam);
		}

		/**
		 * Test {@link CSStudent#getMaxHP()}.
		 */
		@Test
		@DisplayName("Test CSStudent's getMaxHP()")
		public void testCSStudent_getMaxHP() {
			assertEquals(7, student.getMaxHP(), "Incorrect max HP for Level 1 CSStudent");
		}

		/**
		 * Test {@link CSStudent#getAttack()}.
		 */
		@Test
		@DisplayName("Test CSStudent's getAttack()")
		public void testCSStudent_getAttack() {
			assertEquals(6, student.getAttack(), "Incorrect attack for Level 1 CSStudent");
		}

		/**
		 * Test {@link CSStudent#getDefence()}.
		 */
		@Test
		@DisplayName("Test CSStudent's getDefence()")
		public void testCSStudent_getDefence() {
			assertEquals(6, student.getDefence(), "Incorrect defence for Level 1 CSStudent");
		}

		/**
		 * Test {@link CSStudent#getSpeed()}.
		 */
		@Test
		@DisplayName("Test CSStudent's getSpeed()")
		public void testCSStudent_getSpeed() {
			assertEquals(6, student.getSpeed(), "Incorrect speed for Level 1 CSStudent");
		}

		/**
		 * Test {@link CSStudent#javaProgramming()}.
		 */
		@Test
		@DisplayName("Test CSStudent's javaProgramming()")
		public void testCSStudent_javaProgramming() {
			student.javaProgramming(enemy1);
			assertEquals(3, student.getEP(), "Incorrect EP for CSStudent after the first Java Programming attack");
			assertEquals(2, enemy1.getHP(), "Incorrect HP for enemy1 after Java Programming attack by CS student");
			assertEquals(2, enemy1.getEP(), "Incorrect EP for enemy1 after Java Programming attack by CS student");
		}

		/**
		 * Test {@link CSStudent#selfStudy()}.
		 */
		@Test
		@DisplayName("Test CSStudent's selfStudy()")
		public void testCSStudent_selfStudy() {
			student.decreaseHP(4);
			student.selfStudy();
			assertEquals(5, student.getHP(), "Incorrect HP for CSStudent after selfStudy");
			assertEquals(6, student.getEP(), "Incorrect EP for CSStudent after selfStudy");
		}

		/**
		 * Test {@link CSStudent#pairWorking(Character, Character)}.
		 */
		@Test
		@DisplayName("Test CSStudent's pairWorking(Character, Character)")
		public void testCSStudent_pairWorking() {
			student.selfStudy();
			student.selfStudy();
			assertEquals(16, student.getHP(), "Incorrect HP for CSStudent before using pair working");
			assertEquals(14, student.getAttack(), "Incorrect Attack for CSStudent before using pair working");
			assertEquals(0, student.getEP(), "Incorrect EP for CSStudent before using pair working");
			try {
				student.pairWorking(friend, enemy1);
				assertEquals(8, student.getEP(), "Incorrect EP for CSStudent after using pair working");
				assertEquals(0, enemy1.getHP(), "Incorrect HP for Enemy2 after pair working attack by CSStudent");
				assertEquals(0, enemy1.getEP(),
						"Incorrect EP for Enemy2 after pair working attack by CSStudent");
			} catch (Exception e) {
				fail("CS Students should have sufficient KPs");
			}
		}

		/**
		 * Test {@link CSStudent#pairWorking(Character, Character)}.
		 */
		@Test
		@DisplayName("Test CSStudent's pairWorking(Character, Character) (Not enough KPs)")
		public void testCSStudent_pairWorkingException() {
			assertThrows(Exception.class, () -> {
				student.pairWorking(friend, enemy1);
			}, "Cannot use pair working skill (not enough KPs)");
		}

		/**
		 * Test {@link CSStudent#support(Character)}.
		 */
		@Test
		@DisplayName("Test CSStudent's support(Character)")
		public void testCSStudent_support() {
			student.selfStudy();
			student.selfStudy();
			assertEquals(16, student.getHP(), "Incorrect HP for CSStudent before using support");
			assertEquals(14, student.getAttack(), "Incorrect Attack for CSStudent before using support");
			assertEquals(14, student.getDefence(), "Incorrect Defence for CSStudent before using support");
			assertEquals(0, student.getEP(), "Incorrect EP for CSStudent before using support");
			friend.decreaseHP(4);
			try {
				student.support(friend);
				assertEquals(7, friend.getHP(), "Incorrect HP for CSStudent after using natural language processing");
			} catch (Exception e) {
				fail("CS Students should have sufficient KPs");
			}
		}

		/**
		 * Test {@link CSStudent#support()}.
		 */
		@Test
		@DisplayName("Test CSStudent's support() (Not enough KPs)")
		public void testCSStudent_supportException() {
			assertThrows(Exception.class, () -> {
				student.support(friend);
			}, "Cannot use support skill (not enough KPs)");
		}
	}

	/**
	 * Abstract test class for {@link CyberStudent}.
	 * 
	 * @author htson
	 * @version 1.0
	 * @see AbstractTestClass
	 */
	private abstract class AbstractTestCyberStudent extends AbstractTestClass {
		/**
		 * We are testing {@link Team} class.
		 */
		protected Class<?> getTestClass() {
			return CyberStudent.class;
		}

	}

	/**
	 * Test class for {@link CyberStudent}'s signature.
	 * 
	 * @author htson
	 * @version 1.0
	 * @see AbstractTestCyberStudent
	 */
	@Nested
	class TestCyberStudentSignature extends AbstractTestCyberStudent {

		/**
		 * Test {@link CyberStudent} inherits {@link Student}.
		 */
		@Test
		@DisplayName("Test CyberStudent inherits Student")
		public void testCyberStudent_inheritStudent() {
			assertAncestorClass("", Student.class);
		}

		/**
		 * Test {@link CyberStudent#CyberStudent(String)}.
		 */
		@Test
		@DisplayName("Test CyberStudent's constructor")
		public void testCyberStudent_constructor() {
			assertConstructor("", String.class);
		}

		/**
		 * Test {@link CyberStudent#cyberAttack(Character)}.
		 */
		@Test
		@DisplayName("Test CyberStudent's cyberAttack")
		public void testCyberStudent_cyberAttack() {
			assertMethod("", "cyberAttack", Team.class);
		}

	}

	/**
	 * Test class for {@link CyberStudent}'s functionality.
	 * 
	 * @author htson
	 * @version 1.0
	 * @see AbstractTestCyberStudent
	 */
	@Nested
	class TestCyberStudent extends AbstractTestCyberStudent {

		// The student under test.
		private CyberStudent student;

		// The enemy under test.
		private Student enemy1;
		private Student enemy2;
		private Student enemy3;

		// The teams under test
		private Team enemyTeam;
		private Team studentTeam;

		/**
		 * Assert the signature of the classes for testing and create the objects under
		 * test.
		 */
		@BeforeEach
		public void setup() {
			super.setup();
			assertMethod(Student.class, "", "increaseKP", int.class);
			assertMethod(Student.class, "", "javaProgramming", Character.class);
			assertMethod(Student.class, "", "selfStudy");
			assertConstructor("", String.class);
			assertMethod("", "cyberAttack", Team.class);
			student = new CyberStudent("CyberStudent");
			studentTeam = new Team("ECS Team");
			studentTeam.addMember(student);
			student.setTeam(studentTeam);
			enemy1 = new CyberStudent("Enemy1");
			enemy2 = new CyberStudent("Enemy2");
			enemy3 = new CyberStudent("Enemy3");
			enemyTeam = new Team("Enemy");
			enemyTeam.addMember(enemy1);
			enemy1.setTeam(enemyTeam);
			enemyTeam.addMember(enemy2);
			enemy2.setTeam(enemyTeam);
			enemyTeam.addMember(enemy3);
			enemy3.setTeam(enemyTeam);
		}

		/**
		 * Test {@link CyberStudent#getMaxHP()}.
		 */
		@Test
		@DisplayName("Test CyberStudent's getMaxHP()")
		public void testCyberStudent_getMaxHP() {
			assertEquals(7, student.getMaxHP(), "Incorrect max HP for Level 1 CyberStudent");
		}

		/**
		 * Test {@link CyberStudent#getAttack()}.
		 */
		@Test
		@DisplayName("Test CyberStudent's getAttack()")
		public void testCyberStudent_getAttack() {
			assertEquals(7, student.getAttack(), "Incorrect attack for Level 1 CyberStudent");
		}

		/**
		 * Test {@link CyberStudent#getDefence()}.
		 */
		@Test
		@DisplayName("Test CyberStudent's getDefence()")
		public void testCyberStudent_getDefence() {
			assertEquals(5, student.getDefence(), "Incorrect defence for Level 1 CyberStudent");
		}

		/**
		 * Test {@link CyberStudent#getSpeed()}.
		 */
		@Test
		@DisplayName("Test CyberStudent's getSpeed()")
		public void testCyberStudent_getSpeed() {
			assertEquals(6, student.getSpeed(), "Incorrect speed for Level 1 CyberStudent");
		}

		/**
		 * Test {@link CyberStudent#javaProgramming()}.
		 */
		@Test
		@DisplayName("Test CyberStudent's javaProgramming()")
		public void testCyberStudent_javaProgramming() {
			student.javaProgramming(enemy1);
			assertEquals(3, student.getEP(), "Incorrect EP for CyberStudent after the first Java Programming attack");
			assertEquals(1, enemy1.getHP(), "Incorrect HP for enemy1 after Java Programming attack by Cyber student");
			assertEquals(2, enemy1.getEP(), "Incorrect EP for enemy1 after Java Programming attack by Cyber student");
		}

		/**
		 * Test {@link CyberStudent#selfStudy()}.
		 */
		@Test
		@DisplayName("Test CyberStudent's selfStudy()")
		public void testCyberStudent_selfStudy() {
			student.decreaseHP(4);
			student.selfStudy();
			assertEquals(5, student.getHP(), "Incorrect HP for CyberStudent after selfStudy");
			assertEquals(6, student.getEP(), "Incorrect EP for CyberStudent after selfStudy");
		}

		/**
		 * Test {@link CyberStudent#cyberAttack(Team)}.
		 */
		@Test
		@DisplayName("Test CyberStudent's cyberAttack(Team)")
		public void testCyberStudent_cyberAttack() {
			student.selfStudy();
			student.selfStudy();
			student.selfStudy();
			assertEquals(16, student.getHP(), "Incorrect HP for CyberStudent before using cyber attack");
			assertEquals(16, student.getAttack(), "Incorrect Attack for CyberStudent before using cyber attack");
			assertEquals(6, student.getEP(), "Incorrect EP for CyberStudent before using cyber attack");
			try {
				student.cyberAttack(enemyTeam);
				assertEquals(22, student.getEP(), "Incorrect EP for CyberStudent after using pair working");
				assertEquals(0, enemy1.getHP(), "Incorrect HP for Enemy2 after pair working attack by CyberStudent");
				assertEquals(0, enemy2.getHP(), "Incorrect HP for Enemy2 after pair working attack by CyberStudent");
				assertEquals(0, enemy3.getHP(), "Incorrect HP for Enemy2 after pair working attack by CyberStudent");
			} catch (Exception e) {
				fail("Cyber Students should have sufficient KPs");
			}
		}

		/**
		 * Test {@link CyberStudent#cyberAttack(Team)}.
		 */
		@Test
		@DisplayName("Test CyberStudent's cyberAttack(Team) (Not enough KPs)")
		public void testCyberStudent_cyberAttackException() {
			assertThrows(Exception.class, () -> {
				student.cyberAttack(enemyTeam);
			}, "Cannot use cyber attack skill (not enough KPs)");
		}

	}

	/**
	 * Abstract test class for {@link SEStudent}.
	 * 
	 * @author htson
	 * @version 1.0
	 * @see AbstractTestClass
	 */
	private abstract class AbstractTestSEStudent extends AbstractTestClass {
		/**
		 * We are testing {@link Team} class.
		 */
		protected Class<?> getTestClass() {
			return SEStudent.class;
		}

	}

	/**
	 * Test class for {@link SEStudent}'s signature.
	 * 
	 * @author htson
	 * @version 1.0
	 * @see AbstractTestSEStudent
	 */
	@Nested
	class TestSEStudentSignature extends AbstractTestSEStudent {

		/**
		 * Test {@link SEStudent} inherits {@link Student}.
		 */
		@Test
		@DisplayName("Test SEStudent inherits Student")
		public void testSEStudent_inheritStudent() {
			assertAncestorClass("", Student.class);
		}

		/**
		 * Test {@link SEStudent#SEStudent(String)}.
		 */
		@Test
		@DisplayName("Test SEStudent's constructor")
		public void testSEStudent_constructor() {
			assertConstructor("", String.class);
		}

		/**
		 * Test {@link SEStudent#groupWork(Character)}.
		 */
		@Test
		@DisplayName("Test SEStudent's groupWork(Character)")
		public void testSEStudent_groupWork() {
			assertMethod("", "groupWork", Character.class);
		}

		/**
		 * Test {@link SEStudent#groupDiscussion()}.
		 */
		@Test
		@DisplayName("Test SEStudent's groupDiscussion()")
		public void testSEStudent_groupDiscussion() {
			assertMethod("", "groupDiscussion");
		}
	}

	/**
	 * Test class for {@link SEStudent}'s functionality.
	 * 
	 * @author htson
	 * @version 1.0
	 * @see AbstractTestSEStudent
	 */
	@Nested
	class TestSEStudent extends AbstractTestSEStudent {

		// The student under test.
		private SEStudent student;

		// The friends under test.
		private Student friend1;
		private Student friend2;

		// The enemies under test.
		private Student enemy1;
		private Student enemy2;
		private Student enemy3;

		// The teams under test
		private Team enemyTeam;
		private Team studentTeam;

		/**
		 * Assert the signature of the classes for testing and create the objects under
		 * test.
		 */
		@BeforeEach
		public void setup() {
			super.setup();
			assertMethod(Student.class, "", "increaseKP", int.class);
			assertMethod(Student.class, "", "javaProgramming", Character.class);
			assertMethod(Student.class, "", "selfStudy");
			assertConstructor("", String.class);
			assertMethod("", "groupWork", Character.class);
			assertMethod("", "groupDiscussion");
			student = new SEStudent("SEStudent");
			friend1 = new SEStudent("Friend 1");
			friend2 = new SEStudent("Friend 2");
			studentTeam = new Team("ECS Team");
			studentTeam.addMember(student);
			student.setTeam(studentTeam);
			studentTeam.addMember(friend1);
			friend1.setTeam(studentTeam);
			studentTeam.addMember(friend2);
			friend2.setTeam(studentTeam);
			enemy1 = new Student("Enemy1", 10, 10, 10, 10, 5);
			enemy2 = new Student("Enemy2", 20, 10, 10, 10, 5);
			enemy3 = new Student("Enemy3", 30, 10, 10, 10, 5);
			enemyTeam = new Team("Enemy");
			enemyTeam.addMember(enemy1);
			enemy1.setTeam(enemyTeam);
			enemyTeam.addMember(enemy2);
			enemy2.setTeam(enemyTeam);
			enemyTeam.addMember(enemy3);
			enemy3.setTeam(enemyTeam);
		}

		/**
		 * Test {@link SEStudent#getMaxHP()}.
		 */
		@Test
		@DisplayName("Test SEStudent's getMaxHP()")
		public void testSEStudent_getMaxHP() {
			assertEquals(8, student.getMaxHP(), "Incorrect max HP for Level 1 SEStudent");
		}

		/**
		 * Test {@link SEStudent#getAttack()}.
		 */
		@Test
		@DisplayName("Test SEStudent's getAttack()")
		public void testSEStudent_getAttack() {
			assertEquals(5, student.getAttack(), "Incorrect attack for Level 1 SEStudent");
		}

		/**
		 * Test {@link SEStudent#getDefence()}.
		 */
		@Test
		@DisplayName("Test SEStudent's getDefence()")
		public void testSEStudent_getDefence() {
			assertEquals(8, student.getDefence(), "Incorrect defence for Level 1 SEStudent");
		}

		/**
		 * Test {@link SEStudent#getSpeed()}.
		 */
		@Test
		@DisplayName("Test SEStudent's getSpeed()")
		public void testSEStudent_getSpeed() {
			assertEquals(4, student.getSpeed(), "Incorrect speed for Level 1 SEStudent");
		}

		/**
		 * Test {@link SEStudent#javaProgramming()}.
		 */
		@Test
		@DisplayName("Test SEStudent's javaProgramming()")
		public void testSEStudent_javaProgramming() {
			student.javaProgramming(enemy1);
			assertEquals(3, student.getEP(), "Incorrect EP for SEStudent after the first Java Programming attack");
			assertEquals(6, enemy1.getHP(), "Incorrect HP for enemy1 after Java Programming attack by SE student");
			assertEquals(2, enemy1.getEP(), "Incorrect EP for enemy1 after Java Programming attack by SE student");
		}

		/**
		 * Test {@link SEStudent#selfStudy()}.
		 */
		@Test
		@DisplayName("Test SEStudent's selfStudy()")
		public void testSEStudent_selfStudy() {
			student.decreaseHP(4);
			student.selfStudy();
			assertEquals(6, student.getHP(), "Incorrect HP for SEStudent after selfStudy");
			assertEquals(6, student.getEP(), "Incorrect EP for SEStudent after selfStudy");
		}

		/**
		 * Test {@link SEStudent#groupWork(Character)}.
		 */
		@Test
		@DisplayName("Test SEStudent's groupWork(Character)")
		public void testSEStudent_groupWork() {
			student.selfStudy();
			student.selfStudy();
			student.selfStudy();
			student.selfStudy();
			student.selfStudy();
			assertEquals(18, student.getHP(), "Incorrect HP for SEStudent before using group work");
			assertEquals(11, student.getAttack(), "Incorrect Attack for SEStudent before using group work");
			assertEquals(18, student.getEP(), "Incorrect EP for SEStudent before using group work");
			try {
				student.groupWork(enemy2);
				assertEquals(22, student.getEP(), "Incorrect EP for Student after using group work");
				assertEquals(2, enemy2.getHP(), "Incorrect HP for Enemy2 after group work attack by Student");
			} catch (Exception e) {
				fail(" Students should have sufficient KPs");
			}
		}

		/**
		 * Test {@link Student#groupWork(Character)}.
		 */
		@Test
		@DisplayName("Test Student's groupWork(Character) (Not enough KPs)")
		public void testStudent_groupWorkException() {
			assertThrows(Exception.class, () -> {
				student.groupWork(enemy3);
			}, "Cannot use  attack skill (not enough KPs)");
		}

		/**
		 * Test {@link SEStudent#groupDiscussion()}.
		 */
		@Test
		@DisplayName("Test SEStudent's groupDiscussion()")
		public void testSEStudent_groupDiscussion() {
			student.selfStudy();
			student.selfStudy();
			student.selfStudy();
			student.selfStudy();
			student.selfStudy();
			assertEquals(18, student.getHP(), "Incorrect HP for SEStudent before using group discussion");
			assertEquals(11, student.getAttack(), "Incorrect Attack for SEStudent before using group discussion");
			assertEquals(18, student.getDefence(), "Incorrect Defence for SEStudent before using group discussion");
			assertEquals(18, student.getEP(), "Incorrect EP for SEStudent before using group discussion");
			student.decreaseHP(17);
			friend1.decreaseHP(7);
			friend2.decreaseHP(8);
			try {
				student.groupDiscussion();
				assertEquals(22, student.getEP(), "Incorrect EP for Student after using group discussion");
				assertEquals(10, student.getHP(), "Incorrect HP for Student after using group discussion");
				assertEquals(8, friend1.getHP(), "Incorrect HP for Friend1 after group discussion by Student");
				assertEquals(0, friend2.getHP(), "Incorrect HP for Friend2 after group discussion by Student");
			} catch (Exception e) {
				fail(" Students should have sufficient KPs");
			}
		}

		/**
		 * Test {@link Student#groupDiscussion(Character)}.
		 */
		@Test
		@DisplayName("Test Student's groupDiscussion(Character) (Not enough KPs)")
		public void testStudent_AttackException() {
			assertThrows(Exception.class, () -> {
				student.groupDiscussion();
			}, "Cannot use  attack skill (not enough KPs)");
		}

	}

}