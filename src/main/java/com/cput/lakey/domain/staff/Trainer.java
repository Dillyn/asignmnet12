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
public class Trainer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer trainerId;

    private String name;


    private String lastName;


    private String title;


    private Trainer() {
    }

    private Trainer(Trainer.Builder builder) {
        this.trainerId = builder.idTrainer;
        this.name = builder.name;
        this.lastName = builder.lastName;
        this.title = builder.title;
    }


    public Integer getIdTrainer() {
        return trainerId;
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
        private Integer idTrainer;
        private String lastName;
        private String title;


        public Trainer.Builder name(String name) {
            this.name = name;
            return this;
        }

        public Trainer.Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Trainer.Builder title(String title) {
            this.title = title;
            return this;
        }

        public Trainer.Builder idTrainer(Integer idTrainer) {
            this.idTrainer = idTrainer;
            return this;
        }


        public Trainer.Builder copy(Trainer trainer) {
            this.name = trainer.getName();
            this.idTrainer = trainer.getIdTrainer();
            this.lastName = trainer.getLastName();
            this.title = trainer.getTitle();
            return this;
        }

        public Trainer build() {
            return new Trainer(this);
        }

    }

    @Override
    public String toString() {
        return "Trainer{" +
                "TrainerId='" + trainerId + '\'' +
                ", TrainerName='" + name + '\'' +
                ", TrainerLastName='" + lastName + '\'' +
                ", TrainerTitle='" + title + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Trainer staff = (Trainer) o;
        return Objects.equals(trainerId, staff.trainerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(trainerId);
    }

}