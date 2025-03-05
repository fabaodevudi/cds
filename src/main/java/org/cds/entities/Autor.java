package org.cds.entities;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class Autor extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_autor")
    private Long codigoAutor;

    @Column(name = "nome_autor", length = 255)
    private String nomeAutor;

    @ManyToMany(mappedBy = "autores")
    private List<Musica> musicas;
}