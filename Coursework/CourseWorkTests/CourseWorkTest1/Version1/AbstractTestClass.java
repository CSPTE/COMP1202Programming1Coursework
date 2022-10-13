import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;

/**
 * Abstract class for testing signature of the a class.
 * 
 * @author htson
 * @version 1.0
 */
public abstract class AbstractTestClass {

	// The class under test
	protected Class<?> clazz;

	/**
	 * The methods of the class under test. This includes all the public, protected,
	 * (default) package, private methods, but exclude inherited methods.
	 */
	protected Method[] methods;

	/**
	 * The fields of the class under test. This includes all the public, protected,
	 * (default) package, private fields, but exclude inherited fields.
	 */
	protected Field[] fields;

	/**
	 * The constructors of the class under test. This includes all the public,
	 * protected, (default) package, private constructors, but exclude inherited
	 * constructors.
	 */
	protected Constructor<?>[] constructors;

	/**
	 * Client should implement this method to return the class under test.
	 * 
	 * @return the class under test.
	 */
	protected abstract Class<?> getTestClass();

	/**
	 * Before each test, fetch the class under tests and its components.
	 */
	@BeforeEach
	public void setup() {
		clazz = this.getTestClass();
		methods = clazz.getDeclaredMethods();
		fields = clazz.getDeclaredFields();
		constructors = clazz.getDeclaredConstructors();
	}

	/**
	 * Utility method asserting the class under test is an abstract class.
	 * 
	 * @param message the message for testing.
	 */
	public void assertAbstractClass(String message) {
		assertTrue(Modifier.isAbstract(clazz.getModifiers()), message + ": Class " + clazz + " is abstract");
	}	
	
	/**
	 * Utility method asserting the direct superclass of the class under test.
	 * 
	 * @param message            the message for testing.
	 * @param expectedSuperclass the expected direct superclass of the class under
	 *                           test.
	 */
	public void assertSuperclass(String message, Class<?> expectedSuperclass) {
		Class<?> actualClass = clazz.getSuperclass();
		assertEquals(expectedSuperclass, actualClass, message + ": Incorrect Superclass for " + clazz);
	}

	/**
	 * Assert a field of a given name for the class under test.
	 * 
	 * @param message      the message for testing.
	 * @param expectedName the expected field name.
	 */
	public void assertField(String message, String expectedName) {
		try {
			clazz.getDeclaredField(expectedName);
		} catch (NoSuchFieldException e) {
			fail(message + ": Cannot find the field named " + expectedName + " in class " + clazz.getName());
		} catch (SecurityException e) {
			fail(message + ": Unexpected Security Exception");
		}
	}

	/**
	 * Assert a field of a given name and type for the class under test.
	 * 
	 * @param message      the message for testing.
	 * @param expectedName the expected field name
	 * @param expectedType the expected field type
	 */
	public void assertField(String message, String expectedName, Class<?> expectedType) {
		try {
			Field actualField = clazz.getDeclaredField(expectedName);
			Class<?> actualType = actualField.getType();
			assertEquals(expectedType, actualType, message + ": Incorrect type for " + expectedName);
		} catch (NoSuchFieldException e) {
			fail(message + ": Cannot find the field named " + expectedName + " in class " + clazz.getName());
		} catch (SecurityException e) {
			fail(message + ": Unexpected Security Exception");
		}
	}

	/**
	 * Assert a private field of a given name for the class under test.
	 * 
	 * @param message      the message for testing.
	 * @param expectedName the expected field name
	 * @param expectedType the expected field type
	 */
	public void assertPrivateField(String message, String expectedName) {
		try {
			Field actualField = clazz.getDeclaredField(expectedName);
			assertTrue(Modifier.isPrivate(actualField.getModifiers()),
					message + ": Field " + expectedName + " is abstract");
		} catch (NoSuchFieldException e) {
			fail(message + ": Cannot find the field named " + expectedName + " in class " + clazz.getName());
		} catch (SecurityException e) {
			fail(message + ": Unexpected Security Exception");
		}
	}

	/**
	 * Assert a private field of a given name and type for the class under test.
	 * 
	 * @param message      the message for testing.
	 * @param expectedName the expected field name
	 * @param expectedType the expected field type
	 */
	public void assertPrivateField(String message, String expectedName, Class<?> expectedType) {
		try {
			Field actualField = clazz.getDeclaredField(expectedName);
			Class<?> actualType = actualField.getType();
			assertEquals(expectedType, actualType, message + ": Incorrect type for " + expectedName);
			assertTrue(Modifier.isPrivate(actualField.getModifiers()),
					message + ": Field " + expectedName + " is abstract");
		} catch (NoSuchFieldException e) {
			fail(message + ": Cannot find the field named " + expectedName + " in class " + clazz.getName());
		} catch (SecurityException e) {
			fail(message + ": Unexpected Security Exception");
		}
	}
	public void assertConstructor(String message, Class<?>... expectedParameterTypes) {
		try {
			clazz.getDeclaredConstructor(expectedParameterTypes);
		} catch (NoSuchMethodException e) {
			fail(message + ": Cannot find constructor for " + clazz + " with parameter types " + expectedParameterTypes);
		} catch (SecurityException e) {
			fail(message + ": Unexpected Security Exception");
		}
	}

	public void assertConstructor(Class<?> clazz, String message, Class<?>... expectedParameterTypes) {
		try {
			clazz.getDeclaredConstructor(expectedParameterTypes);
		} catch (NoSuchMethodException e) {
			fail(message + ": Cannot find constructor for " + clazz + " with parameter types " + expectedParameterTypes);
		} catch (SecurityException e) {
			fail(message + ": Unexpected Security Exception");
		}
	}

	public void assertMethod(String message, String expectedName, Class<?>... expectedParameterTypes) {
		try {
			clazz.getDeclaredMethod(expectedName, expectedParameterTypes);
		} catch (NoSuchMethodException e) {
			fail(message + ": Cannot find method " + expectedName + " with parameter types " + expectedParameterTypes);
		} catch (SecurityException e) {
			fail(message + ": Unexpected Security Exception");
		}
	}

	public void assertMethod(String message, Class<?> expectedReturnType, String expectedName,
			Class<?>... expectedParameterTypes) {
		try {
			Method actualMethod = clazz.getDeclaredMethod(expectedName, expectedParameterTypes);
			assertEquals(expectedReturnType, actualMethod.getReturnType(),
					message + ": Incorrect return type for method " + expectedName + " with parameter types "
							+ Arrays.toString(expectedParameterTypes));
		} catch (NoSuchMethodException e) {
			fail(message + ": Cannot find method " + expectedName + " with parameter types "
					+ Arrays.toString(expectedParameterTypes));
		} catch (SecurityException e) {
			fail(message + ": Unexpected Security Exception");
		}
	}

	public void assertMethod(String message, int expectedModifier, Class<?> expectedReturnType, String expectedName,
			Class<?>... expectedParameterTypes) {
		try {
			Method actualMethod = clazz.getDeclaredMethod(expectedName, expectedParameterTypes);
			assertEquals(expectedReturnType, actualMethod.getReturnType(),
					message + ": Incorrect return type for method " + expectedName + " with parameter types "
							+ expectedParameterTypes);
			assertEquals(expectedModifier, actualMethod.getModifiers(),
					message + ": Incorrect access modifier for method " + expectedName + " with parameter types "
							+ expectedParameterTypes);
		} catch (NoSuchMethodException e) {
			fail(message + ": Cannot find method " + expectedName + " with parameter types " + expectedParameterTypes);
		} catch (SecurityException e) {
			fail(message + ": Unexpected Security Exception");
		}
	}

}
