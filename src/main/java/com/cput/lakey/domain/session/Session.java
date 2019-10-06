package com.cput.lakey.domain.session;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import java.util.Objects;

/**
 *
 */
@Entity
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Date sessionDate;

    private Session() {
    }

    private Session(Session.Builder builder) {
        this.id = builder.id;
        this.sessionDate = builder.date;

    }

    public Integer getId() {
        return id;
    }

    public Date getSessionDate() {
        return sessionDate;
    }


    public static class Builder {

        private Integer id;
        private Date date;

        public Session.Builder id(Integer id) {
            this.id = id;
            return this;
        }

        public Session.Builder date(Date date) {
            this.date = date;
            return this;
        }


        public Session.Builder copy(Session session) {
            this.id = session.getId();
            this.date = session.getSessionDate();

            return this;
        }

        public Session build() {
            return new Session(this);
        }

    }

    @Override
    public String toString() {
        return "Session{" +
                "SessionId'" + id + '\'' +
                "SessionDate='" + sessionDate + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Session session = (Session) o;
        return Objects.equals(id, session.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}