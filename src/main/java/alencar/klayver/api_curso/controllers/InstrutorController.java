package alencar.klayver.api_curso.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import alencar.klayver.api_curso.entities.Instrutor;
import alencar.klayver.api_curso.services.InstrutorService;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/instrutor")
public class InstrutorController {

    @Autowired
    InstrutorService instrutorService;

    @GetMapping
    public ResponseEntity<List<Instrutor>> getAll() {
        List<Instrutor> instrutors = instrutorService.findAll();
        return ResponseEntity.status(200).body(instrutors);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Instrutor> getById(@PathVariable Long id ) {
        Instrutor findInstrutor = instrutorService.findById(id);
        return ResponseEntity.status(200).body(findInstrutor);
    }
    @PostMapping()
    public ResponseEntity<Instrutor> postInstrutor(@RequestBody @Valid Instrutor instrutor) {
        Instrutor instrutorCreated = instrutorService.save(instrutor);
        return ResponseEntity.status(201).body(instrutorCreated);

    }
    @PutMapping("/{id}")
    public ResponseEntity<Instrutor> putInstrutor(@PathVariable Long id, @RequestBody @Valid  Instrutor instrutor) {
        Instrutor updateInstrutor = instrutorService.update(id, instrutor);
        return ResponseEntity.status(200).body(updateInstrutor);

    }

    @DeleteMapping("/{id}") 
    public ResponseEntity<Void> deleteInstrutor(@PathVariable Long id) {
        instrutorService.delete(id);
        return ResponseEntity.status(204).build();
    }
    


    








}
