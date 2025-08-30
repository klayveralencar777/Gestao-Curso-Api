package alencar.klayver.api_curso.entities;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "tb_instrutor")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Instrutor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Nome é um campo obrigatório")
    private String nome;
    @Column(unique = true)
    @Email(message = "Email precisa ser válido")
    @NotBlank(message = "Email é um campo obrigatório")
    private String email;

    @OneToMany(mappedBy = "instrutor", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Curso> cursos;

}




