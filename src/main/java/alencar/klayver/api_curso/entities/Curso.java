package alencar.klayver.api_curso.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Table(name = "tb_curso")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nome do curso é obrigatório")
    @Column(unique = true)
    private String titulo;

    @NotBlank(message = "A descrição do curso é obrigatória")
    private String descricao;

    @NotBlank(message = "A categoria do curso é obrigatória")
    private String categoria;

    @ManyToOne
    @JoinColumn(name = "instrutor_id")
    @JsonBackReference
    private Instrutor instrutor;

}
