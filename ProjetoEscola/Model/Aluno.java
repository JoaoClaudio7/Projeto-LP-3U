package ProjetoEscola.Model;

import Annotation.InfoAutor;

@InfoAutor(nome = "João Claudio", data = "25/11/2025")
public class Aluno extends Pessoa implements Comparable<Aluno>{
    private String curso;
    private int matricula;
    
    public Aluno(String nome, String cpf, String telefone, String email, String curso, int matricula) {
        super(nome, cpf, telefone, email);
        this.curso = curso;
        this.matricula = matricula;
    }
    
    public Aluno(int matricula) {
        super("", "", "", "");
        this.matricula = matricula;
    }
    public String getCurso() {
        return curso;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    @Override
    public int compareTo(Aluno other) {
        return Integer.compare(this.matricula, other.matricula);
    }
}
