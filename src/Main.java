//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Agenda agenda = new Agenda("Sam", 10);

        Pessoa ana = new Pessoa("Jose", 5);
        ana.adicionarContato(new Email("jose@gmail.com"));
        ana.adicionarContato(new Telefone("999999991"));

        Pessoa bruno = new Pessoa("Joao", 5);
        bruno.adicionarContato(new Telefone("999999992"));

        agenda.addPessoa(ana);
        agenda.addPessoa(bruno);

        agenda.addContato("Joao", new Email("joao@hotmail.com"));

        agenda.exibirTodasPessoas();
        System.out.println();

        agenda.exibirContatosPessoa("Jose");
        System.out.println();

        agenda.exibirPessoasComEmail();
        System.out.println();

        agenda.recuperarPessoaPorEmail("joao@hotmail.com");
        agenda.recuperarPessoaPorTelefone("999999992");
    }
}
