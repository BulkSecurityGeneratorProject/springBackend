package com.bms.backend.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A STATE.
 */
@Entity
@Table(name = "state")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class STATE implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "c_ode")
    private String cOde;

    @Column(name = "d_escription")
    private String dEscription;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getcOde() {
        return cOde;
    }

    public STATE cOde(String cOde) {
        this.cOde = cOde;
        return this;
    }

    public void setcOde(String cOde) {
        this.cOde = cOde;
    }

    public String getdEscription() {
        return dEscription;
    }

    public STATE dEscription(String dEscription) {
        this.dEscription = dEscription;
        return this;
    }

    public void setdEscription(String dEscription) {
        this.dEscription = dEscription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        STATE sTATE = (STATE) o;
        if (sTATE.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), sTATE.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "STATE{" +
            "id=" + getId() +
            ", cOde='" + getcOde() + "'" +
            ", dEscription='" + getdEscription() + "'" +
            "}";
    }
}
