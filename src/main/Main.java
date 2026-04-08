package main;

import comprovante.ComprovanteEmissor;
import model.Reserva;
import notificacao.EmailNotificador;
import notificacao.Notificador;
import pagamento.Pagamento;
import pagamento.PagamentoPix;
import repository.ReservaRepositorio;
import repository.ReservaRepositoryMemoria;
import service.ReservaService;
import service.ReservaValidador;

public class Main {

    public static void main(String[] args) {
        Reserva reserva = new Reserva(
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

        ReservaService service = new ReservaService(
                validador,
                repositorio,
                notificador, 
                emissor);

        Pagamento pagamento = new PagamentoPix();
        service.processar(reserva, pagamento);
    }
}
