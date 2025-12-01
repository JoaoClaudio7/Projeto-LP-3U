package ProjetoEscola.Model;

import Annotation.InfoAutor;

@InfoAutor(nome = "João Claudio", data = "25/11/2025")
public class Professor extends Pessoa implements Comparable<Professor>{
    private int idProfessor;
    private String disciplina;
    private double salario;
    
    public Professor(String nome, String cpf, String telefone, String email,  String disciplina, double salario, int idProfessor) {
        super(nome, cpf, telefone, email);
        this.idProfessor = idProfessor;
        this.disciplina = disciplina;
        this.salario = salario;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public double getSalario() {
        return salario;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }   
    
    public int getIdProfessor() {
        return idProfessor;
    }

    public void setIdProfessor(int idProfessor) {
        this.idProfessor = idProfessor;
    }

    @Override
    public int compareTo(Professor o) {
        return Integer.compare(this.idProfessor, o.idProfessor);
    }
}
