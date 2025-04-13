package src.model;

import java.util.Arrays;

public class Cliente {
    private String nome;
    private char[] senha;

    public Cliente(String nome, char[] senha) {
        this.nome = nome;
        this.senha = Arrays.copyOf(senha, senha.length);
    }
    public String getNome() {
        return nome;
    }

    public char[] getSenha() {
        return senha;
    }

    public void limparSenha() {
        Arrays.fill(senha, ' ');
    }
}
