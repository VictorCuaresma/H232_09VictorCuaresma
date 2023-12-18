package edu.pe.vallegrande.maestro2.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor

public class bienes {

    private Integer id_contabilidad;
    private Integer id_date;
    private Integer id_depre;
    private String code;
    private String detail;
    private Double value_book;
    private Integer amount;
    private Double porcentaje;
    private LocalDate date_admi;
    private LocalDate depre_admi;
    private Double depreciacion_anual;
    private Double depreciacion_mensual;
    private Double depreciacion_acumulada;
    private String status;
    
    public void setId_client(Integer id_contabilidad) {
        this.id_contabilidad = id_contabilidad;
    }
    public LocalDate getdate_admi() {
        return date_admi;
    }
    public LocalDate getdepre_admi() {
        return depre_admi;
    }
    public void setdate_admi(LocalDate date_admi) {
        this.date_admi = date_admi;
    }
    public void setdepre_admi(LocalDate depre_admi) {
        this.depre_admi = depre_admi;
    }

}
