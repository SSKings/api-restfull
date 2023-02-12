package br.com.sskings.apirestfull.dtos;

import jakarta.validation.constraints.*;

public class ClienteDto {

    @NotBlank
    @Size(max = 30)
    private String nome;
    @NotNull
    private int dataNasc;
    @NotBlank
    @Size(max = 50)
    private String end;
    @NotNull
    private long telefone;
    @NotBlank
    @Email
    private String email;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(int dataNasc) {
        this.dataNasc = dataNasc;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public long getTelefone() {
        return telefone;
    }

    public void setTelefone(long telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
