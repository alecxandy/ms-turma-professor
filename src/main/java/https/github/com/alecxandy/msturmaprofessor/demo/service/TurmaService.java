package https.github.com.alecxandy.msturmaprofessor.demo.service;

import https.github.com.alecxandy.msturmaprofessor.demo.domain.Professor;
import https.github.com.alecxandy.msturmaprofessor.demo.domain.Turma;
import https.github.com.alecxandy.msturmaprofessor.demo.domain.dto.TurmaRequestDTO;
import https.github.com.alecxandy.msturmaprofessor.demo.repository.ProfessorRepository;
import https.github.com.alecxandy.msturmaprofessor.demo.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.List;

@Service
public class TurmaService {
    @Autowired
    private TurmaRepository turmaRepository;
    @Autowired
    private ProfessorRepository professorRepository;

    public Turma save(TurmaRequestDTO turmaRequestDTO) {
        Professor professor = professorRepository.findById(turmaRequestDTO.getProfessorId())
                .orElseThrow(() -> new RuntimeException("notnull"));
        Turma turma = new Turma();
        turma.setCapacidade(turmaRequestDTO.getCapacidade());
        turma.setProfessor(professor);
        return turmaRepository.save(turma);
    }

    public List<Turma> ListAll() {
        return turmaRepository.findAll();
    }

    public Optional<Turma> findById(Long id) {
        Turma turma = turmaRepository.findById(id).orElseThrow(() -> new RuntimeException("notnull"));
        return Optional.of(turma);
    }

    public void deleteById(Long id) {
        turmaRepository.findById(id).map(turma -> {
            turma.setProfessor(null);
            turmaRepository.save(turma);
            turmaRepository.deleteById(turma.getId());
            return turma;
        }).orElseThrow(() -> new RuntimeException("notnull"));
    }

    public Turma update(TurmaRequestDTO turmaRequestDTO, Long id) {
        Professor professor = turmaRepository.findById(turmaRequestDTO.getProfessorId())
                .orElseThrow(() -> new RuntimeException("id is not professor exists")).getProfessor();
        return turmaRepository.findById(id).map(t -> {
            t.setId(id);
            t.setProfessor(professor);
            t.setCapacidade(turmaRequestDTO.getCapacidade());
            turmaRepository.save(t);
            return t;
        }).orElseThrow(() -> new RuntimeException("id is not exists"));
    }

}
