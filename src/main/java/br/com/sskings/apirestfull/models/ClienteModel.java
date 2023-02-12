package br.com.sskings.apirestfull.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "TB_CLIENTE")
public class ClienteModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(nullable = false, length = 30)
    private String nome;
    @Column(name = "data_nasc", nullable = false)
    private int dataNasc;
    @Column(name = "endereco" ,nullable = false, length = 50)
    private String End;
    @Column(name = "fone", nullable = false)
    private long telefone;
    @Email
    @Column(nullable = false)
    private String email;

    public ClienteModel() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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
        return End;
    }

    public void setEnd(String end) {
        End = end;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClienteModel that = (ClienteModel) o;
        return id == that.id && dataNasc == that.dataNasc && telefone == that.telefone && Objects.equals(nome, that.nome) && Objects.equals(End, that.End) && Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, dataNasc, End, telefone, email);
    }
}
