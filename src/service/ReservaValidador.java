package service;

//* Importa model */
import model.Reserva;

public class ReservaValidador {

  public boolean validar(Reserva reserva) {
    boolean isErro = false;

    if (reserva.getUsuario() == null || reserva.getUsuario().trim().isEmpty()) {
      System.out.println("⛔ Erro: Usuário inválido ⛔");
      isErro = true;
    }

    if (reserva.getSala() == null || reserva.getSala().trim().isEmpty()) {
      System.out.println("⛔ Erro: Sala inválida ⛔");
      isErro = true;
    }

    if (reserva.getHoras() <= 0) {
      System.out.println("⛔ Erro: Horas inválidas ⛔");
      isErro = true;
    }

    if (!reserva.getFormaPagamento().equalsIgnoreCase("pix")) {
      System.out.println("⛔ Erro: Pagamento inválido ⛔");
      isErro = true;
    }

    return isErro;
  }
}
