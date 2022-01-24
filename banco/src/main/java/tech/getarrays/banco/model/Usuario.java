package tech.getarrays.banco.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String tipoId;
    private Integer identificacion;
    private String name;
    private String apellido;
    private String email;
    @Temporal(TemporalType.DATE)
    private Date fecha_nac;
    private String fecha_crea;
    private Boolean estado;
    @Column(nullable = false, updatable = false)
    private String usuario_codigo;

    public Usuario() {
    }

    public Usuario(Long id, String tipoId, Integer identificacion, String name, String apellido,
                   String email, Date fecha_nac, String fecha_crea, Boolean estado, String usuario_codigo) {
        this.id = id;
        this.tipoId = tipoId;
        this.identificacion = identificacion;
        this.name = name;
        this.apellido = apellido;
        this.email = email;
        this.fecha_nac = fecha_nac;
        this.fecha_crea = fecha_crea;
        this.estado = estado;
        this.usuario_codigo = usuario_codigo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTipoId() {
        return tipoId;
    }

    public void setTipoId(String tipoId) {
        this.tipoId = tipoId;
    }

    public Integer getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(Integer identificacion) {
        this.identificacion = identificacion;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getFecha_nac() {
        return fecha_nac;
    }

    public void setFecha_nac(Date fecha_nac) {
        this.fecha_nac = fecha_nac;
    }

    public String getFecha_crea() {
        return fecha_crea;
    }

    public void setFecha_crea(String fecha_crea) {
        this.fecha_crea = fecha_crea;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public String getUsuario_codigo() {
        return usuario_codigo;
    }

    public void setUsuario_codigo(String usuario_codigo) {
        this.usuario_codigo = usuario_codigo;
    }
}
