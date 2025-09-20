package ua.opnu;

public class Student {
    private String name;
    private int year;
    private String[] courses;

    Student(String name, int year) {
        this.name = name;
        this.year = (year >= 1 && year <= 4 ? year : 1);
        this.courses = new String[0];
    }

    public void addCourse(String courseName) {
        String[] newArray = new String[courses.length + 1];
        for (int i = 0; i < courses.length; i++) {
            newArray[i] = courses[i];
        }
        newArray[newArray.length - 1] = courseName;
        courses = newArray;
    }

    public void dropAll() {
        courses = new String[0];
    }

    public int getCourseCount() {
        return courses.length;
    }

    public String getName() {
        return name;
    }

    public int getTuition() {
        return year * 20000;
    }

    public int getYear() {
        return year;
    }
}
