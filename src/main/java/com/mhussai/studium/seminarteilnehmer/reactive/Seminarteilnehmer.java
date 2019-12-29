package com.mhussai.studium.seminarteilnehmer.reactive;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

@Data
public class Seminarteilnehmer {

    @Id
    @Column("ID")
    private Long id;

    @Column("MATRIKEL_NUMMER")
    private Long matrikelNummer;

    @Column("NAME")
    private String name;

    @Column("EMAIL")
    private String email;

    @Column("SEMINAR")
    private String seminar;

}