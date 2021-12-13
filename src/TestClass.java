package lab3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;

public class TestClass {
	public static void main(String[] args) {
		DataManager dataManager = new DataManager();

		dataManager.gradeStudents();
		dataManager.manager.reportAllCourses();
		dataManager.manager.reportAllStudentsGrades();
		dataManager.manager.reportAllCourses();
		try {
			dataManager.manager.RemoveCurs(new Curs("PLCP 1"));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		System.out.println("Dupa stergere:");
		dataManager.manager.reportAllCourses();

		dataManager.manager.reportAllStudentsGrades();

		try {
			dataManager.manager.EditCurs(new Curs("Limba engleza"), new Curs("Limba engleza II", "descriere",
					new Profesor("Ana", "Maria"), dataManager.createRandomSetOfStudents()));
			dataManager.manager.reportAllCourses();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		System.out.println("\nSortarea studentilor dupa grupa:");
		HashMap<Integer, ArrayList<Student>> grupareStudentiDupaGrupa = new HashMap<Integer, ArrayList<Student>>();
		for (Curs c : dataManager.manager.cursuri) {
			for (Student s : c.studenti) {
				ArrayList<Student> studenti = grupareStudentiDupaGrupa.get(s.grupa);
				if (studenti != null) {
					studenti.add(s);
					grupareStudentiDupaGrupa.replace(s.grupa, studenti);
				} else {
					studenti = new ArrayList<>();
					studenti.add(s);
					grupareStudentiDupaGrupa.put(s.grupa, studenti);

				}

			}
		}
		for (Integer grupa : grupareStudentiDupaGrupa.keySet()) {
			System.out.println(grupareStudentiDupaGrupa.get(grupa));
		}

		/*
		 * ArrayList<Student> lista = new
		 * ArrayList<Student>(dataManager.manager.cursuri.get(3).studenti);
		 * Collections.sort(lista); System.out.println("Dupa sortare alfabetica:");
		 * for(Student s:dataManager.manager.cursuri.get(3).studenti ) {
		 * System.out.println(s.toString()); }
		 */

		ArrayList<Student> lista = new ArrayList<Student>(dataManager.manager.cursuri.get(3).studenti);
		Collections.sort(lista, new SortareStudenti());
		System.out.println("\nSortarea studentilor in ordine alfabetica:");
		for (int i = 0; i < lista.size(); i++) {
			System.out.println(lista.get(i).toString());
		}
		System.out.println("\nSortarea cursurilor dupa nume:");
		ArrayList<Curs> lista2 = new ArrayList<>(dataManager.manager.cursuri);
		Collections.sort(lista2, new SortareDupaNumeCurs());
		for (int i = 0; i < lista2.size(); i++)
			System.out.println(lista2.get(i).nume);

		System.out.println("\nSortarea cursurilor dupa numele profesorului:");
		ArrayList<Curs> lista3 = new ArrayList<>(dataManager.manager.cursuri);
		Collections.sort(lista3, new SortareDupaNumeProfesorCurs());
		for (int i = 0; i < lista3.size(); i++)
			System.out.println(lista3.get(i).nume + "   " + lista3.get(i).profu.toString());

		System.out.println("\nSortarea cursurilor dupa numar de studenti inscrisi:");
		ArrayList<Curs> lista4 = new ArrayList<>(dataManager.manager.cursuri);
		Collections.sort(lista4, new SortareDupaNumarStudentiCurs());
		for (int i = 0; i < lista4.size(); i++)
			System.out.println(lista4.get(i).nume + "   " + lista4.get(i).studenti.size());
	}

}
