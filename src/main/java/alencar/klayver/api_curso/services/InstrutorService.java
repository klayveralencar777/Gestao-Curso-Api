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

    public List<Instrutor> findAllInstrutor() {
        return instrutorRepository.findAll();
    }
    public Instrutor findByIdInstrutor(Long id) {
        return instrutorRepository.findById(id).
                orElseThrow(() -> new EntityNotFoundException("Instrutor não encontrado com o ID: " + id));
    }
    public Instrutor saveInstrutor(Instrutor instrutor) {
        if(instrutor.getCursos() != null) {
            instrutor.getCursos().forEach(curso -> curso.setInstrutor(instrutor));
        }
        return instrutorRepository.save(instrutor);
    }
    public void deleteInstrutor(Long id) {
        Instrutor instrutor = instrutorRepository.findById(id).
                orElseThrow(() -> new EntityNotFoundException("Instrutor não encontrado com o ID: " + id));
        instrutorRepository.delete(instrutor);
    }

    public Instrutor updateInstrutor(Long id, Instrutor novoInstrutor) {
        return instrutorRepository.findById(id).map(
                instrutor -> {
                    instrutor.setNome(novoInstrutor.getNome());
                    instrutor.setEmail(novoInstrutor.getEmail());
                    return instrutorRepository.save(instrutor);
                }).orElseThrow(() -> new EntityNotFoundException(("Instrutor não encontrado pelo ID: " + id)));

    }














}
