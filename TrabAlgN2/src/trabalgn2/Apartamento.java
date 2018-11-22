package trabalgn2;

public class Apartamento {
    private int numero; // número do apartamento
    private Morador morador; // morador do apartamento

    // construtor cheio recebe apenas o número do apartamento
    public Apartamento(int numero) {
        this.numero = numero;
    }

    // construtor vazio
    public Apartamento() {
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Morador getMorador() {
        return morador;
    }

    public void setMorador(Morador morador) {
        this.morador = morador;
    }
}
