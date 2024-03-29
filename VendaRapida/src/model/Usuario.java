package model;

import controller.dao.util.MongoDBObject;
import java.util.List;

public class Usuario extends MongoDBObject {
    private List<String> teste;
    private String login;
    private String senha;
    private String nome;
    private double comissao;
    private boolean administrador;
    private boolean cadastraProduto;
    private boolean vendeProduto;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getComissao() {
        return comissao;
    }

    public void setComissao(double comissao) {
        this.comissao = comissao;
    }

    public boolean isAdministrador() {
        return administrador;
    }

    public void setAdministrador(boolean administrador) {
        this.administrador = administrador;
    }

    public boolean isCadastraProduto() {
        return cadastraProduto;
    }

    public void setCadastraProduto(boolean cadastraProduto) {
        this.cadastraProduto = cadastraProduto;
    }

    public boolean isVendeProduto() {
        return vendeProduto;
    }

    public void setVendeProduto(boolean vendeProduto) {
        this.vendeProduto = vendeProduto;
    }
}