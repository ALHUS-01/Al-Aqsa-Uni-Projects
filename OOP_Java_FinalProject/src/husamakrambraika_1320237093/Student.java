// Husam Akram Hamad Braika - 1320237093
package husamakrambraika_1320237093;

import java.io.Serializable;

public class Student extends Person implements Serializable {

    private String studentId;
    private String specialization;
    private String enrolledDate;
    private double budget;

    public Student() {
    }

    public Student(String identityNumber, String name, String gender, String phone, String address,
            String studentId, String specialization, String enrolledDate, double budget) {

        super(identityNumber, name, gender, phone, address);

        this.studentId = studentId;
        this.specialization = specialization;
        this.enrolledDate = enrolledDate;
        this.budget = budget;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getEnrolledDate() {
        return enrolledDate;
    }

    public void setEnrolledDate(String enrolledDate) {
        this.enrolledDate = enrolledDate;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    @Override
    public String toString() {
        return super.toString() + " | Student ID: " + studentId + " | Major: " + specialization + " | Budget: $" + budget;
    }
}
// Husam Akram Hamad Braika - 1320237093
