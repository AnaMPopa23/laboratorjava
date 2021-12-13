package lab3;

import java.util.Comparator;

public class SortareStudenti implements Comparator<Student> {

	@Override
	public int compare(Student o1, Student o2) {
		// TODO Auto-generated method stub
		return o1.nume.compareTo(o2.nume);
	}

}
