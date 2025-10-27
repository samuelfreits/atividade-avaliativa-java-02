public abstract class Contato {
    protected String tipo;

    public Contato(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public abstract void exibir();
}
