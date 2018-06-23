package Entities;

import org.primefaces.model.ScheduleEvent;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
@NamedQueries({
        @NamedQuery(
                name = "UPDATE_AGENDA_MEDECIN", query = "UPDATE Agenda a SET a.medecin.idMedecin= :idMed WHERE a.title=:idAgenda")
,  @NamedQuery(
        name = "FIND_ALL_AGENDA_MEDECIN", query = "SELECT a from Agenda a where a.medecin.idMedecin= :idMed")
        })
@Entity
public class Agenda implements ScheduleEvent,Serializable {



    @Id
    private String title;
    private Date startDate;
    private Date endDate;
    private boolean allDay = false;
    private boolean editable = true;



    @ManyToOne(cascade = CascadeType.ALL)
    private Medecin medecin;

    public Agenda() {
    }

    public Agenda(String title) {
        this.title = title;
    }

    public Agenda(String title, Date startDate, Date endDate) {
        this.title = title;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    @Override
    public String getId() {
        return null;
    }

    @Override
    public void setId(String id) {

    }

    @Override
    public Object getData() {
        return null;
    }

    @Override
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @Override
    public Date getEndDate() {
        return endDate;
    }

    @Override
    public boolean isAllDay() {
        return false;
    }

    @Override
    public String getStyleClass() {
        return null;
    }

    @Override
    public boolean isEditable() {
        return false;
    }

    @Override
    public String getDescription() {
        return null;
    }

    @Override
    public String getUrl() {
        return null;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Medecin getMedecin() {
        return medecin;
    }

    public void setMedecin(Medecin medecin) {
        this.medecin = medecin;
    }


    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Agenda other = (Agenda) obj;
        if ((this.title == null) ? (other.title != null) : !this.title.equals(other.title)) {
            return false;
        }
        if (this.startDate != other.startDate && (this.startDate == null || !this.startDate.equals(other.startDate))) {
            return false;
        }
        if (this.endDate != other.endDate && (this.endDate == null || !this.endDate.equals(other.endDate))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 61 * hash + (this.title != null ? this.title.hashCode() : 0);
        hash = 61 * hash + (this.startDate != null ? this.startDate.hashCode() : 0);
        hash = 61 * hash + (this.endDate != null ? this.endDate.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return "Agenda{title=" + title + ",startDate=" + startDate + ",endDate=" + endDate + "}";
    }

    public void setAllDay(boolean allDay) {
        this.allDay = allDay;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    }
}
