package https.github.com.alecxandy.msturmaprofessor.demo.controller;

import https.github.com.alecxandy.msturmaprofessor.demo.domain.Professor;
import https.github.com.alecxandy.msturmaprofessor.demo.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/av1/professor")
public class ProfessorController {

    @Autowired
    private ProfessorService professorService;

    @PostMapping
    public ResponseEntity<Professor> save(@RequestBody Professor professor) {
        return ResponseEntity.status(HttpStatus.CREATED).body(professorService.save(professor));
    }

    @GetMapping
    public ResponseEntity<List<Professor>> listAll() {
        return ResponseEntity.status(HttpStatus.OK).body(professorService.listAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Professor>> findById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(professorService.findById(id));
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        professorService.DeleteById(id);
    }
}
