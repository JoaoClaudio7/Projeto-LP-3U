package Interface;

import Exception.AlunoJaCadastradoException;
import Exception.NaoEncontradoException;
import ProjetoEscola.Model.Pessoa;

public interface Service<T> {
    void inserir(int chave, Pessoa pessoa) throws AlunoJaCadastradoException ;
    void remover(int matricula) throws NaoEncontradoException;
}
