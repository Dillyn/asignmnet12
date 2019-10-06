package com.cput.lakey.domain.studio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

/**
 *
 */
@Entity
public class Studio {

    @Id
   // @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer studioId;

    private String name;


    private Studio() {
    }

    private Studio(Studio.Builder builder) {
        this.studioId = builder.id;
        this.name = builder.name;

    }

    public Integer getId() {
        return studioId;
    }

    public String getName() {
        return name;
    }


    public static class Builder {

        private String name;
        private Integer id;

        public Studio.Builder id(Integer id) {
            this.id = id;
            return this;
        }

        public Studio.Builder name(String name) {
            this.name = name;
            return this;
        }


        public Studio.Builder copy(Studio studio) {
            this.id = studio.getId();
            this.name = studio.getName();
            return this;
        }

        public Studio build() {
            return new Studio(this);
        }

    }

    @Override
    public String toString() {
        return "Studio{StudioId='" + studioId + '\'' +
                ", Studio='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Studio staff = (Studio) o;
        return staff.equals(staff.studioId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studioId);
    }

}