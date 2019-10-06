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
public class Silver {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idSilver;

    private String name;

    private String lastName;


    /**
     *
     */


    private Silver() {
    }

    private Silver(Silver.Builder builder) {
        this.idSilver = builder.idSilver;
        this.name = builder.name;
        this.lastName = builder.lastName;
    }


    public Integer getIdSilver() {
        return idSilver;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }


    public static class Builder {

        private String name;
        private Integer idSilver;
        private String lastName;

        public Silver.Builder name(String name) {
            this.name = name;
            return this;
        }

        public Silver.Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Silver.Builder idSilver(Integer idSilver) {
            this.idSilver = idSilver;
            return this;
        }


        public Silver.Builder copy(Silver silver) {
            this.name = silver.getName();
            this.idSilver = silver.getIdSilver();
            this.lastName = silver.getLastName();
            return this;
        }

        public Silver build() {
            return new Silver(this);
        }

    }

    @Override
    public String toString() {
        return "GoldMember{" +
                "GoldMemberId='" + idSilver + '\'' +
                ", GoldMemberName='" + name + '\'' +
                ", GoldMemberLastName='" + lastName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Silver member = (Silver) o;
        return Objects.equals(idSilver, member.idSilver);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idSilver);
    }

}