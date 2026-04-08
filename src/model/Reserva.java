package model;

public class Reserva {
    String usuario;
    String sala;
    String tipoSala;
    int horas;
    boolean projetor;
    String formaPagamento;
    double valor = 0;

    public Reserva(String usuario, String sala, String tipoSala, int horas, boolean projetor, String formaPagamento, double valor) {
        this.usuario = usuario;
        this.sala = sala;
        this.tipoSala = tipoSala;
        this.horas = horas;
        this.projetor = projetor;
        this.valor = valor;
        this.formaPagamento = formaPagamento;
    }

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
        return valor;
    }
}
