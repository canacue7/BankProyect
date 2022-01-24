package tech.getarrays.banco.model;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Entity
public class Operaciones {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String tipo_transfer;
    private String fecha_transfer;
    private Double saldo_in;
    private Double saldo_fin;
    private Double monto;
    private String mov_financiero;
    private Long id_cuenta;
    private Long id_cuenta_destino;

    public Operaciones() {
    }

    public Operaciones(Long id, String tipo_transfer, String fecha_transfer, Double saldo_in, Double saldo_fin, Double monto, String mov_financiero, Long id_cuenta, Long id_cuenta_destino) {
        this.id = id;
        this.tipo_transfer = tipo_transfer;
        this.fecha_transfer = fecha_transfer;
        this.saldo_in = saldo_in;
        this.saldo_fin = saldo_fin;
        this.monto = monto;
        this.mov_financiero = mov_financiero;
        this.id_cuenta = id_cuenta;
        this.id_cuenta_destino=id_cuenta_destino;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo_transfer() {
        return tipo_transfer;
    }

    public void setTipo_transfer(String tipo_transfer) {
        this.tipo_transfer = tipo_transfer;
    }

    public String getFecha_transfer() {
        return fecha_transfer;
    }

    public void setFecha_transfer(String fecha_transfer) {
        this.fecha_transfer = fecha_transfer;
        ;
    }

    public Double getSaldo_in() {
        return saldo_in;
    }

    public void setSaldo_in(Double saldo_in) {
        this.saldo_in = saldo_in;
    }

    public Double getSaldo_fin() {
        return saldo_fin;
    }

    public void setSaldo_fin(Double saldo_fin) {
        this.saldo_fin = saldo_fin;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public String getMov_financiero() {
        return mov_financiero;
    }

    public void setMov_financiero(String mov_financiero) {
        this.mov_financiero = mov_financiero;
    }

    public Long getId_cuenta() {
        return id_cuenta;
    }

    public void setId_cuenta(Long id_cuenta) {
        this.id_cuenta = id_cuenta;
    }

    public Long getId_cuenta_destino() {
        return id_cuenta_destino;
    }

    public void setId_cuenta_destino(Long id_cuenta_destino) {
        this.id_cuenta_destino = id_cuenta_destino;
    }
}
