package service;

import comprovante.ComprovanteEmissor;
import model.Reserva;
import notificacao.Notificador;
import pagamento.Pagamento;
import repository.ReservaRepositorio;

public class ReservaService {

    private ReservaValidador validador;
    private ReservaRepositorio repositorio;
    private Notificador notificador;
    private ComprovanteEmissor emissor;

    public ReservaService(ReservaValidador validador,
            ReservaRepositorio repositorio,
            Notificador notificador,
            ComprovanteEmissor emissor) {
        this.validador = validador;
        this.repositorio = repositorio;
        this.notificador = notificador;
        this.emissor = emissor;
    }

    public void processar(Reserva reserva, Pagamento pagamento) {
        validador.validar(reserva);

        repositorio.reservaExistente(reserva);

        double total = reserva.getValor();
        pagamento.pagar(total);

        notificador.notificar(reserva.getUsuario());

        String comprovante = repositorio.salvar(reserva);
        emissor.emitir(comprovante);
    }
}
