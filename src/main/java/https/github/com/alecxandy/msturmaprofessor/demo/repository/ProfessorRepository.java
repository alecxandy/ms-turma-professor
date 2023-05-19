package https.github.com.alecxandy.msturmaprofessor.demo.repository;

import https.github.com.alecxandy.msturmaprofessor.demo.domain.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long> {
}
