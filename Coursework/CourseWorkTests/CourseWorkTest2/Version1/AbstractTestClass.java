import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;

/**
 * Abstract class for testing signature of the a class.
 * 
 * @author htson - v1.0.0 - Initial version
 * 
 * @author htson - v1.2.0 - Return the different reflection components, e.g.,
 *         constructors, methods, fields when asserting. These components will
 *         be used in the tests to avoid failed compilation if the elements are
 *         not presented.
 * @version 1.2.0
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
	 * Assert that the class under test is a class.
	 */
	public void assertClass() {
		assertClass(clazz);
	}

	/**
	 * Assert that the input class is an interface.
	 * 
	 * @param clazz the input class
	 */
	public void assertClass(Class<?> clazz) {
		assertTrue(!clazz.isInterface(), clazz + " should be a class");
	}

	/**
	 * Assert that there exists a class/interface with the given input name.
	 * 
	 * @param className the name of the class/interface.
	 * @return the class/interface with the given name.
	 */
	public Class<?> assertClassOrInterface(String className) {
		try {
			return Class.forName(className);
		} catch (ClassNotFoundException e) {
			fail("Cannot find class/interface " + className);
		}
		return null;
	}

	/**
	 * Assert that the class under test is an interface.
	 */
	public void assertInterface() {
		assertInterface(clazz);
	}

	/**
	 * Assert that the input class is an interface.
	 * 
	 * @param clazz the input class
	 */
	public void assertInterface(Class<?> clazz) {
		assertTrue(clazz.isInterface(), clazz + " should be an interface");
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
	 * Utility method asserting the superclass of the class under test.
	 * 
	 * @param message            the message for testing.
	 * @param expectedSuperclass the expected direct superclass of the class under
	 *                           test.
	 */
	public void assertAncestorClass(String message, Class<?> expectedAncestorClass) {
		Set<Class<?>> ancestorClasses = getAllSuperclasses(clazz);
		assertTrue(ancestorClasses.contains(expectedAncestorClass),
				message + ": " + clazz + " is not a subclasses of " + expectedAncestorClass);
	}

	/**
	 * Utility method to return all the super classes of the input class. This is
	 * done by recursively check through the inheritance hierarchy.
	 * 
	 * @param clazz the input class.
	 * @return the ancestor classes.
	 * @since 1.1.0
	 */
	private Set<Class<?>> getAllSuperclasses(Class<?> clazz) {
		Set<Class<?>> ancestorClasses = new HashSet<Class<?>>();
		Class<?> superclass = clazz.getSuperclass();
		if (superclass != null) {
			ancestorClasses.add(superclass);
			ancestorClasses.addAll(getAllSuperclasses(superclass));
		}

		return ancestorClasses;
	}

	/**
	 * Utility method asserting the class under test implement an interface
	 * 
	 * @param message            the message for testing.
	 * @param expectedSuperclass the expected direct superclass of the class under
	 *                           test.
	 */
	public void assertAncestorInterface(String message, Class<?> expectedAncestorInterface) {
		Set<Class<?>> ancestorInterfaces = getAllInterfaces(clazz);
		assertTrue(ancestorInterfaces.contains(expectedAncestorInterface),
				message + ": " + clazz + " does not implement " + expectedAncestorInterface);
	}

	/**
	 * Utility method to return all the super classes of the input class. This is
	 * done by recursively check through the inheritance hierarchy.
	 * 
	 * @param clazz the input class.
	 * @return the ancestor classes.
	 * @since 1.1.0
	 */
	private Set<Class<?>> getAllInterfaces(Class<?> clazz) {
		Set<Class<?>> ancestorInterfaces = new HashSet<Class<?>>();
		Class<?>[] interfaces = clazz.getInterfaces();
		for (Class<?> interfaze : interfaces) {
			ancestorInterfaces.add(interfaze);
			ancestorInterfaces.addAll(getAllInterfaces(interfaze));
		}

		Set<Class<?>> superClasses = getAllSuperclasses(clazz);
		for (Class<?> superclazz : superClasses) {
			ancestorInterfaces.addAll(getAllInterfaces(superclazz));
		}
		return ancestorInterfaces;
	}

	/**
	 * Assert a field of a given name for the class under test.
	 * 
	 * @param message      the message for testing.
	 * @param expectedName the expected field name.
	 * @return
	 */
	public Field assertField(String message, String expectedName) {
		try {
			return clazz.getDeclaredField(expectedName);
		} catch (NoSuchFieldException e) {
			fail(message + ": Cannot find the field named " + expectedName + " in class " + clazz.getName());
		} catch (SecurityException e) {
			fail(message + ": Unexpected Security Exception");
		}
		return null;
	}

	/**
	 * Assert a field of a given name and type for the class under test.
	 * 
	 * @param message      the message for testing.
	 * @param expectedName the expected field name.
	 * @param expectedType the expected field type.
	 * @return the field matching the input signature.
	 */
	public Field assertField(String message, String expectedName, Class<?> expectedType) {
		try {
			Field actualField = clazz.getDeclaredField(expectedName);
			Class<?> actualType = actualField.getType();
			assertEquals(expectedType, actualType, message + ": Incorrect type for " + expectedName);
			return actualField;
		} catch (NoSuchFieldException e) {
			fail(message + ": Cannot find the field named " + expectedName + " in class " + clazz.getName());
		} catch (SecurityException e) {
			fail(message + ": Unexpected Security Exception");
		}
		return null;
	}

	/**
	 * Assert a private field of a given name for the class under test.
	 * 
	 * @param message      the message for testing.
	 * @param expectedName the expected field name
	 * @return the field matching the input signature.
	 */
	public Field assertPrivateField(String message, String expectedName) {
		try {
			Field actualField = clazz.getDeclaredField(expectedName);
			assertTrue(Modifier.isPrivate(actualField.getModifiers()),
					message + ": Field " + expectedName + " is private");
			return actualField;
		} catch (NoSuchFieldException e) {
			fail(message + ": Cannot find the field named " + expectedName + " in class " + clazz.getName());
		} catch (SecurityException e) {
			fail(message + ": Unexpected Security Exception");
		}
		return null;
	}

	/**
	 * Assert a private field of a given name and type for the class under test.
	 * 
	 * @param message      the message for testing.
	 * @param expectedName the expected field name
	 * @param expectedType the expected field type
	 * @return the field matching the input signature.
	 */
	public Field assertPrivateField(String message, String expectedName, Class<?> expectedType) {
		try {
			Field actualField = clazz.getDeclaredField(expectedName);
			Class<?> actualType = actualField.getType();
			assertEquals(expectedType, actualType, message + ": Incorrect type for " + expectedName);
			assertTrue(Modifier.isPrivate(actualField.getModifiers()),
					message + ": Field " + expectedName + " is abstract");
			return actualField;
		} catch (NoSuchFieldException e) {
			fail(message + ": Cannot find the field named " + expectedName + " in class " + clazz.getName());
		} catch (SecurityException e) {
			fail(message + ": Unexpected Security Exception");
		}
		return null;
	}

	public Constructor<?> assertConstructor(String message, Class<?>... expectedParameterTypes) {
		return assertConstructor(clazz, message, expectedParameterTypes);
	}

	/**
	 * Assert and return the constructor with the given parameter types for an input
	 * class.
	 * 
	 * @param clazz          the class under test
	 * @param message        the message for testing.
	 * @param parameterTypes the parameter types
	 * @return the constructor that match the input signature.
	 */
	public Constructor<?> assertConstructor(Class<?> clazz, String message, Class<?>... parameterTypes) {
		try {
			return clazz.getDeclaredConstructor(parameterTypes);
		} catch (NoSuchMethodException e) {
			fail(message + ": Cannot find constructor for " + clazz + " with parameter types "
					+ Arrays.toString(parameterTypes));
		} catch (SecurityException e) {
			fail(message + ": Unexpected Security Exception");
		}
		return null;
	}

	public Method assertMethod(String message, String expectedName, Class<?>... expectedParameterTypes) {
		return assertMethod(clazz, message, expectedName, expectedParameterTypes);
	}

	public Method assertMethod(Class<?> clazz, String message, String expectedName,
			Class<?>... expectedParameterTypes) {
		return assertMethod(clazz, message, null, expectedName, expectedParameterTypes);
	}

	public Method assertMethod(String message, Class<?> expectedReturnType, String expectedName,
			Class<?>... expectedParameterTypes) {
		return assertMethod(clazz, message, expectedReturnType, expectedName, expectedParameterTypes);
	}

	/**
	 * Assert and return a method with a given signature for an input class.
	 * 
	 * @param clazz              the class under test.
	 * @param message            the message for testing.
	 * @param expectedReturnType the expect return type for the method.
	 * @param name               the name of the method.
	 * @param parameterTypes     the parameter types.
	 * @return the method matching the input signature.
	 */
	public Method assertMethod(Class<?> clazz, String message, Class<?> expectedReturnType, String name,
			Class<?>... parameterTypes) {
		try {
			Method actualMethod = clazz.getMethod(name, parameterTypes);
			if (expectedReturnType != null) {
				assertEquals(expectedReturnType, actualMethod.getReturnType(),
						message + ": Incorrect return type for method " + name + " with parameter types "
								+ Arrays.toString(parameterTypes));
			}
			return actualMethod;
		} catch (NoSuchMethodException e) {
			fail(message + ": Cannot find method " + name + " with parameter types " + Arrays.toString(parameterTypes));
		} catch (SecurityException e) {
			fail(message + ": Unexpected Security Exception");
		}
		return null;
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
