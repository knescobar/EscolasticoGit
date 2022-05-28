package ec.edu.espe.arquitectura.escolastico.organizacionFisica.model;

import ec.edu.espe.arquitectura.escolastico.educacion.model.NrcHorario;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "ofi_aula")

public class Aula implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_aula", nullable = false)
    private Integer codAula;
    @Basic(optional = false)
    @Column(name = "cod_alterno", nullable = false, length = 10)
    private String codAlterno;
    @Basic(optional = false)
    @Column(name = "capacidad", nullable = false)
    private short capacidad;
    @Basic(optional = false)
    @Column(name = "piso", nullable = false)
    private short piso;
    @Basic(optional = false)
    @Column(name = "aud_usuario", nullable = false, length = 30)
    private String audUsuario;
    @Basic(optional = false)
    @Column(name = "aud_fecha", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date audFecha;
    @Basic(optional = false)
    @Column(name = "aud_ip", nullable = false, length = 30)
    private String audIp;
    @Basic(optional = false)
    @Column(name = "version", nullable = false)
    private int version;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ofiAula")
    private List<NrcHorario> eduNrcHorarioList;
    @JoinColumn(name = "cod_edificio", referencedColumnName = "cod_edificio")
    @ManyToOne
    private Edificio codEdificio;
    @JoinColumn(name = "cod_edificio_bloque", referencedColumnName = "cod_edificio_bloque")
    @ManyToOne
    private EdificioBloque codEdificioBloque;
    @JoinColumn(name = "cod_tipo_aula", referencedColumnName = "cod_tipo_aula")
    @ManyToOne
    private TipoAula codTipoAula;

    public Aula() {
    }

    public Aula(Integer codAula) {
        this.codAula = codAula;
    }

    public Aula(Integer codAula, String codAlterno, short capacidad, short piso, String audUsuario, Date audFecha, String audIp, int version) {
        this.codAula = codAula;
        this.codAlterno = codAlterno;
        this.capacidad = capacidad;
        this.piso = piso;
        this.audUsuario = audUsuario;
        this.audFecha = audFecha;
        this.audIp = audIp;
        this.version = version;
    }

    public Integer getCodAula() {
        return codAula;
    }

    public void setCodAula(Integer codAula) {
        this.codAula = codAula;
    }

    public String getCodAlterno() {
        return codAlterno;
    }

    public void setCodAlterno(String codAlterno) {
        this.codAlterno = codAlterno;
    }

    public short getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(short capacidad) {
        this.capacidad = capacidad;
    }

    public short getPiso() {
        return piso;
    }

    public void setPiso(short piso) {
        this.piso = piso;
    }

    public String getAudUsuario() {
        return audUsuario;
    }

    public void setAudUsuario(String audUsuario) {
        this.audUsuario = audUsuario;
    }

    public Date getAudFecha() {
        return audFecha;
    }

    public void setAudFecha(Date audFecha) {
        this.audFecha = audFecha;
    }

    public String getAudIp() {
        return audIp;
    }

    public void setAudIp(String audIp) {
        this.audIp = audIp;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public List<NrcHorario> getEduNrcHorarioList() {
        return eduNrcHorarioList;
    }

    public void setEduNrcHorarioList(List<NrcHorario> eduNrcHorarioList) {
        this.eduNrcHorarioList = eduNrcHorarioList;
    }

    public Edificio getCodEdificio() {
        return codEdificio;
    }

    public void setCodEdificio(Edificio codEdificio) {
        this.codEdificio = codEdificio;
    }

    public EdificioBloque getCodEdificioBloque() {
        return codEdificioBloque;
    }

    public void setCodEdificioBloque(EdificioBloque codEdificioBloque) {
        this.codEdificioBloque = codEdificioBloque;
    }

    public TipoAula getCodTipoAula() {
        return codTipoAula;
    }

    public void setCodTipoAula(TipoAula codTipoAula) {
        this.codTipoAula = codTipoAula;
    }
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codAula != null ? codAula.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Aula)) {
            return false;
        }
        Aula other = (Aula) object;
        if ((this.codAula == null && other.codAula != null) || (this.codAula != null && !this.codAula.equals(other.codAula))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.arquitectura.escolastico.model.OfiAula[ codAula=" + codAula + " ]";
    }
    
}
