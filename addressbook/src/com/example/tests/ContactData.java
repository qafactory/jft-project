package com.example.tests;

public class ContactData implements Comparable<ContactData>{

    public String firstname;
    public String lastname;
    public String address;
    public String homephone;
    public String mobilephone;
    public String workphone;
    public String email1;
    public String email2;
    public String bday;
    public String bmonth;
    public String byear;
    public String group;
    public String address2;
    public String phone2;

    public ContactData(String firstname, String lastname, String address, String homephone, String mobilephone, String workphone, String email1, String email2, String bday, String bmonth, String byear, String group, String address2, String phone2) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.homephone = homephone;
        this.mobilephone = mobilephone;
        this.workphone = workphone;
        this.email1 = email1;
        this.email2 = email2;
        this.bday = bday;
        this.bmonth = bmonth;
        this.byear = byear;
        this.group = group;
        this.address2 = address2;
        this.phone2 = phone2;
    }

    public ContactData(){
    }

    @Override
    public String toString() {
        return "ContactData{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", address='" + address + '\'' +
                ", homephone='" + homephone + '\'' +
                ", mobilephone='" + mobilephone + '\'' +
                ", workphone='" + workphone + '\'' +
                ", email1='" + email1 + '\'' +
                ", email2='" + email2 + '\'' +
                ", bday='" + bday + '\'' +
                ", bmonth='" + bmonth + '\'' +
                ", byear='" + byear + '\'' +
                ", group='" + group + '\'' +
                ", address2='" + address2 + '\'' +
                ", phone2='" + phone2 + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactData that = (ContactData) o;

        return !(lastname != null ? !lastname.equals(that.lastname) : that.lastname != null);
    }

    @Override
    public int hashCode() {
        //int result = lastname != null ? lastname.hashCode() : 0;
        return lastname != null ? lastname.hashCode() : 0;
    }

    @Override
    public int compareTo(ContactData other) {
        return this.lastname.toLowerCase().compareTo(other.lastname.toLowerCase());
    }
}
