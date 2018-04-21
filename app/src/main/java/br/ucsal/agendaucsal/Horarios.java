package br.ucsal.agendaucsal;

import java.time.LocalTime;

class Horarios {

    private Integer id;
    private String hora_inicio;
    private String hora_fim;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getHora_inicio() {
        return hora_inicio;
    }
    public void setHora_inicio(String hora_inicio) {
        this.hora_inicio = hora_inicio;
    }
    public String getHora_fim() {
        return hora_fim;
    }
    public void setHora_fim(String hora_fim) {
        this.hora_fim = hora_fim;
    }
}
