package repository;

//* Importa model */
import model.Reserva;

public interface ReservaRepositorio {
  String salvar(Reserva reserva);

  boolean isSalaReservada(Reserva reserva);
}
