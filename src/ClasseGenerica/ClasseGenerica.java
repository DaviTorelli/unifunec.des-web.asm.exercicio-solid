package ClasseGenerica;

import java.util.ArrayList;
import java.util.List;

public class ClasseGenerica {

    private List<String> reservas = new ArrayList<>();

    public void reservar(String usuario, String sala, String tipoSala, int horas, boolean projetor, String formaPagamento) {

        if (usuario == null || usuario.trim().isEmpty()) {
            System.out.println("Usuário inválido.");
            return;
        }

        if (sala == null || sala.trim().isEmpty()) {
            System.out.println("Sala inválida.");
            return;
        }

        if (horas <= 0) {
            System.out.println("Horas inválidas.");
            return;
        }

        for (String r : reservas) {
            if (r.contains(sala)) {
                System.out.println("Sala já reservada.");
                return;
            }
        }

        double valor = 50 * horas;

        // PEGADINHA
        if (tipoSala == "laboratorio") {
            valor += 30;
        }

        if (projetor) {
            valor += 20;
        }

        if (formaPagamento.equalsIgnoreCase("pix")) {
            System.out.println("Pagamento PIX ok");
        } else {
            System.out.println("Pagamento inválido");
            return;
        }

        String dados = usuario + " - " + sala + " - " + valor;
        reservas.add(dados);

        System.out.println("Email enviado");
        System.out.println("Comprovante: " + dados);
    }
}
