package Entities;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Entity
public class PostOperation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPostOperation;

    @NotNull
    @Future
    @Column(name = "date_debut")
    private Date dateDebut;

    @NotNull
    @Future
    @Column(name = "date_fin")
    private Date dateFin;

    @Lob
    @Column(name = "rapport_postoperation")
    private byte[] rappotPostOperation;

    @OneToOne
    @JoinColumn(name = "idOperation")
    private Operation operation;

    public PostOperation() {
    }

    public PostOperation(@NotNull @Future Date dateDebut, @NotNull @Future Date dateFin, byte[] rappotPostOperation, Operation operation) {
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.rappotPostOperation = rappotPostOperation;
        this.operation = operation;
    }

    public int getIdPostOperation() {
        return idPostOperation;
    }

    public void setIdPostOperation(int idPostOperation) {
        this.idPostOperation = idPostOperation;
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

    public byte[] getRappotPostOperation() {
        return rappotPostOperation;
    }

    public void setRappotPostOperation(byte[] rappotPostOperation) {
        this.rappotPostOperation = rappotPostOperation;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }
}
