import java.util.HashSet;
import java.util.Set;

public class Agenda {
    private String proprietario;
    private Pessoa[] pessoas;
    private int max;
    private int cont;

    public Agenda(String proprietario, int max) {
        this.proprietario = proprietario;
        this.max = Math.max(0, max);
        this.pessoas = new Pessoa[this.max];
        this.cont = 0;
    }

    public void addPessoa(Pessoa p) {
        if (p == null) return;
        if (cont < max) {
            pessoas[cont++] = p;
        } else {
            System.out.println("Agenda: limite de pessoas atingido.");
        }
    }

    public Pessoa buscarPessoa(String nome) {
        if (nome == null) return null;
        for (int i = 0; i < cont; i++) {
            if (pessoas[i].getNome().equalsIgnoreCase(nome)) {
                return pessoas[i];
            }
        }
        return null;
    }

    public void addContato(String nome, Contato c) {
        Pessoa p = buscarPessoa(nome);
        if (p != null) p.adicionarContato(c);
    }

    public void exibirTodasPessoas() {
        System.out.println("=== Agenda de " + proprietario + " ===");
        if (cont == 0) {
            System.out.println("(sem pessoas)");
            return;
        }
        for (int i = 0; i < cont; i++) {
            pessoas[i].exibirContatos();
        }
    }

    public void exibirContatosPessoa(String nome) {
        Pessoa p = buscarPessoa(nome);
        if (p == null) {
            System.out.println("Pessoa '" + nome + "' não encontrada.");
            return;
        }
        p.exibirContatos();
    }

    public void exibirPessoasComEmail() {
        System.out.println("Pessoas com e-mail:");
        boolean achou = false;
        for (int i = 0; i < cont; i++) {
            if (pessoas[i].possuiEmail()) {
                System.out.println(" - " + pessoas[i].getNome());
                achou = true;
            }
        }
        if (!achou) System.out.println(" (nenhuma)");
    }

    public void recuperarPessoaPorEmail(String email) {
        if (email == null || email.isBlank()) {
            System.out.println("E-mail inválido.");
            return;
        }
        System.out.println("Pessoas com e-mail '" + email + "':");
        Set<String> nomes = new HashSet<>();
        for (int i = 0; i < cont; i++) {
            for (Contato c : pessoas[i].getContatos("email")) {
                if (c instanceof Email e && e.getEmail().equalsIgnoreCase(email)) {
                    nomes.add(pessoas[i].getNome());
                }
            }
        }
        if (nomes.isEmpty()) {
            System.out.println(" (nenhuma)");
        } else {
            nomes.forEach(n -> System.out.println(" - " + n));
        }
    }

    public void recuperarPessoaPorTelefone(String telefone) {
        if (telefone == null || telefone.isBlank()) {
            System.out.println("Telefone inválido.");
            return;
        }
        System.out.println("Pessoas com telefone '" + telefone + "':");
        Set<String> nomes = new HashSet<>();
        for (int i = 0; i < cont; i++) {
            for (Contato c : pessoas[i].getContatos("telefone")) {
                if (c instanceof Telefone t && t.getTelefone().equals(telefone)) {
                    nomes.add(pessoas[i].getNome());
                }
            }
        }
        if (nomes.isEmpty()) {
            System.out.println(" (nenhuma)");
        } else {
            nomes.forEach(n -> System.out.println(" - " + n));
        }
    }
}
