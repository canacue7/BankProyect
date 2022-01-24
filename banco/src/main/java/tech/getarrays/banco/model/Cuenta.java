package tech.getarrays.banco.model;

import javax.persistence.*;

@Entity
public class Cuenta {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String fecha_crea;
    private String estado;
    private String tipo_cuenta;
    private Double saldo;
    private Long id_usuario;

    public Cuenta() {
    }

    public Cuenta(Long id, String fecha_crea, String estado, String tipo_cuenta, Double saldo, Long id_usuario) {
        this.id = id;
        this.fecha_crea = fecha_crea;
        this.estado = estado;
        this.tipo_cuenta = tipo_cuenta;
        this.saldo = saldo;
        this.id_usuario=id_usuario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFecha_crea() {
        return fecha_crea;
    }

    public void setFecha_crea(String fecha_crea) {
        this.fecha_crea = fecha_crea;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTipo_cuenta() {
        return tipo_cuenta;
    }

    public void setTipo_cuenta(String tipo_cuenta) {
        this.tipo_cuenta = tipo_cuenta;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public Long getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Long id_usuario) {
        this.id_usuario = id_usuario;
    }
}
