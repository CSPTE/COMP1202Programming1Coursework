import java.util.*;
public class SpeedComparator implements Comparator<Character> {

	@Override
	public int compare(Character o1, Character o2) {
		return ((Integer)o1.getSpeed()).compareTo((Integer)o2.getSpeed());
	}
}
