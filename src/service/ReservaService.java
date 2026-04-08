package service;

//* Importa model */
import model.Reserva;

//* Importa repositório */
import repository.ReservaRepositorio;

//* Importa pagamento */
import pagamento.Pagamento;

//* Importa notificação */
import notificacao.Notificador;

//* Importa comprovante */
import comprovante.ComprovanteEmissor;

public class ReservaService {

  private ReservaValidador validador;
  private ReservaRepositorio repositorio;
  private Notificador notificador;
  private ComprovanteEmissor comprovante;
  private Pagamento pagamento;

  public ReservaService(ReservaValidador validador,
      ReservaRepositorio repositorio,
      Notificador notificador,
      ComprovanteEmissor comprovante,
      Pagamento pagamento) {
    this.validador = validador;
    this.repositorio = repositorio;
    this.notificador = notificador;
    this.comprovante = comprovante;
    this.pagamento = pagamento;
  }

  public void processar(Reserva reserva) {
    validador.validar(reserva);

    if (repositorio.isSalaReservada(reserva)) {
      throw new IllegalStateException("Sala já reservada.");
    }

    pagamento.pagar(reserva.getValor());

    notificador.notificar(reserva.getUsuario());
    String dados = repositorio.salvar(reserva);
    comprovante.emitir(dados);
  }
}
