package com.cput.lakey.domain.members;

import javax.persistence.*;
import java.util.Objects;

/**
 *
 */
@Entity
@Table(name="gymMember")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Integer idMember;

    private String name;

    private String lastName;


    /**
     *
     */


    private Member() {
    }

    private Member(Member.Builder builder) {
        this.idMember = builder.idMember;
        this.name = builder.name;
        this.lastName = builder.lastName;
    }


    public Integer getIdMember() {
        return idMember;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }


    public static class Builder {
        private Integer idMember;
        private String name;

        private String lastName;

        public Member.Builder idMember(Integer idMember) {
            this.idMember = idMember;
            return this;
        }

        public Member.Builder name(String name) {
            this.name = name;
            return this;
        }

        public Member.Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }




        public Member.Builder copy(Member member) {
            this.idMember = member.getIdMember();
            this.name = member.getName();

            this.lastName = member.getLastName();
            return this;
        }

        public Member build() {
            return new Member(this);
        }

    }

    @Override
    public String toString() {
        return "Member{" +
                "MemberId='" + idMember + '\'' +
                ", MemberName='" + name + '\'' +
                ", MemberLastName='" + lastName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Member member = (Member) o;
        return Objects.equals(idMember, member.idMember);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idMember);
    }

}