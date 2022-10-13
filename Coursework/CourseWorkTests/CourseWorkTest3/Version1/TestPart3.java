import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

/**
 * Unit Tests for Part 3 of Coursework.
 * 
 * @author htson - v1.0 - Initial API and implementation
 * @version 1.0
 */
public class TestPart3 {

	/**
	 * Abstract test class for {@link Monster}.
	 * 
	 * @author htson
	 * @version 1.0
	 * @see AbstractTestClass
	 */
	private abstract class AbstractTestMonster extends AbstractTestClass {
		/**
		 * We are testing {@link Monster} interface.
		 */
		protected Class<?> getTestClass() {
			return assertClassOrInterface("Monster");
		}
	}

	/**
	 * Test for {@link Monster}'s signature.
	 * 
	 * @author htson
	 * @version 1.0
	 * @see AbstractTestMonster
	 */
	@Nested
	class TestMonsterSignature extends AbstractTestMonster {

		/**
		 * Test {@link Monster}.
		 */
		@Test
		@DisplayName("Test Monster is an interface")
		public void testMonster_interface() {
			assertInterface();
		}

		/**
		 * Test {@link Monster#strike(Monster)}.
		 */
		@Test
		@DisplayName("Test Monster's strike(Character) method")
		public void testMonster_strike() {
			assertMethod("", "strike", Character.class);
		}
	}

	/**
	 * Abstract test class for {@link Minion}.
	 * 
	 * @author htson
	 * @version 1.0
	 * @see AbstractTestClass
	 */
	private abstract class AbstractTestMinion extends AbstractTestClass {
		/**
		 * We are testing {@link Minion} class.
		 */
		protected Class<?> getTestClass() {
			return assertClassOrInterface("Minion");
		}
	}

	/**
	 * Test for {@link Monster}'s signature.
	 * 
	 * @author htson
	 * @version 1.0
	 * @see AbstractTestMinion
	 */
	@Nested
	class TestMinionSignature extends AbstractTestMinion {

		private Class<?> monsterClass;

		/**
		 * Assert the signature of the classes for testing and create the objects under
		 * test.
		 */
		@BeforeEach
		public void setup() {
			super.setup();
			monsterClass = assertClassOrInterface("Monster");
		}
		
		
		/**
		 * Test {@link Minion}.
		 */
		@Test
		@DisplayName("Test Minion is an class")
		public void testMinion_class() {
			assertClass();
		}

		/**
		 * Test {@link Minion} implements {@link Monster}.
		 */
		@Test
		@DisplayName("Test Minion's implement Monster")
		public void testMinion_implementMonster() {
			assertAncestorInterface("", monsterClass);
		}

		/**
		 * Test {@link Minion} inherits {@link Character}.
		 */
		@Test
		@DisplayName("Test Minion inherits Character")
		public void testMinion_inheritCharacter() {
			assertAncestorClass("", Character.class);
		}

		/**
		 * Test {@link Minion#strike(Monster)}.
		 */
		@Test
		@DisplayName("Test Minion's strike(Character) method")
		public void testMinion_strike() {
			assertMethod("", "strike", Character.class);
		}
	}

	/**
	 * Test class for {@link Minion}'s functionality.
	 * 
	 * @author htson
	 * @version 1.0
	 * @see AbstractTestMinion
	 */
	@Nested
	class TestMinion extends AbstractTestMinion {

		private Object minion;
		private Object monsterTeam;

		private Constructor<?> minionConstructor;
		private Method minionGetNameMethod;
		private Method minionGetMaxHPMethod;
		private Method minionGetAttackMethod;
		private Method minionGetDefenceMethod;
		private Method minionGetSpeedMethod;
		private Method minionGetTargetEPMethod;
		private Method minionGetHPMethod;
		private Method minionGetEPMethod;
		private Method minionIncreaseHPMethod;
		private Method minionDecreaseHPMethod;
		private Method minionIncreaseEPMethod;
		private Method minionSetTeamMethod;
		private Method minionGetTeamMethod;
		private Method minionStrikeMethod;

		private Object enemy1;
		private Object enemy2;
		private Object enemy3;
		private Object enemyTeam;

		/**
		 * Assert the signature of the classes for testing and create the objects under
		 * test.
		 */
		@BeforeEach
		public void setup() {
			super.setup();
			assertClass();
			minionConstructor = assertConstructor("", String.class);
			try {
				minion = minionConstructor.newInstance("Minion");
			} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException e) {
				fail("Cannot invoke constructor Minion(\"Minion\")");
			}
			Class<?> characterClass = assertClassOrInterface("Character");
			Class<?> teamClass = assertClassOrInterface("Team");

			minionStrikeMethod = assertMethod("", "strike", characterClass);
			minionGetNameMethod = assertMethod("", "getName");
			minionGetMaxHPMethod = assertMethod("", "getMaxHP");
			minionGetAttackMethod = assertMethod("", "getAttack");
			minionGetDefenceMethod = assertMethod("", "getDefence");
			minionGetSpeedMethod = assertMethod("", "getSpeed");
			minionGetHPMethod = assertMethod("", "getHP");
			minionGetEPMethod = assertMethod("", "getEP");
			minionIncreaseHPMethod = assertMethod("", "increaseHP", int.class);
			minionDecreaseHPMethod = assertMethod("", "decreaseHP", int.class);
			minionIncreaseEPMethod = assertMethod("", "increaseEP", int.class);
			minionGetTargetEPMethod = assertMethod("", "getTargetEP");
			minionSetTeamMethod = assertMethod("", "setTeam", teamClass);
			minionGetTeamMethod = assertMethod("", "getTeam");

			Constructor<?> teamConstructor = assertConstructor(teamClass, "", String.class);
			Method teamAddMemberMethod = assertMethod(teamClass, "", "addMember", characterClass);

			monsterTeam = null;
			try {
				monsterTeam = teamConstructor.newInstance("Monster Team");
			} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException e) {
				fail("Cannot invoke constructor Team(\"Monster Team\")");
			}
			try {
				teamAddMemberMethod.invoke(monsterTeam, minion);
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				fail("Cannot invoke monsterTeam.addMember(minion)");
			}
			try {
				minionSetTeamMethod.invoke(minion, monsterTeam);
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				fail("Cannot invoke minion.setTeam(monsterTeam)");
			}

			enemyTeam = null;
			try {
				enemyTeam = teamConstructor.newInstance("Enemy Team");
			} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException e) {
				fail("Cannot invoke constructor Team(\"Enemy Team\")");
			}
			try {
				enemy1 = minionConstructor.newInstance("Enemy 1");
			} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException e) {
				fail("Cannot invoke constructor Minion(\"Enemy 1\")");
			}
			try {
				teamAddMemberMethod.invoke(enemyTeam, enemy1);
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				fail("Cannot invoke enemyTeam.addMember(enemy1)");
			}
			try {
				minionSetTeamMethod.invoke(enemy1, enemyTeam);
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				fail("Cannot invoke enemy1.setTeam(enemyTeam)");
			}

			try {
				enemy2 = minionConstructor.newInstance("Enemy 2");
			} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException e) {
				fail("Cannot invoke constructor Minion(\"Enemy 2\")");
			}
			try {
				teamAddMemberMethod.invoke(enemyTeam, enemy2);
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				fail("Cannot invoke enemyTeam.addMember(enemy2)");
			}
			try {
				minionSetTeamMethod.invoke(enemy2, enemyTeam);
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				fail("Cannot invoke enemy2.setTeam(enemyTeam)");
			}

			try {
				enemy3 = minionConstructor.newInstance("Enemy 3");
			} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException e) {
				fail("Cannot invoke constructor Minion(\"Enemy 3\")");
			}
			try {
				teamAddMemberMethod.invoke(enemyTeam, enemy3);
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				fail("Cannot invoke enemyTeam.addMember(enemy3)");
			}
			try {
				minionSetTeamMethod.invoke(enemy3, enemyTeam);
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				fail("Cannot invoke enemy3.setTeam(enemyTeam)");
			}
		}

		/**
		 * Test {@link Minion#getName()}.
		 */
		@Test
		@DisplayName("Test Minion's getName()")
		public void testMinion_getName() {
			try {
				assertEquals("Minion", minionGetNameMethod.invoke(minion), "Incorrect name for Level 1 Minion");
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				fail("Cannot invoke method getName() for Minion");
			}
		}

		/**
		 * Test {@link Minion#getMaxHP()}.
		 */
		@Test
		@DisplayName("Test Minion's getMaxHP()")
		public void testMinion_getMaxHP() {
			try {
				assertEquals(5, minionGetMaxHPMethod.invoke(minion), "Incorrect max HP for Level 1 Minion");
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				fail("Cannot invoke method getMaxHP() for Minion");
			}
		}

		/**
		 * Test {@link Minion#getAttack()}.
		 */
		@Test
		@DisplayName("Test Minion's getAttack()")
		public void testMinion_getAttack() {
			try {
				assertEquals(5, minionGetAttackMethod.invoke(minion), "Incorrect attack for Level 1 Minion");
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				fail("Cannot invoke method getAttack() for Minion");
			}
		}

		/**
		 * Test {@link Minion#getDefence()}.
		 */
		@Test
		@DisplayName("Test Minion's getDefence()")
		public void testMinion_getDefence() {
			try {
				assertEquals(5, minionGetDefenceMethod.invoke(minion), "Incorrect defence for Level 1 Minion");
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				fail("Cannot invoke method getDefence() for Minion");
			}
		}

		/**
		 * Test {@link Minion#getSpeed()}.
		 */
		@Test
		@DisplayName("Test Minion's getSpeed()")
		public void testMinion_getSpeed() {
			try {
				assertEquals(5, minionGetSpeedMethod.invoke(minion), "Incorrect speed for Level 1 Minion");
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				fail("Cannot invoke method getSpeed() for Minion");
			}
		}

		/**
		 * Test {@link Minion#getTargetEP()}.
		 */
		@Test
		@DisplayName("Test Minion's getTargetEP()")
		public void testMinion_getTargetEP() {
			try {
				assertEquals(10, minionGetTargetEPMethod.invoke(minion), "Incorrect target EP for Level 1 Minion");
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				fail("Cannot invoke method getTargetEP() for Minion");
			}
		}

		/**
		 * Test {@link Minion#getHP()}.
		 */
		@Test
		@DisplayName("Test Minion's getHP()")
		public void testMinion_getHP() {
			try {
				assertEquals(5, minionGetHPMethod.invoke(minion), "Incorrect HP for Level 1 Minion");
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				fail("Cannot invoke method getHP() for Minion");
			}
		}

		/**
		 * Test {@link Minion#getEP()}.
		 */
		@Test
		@DisplayName("Test Minion's getEP()")
		public void testMinion_getEP() {
			try {
				assertEquals(0, minionGetEPMethod.invoke(minion), "Incorrect EP for Level 1 Minion");
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				fail("Cannot invoke method getEP() for Minion");
			}
		}

		/**
		 * Test {@link Minion#decreaseHP()}.
		 */
		@Test
		@DisplayName("Test Minion's decreaseHP()")
		public void testMinion_decreaseHP() {
			try {
				minionDecreaseHPMethod.invoke(minion, 4);
				assertEquals(1, minionGetHPMethod.invoke(minion),
						"Incorrect HP for Level 1 Minion after decreasing 4 HPs");
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				fail("Cannot invoke either decreaseHP() or getHP() for Minion");
			}
		}

		/**
		 * Test {@link Minion#decreaseHP()}.
		 */
		@Test
		@DisplayName("Test Minion's decreaseHP() Full HP")
		public void testMinion_decreaseHP_Full() {
			try {
				minionDecreaseHPMethod.invoke(minion, 5);
				assertEquals(0, minionGetHPMethod.invoke(minion),
						"Incorrect HP for Level 1 Minion after decreasing 5 HPs");
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				fail("Cannot invoke either decreaseHP() or getHP() for Minion");
			}
		}

		/**
		 * Test {@link Minion#decreaseHP()}.
		 */
		@Test
		@DisplayName("Test Minion's decreaseHP() over decrease")
		public void testMinion_decreaseHP_Over() {
			try {
				minionDecreaseHPMethod.invoke(minion, 6);
				assertEquals(0, minionGetHPMethod.invoke(minion),
						"Incorrect HP for Level 1 Minion after decreasing 6 HPs");
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				fail("Cannot invoke either decreaseHP() or getHP() for Minion");
			}
		}

		/**
		 * Test {@link Minion#increaseHP()}.
		 */
		@Test
		@DisplayName("Test Minion's increaseHP()")
		public void testMinion_increaseHP() {
			try {
				minionDecreaseHPMethod.invoke(minion, 4); // Reset the HP to 1
				minionIncreaseHPMethod.invoke(minion, 3);
				assertEquals(4, minionGetHPMethod.invoke(minion),
						"Incorrect HP for Level 1 Minion after increasing 3 HPs from 1");
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				fail("Cannot invoke either decreaseHP(), increaseHP() or getHP() for Minion");
			}
		}

		/**
		 * Test {@link Minion#increaseHP()}.
		 */
		@Test
		@DisplayName("Test Minion's increaseHP() Full HP")
		public void testMinion_increaseHP_Full() {
			try {
				minionDecreaseHPMethod.invoke(minion, 4); // Reset the HP to 1
				minionIncreaseHPMethod.invoke(minion, 4);
				assertEquals(5, minionGetHPMethod.invoke(minion),
						"Incorrect HP for Level 1 Minion after increasing 4 HPs from 1");
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				fail("Cannot invoke either decreaseHP(), increaseHP() or getHP() for Minion");
			}
		}

		/**
		 * Test {@link Minion#increaseHP()}.
		 */
		@Test
		@DisplayName("Test Minion's increaseHP() over increase")
		public void testMinion_increaseHP_Over() {
			try {
				minionDecreaseHPMethod.invoke(minion, 4); // Reset the HP to 1
				minionIncreaseHPMethod.invoke(minion, 5);
				assertEquals(5, minionGetHPMethod.invoke(minion),
						"Incorrect HP for Level 1 Minion after increasing 5 HPs from 1");
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				fail("Cannot invoke either decreaseHP(), increaseHP() or getHP() for Minion");
			}
		}

		/**
		 * Test {@link Minion#increaseEP()}.
		 */
		@Test
		@DisplayName("Test Minion's increaseEP()")
		public void testMinion_increaseEP() {
			try {
				minionIncreaseEPMethod.invoke(minion, 9);
				assertEquals(9, minionGetEPMethod.invoke(minion),
						"Incorrect EP for Level 1 Minion after increasing 9 EPs");
				assertEquals(5, minionGetHPMethod.invoke(minion),
						"Incorrect HP for Level 1 Minion after increasing 9 EPs");
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				fail("Cannot invoke either increaseEP() or getEP() for Minion");
			}
		}

		/**
		 * Test {@link Minion#increaseEP()}.
		 */
		@Test
		@DisplayName("Test Minion's increaseEP() Full EP")
		public void testMinion_increaseEP_Full() {
			try {
				minionIncreaseEPMethod.invoke(minion, 10);
				assertEquals(0, minionGetEPMethod.invoke(minion),
						"Incorrect EP for Level 1 Minion after increasing 10 EPs");
				assertEquals(11, minionGetHPMethod.invoke(minion),
						"Incorrect HP for Level 1 Minion after increasing 10 EPs");
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				fail("Cannot invoke either increaseEP() or getEP() for Minion");
			}
		}

		/**
		 * Test {@link Minion#increaseEP()}.
		 */
		@Test
		@DisplayName("Test Minion's increaseEP() over increase")
		public void testMinion_increaseEP_Over() {
			try {
				minionIncreaseEPMethod.invoke(minion, 11);
				assertEquals(0, minionGetEPMethod.invoke(minion),
						"Incorrect EP for Level 1 Minion after increasing 11 EPs");
				assertEquals(11, minionGetHPMethod.invoke(minion),
						"Incorrect HP for Level 1 Minion after increasing 11 EPs");
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				fail("Cannot invoke either increaseEP() or getEP() for Minion");
			}
		}

		/**
		 * Test {@link Minion#getTeam()}.
		 */
		@Test
		@DisplayName("Test Minion's getTeam()")
		public void testMinion_getTeam() {
			try {
				assertEquals(monsterTeam, minionGetTeamMethod.invoke(minion), "Incorrect team for Level 1 Minion");
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				fail("Cannot invoke getTeam()for Minion");
			}
		}

		/**
		 * Test {@link Minion#setTeam()}.
		 */
		@Test
		@DisplayName("Test Minion's setTeam()")
		public void testMinion_setTeam() {
			try {
				minionSetTeamMethod.invoke(minion, enemyTeam);
				assertEquals(enemyTeam, minionGetTeamMethod.invoke(minion),
						"Incorrect team for Level 1 Minion after setting to enemyTeam");
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				fail("Cannot invoke either getTeam() or setTeam() for Minion");
			}
		}

		/**
		 * Test {@link Minion#strike()}.
		 */
		@Test
		@DisplayName("Test Minion's strike()")
		public void testMinion_strike() {
			try {
				minionStrikeMethod.invoke(minion, enemy1);
				if (minionGetHPMethod.invoke(enemy1).equals(0)) {
					assertEquals(7, minionGetEPMethod.invoke(minion),
						"Incorrect EP for Level 1 Minion after striking Enemy 1");
				} else {
					assertEquals(3, minionGetEPMethod.invoke(minion),
							"Incorrect EP for Level 1 Minion after striking Enemy 1");				
				}
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				fail("Cannot invoke either strike() or getEP() for Minion");
			}
		}

	}

	/**
	 * Abstract test class for {@link Boss}.
	 * 
	 * @author htson
	 * @version 1.0
	 * @see AbstractTestClass
	 */
	private abstract class AbstractTestBoss extends AbstractTestClass {
		/**
		 * We are testing {@link Boss} class.
		 */
		protected Class<?> getTestClass() {
			return assertClassOrInterface("Boss");
		}
	}

	/**
	 * Test for {@link Monster}'s signature.
	 * 
	 * @author htson
	 * @version 1.0
	 * @see AbstractTestBoss
	 */
	@Nested
	class TestBossSignature extends AbstractTestBoss {

		private Class<?> monsterClass;

		/**
		 * Assert the signature of the classes for testing and create the objects under
		 * test.
		 */
		@BeforeEach
		public void setup() {
			super.setup();
			monsterClass = assertClassOrInterface("Monster");
		}
		
		
		/**
		 * Test {@link Boss}.
		 */
		@Test
		@DisplayName("Test Boss is an class")
		public void testBoss_class() {
			assertClass();
		}

		/**
		 * Test {@link Boss} implements {@link Monster}.
		 */
		@Test
		@DisplayName("Test Boss's implement Monster")
		public void testBoss_implementMonster() {
			assertAncestorInterface("", monsterClass);
		}

		/**
		 * Test {@link Boss} inherits {@link Character}.
		 */
		@Test
		@DisplayName("Test Boss inherits Character")
		public void testBoss_inheritCharacter() {
			assertAncestorClass("", Character.class);
		}

		/**
		 * Test {@link Boss#strike(Monster)}.
		 */
		@Test
		@DisplayName("Test Boss's strike(Character) method")
		public void testBoss_strike() {
			assertMethod("", "strike", Character.class);
		}
	}

	/**
	 * Test class for {@link Boss}'s functionality.
	 * 
	 * @author htson
	 * @version 1.0
	 * @see AbstractTestBoss
	 */
	@Nested
	class TestBoss extends AbstractTestBoss {

		private Object boss;
		private Object monsterTeam;

		private Constructor<?> bossConstructor;
		private Method bossGetNameMethod;
		private Method bossGetMaxHPMethod;
		private Method bossGetAttackMethod;
		private Method bossGetDefenceMethod;
		private Method bossGetSpeedMethod;
		private Method bossGetTargetEPMethod;
		private Method bossGetHPMethod;
		private Method bossGetEPMethod;
		private Method bossIncreaseHPMethod;
		private Method bossDecreaseHPMethod;
		private Method bossIncreaseEPMethod;
		private Method bossSetTeamMethod;
		private Method bossGetTeamMethod;
		private Method bossStrikeMethod;

		private Object enemy1;
		private Object enemy2;
		private Object enemy3;
		private Object enemyTeam;

		/**
		 * Assert the signature of the classes for testing and create the objects under
		 * test.
		 */
		@BeforeEach
		public void setup() {
			super.setup();
			assertClass();
			bossConstructor = assertConstructor("", String.class);
			try {
				boss = bossConstructor.newInstance("Boss");
			} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException e) {
				fail("Cannot invoke constructor Boss(\"Boss\")");
			}
			Class<?> characterClass = assertClassOrInterface("Character");
			Class<?> teamClass = assertClassOrInterface("Team");

			bossStrikeMethod = assertMethod("", "strike", characterClass);
			bossGetNameMethod = assertMethod("", "getName");
			bossGetMaxHPMethod = assertMethod("", "getMaxHP");
			bossGetAttackMethod = assertMethod("", "getAttack");
			bossGetDefenceMethod = assertMethod("", "getDefence");
			bossGetSpeedMethod = assertMethod("", "getSpeed");
			bossGetHPMethod = assertMethod("", "getHP");
			bossGetEPMethod = assertMethod("", "getEP");
			bossIncreaseHPMethod = assertMethod("", "increaseHP", int.class);
			bossDecreaseHPMethod = assertMethod("", "decreaseHP", int.class);
			bossIncreaseEPMethod = assertMethod("", "increaseEP", int.class);
			bossGetTargetEPMethod = assertMethod("", "getTargetEP");
			bossSetTeamMethod = assertMethod("", "setTeam", teamClass);
			bossGetTeamMethod = assertMethod("", "getTeam");

			Constructor<?> teamConstructor = assertConstructor(teamClass, "", String.class);
			Method teamAddMemberMethod = assertMethod(teamClass, "", "addMember", characterClass);

			monsterTeam = null;
			try {
				monsterTeam = teamConstructor.newInstance("Monster Team");
			} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException e) {
				fail("Cannot invoke constructor Team(\"Monster Team\")");
			}
			try {
				teamAddMemberMethod.invoke(monsterTeam, boss);
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				fail("Cannot invoke monsterTeam.addMember(boss)");
			}
			try {
				bossSetTeamMethod.invoke(boss, monsterTeam);
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				fail("Cannot invoke boss.setTeam(monsterTeam)");
			}

			enemyTeam = null;
			try {
				enemyTeam = teamConstructor.newInstance("Enemy Team");
			} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException e) {
				fail("Cannot invoke constructor Team(\"Enemy Team\")");
			}
			try {
				enemy1 = bossConstructor.newInstance("Enemy 1");
			} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException e) {
				fail("Cannot invoke constructor Boss(\"Enemy 1\")");
			}
			try {
				teamAddMemberMethod.invoke(enemyTeam, enemy1);
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				fail("Cannot invoke enemyTeam.addMember(enemy1)");
			}
			try {
				bossSetTeamMethod.invoke(enemy1, enemyTeam);
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				fail("Cannot invoke enemy1.setTeam(enemyTeam)");
			}

			try {
				enemy2 = bossConstructor.newInstance("Enemy 2");
			} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException e) {
				fail("Cannot invoke constructor Boss(\"Enemy 2\")");
			}
			try {
				teamAddMemberMethod.invoke(enemyTeam, enemy2);
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				fail("Cannot invoke enemyTeam.addMember(enemy2)");
			}
			try {
				bossSetTeamMethod.invoke(enemy2, enemyTeam);
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				fail("Cannot invoke enemy2.setTeam(enemyTeam)");
			}

			try {
				enemy3 = bossConstructor.newInstance("Enemy 3");
			} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException e) {
				fail("Cannot invoke constructor Boss(\"Enemy 3\")");
			}
			try {
				teamAddMemberMethod.invoke(enemyTeam, enemy3);
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				fail("Cannot invoke enemyTeam.addMember(enemy3)");
			}
			try {
				bossSetTeamMethod.invoke(enemy3, enemyTeam);
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				fail("Cannot invoke enemy3.setTeam(enemyTeam)");
			}
		}

		/**
		 * Test {@link Boss#getName()}.
		 */
		@Test
		@DisplayName("Test Boss's getName()")
		public void testBoss_getName() {
			try {
				assertEquals("Boss", bossGetNameMethod.invoke(boss), "Incorrect name for Level 1 Boss");
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				fail("Cannot invoke method getName() for Boss");
			}
		}

		/**
		 * Test {@link Boss#getMaxHP()}.
		 */
		@Test
		@DisplayName("Test Boss's getMaxHP()")
		public void testBoss_getMaxHP() {
			try {
				assertEquals(8, bossGetMaxHPMethod.invoke(boss), "Incorrect max HP for Level 1 Boss");
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				fail("Cannot invoke method getMaxHP() for Boss");
			}
		}

		/**
		 * Test {@link Boss#getAttack()}.
		 */
		@Test
		@DisplayName("Test Boss's getAttack()")
		public void testBoss_getAttack() {
			try {
				assertEquals(7, bossGetAttackMethod.invoke(boss), "Incorrect attack for Level 1 Boss");
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				fail("Cannot invoke method getAttack() for Boss");
			}
		}

		/**
		 * Test {@link Boss#getDefence()}.
		 */
		@Test
		@DisplayName("Test Boss's getDefence()")
		public void testBoss_getDefence() {
			try {
				assertEquals(8, bossGetDefenceMethod.invoke(boss), "Incorrect defence for Level 1 Boss");
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				fail("Cannot invoke method getDefence() for Boss");
			}
		}

		/**
		 * Test {@link Boss#getSpeed()}.
		 */
		@Test
		@DisplayName("Test Boss's getSpeed()")
		public void testBoss_getSpeed() {
			try {
				assertEquals(7, bossGetSpeedMethod.invoke(boss), "Incorrect speed for Level 1 Boss");
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				fail("Cannot invoke method getSpeed() for Boss");
			}
		}

		/**
		 * Test {@link Boss#getTargetEP()}.
		 */
		@Test
		@DisplayName("Test Boss's getTargetEP()")
		public void testBoss_getTargetEP() {
			try {
				assertEquals(10, bossGetTargetEPMethod.invoke(boss), "Incorrect target EP for Level 1 Boss");
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				fail("Cannot invoke method getTargetEP() for Boss");
			}
		}

		/**
		 * Test {@link Boss#getHP()}.
		 */
		@Test
		@DisplayName("Test Boss's getHP()")
		public void testBoss_getHP() {
			try {
				assertEquals(8, bossGetHPMethod.invoke(boss), "Incorrect HP for Level 1 Boss");
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				fail("Cannot invoke method getHP() for Boss");
			}
		}

		/**
		 * Test {@link Boss#getEP()}.
		 */
		@Test
		@DisplayName("Test Boss's getEP()")
		public void testBoss_getEP() {
			try {
				assertEquals(0, bossGetEPMethod.invoke(boss), "Incorrect EP for Level 1 Boss");
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				fail("Cannot invoke method getEP() for Boss");
			}
		}

		/**
		 * Test {@link Boss#decreaseHP()}.
		 */
		@Test
		@DisplayName("Test Boss's decreaseHP()")
		public void testBoss_decreaseHP() {
			try {
				bossDecreaseHPMethod.invoke(boss, 7);
				assertEquals(1, bossGetHPMethod.invoke(boss),
						"Incorrect HP for Level 1 Boss after decreasing 7 HPs");
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				fail("Cannot invoke either decreaseHP() or getHP() for Boss");
			}
		}

		/**
		 * Test {@link Boss#decreaseHP()}.
		 */
		@Test
		@DisplayName("Test Boss's decreaseHP() Full HP")
		public void testBoss_decreaseHP_Full() {
			try {
				bossDecreaseHPMethod.invoke(boss, 8);
				assertEquals(0, bossGetHPMethod.invoke(boss),
						"Incorrect HP for Level 1 Boss after decreasing 8 HPs");
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				fail("Cannot invoke either decreaseHP() or getHP() for Boss");
			}
		}

		/**
		 * Test {@link Boss#decreaseHP()}.
		 */
		@Test
		@DisplayName("Test Boss's decreaseHP() over decrease")
		public void testBoss_decreaseHP_Over() {
			try {
				bossDecreaseHPMethod.invoke(boss, 9);
				assertEquals(0, bossGetHPMethod.invoke(boss),
						"Incorrect HP for Level 1 Boss after decreasing 9 HPs");
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				fail("Cannot invoke either decreaseHP() or getHP() for Boss");
			}
		}

		/**
		 * Test {@link Boss#increaseHP()}.
		 */
		@Test
		@DisplayName("Test Boss's increaseHP()")
		public void testBoss_increaseHP() {
			try {
				bossDecreaseHPMethod.invoke(boss, 7); // Reset the HP to 1
				bossIncreaseHPMethod.invoke(boss, 6);
				assertEquals(7, bossGetHPMethod.invoke(boss),
						"Incorrect HP for Level 1 Boss after increasing 6 HPs from 1");
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				fail("Cannot invoke either decreaseHP(), increaseHP() or getHP() for Boss");
			}
		}

		/**
		 * Test {@link Boss#increaseHP()}.
		 */
		@Test
		@DisplayName("Test Boss's increaseHP() Full HP")
		public void testBoss_increaseHP_Full() {
			try {
				bossDecreaseHPMethod.invoke(boss, 7); // Reset the HP to 1
				bossIncreaseHPMethod.invoke(boss, 7);
				assertEquals(8, bossGetHPMethod.invoke(boss),
						"Incorrect HP for Level 1 Boss after increasing 7 HPs from 1");
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				fail("Cannot invoke either decreaseHP(), increaseHP() or getHP() for Boss");
			}
		}

		/**
		 * Test {@link Boss#increaseHP()}.
		 */
		@Test
		@DisplayName("Test Boss's increaseHP() over increase")
		public void testBoss_increaseHP_Over() {
			try {
				bossDecreaseHPMethod.invoke(boss, 7); // Reset the HP to 1
				bossIncreaseHPMethod.invoke(boss, 8);
				assertEquals(8, bossGetHPMethod.invoke(boss),
						"Incorrect HP for Level 1 Boss after increasing 8 HPs from 1");
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				fail("Cannot invoke either decreaseHP(), increaseHP() or getHP() for Boss");
			}
		}

		/**
		 * Test {@link Boss#increaseEP()}.
		 */
		@Test
		@DisplayName("Test Boss's increaseEP()")
		public void testBoss_increaseEP() {
			try {
				bossIncreaseEPMethod.invoke(boss, 9);
				assertEquals(9, bossGetEPMethod.invoke(boss),
						"Incorrect EP for Level 1 Boss after increasing 9 EPs");
				assertEquals(8, bossGetHPMethod.invoke(boss),
						"Incorrect HP for Level 1 Boss after increasing 9 EPs");
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				fail("Cannot invoke either increaseEP() or getEP() for Boss");
			}
		}

		/**
		 * Test {@link Boss#increaseEP()}.
		 */
		@Test
		@DisplayName("Test Boss's increaseEP() Full EP")
		public void testBoss_increaseEP_Full() {
			try {
				bossIncreaseEPMethod.invoke(boss, 10);
				assertEquals(0, bossGetEPMethod.invoke(boss),
						"Incorrect EP for Level 1 Boss after increasing 10 EPs");
				assertEquals(18, bossGetHPMethod.invoke(boss),
						"Incorrect HP for Level 1 Boss after increasing 10 EPs");
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				fail("Cannot invoke either increaseEP() or getEP() for Boss");
			}
		}

		/**
		 * Test {@link Boss#increaseEP()}.
		 */
		@Test
		@DisplayName("Test Boss's increaseEP() over increase")
		public void testBoss_increaseEP_Over() {
			try {
				bossIncreaseEPMethod.invoke(boss, 11);
				assertEquals(0, bossGetEPMethod.invoke(boss),
						"Incorrect EP for Level 1 Boss after increasing 11 EPs");
				assertEquals(18, bossGetHPMethod.invoke(boss),
						"Incorrect HP for Level 1 Boss after increasing 11 EPs");
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				fail("Cannot invoke either increaseEP() or getEP() for Boss");
			}
		}

		/**
		 * Test {@link Boss#getTeam()}.
		 */
		@Test
		@DisplayName("Test Boss's getTeam()")
		public void testBoss_getTeam() {
			try {
				assertEquals(monsterTeam, bossGetTeamMethod.invoke(boss), "Incorrect team for Level 1 Boss");
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				fail("Cannot invoke getTeam()for Boss");
			}
		}

		/**
		 * Test {@link Boss#setTeam()}.
		 */
		@Test
		@DisplayName("Test Boss's setTeam()")
		public void testBoss_setTeam() {
			try {
				bossSetTeamMethod.invoke(boss, enemyTeam);
				assertEquals(enemyTeam, bossGetTeamMethod.invoke(boss),
						"Incorrect team for Level 1 Boss after setting to enemyTeam");
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				fail("Cannot invoke either getTeam() or setTeam() for Boss");
			}
		}

		/**
		 * Test {@link Boss#strike()}.
		 */
		@Test
		@DisplayName("Test Boss's strike()")
		public void testBoss_strike() {
			try {
				bossStrikeMethod.invoke(boss, enemy1);
				if (bossGetHPMethod.invoke(enemy1).equals(0)) {
					assertEquals(7, bossGetEPMethod.invoke(boss),
						"Incorrect EP for Level 1 Boss after striking Enemy 1");
				} else {
					assertEquals(3, bossGetEPMethod.invoke(boss),
							"Incorrect EP for Level 1 Boss after striking Enemy 1");				
				}
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				fail("Cannot invoke either strike() or getEP() for Boss");
			}
		}

	}
}