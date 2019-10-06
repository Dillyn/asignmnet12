package com.cput.lakey.domain.classes;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

/**
 *
 */
@Entity
public class Endurance {
    @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idClass;

    private String name;

    /**
     * Default constructor
     */

    private Endurance() {
    }

    private Endurance(Endurance.Builder builder) {
        this.idClass = builder.idClass;
        this.name = builder.name;
    }

    public Integer getIdClass() {
        return idClass;
    }

    public String getName() {
        return name;
    }


    public static class Builder {

        private String name;
        private Integer idClass;

        public Endurance.Builder name(String name) {
            this.name = name;
            return this;
        }

        public Endurance.Builder idClass(Integer idClass) {
            this.idClass = idClass;
            return this;
        }


        public Endurance.Builder copy(Endurance classs) {
            this.name = classs.getName();
            this.idClass = classs.getIdClass();
            return this;
        }

        public Endurance build() {
            return new Endurance(this);
        }

    }

    @Override
    public String toString() {
        return "Class{" +
                "ClassId='" + idClass + '\'' +
                ", ClassName='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Endurance classs = (Endurance) o;
        return Objects.equals(idClass, classs.idClass);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idClass);
    }

}