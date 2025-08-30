package alencar.klayver.api_curso.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import alencar.klayver.api_curso.entities.Curso;
import alencar.klayver.api_curso.services.CursoService;


@RestController
@RequestMapping(value = "/cursos")

public class CursoController{
    @Autowired
    private CursoService cursoService;

    @GetMapping()
    public ResponseEntity<List<Curso>> getAllCursos() {
        List<Curso> cursos = cursoService.findAllCurso();
        return ResponseEntity.status(200).body(cursos);
        
    }
    

    
    

}


