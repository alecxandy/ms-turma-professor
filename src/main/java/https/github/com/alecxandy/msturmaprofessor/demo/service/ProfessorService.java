package https.github.com.alecxandy.msturmaprofessor.demo.service;

import https.github.com.alecxandy.msturmaprofessor.demo.domain.Professor;
import https.github.com.alecxandy.msturmaprofessor.demo.repository.ProfessorRepository;
import https.github.com.alecxandy.msturmaprofessor.demo.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfessorService {

    @Autowired
    private ProfessorRepository professorRepository;
    @Autowired
    private TurmaService turmaService;

    public Professor save(Professor professor) {
        return professorRepository.save(professor);
    }

    public List<Professor> listAll() {
        return professorRepository.findAll();
    }

    public Optional<Professor> findById(Long id) {
        Professor professor = professorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("id is not exists"));
        return Optional.of(professor);
    }

    public void DeleteById(Long id) {
        professorRepository.findById(id).map(professor -> {
            professorRepository.deleteById(professor.getId());
            return professor;
        }).orElseThrow(() -> new RuntimeException("id is not exists"));
    }

    public Professor update(Professor professor, long id) {
        return professorRepository.findById(id).map(p -> {
            p.setId(id);
            p.setNome(professor.getNome());
            p.setTelefone(professor.getTelefone());
            p.setTurmaList(professor.getTurmaList());
            professorRepository.save(p);
            return p;
        }).orElseThrow(() -> new RuntimeException("it is not exists"));
    }
}


