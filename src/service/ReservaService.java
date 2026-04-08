package service;

import model.Reserva;
import notificacao.Notificador;
import pagamento.Pagamento;
import repository.ReservaRepositorio;

public class ReservaService {

    private ReservaValidador validador;
    private CalculadoraReserva calculadora;
    private ReservaRepositorio repositorio;
    private Notificador notificador;

    public ReservaService(ReservaValidador validador,
            CalculadoraReserva calculadora,
            ReservaRepositorio repositorio,
            Notificador notificador) {
        this.validador = validador;
        this.calculadora = calculadora;
        this.repositorio = repositorio;
        this.notificador = notificador;
    }

    public void processar(Reserva reserva, Pagamento pagamento) {
        validador.validar(reserva);
        double total = calculadora.calcularTotal(reserva);
        pagamento.pagar(total);
        String comprovante = repositorio.salvar(reserva);
        notificador.notificar(reserva.getUsuario());
        System.out.println("Comprovante: " + comprovante);
    }
}
