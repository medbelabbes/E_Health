package Entities;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;


@Entity
public class PreOperation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPreOperation;

    @NotNull
    @Future
    @Column(name = "date_debut")
    private Date dateDebut;

    @NotNull
    @Future
    @Column(name = "date_fin")
    private Date dateFin;

    @Lob
    @Column(name = "rapport_preoperation")
    private byte[] rappotPreOperation;

    @OneToOne
    @JoinColumn(name = "idOperation")
    private Operation operation;

    public PreOperation(@NotNull @Future Date dateDebut, @NotNull @Future Date dateFin, byte[] rappotPreOperation, Operation operation) {
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.rappotPreOperation = rappotPreOperation;
        this.operation = operation;
    }

    public PreOperation() {
    }

    public int getIdPreOperation() {
        return idPreOperation;
    }

    public void setIdPreOperation(int idPreOperation) {
        this.idPreOperation = idPreOperation;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public byte[] getRappotPreOperation() {
        return rappotPreOperation;
    }

    public void setRappotPreOperation(byte[] rappotPreOperation) {
        this.rappotPreOperation = rappotPreOperation;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }
}
