package com.cput.lakey.domain.privateSession;

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
public class PrivateSession {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String type;

    private Date privateSessionDate;


    private PrivateSession() {
    }

    private PrivateSession(PrivateSession.Builder builder) {
        this.id = builder.id;
        this.privateSessionDate = builder.privateSessionDate;
        this.type = builder.type;
    }

    public Integer getId() {
        return id;
    }

    public Date getPrivateSessionDate() {
        return privateSessionDate;
    }

    public String getType() {
        return type;
    }


    public static class Builder {

        private Date privateSessionDate;
        private String type;
        private Integer id;

        public PrivateSession.Builder id(Integer id) {
            this.id = id;
            return this;
        }

        public PrivateSession.Builder date(Date date) {
            this.privateSessionDate = date;
            return this;
        }

        public PrivateSession.Builder type(String type) {
            this.type = type;
            return this;
        }

        public PrivateSession.Builder copy(PrivateSession privateSession) {
            this.id = privateSession.getId();
            this.privateSessionDate = privateSession.getPrivateSessionDate();
            this.type = privateSession.getType();
            return this;
        }

        public PrivateSession build() {
            return new PrivateSession(this);
        }

    }

    @Override
    public String toString() {
        return "PrivateSession{" +
                "PrivateSessionId'" + id + '\'' +
                "PrivateSessionDate'" + privateSessionDate + '\'' +
                "PrivateSessionType'" + type + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PrivateSession session = (PrivateSession) o;
        return Objects.equals(id, session.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}