package sistema.projeto;

public class Main {
    public static void main(String[] args) {
        Cliente c = new Cliente("Natan");
        Cliente c2 = new Cliente("Natan");
        System.out.println(c.hashCode() + " segundo: " + c2.hashCode());
    }
}
