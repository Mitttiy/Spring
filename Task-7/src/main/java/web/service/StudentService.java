package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.models.Student;
import web.repositories.StudentRepositories;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class StudentService {

    private final StudentRepositories studentRepositories;

    @Autowired
    public StudentService(StudentRepositories studentRepositories) {
        this.studentRepositories = studentRepositories;
    }

    public List<Student> getAll() {
        return studentRepositories.findAll();
    }

    public Student getById(int id) {
        Optional<Student> userOptional = studentRepositories.findById(id);
        return userOptional.orElse(null);
    }

    @Transactional
    public void save(Student student) {
        studentRepositories.save(student);
    }

    @Transactional
    public void update(int id, Student updateStudent) {
        updateStudent.setId(id);
        studentRepositories.save(updateStudent);
    }

    @Transactional
    public void delete(int id) {
        studentRepositories.deleteById(id);
    }
}