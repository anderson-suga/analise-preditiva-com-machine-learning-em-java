package models;

/**
 * Created by suemareverton on 16/08/17.
 */
public class Funcionario {

    private String nome;
    private String email;
    private String empresa;
    private float salario;

    public Funcionario(String nome, String email, String empresa, float salario) {
        this.nome = nome;
        this.email = email;
        this.empresa = empresa;
        this.salario = salario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }
}
