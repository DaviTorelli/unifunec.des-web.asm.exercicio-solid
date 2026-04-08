package repository;

//* Importa model */
import model.Reserva;

//* Importa bibliotecas */
import java.util.ArrayList;
import java.util.List;

public class ReservaRepositoryMemoria implements ReservaRepositorio {

  private List<String> reservas = new ArrayList<>();

  @Override
  public String salvar(Reserva reserva) {
    String dados = reserva.getUsuario() + " - " + reserva.getSala() + " - " + reserva.getValor();
    reservas.add(dados);
    System.out.println("Reserva salva em memória.");
    return dados;
  }

  @Override
  public boolean isSalaReservada(Reserva reserva) {
    for (String r : reservas) {
      if (r.contains(reserva.getSala())) {
        return true;
      }
    }
    return false;
  }
}