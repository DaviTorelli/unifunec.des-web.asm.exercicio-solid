package service;

import model.Reserva;

public class ReservaValidador {

    public void validar(Reserva reserva) {
        if (reserva.getUsuario() == null || reserva.getUsuario().trim().isEmpty()) {
            throw new IllegalArgumentException("Usuário inválido.");
        }

        if (reserva.getSala() == null || reserva.getSala().trim().isEmpty()) {
            throw new IllegalArgumentException("Sala inválida.");
        }

        if (reserva.getHoras() <= 0) {
            throw new IllegalArgumentException("Horas inválidas.");
        }
    }
}
