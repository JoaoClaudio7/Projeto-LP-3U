package Services;

import java.util.ArrayList;
import java.util.List;
import Exception.AlunoJaCadastradoException;
import Exception.ListaOuArvoreVaziaException;
import Exception.NaoEncontradoException;
import Interface.Service;
import ProjetoEscola.Model.Aluno;
import ProjetoEscola.Model.Pessoa;
import ProjetoEscola.Model.Professor;

public class ServiceProfessor implements Service<Aluno>{
    List<Professor> professores = new ArrayList<>();

    @Override
    public void inserir(int chave, Pessoa pessoa) throws AlunoJaCadastradoException {
        if(!(pessoa instanceof Professor)){
            throw new IllegalArgumentException("Pessoa precisa ser do tipo Aluno");
        }

        Professor professorExistente = null;
        try {
            professorExistente = buscar(chave);
        } catch (NaoEncontradoException e) {
            e.printStackTrace();
        }

        if(professorExistente != null){
            throw new AlunoJaCadastradoException("Matricula " + chave + " ja cadastrada.");
        }
        Professor aluno = (Professor) pessoa;
        professores.add(aluno);
    }

    @Override
    public void remover(int matricula) {
        Professor professor = null;
        try {
            professor = buscar(matricula);
        } catch (NaoEncontradoException e) {
            e.printStackTrace();
        }
        professores.remove(professor);
    }

    public Professor buscar(int idProfessor) throws NaoEncontradoException {
        for (Professor  professor : professores) {
            if(professor.getIdProfessor() == idProfessor){
                return professor;
            }
        }
        return null;
    }
    public void imprimirComMerge() throws ListaOuArvoreVaziaException {
        mergeSort();
        if(professores == null){
            throw new ListaOuArvoreVaziaException("ArvoreAVL vazia");
        }
        for (Professor professor : professores) {
            System.out.println("Nome: "+professor.getNome()+" ID do professor: "+professor.getIdProfessor());
        }
    }

    public void imprimirSemMerge() throws ListaOuArvoreVaziaException {
        if(professores == null){
            throw new ListaOuArvoreVaziaException("ArvoreAVL vazia");
        }
        for (Professor professor : professores) {
            System.out.println("Nome: "+professor.getNome()+" ID do professor: "+professor.getIdProfessor());
        }
    }
    public void mergeSort() {
        mergeSort(professores, 0, professores.size() - 1);
        
    }

    private void mergeSort(List<Professor> list, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(list, left, mid);
            mergeSort(list, mid + 1, right);
            merge(list, left, mid, right);
        }
    }

    private void merge(List<Professor> list, int left, int mid, int right) {
        List<Professor> leftList = new ArrayList<>(list.subList(left, mid + 1));
        List<Professor> rightList = new ArrayList<>(list.subList(mid + 1, right + 1));

        int i = 0, j = 0, k = left;

        while (i < leftList.size() && j < rightList.size()) {
            if (leftList.get(i).compareTo(rightList.get(j)) <= 0) {
                list.set(k++, leftList.get(i++));
            } else {
                list.set(k++, rightList.get(j++));
            }
        }

        while (i < leftList.size()) {
            list.set(k++, leftList.get(i++));
        }

        while (j < rightList.size()) {
            list.set(k++, rightList.get(j++));
        }
    }
}