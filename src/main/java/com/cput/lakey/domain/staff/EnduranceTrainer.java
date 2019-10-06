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
public class EnduranceTrainer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idEnduranceTrainer;

    private String name;


    private String lastName;


    private String title;


    private EnduranceTrainer() {
    }

    private EnduranceTrainer(EnduranceTrainer.Builder builder) {
        this.idEnduranceTrainer = builder.idEnduranceTrainer;
        this.name = builder.name;
        this.lastName = builder.lastName;
        this.title = builder.title;
    }


    public Integer getIdEnduranceTrainer() {
        return idEnduranceTrainer;
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
        private Integer idEnduranceTrainer;
        private String lastName;
        private String title;


        public EnduranceTrainer.Builder name(String name) {
            this.name = name;
            return this;
        }

        public EnduranceTrainer.Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public EnduranceTrainer.Builder title(String title) {
            this.title = title;
            return this;
        }

        public EnduranceTrainer.Builder idEnduranceTrainer(Integer idEnduranceTrainer) {
            this.idEnduranceTrainer = idEnduranceTrainer;
            return this;
        }


        public EnduranceTrainer.Builder copy(EnduranceTrainer enduranceTrainer) {
            this.name = enduranceTrainer.getName();
            this.idEnduranceTrainer = enduranceTrainer.getIdEnduranceTrainer();
            this.lastName = enduranceTrainer.getLastName();
            this.title = enduranceTrainer.getTitle();
            return this;
        }

        public EnduranceTrainer build() {
            return new EnduranceTrainer(this);
        }

    }

    @Override
    public String toString() {
        return "EnduranceTrainer{" +
                "EnduranceTrainerId='" + idEnduranceTrainer + '\'' +
                ", EnduranceTrainerName='" + name + '\'' +
                ", EnduranceTrainerLastName='" + lastName + '\'' +
                ", EnduranceTrainerTitle='" + title + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EnduranceTrainer staff = (EnduranceTrainer) o;
        return Objects.equals(idEnduranceTrainer, staff.idEnduranceTrainer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEnduranceTrainer);
    }

}