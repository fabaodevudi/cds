package org.cds.entities;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.cds.entities.Autor;

import java.time.LocalTime;
import java.util.List;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class Musica extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_musica")
    private Long codigoMusica;

    @Column(name = "nome_musica", length = 255)
    private String nomeMusica;

    @Column(name = "duracao")
    private LocalTime duracao;

    @ManyToMany
    @JoinTable(
            name = "MUSICA_AUTOR",
            joinColumns = @JoinColumn(name = "Codigo_Musica"),
            inverseJoinColumns = @JoinColumn(name = "Codigo_Autor")
    )
    private List<Autor> autores;
}