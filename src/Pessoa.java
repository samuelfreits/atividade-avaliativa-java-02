import java.util.ArrayList;
import java.util.List;

public class Pessoa {
    private Contato[] contatos;
    private String nome;
    private int max;
    private int cont;

    public Pessoa(String nome, int max) {
        this.nome = nome;
        this.max = Math.max(0, max);
        this.contatos = new Contato[this.max];
        this.cont = 0;
    }

    public String getNome() { return nome; }

    public void adicionarContato(Contato c) {
        if (c == null) return;
        if (cont < max) {
            contatos[cont++] = c;
        } else {
            System.out.println("Pessoa '" + nome + "': limite de contatos atingido.");
        }
    }

    public Contato[] getContatos() {
        Contato[] copia = new Contato[cont];
        System.arraycopy(contatos, 0, copia, 0, cont);
        return copia;
    }

    public Contato[] getContatos(String tipo) {
        if (tipo == null) tipo = "";
        List<Contato> lista = new ArrayList<>();
        for (int i = 0; i < cont; i++) {
            if (contatos[i].getTipo().equalsIgnoreCase(tipo)) {
                lista.add(contatos[i]);
            }
        }
        return lista.toArray(new Contato[0]);
    }

    public boolean possuiEmail() {
        for (int i = 0; i < cont; i++) {
            if (contatos[i] instanceof Email) return true;
            if (contatos[i].getTipo().equalsIgnoreCase("email")) return true;
        }
        return false;
    }

    public boolean possuiTelefone() {
        for (int i = 0; i < cont; i++) {
            if (contatos[i] instanceof Telefone) return true;
            if (contatos[i].getTipo().equalsIgnoreCase("telefone")) return true;
        }
        return false;
    }

    public void exibirContatos() {
        System.out.println("Pessoa: " + nome);
        if (cont == 0) {
            System.out.println("  (sem contatos)");
            return;
        }
        for (int i = 0; i < cont; i++) {
            contatos[i].exibir();
        }
    }
}
