package br.unicesumar;

public class Principal {

    public static void main(String[] args) {
        try {
            Pessoa edson = new Pessoa("11111", "Edson");
            Pessoa vini = new Pessoa("22222", "Vini");

            ControlePessoas controlePessoas = new ControlePessoas();
            controlePessoas.inserirPessoa(edson);
            controlePessoas.inserirPessoa(vini);

            System.out.println(controlePessoas.exibirTodos());

            Pessoa pessoa = controlePessoas.consultarPessoasPorNome("Vini");
            System.out.println("Pessoa encontrada: "+pessoa);

            Pessoa edsonNovo = new Pessoa("00000", "Edson Lessa");
            Pessoa pessoaAterada = controlePessoas.alterarPessoa("Edson", edsonNovo);
            System.out.println("Pessoa alterada: "+pessoaAterada);
            System.out.println(controlePessoas.exibirTodos());

            controlePessoas.deletar(pessoaAterada);
            System.out.println(controlePessoas.exibirTodos());
            controlePessoas.deletar("vini");
            System.out.println(controlePessoas.exibirTodos());
        } catch (PessoaException e) {
            System.out.println(e.getMessage());
        }
    }
}
