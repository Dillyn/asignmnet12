package com.cput.lakey.domain.members;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

/**
 *
 */
@Entity
public class Gold {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idGold;

    private String name;

    private String lastName;


    /**
     *
     */


    private Gold() {
    }

    private Gold(Gold.Builder builder) {
        this.idGold = builder.idGold;
        this.name = builder.name;
        this.lastName = builder.lastName;
    }


    public Integer getIdGold() {
        return idGold;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }


    public static class Builder {

        private String name;
        private Integer idGold;
        private String lastName;

        public Gold.Builder name(String name) {
            this.name = name;
            return this;
        }

        public Gold.Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Gold.Builder idGold(Integer idGold) {
            this.idGold = idGold;
            return this;
        }


        public Gold.Builder copy(Gold gold) {
            this.name = gold.getName();
            this.idGold = gold.getIdGold();
            this.lastName = gold.getLastName();
            return this;
        }

        public Gold build() {
            return new Gold(this);
        }

    }

    @Override
    public String toString() {
        return "GoldMember{" +
                "GoldMemberId='" + idGold + '\'' +
                ", GoldMemberName='" + name + '\'' +
                ", GoldMemberLastName='" + lastName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Gold member = (Gold) o;
        return Objects.equals(idGold, member.idGold);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idGold);
    }

}