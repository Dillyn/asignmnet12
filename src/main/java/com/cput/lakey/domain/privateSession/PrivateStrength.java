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
public class PrivateStrength {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String type;

    private Date date;


    private PrivateStrength() {
    }

    private PrivateStrength(PrivateStrength.Builder builder) {
        this.id = builder.id;
        this.date = builder.date;
        this.type = builder.type;
    }

    public Integer getId() {
        return id;
    }


    public Date getDate() {
        return date;
    }

    public String getType() {
        return type;
    }


    public static class Builder {

        private Date date;
        private String type;
        private Integer id;

        public PrivateStrength.Builder id(Integer id) {
            this.id = id;
            return this;
        }

        public PrivateStrength.Builder date(Date date) {
            this.date = date;
            return this;
        }

        public PrivateStrength.Builder type(String type) {
            this.type = type;
            return this;
        }

        public PrivateStrength.Builder copy(PrivateStrength privateStrength) {
            this.id = privateStrength.getId();
            this.date = privateStrength.getDate();
            this.type = privateStrength.getType();
            return this;
        }

        public PrivateStrength build() {
            return new PrivateStrength(this);
        }

    }

    @Override
    public String toString() {
        return "PrivateStrength{" +
                "PrivateStrengthId'" + id + '\'' +
                "PrivateStrengthDate'" + date + '\'' +
                "PrivateStrengthType'" + type + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PrivateStrength session = (PrivateStrength) o;
        return Objects.equals(id, session.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}