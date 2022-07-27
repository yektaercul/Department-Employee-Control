package yekta.springtest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import yekta.springtest.model.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
