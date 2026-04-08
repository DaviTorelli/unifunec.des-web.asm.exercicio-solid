package notificacao;

public class EmailNotificador implements Notificador {

    @Override
    public void notificar(String cliente) {
        System.out.println("E-mail enviado para " + cliente);
    }
}
