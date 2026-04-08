package service;

import model.Reserva;

public class CalculadoraReserva {

    public double calcularTotal(Reserva reserva) {
        double valor = 50 * reserva.getHoras();

        if (reserva.getTipoSala().equals("laboratorio")) {
            valor += 30;
        }

        if (reserva.isProjetor()) {
            valor += 20;
        }

        return valor;
    }
}
