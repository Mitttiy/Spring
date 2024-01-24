package web.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import web.models.Student;

@Repository
public interface StudentRepositories extends JpaRepository<Student,Integer> {
}