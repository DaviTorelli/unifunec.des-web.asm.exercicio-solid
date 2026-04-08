package service;

//* Importa model */
import model.Reserva;

public class CalculadoraReserva {

  public double calcularTotal(Reserva reserva) {
    double valorHora = 50;
    double valorTotal = valorHora * reserva.getHoras();

    if (reserva.getTipoSala().equals("laboratorio")) {
      double valorLaboratorio = 30;
      valorTotal += valorLaboratorio;
    }

    if (reserva.isProjetor()) {
      double valorProjetor = 20;
      valorTotal += valorProjetor;
    }

    return valorTotal;
  }
}
