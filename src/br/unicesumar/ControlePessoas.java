package br.unicesumar;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ControlePessoas {
    private static Set<Pessoa> pessoas = new HashSet<>();

    public void inserirPessoa(Pessoa pessoa){
            pessoas.add(pessoa);
    }

    public List<Pessoa> exibirTodos() {
        List<Pessoa> pessoaList = new ArrayList<>();
        pessoaList.addAll(pessoas);
        return pessoaList;
    }

    public Pessoa consultarPessoasPorNome(String nome) throws PessoaException {
        for(Pessoa pessoa: pessoas){
            if (pessoa.getNome().equalsIgnoreCase(nome)){
                return pessoa;
            }
        }
        throw new PessoaException("Pessoa não encontrada com o nome: "+nome);
    }

    public Pessoa alterarPessoa(String nome, Pessoa pessoaNova) throws PessoaException {
        Pessoa pessoaEncontrada = consultarPessoasPorNome(nome);
        pessoaEncontrada.setCpf(pessoaNova.getCpf());
        pessoaEncontrada.setNome(pessoaNova.getNome());
        return pessoaEncontrada;
    }

    public void deletar(Pessoa pessoa) throws PessoaException {
        if (pessoas.contains(pessoa)){
            pessoas.remove(pessoa);
            return;
        }
        throw new PessoaException("Não foi encontrado a pessoa para exclusão");
    }
    public void deletar(String nome) throws PessoaException {
        Pessoa pessoa = consultarPessoasPorNome(nome);
        this.deletar(pessoa);
    }
}
