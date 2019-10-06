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
public class PrivateEndurance {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer  id;
   private String type;
    private Date date;


    private PrivateEndurance() {
    }

    private PrivateEndurance(PrivateEndurance.Builder builder) {
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

        public PrivateEndurance.Builder id(Integer id) {
            this.id = id;
            return this;
        }

        public PrivateEndurance.Builder date(Date date) {
            this.date = date;
            return this;
        }

        public PrivateEndurance.Builder type(String type) {
            this.type = type;
            return this;
        }

        public PrivateEndurance.Builder copy(PrivateEndurance privateEndurance) {
            this.id = privateEndurance.getId();
            this.date = privateEndurance.getDate();
            this.type = privateEndurance.getType();
            return this;
        }

        public PrivateEndurance build() {
            return new PrivateEndurance(this);
        }

    }

    @Override
    public String toString() {
        return "PrivateEndurance{" +
                "PrivateEnduranceId'" + id + '\'' +
                "PrivateEnduranceDate'" + date + '\'' +
                "PrivateEnduranceType'" + type + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PrivateEndurance session = (PrivateEndurance) o;
        return Objects.equals(id, session.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}