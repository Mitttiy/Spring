package web.models;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Students1")
public class Student {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotEmpty(message = "Enter the correct value")
    @Size(min = 2, max = 20, message = "Enter the correct value")
    @Column(name = "name")
    private String name;
    @Min(value = 0, message = "Enter the correct value")
    @Column(name = "grade")
    private int grade;
    @Email(message = "Enter correct email")
    @Column(name = "email")
    private String email;

    public Student() {
    }

    public Student(String name, int grade, String email) {
        this.name = name;
        this.grade = grade;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Student: " + id + ", " + name + ", " + grade + ", " + email;
    }
}