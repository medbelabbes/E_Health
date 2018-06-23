package Entities;

import Entities.Types.OperationType;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
public class Consigne implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idConsigne;


    @Size(min = 5, max = 500)
    private String Consigne;

    @Enumerated(EnumType.STRING)
    private OperationType Operation;

    //chacun  d'opération ou préOpération ou PostOpération posséde plusiéurs consignes
    @ManyToOne
    @JoinColumn(name = "idOperation")
    private Operation operation;

    public Consigne(@NotNull @Size(min = 5, max = 500) String consigne, @NotNull @Size(min = 5, max = 13) OperationType operation, Entities.Operation operation1) {
        Consigne = consigne;
        Operation = operation;
        this.operation = operation1;
    }

    public Consigne() {
    }

    public int getIdConsigne() {
        return idConsigne;
    }

    public void setIdConsigne(int idConsigne) {
        this.idConsigne = idConsigne;
    }

    public String getConsigne() {
        return Consigne;
    }

    public void setConsigne(String consigne) {
        Consigne = consigne;
    }

    public OperationType getOperation() {
        return Operation;
    }

    public void setOperation(Entities.Operation operation) {
        this.operation = operation;
    }

    public void setOperation(OperationType operation) {
        Operation = operation;
    }

}
