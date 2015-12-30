package ua.nure.kushnarenko.rest.myapi.entity;

import java.sql.Date;

public class Agreement {

    private Long id;

    private User user;

    private Bicycle bicycle;

    private Date fromDate;

    private Date toDate;

    public Agreement() {
    }

    @Override
    public String toString() {
        return "Agreement{" +
                "id=" + id +
                ", user=" + user +
                ", bicycle=" + bicycle +
                ", fromDate=" + fromDate +
                ", toDate=" + toDate +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Agreement(User user, Bicycle bicycle, Date fromDate, Date toDate) {

        this.user = user;
        this.bicycle = bicycle;
        this.fromDate = fromDate;
        this.toDate = toDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Bicycle getBicycle() {
        return bicycle;
    }

    public void setBicycle(Bicycle bicycle) {
        this.bicycle = bicycle;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

}
