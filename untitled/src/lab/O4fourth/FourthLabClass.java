package lab.O4fourth;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class FourthLabClass {

    /*
    variant 20
    C11 = 9 -> Визначити клас студент, який складається як мінімум з 5-и полів.
    */
    private static final String[] firstNames = new String[]{"Vasia", "Sveta", "Tolik", "Liosha", "Vitalik", "Masha"};
    private static final String[] secondNames = new String[]{"Black", "Brown", "White", "Orange", "Red", "Yellow"};
    private static final String[] universities = new String[]{"KPI", "KNU", "LPNU"};

    public static void main(String[] args) {
        Student[] students = studentGenerator(10);
        System.out.println("Students: \n");
        for (Student student : students) {
            System.out.println(student);
        }
        Arrays.sort(students, Comparator.comparing(Student::getFirstName)
                .thenComparing(Student::getSecondName)
                .thenComparing(Student::getUniversity)
                .thenComparing(Student::getAge)
                .thenComparing(Student::getRating)
        );
        System.out.println("\n\nStudents sorted by names asc: \n");
        for (Student student : students) {
            System.out.println(student);
        }
        Arrays.sort(students, Comparator.comparing(Student::getRating)
                .thenComparing(Student::getFirstName)
                .thenComparing(Student::getSecondName)
                .thenComparing(Student::getAge)
                .thenComparing(Student::getUniversity)
                .reversed()
        );
        System.out.println("\n\nStudents sorted by rating decs: \n");
        for (Student student : students) {
            System.out.println(student);
        }
    }


    private static Student[] studentGenerator(int size) {
        Student[] students = new Student[size];
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            students[i] = new Student(firstNames[rand.nextInt(firstNames.length - 1)],
                    secondNames[rand.nextInt(secondNames.length - 1)],
                    universities[rand.nextInt(universities.length - 1)],
                    rand.nextInt(10) + 16,
                    Double.parseDouble(String.format("%.1f", rand.nextDouble(100)).replace(",", ".")));
        }
        return students;
    }


}
