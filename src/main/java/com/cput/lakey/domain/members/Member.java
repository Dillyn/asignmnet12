package com.cput.lakey.domain.members;

import javax.persistence.*;
import java.util.Objects;

/**
 *
 */
@Entity
@Table(name = "gymMember")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;


    /**
     *
     */


    private Member() {
    }

    private Member(Member.Builder builder) {
        this.id = builder.id;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
    }


    public Integer getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }


    public static class Builder {
        private Integer id;
        private String firstName;

        private String lastName;

        public Member.Builder idMember(Integer idMember) {
            this.id = idMember;
            return this;
        }

        public Member.Builder name(String name) {
            this.firstName = name;
            return this;
        }

        public Member.Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }


        public Member.Builder copy(Member member) {
            this.id = member.getId();
            this.firstName = member.getFirstName();

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
                "MemberId='" + id + '\'' +
                ", MemberName='" + firstName + '\'' +
                ", MemberLastName='" + lastName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Member member = (Member) o;
        return Objects.equals(id, member.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}