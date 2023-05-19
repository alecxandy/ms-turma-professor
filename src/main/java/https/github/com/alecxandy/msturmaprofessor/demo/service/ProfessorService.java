package https.github.com.alecxandy.msturmaprofessor.demo.service;

import https.github.com.alecxandy.msturmaprofessor.demo.domain.Professor;
import https.github.com.alecxandy.msturmaprofessor.demo.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class ProfessorService {

    @Autowired
    private ProfessorRepository professorRepository;

    public Professor save(Professor professor) {
        return professorRepository.save(professor);
    }

    public List<Professor> listAll() {
        return professorRepository.findAll();
    }

    public Optional<Professor> findById(Long id) {
        return professorRepository.findById(id);
    }

    public void DeleteById(Long id) {
        professorRepository.deleteById(id);
    }

}
