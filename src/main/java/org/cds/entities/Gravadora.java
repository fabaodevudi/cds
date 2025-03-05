package org.cds.entities;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class Gravadora extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_gravadora")
    private Long codigoGravadora;

    @Column(name = "nome_gravadora", length = 60)
    private String nomeGravadora;

    @Column(name = "endereco", length = 255)
    private String endereco;

    @Column(name = "telefone", length = 20)
    private String telefone;

    @Column(name = "contato", length = 255)
    private String contato;

    @Column(name = "url", length = 255)
    private String url;
}