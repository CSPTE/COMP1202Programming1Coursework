
public interface Monster {
	 void strike(Character enemy) throws CharacterDeadException;
	 void SyntaxError(Character enemy) throws CharacterDeadException;
	 void NullPointerException() throws CharacterDeadException;
	 void ArrayIndexOutOfBoundException(Character enemy) throws CharacterDeadException;
	 //void NoneTermination();
	 //void ConcurrentModificationException();
}
