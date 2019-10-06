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
public class HelpDesk {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idHelpDesk;

    private String name;


    private String lastName;


    private String title;


    private HelpDesk() {
    }

    private HelpDesk(HelpDesk.Builder builder) {
        this.idHelpDesk = builder.idHelpDesk;
        this.name = builder.name;
        this.lastName = builder.lastName;
        this.title = builder.title;
    }


    public Integer getIdHelpDesk() {
        return idHelpDesk;
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
        private Integer idHelpDesk;
        private String lastName;
        private String title;


        public HelpDesk.Builder name(String name) {
            this.name = name;
            return this;
        }

        public HelpDesk.Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public HelpDesk.Builder title(String title) {
            this.title = title;
            return this;
        }

        public HelpDesk.Builder idHelpDesk(Integer idHelpDesk) {
            this.idHelpDesk = idHelpDesk;
            return this;
        }


        public HelpDesk.Builder copy(HelpDesk helpDesk) {
            this.name = helpDesk.getName();
            this.idHelpDesk = helpDesk.getIdHelpDesk();
            this.lastName = helpDesk.getLastName();
            this.title = helpDesk.getTitle();
            return this;
        }

        public HelpDesk build() {
            return new HelpDesk(this);
        }

    }

    @Override
    public String toString() {
        return "HelpDesk{" +
                "HelpDeskId='" + idHelpDesk + '\'' +
                ", HelpDeskName='" + name + '\'' +
                ", HelpDeskLastName='" + lastName + '\'' +
                ", HelpDeskTitle='" + title + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HelpDesk staff = (HelpDesk) o;
        return Objects.equals(idHelpDesk, staff.idHelpDesk);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idHelpDesk);
    }

}