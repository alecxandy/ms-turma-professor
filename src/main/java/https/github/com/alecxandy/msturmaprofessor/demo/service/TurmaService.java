package https.github.com.alecxandy.msturmaprofessor.demo.service;

import https.github.com.alecxandy.msturmaprofessor.demo.domain.Turma;
import https.github.com.alecxandy.msturmaprofessor.demo.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.List;

@Service
public class TurmaService {

    @Autowired
    private TurmaRepository turmaRepository;

    public Turma save(Turma turma) {
        return turmaRepository.save(turma);
    }

    public List<Turma> ListAll() {
        return turmaRepository.findAll();
    }

    public Optional<Turma> findById(Long id) {
        return turmaRepository.findById(id);
    }

    public void deleteById(Long id) {
        turmaRepository.deleteById(id);
    }


}
