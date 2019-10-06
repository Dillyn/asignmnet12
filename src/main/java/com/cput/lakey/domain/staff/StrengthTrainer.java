package com.cput.lakey.domain.staff;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

/**
 *
 */
@Entity
public class StrengthTrainer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idStrengthTrainer;

    private String name;


    private String lastName;


    private String title;


    private StrengthTrainer() {
    }

    private StrengthTrainer(StrengthTrainer.Builder builder) {
        this.idStrengthTrainer = builder.idStrengthTrainer;
        this.name = builder.name;
        this.lastName = builder.lastName;
        this.title = builder.title;
    }


    public Integer getIdStrengthTrainer() {
        return idStrengthTrainer;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getTitle() {
        return title;
    }


    public static class Builder {

        private String name;
        private Integer idStrengthTrainer;
        private String lastName;
        private String title;


        public StrengthTrainer.Builder name(String name) {
            this.name = name;
            return this;
        }

        public StrengthTrainer.Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public StrengthTrainer.Builder title(String title) {
            this.title = title;
            return this;
        }

        public StrengthTrainer.Builder idStrengthTrainer(Integer idStrengthTrainer) {
            this.idStrengthTrainer = idStrengthTrainer;
            return this;
        }


        public StrengthTrainer.Builder copy(StrengthTrainer strengthTrainer) {
            this.name = strengthTrainer.getName();
            this.idStrengthTrainer = strengthTrainer.getIdStrengthTrainer();
            this.lastName = strengthTrainer.getLastName();
            this.title = strengthTrainer.getTitle();
            return this;
        }

        public StrengthTrainer build() {
            return new StrengthTrainer(this);
        }

    }

    @Override
    public String toString() {
        return "StrengthTrainer{" +
                "StrengthTrainerId='" + idStrengthTrainer + '\'' +
                ", StrengthTrainerName='" + name + '\'' +
                ", StrengthTrainerLastName='" + lastName + '\'' +
                ", StrengthTrainerTitle='" + title + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StrengthTrainer staff = (StrengthTrainer) o;
        return Objects.equals(idStrengthTrainer, staff.idStrengthTrainer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idStrengthTrainer);
    }

}