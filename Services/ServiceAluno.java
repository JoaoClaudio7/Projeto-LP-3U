
package Services;

import ArvoreAVL.ArvoreAVL;
import Exception.AlunoJaCadastradoException;
import Exception.NaoEncontradoException;
import ProjetoEscola.Model.Aluno;
import ProjetoEscola.Model.Pessoa;
import Interface.Service;

import java.util.List;
public class ServiceAluno implements Service<Aluno> {
    ArvoreAVL<Aluno> arvoreAVL = new ArvoreAVL<>();

    @Override
    public void inserir(int chave, Pessoa pessoa) throws AlunoJaCadastradoException {
        // Assumindo que Pessoa é do tipo Aluno
        if (!(pessoa instanceof Aluno)) {
            throw new IllegalArgumentException("Pessoa precisa ser do tipo Aluno");
        }

        //verificar se a matricula ja existe
        Aluno dummy = new Aluno(chave);
        Aluno alunoExistente = arvoreAVL.buscar(dummy);
        if (alunoExistente != null) {
            throw new AlunoJaCadastradoException("Matricula " + chave + " ja cadastrada.");
        }

        Aluno aluno = (Aluno) pessoa;
        aluno.setMatricula(chave);
        arvoreAVL.inserir(aluno);
    }

    @Override
    public void remover(int matricula) throws NaoEncontradoException {
        // Criar um objeto Aluno "dummy" para remover
        Aluno dummy = new Aluno("", "", "", "", "", matricula);
        Aluno alunoExistente = arvoreAVL.buscar(dummy);
        if (alunoExistente == null) {
            throw new NaoEncontradoException("Aluno com matricula " + matricula + " nao encontrado.");
        }
        arvoreAVL.remover(dummy);
    }

    public void imprimirEmOrdem(ArvoreAVL arvoreAVL) throws NaoEncontradoException {
        if(arvoreAVL == null){
            throw new NaoEncontradoException("ArvoreAVL vazia");
        };
        List<Aluno> alunos = arvoreAVL.emOrdem();
        for (Aluno aluno : alunos) {
            System.out.println("Nome: "+aluno.getNome()+" Matricula: "+aluno.getMatricula());
        }
    }

    public ArvoreAVL<Aluno> getArvoreAVLCopy() {
        if(arvoreAVL == null){
            return null;
        };
        ArvoreAVL<Aluno> copia = new ArvoreAVL<>();
        for (Aluno aluno : arvoreAVL.emOrdem()) {
            copia.inserir(aluno);
        }
        return copia;
    }
    
    public Aluno buscar(int matricula) throws NaoEncontradoException  {
        Aluno dummy = new Aluno(matricula);
        Aluno result = arvoreAVL.buscar(dummy);
        if (result != null) {
            return result;
        } 
        throw new NaoEncontradoException("Aluno com matricula " + matricula + " nao encontrado.");
    }

}
