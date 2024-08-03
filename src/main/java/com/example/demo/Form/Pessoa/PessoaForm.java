package com.example.demo.Form.Pessoa;
import com.example.demo.Enum.Sexo;
import com.example.demo.Model.Pessoa;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class PessoaForm {

    @NotBlank(message = "Preencha os campos.")
    private String nome;

    @NotNull(message = "Preencha a data de Nascimento.")
    @Past(message = "Data de nascimento deve ser no passado.")
    @JsonFormat(pattern = "dd-mm-yyyy")
    private LocalDate nascimento;

    @NotNull(message = "Preencha o campo Sexo.")
    private int sexo;


    public Pessoa toEntity() {

        Sexo sexo = Sexo.fromCodigo(this.sexo);
        return new Pessoa(nome, nascimento, sexo);
    }

    public PessoaForm(Pessoa pessoa) {
        this.nome = pessoa.getNome();
        this.nascimento = pessoa.getNascimento();
    }
}

