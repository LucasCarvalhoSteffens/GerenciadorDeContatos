import java.io.*;
import java.time.LocalDate;

public class Contato implements Serializable {
    private static final long serialVersionUID = 1L;
    private String nome;
    private String telefone;
    private LocalDate dataNascimento;

    public Contato(String nome, String telefone, LocalDate dataNascimento) {
        this.nome = nome;
        this.telefone = telefone;
        this.dataNascimento = dataNascimento;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    @Override
    public String toString() {
        return nome + " - " + telefone + " - " + dataNascimento;
    }
}