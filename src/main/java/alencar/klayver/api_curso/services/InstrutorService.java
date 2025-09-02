package alencar.klayver.api_curso.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import alencar.klayver.api_curso.entities.Instrutor;
import alencar.klayver.api_curso.exceptions.EntityNotFoundException;
import alencar.klayver.api_curso.repository.InstrutorRepository;

@Service
public class InstrutorService {
    @Autowired
    private InstrutorRepository instrutorRepository;

    public List<Instrutor> findAll() {
        return instrutorRepository.findAll();
    }
    public Instrutor findById(Long id) {
        return instrutorRepository.findById(id).
                orElseThrow(() -> new EntityNotFoundException("Instrutor não encontrado com o ID: " + id));
    }


    public Instrutor save(Instrutor instrutor) {
        if(instrutor.getCursos() != null) {
            instrutor.getCursos().forEach(c -> c.setInstrutor(instrutor));
        }
        return instrutorRepository.save(instrutor);
    }

    public void delete(Long id) {
        Instrutor instrutor = instrutorRepository.findById(id).
                orElseThrow(() -> new EntityNotFoundException("Instrutor não encontrado com o ID: " + id));
        instrutorRepository.delete(instrutor);
    }

    public Instrutor update(Long id, Instrutor novoInstrutor) {
        return instrutorRepository.findById(id).map(
                instrutor -> {
                    instrutor.setNome(novoInstrutor.getNome());
                    instrutor.setEmail(novoInstrutor.getEmail());
                    if(novoInstrutor.getCursos() != null) {
                        instrutor.getCursos().clear();
                        novoInstrutor.getCursos().forEach(curso -> {
                            curso.setInstrutor(instrutor);
                            instrutor.getCursos().add(curso);
                        });
                    }

                    return instrutorRepository.save(instrutor);
                }).orElseThrow(() -> new EntityNotFoundException(("Instrutor não encontrado pelo ID: " + id)));

    }

}
