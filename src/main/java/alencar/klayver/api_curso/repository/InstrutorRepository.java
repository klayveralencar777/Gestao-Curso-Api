package alencar.klayver.api_curso.repository;

import alencar.klayver.api_curso.entities.Instrutor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstrutorRepository extends JpaRepository<Instrutor, Long> {}
