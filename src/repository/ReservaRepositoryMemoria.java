package repository;

import java.util.ArrayList;
import java.util.List;

import model.Reserva;

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
    public boolean reservaExistente(Reserva reserva) {
        for (String r : reservas) {
            if (r.contains(reserva.getSala())) {
                System.out.println("Sala já reservada.");
                return true;
            }
        }
        return false;
    }
}