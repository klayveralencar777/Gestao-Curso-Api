package alencar.klayver.api_curso.entities;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    @OneToMany(mappedBy = "instrutor", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Curso> cursos;

}




