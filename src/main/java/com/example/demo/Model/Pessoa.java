package com.example.demo.Model;

import com.example.demo.Enum.Sexo;
import org.hibernate.annotations.ColumnDefault;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "pessoa")
public class Pessoa {
    //adicionar nascimento, sexo e endereço
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
    @Column(name = "nome", nullable = false, length = 100, unique = false)
    private String nome;

    @Column(name = "nascimento")
    private LocalDate nascimento;

    @Column(name = "sexo", nullable = false)
    @ColumnDefault("2")
    @Enumerated(EnumType.ORDINAL)
    private Sexo sexo = Sexo.NAO_INFORMADO;

//    @Column(name = "sexo")
//    private String sexo;
//
//    @OneToOne
//    @JoinColumn(name = "endereco_id", nullable = false)
//    private Endereco endereco;

    @Column(name = "ativo", nullable = false)
    @ColumnDefault("true")
    private boolean ativo = true;

    public Pessoa(String nome, LocalDate nascimento, Sexo sexo){
        this.nome = nome;
        this.nascimento = nascimento;
        this.sexo = sexo;
    }
}