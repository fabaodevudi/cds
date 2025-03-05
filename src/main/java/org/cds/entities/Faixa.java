package org.example.model;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.cds.entities.CD;
import org.cds.entities.Musica;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class Faixa extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Chave primária da faixa

    @ManyToOne
    @JoinColumn(name = "Codigo_Musica")
    private Musica musica;

    @ManyToOne
    @JoinColumn(name = "Codigo_CD")
    private CD cd;

    @Column(name = "Numero_Faixa")
    private Integer numeroFaixa;
}