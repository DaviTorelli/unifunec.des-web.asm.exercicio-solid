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

    Reserva reservaCamposInvalidos = new Reserva(
        "",
        "",
        "",
        1,
        false,
        "Cartão de Crédito");

    Reserva outraReserva = new Reserva(
        "Maria",
        "Sala B",
        "reunião",
        3,
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

    System.out.println("1️⃣ - - - RESERVA 1 - - - 1️⃣");
    service.processar(reserva);

    System.out.println("\n2️⃣ - - - RESERVA 2 (REPETIDA, DEVE GERAR ERRO) - - - 2️⃣");
    service.processar(reserva);

    System.out.println("\n3️⃣ - - - RESERVA 3 (CAMPOS INVÁLIDOS, DEVE GERAR ERRO) - - - 3️⃣");
    service.processar(reservaCamposInvalidos);

    System.out.println("\n4️⃣ - - - RESERVA 4 (DIFERENTE, DEVE SER PROCESSADA) - - - 4️⃣");
    service.processar(outraReserva);
  }
}
