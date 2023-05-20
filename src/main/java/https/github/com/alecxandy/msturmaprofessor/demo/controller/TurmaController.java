package https.github.com.alecxandy.msturmaprofessor.demo.controller;

import https.github.com.alecxandy.msturmaprofessor.demo.domain.Turma;
import https.github.com.alecxandy.msturmaprofessor.demo.domain.dto.TurmaRequestDTO;
import https.github.com.alecxandy.msturmaprofessor.demo.service.TurmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/turma")
public class TurmaController {

    @Autowired
    private TurmaService turmaService;

    @PostMapping
    public ResponseEntity<Turma> save(@RequestBody TurmaRequestDTO turmaRequestDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(turmaService.save(turmaRequestDTO));
    }

    @GetMapping
    public ResponseEntity<List<Turma>> listAll() {
        return ResponseEntity.status(HttpStatus.OK).body(turmaService.ListAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Turma>> findById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(turmaService.findById(id));
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        turmaService.deleteById(id);
    }


}
