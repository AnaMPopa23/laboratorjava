package lab3;

import java.util.Comparator;

public class SortareDupaNumeProfesorCurs implements Comparator<Curs> {

	@Override
	public int compare(Curs o1, Curs o2) {
		// TODO Auto-generated method stub
		return o1.profu.nume.compareTo(o2.profu.nume);
	}

}
