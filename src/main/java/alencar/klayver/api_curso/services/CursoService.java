package alencar.klayver.api_curso.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import alencar.klayver.api_curso.entities.Curso;
import alencar.klayver.api_curso.exceptions.EntityNotFoundException;
import alencar.klayver.api_curso.repository.CursoRepository;

@Service
public class CursoService {
    @Autowired
    CursoRepository cursoRepository;

    public List<Curso> findAll() {
        return cursoRepository.findAll();

    }

    public Curso findById(Long id) {
        return cursoRepository.findById(id).
                orElseThrow(() -> new EntityNotFoundException("Curso não encontrado com o ID: " + id));
    }

    public Curso save(Curso curso) {
        return cursoRepository.save(curso);
    }

   public void delete(Long id) {
        Curso cursoDeletado = cursoRepository.findById(id).
                orElseThrow(() -> new EntityNotFoundException("Curso não encontrado para remover com o ID: " + id));
                cursoRepository.delete(cursoDeletado);
   }

  public Curso update(Long id, Curso curso) {
        return cursoRepository.findById(id).map(
                c -> {
                    c.setTitulo(curso.getTitulo());
                    c.setDescricao(curso.getDescricao());
                    c.setCategoria(curso.getCategoria());
                    return cursoRepository.save(c);
                }).orElseThrow(() -> new EntityNotFoundException("Curso não encontrado com o ID: " + id));

  }
  

}

