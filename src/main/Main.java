package main;

//* Importa model */
import model.Reserva;

//* Importa repositorio */
import repository.ReservaRepositorio;
import repository.ReservaRepositoryMemoria;

//* Importa service */
import service.ReservaService;
import service.ReservaValidador;

//* Importa pagamento */
import pagamento.Pagamento;
import pagamento.PagamentoPix;

//* Importa notificacao */
import notificacao.EmailNotificador;
import notificacao.Notificador;

//* Importa comprovante */
import comprovante.ComprovanteEmissor;

public class Main {

  public static void main(String[] args) {
    Reserva reserva = new Reserva(
        "João",
        "Sala A",
        "laboratorio",
        2,
        true,
        "Pix");

    Reserva reservaRepetida = new Reserva(
        "João",
        "Sala A",
        "laboratorio",
        2,
        true,
        "Pix");

    ReservaValidador validador = new ReservaValidador();
    ReservaRepositorio repositorio = new ReservaRepositoryMemoria();
    Notificador notificador = new EmailNotificador();
    ComprovanteEmissor emissor = new ComprovanteEmissor();
    Pagamento pagamento = new PagamentoPix();

    ReservaService service = new ReservaService(
        validador,
        repositorio,
        notificador,
        emissor,
        pagamento);

    service.processar(reserva);
    service.processar(reservaRepetida);
  }
}
