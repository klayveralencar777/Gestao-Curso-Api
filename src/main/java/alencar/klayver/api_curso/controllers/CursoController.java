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

import alencar.klayver.api_curso.entities.Curso;
import alencar.klayver.api_curso.services.CursoService;
import jakarta.validation.Valid;


@RestController
@RequestMapping(value = "/cursos")

public class CursoController{
    @Autowired
    private CursoService cursoService;

    @GetMapping()
    public ResponseEntity<List<Curso>> getAllCursos() {
        List<Curso> cursos = cursoService.findAll();
        return ResponseEntity.status(200).body(cursos);
        
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Curso> getByIdCurso(@PathVariable Long id) {
        Curso cursoEncontrado = cursoService.findById(id);
        return ResponseEntity.status(200).body(cursoEncontrado);

        
    }

    @PostMapping
    public ResponseEntity<Curso> postCurso(@RequestBody @Valid Curso curso) {
        Curso cursoCreated = cursoService.save(curso);
        return ResponseEntity.status(201).body(cursoCreated);

    }
    @PutMapping("/{id}")
    public ResponseEntity<Curso> putCurso(@PathVariable Long id, @RequestBody @Valid Curso curso) {
        Curso cursoAtualizado = cursoService.update(id, curso);
        return ResponseEntity.status(200).body(cursoAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCurso(@PathVariable Long id) {
        cursoService.delete(id);
        return ResponseEntity.status(204).build();

    }
    
    





    

    
    

}


