package repository;

import model.Reserva;

public interface ReservaRepositorio {
    String salvar(Reserva reserva);
    boolean reservaExistente(Reserva reserva);
}
