package https.github.com.alecxandy.msturmaprofessor.demo.service;

import https.github.com.alecxandy.msturmaprofessor.demo.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TurmaService {

    @Autowired
    private TurmaRepository turmaRepository;



}
