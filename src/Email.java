public class Email extends Contato {
    private String email;

    public Email(String email) {
        super("email");
        this.email = email;
    }

    public String getEmail() { return email; }

    @Override
    public void exibir() {
        System.out.println("  - Email: " + email);
    }
}
