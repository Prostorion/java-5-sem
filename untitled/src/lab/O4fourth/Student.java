package lab.O4fourth;

public class Student {
    private String firstName;
    private String secondName;
    private String university;
    private int age;
    private double rating;

    public Student(String firstName, String secondName, String university, int age, double rating) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.university = university;
        this.age = age;
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Student{" +
                firstName + ' ' +
                secondName + ' ' +
                university + ' ' +
                age + ' ' +
                rating + ' ' +
                '}';
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}
