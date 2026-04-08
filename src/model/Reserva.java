package model;

//* Importa service */
import service.CalculadoraReserva;

public class Reserva {
  String usuario;
  String sala;
  String tipoSala;
  int horas;
  boolean projetor;
  String formaPagamento;

  public Reserva(String usuario, String sala, String tipoSala, int horas, boolean projetor, String formaPagamento) {
    this.usuario = usuario;
    this.sala = sala;
    this.tipoSala = tipoSala;
    this.horas = horas;
    this.projetor = projetor;
    this.formaPagamento = formaPagamento;
  }

  // * Getters *//

  public String getUsuario() {
    return usuario;
  }

  public String getSala() {
    return sala;
  }

  public String getTipoSala() {
    return tipoSala;
  }

  public int getHoras() {
    return horas;
  }

  public boolean isProjetor() {
    return projetor;
  }

  public String getFormaPagamento() {
    return formaPagamento;
  }

  public double getValor() {
    CalculadoraReserva calculadora = new CalculadoraReserva();
    return calculadora.calcularTotal(this);
  }
}
