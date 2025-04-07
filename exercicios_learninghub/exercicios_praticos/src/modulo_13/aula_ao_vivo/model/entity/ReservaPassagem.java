package modulo_13.aula_ao_vivo.model.entity;

import java.time.LocalDateTime;

public class ReservaPassagem extends Reserva {
    private String localEmbarque;
    private String localDesembarque;

    public ReservaPassagem(Long id, String descricao, String local, LocalDateTime dataReserva, double valor, String localEmbarque, String localDesembarque) {
        super(id, descricao, local, dataReserva, valor);
        this.localEmbarque = localEmbarque;
        this.localDesembarque = localDesembarque;
    }

    public String getLocalEmbarque() {
        return localEmbarque;
    }

    public void setLocalEmbarque(String localEmbarque) {
        this.localEmbarque = localEmbarque;
    }

    public String getLocalDesembarque() {
        return localDesembarque;
    }

    public void setLocalDesembarque(String localDesembarque) {
        this.localDesembarque = localDesembarque;
    }
}
