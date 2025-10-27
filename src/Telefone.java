public class Telefone extends Contato {
    private String telefone;

    public Telefone(String telefone) {
        super("telefone");
        this.telefone = telefone;
    }

    public String getTelefone() { return telefone; }

    @Override
    public void exibir() {
        System.out.println("  - Telefone: " + telefone);
    }
}
