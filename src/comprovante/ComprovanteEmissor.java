package comprovante;

public class ComprovanteEmissor implements Comprovante {

    @Override
    public void emitir(String comprovante) {
        System.out.println("Comprovante da reserva: " + comprovante);
    }
}
