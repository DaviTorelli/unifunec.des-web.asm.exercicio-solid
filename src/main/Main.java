package main;

import model.Reserva;
import notificacao.EmailNotificador;
import notificacao.Notificador;
import pagamento.Pagamento;
import pagamento.PagamentoPix;
import repository.ReservaRepositorio;
import repository.ReservaRepositoryMemoria;
import service.CalculadoraReserva;
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
                "Pix",
                0 // TODO: calcular valor com base no tipo de sala, horas e projetor
            );

        ReservaValidador validador = new ReservaValidador();
        CalculadoraReserva calculadora = new CalculadoraReserva();
        ReservaRepositorio repositorio = new ReservaRepositoryMemoria();
        Notificador notificador = new EmailNotificador();

        ReservaService service = new ReservaService(
                validador,
                calculadora,
                repositorio,
                notificador);

        Pagamento pagamento = new PagamentoPix();
        service.processar(reserva, pagamento);
    }
}
