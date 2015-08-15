package com.example.tests;

public class ContactData implements Comparable<ContactData>{

    public String id;
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
        return lastname != null ? lastname.hashCode() : 0;
    }

    @Override
    public int compareTo(ContactData other) {
        return this.lastname.toLowerCase().compareTo(other.lastname.toLowerCase());
    }

    public ContactData withFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public ContactData withLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public ContactData withAddress(String address) {
        this.address = address;
        return this;
    }

    public ContactData withHomePhone(String homephone) {
        this.homephone = homephone;
        return this;
    }

    public ContactData withMobilePhone(String mobilephone) {
        this.mobilephone = mobilephone;
        return this;
    }

    public ContactData withWorkPhone(String workphone) {
        this.workphone = workphone;
        return this;
    }

    public ContactData withEmail1(String email1) {
        this.email1 = email1;
        return this;
    }

    public ContactData withEmail2(String email2) {
        this.email2 = email2;
        return this;
    }

    public ContactData withBday(String bday) {
        this.bday = bday;
        return this;
    }

    public ContactData withBmonth(String bmonth) {
        this.bmonth = bmonth;
        return this;
    }

    public ContactData withByear(String byear) {
        this.byear = byear;
        return this;
    }

    public ContactData withGroup(String group) {
        this.group = group;
        return this;
    }

    public ContactData withAddress2(String address2) {
        this.address2 = address2;
        return this;
    }

    public ContactData withPhone2(String phone2) {
        this.phone2 = phone2;
        return this;
    }

    public String getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getAddress() {
        return address;
    }

    public String getHomephone() {
        return homephone;
    }

    public String getMobilephone() {
        return mobilephone;
    }

    public String getWorkphone() {
        return workphone;
    }

    public String getEmail1() {
        return email1;
    }

    public String getEmail2() {
        return email2;
    }

    public String getBday() {
        return bday;
    }

    public String getBmonth() {
        return bmonth;
    }

    public String getByear() {
        return byear;
    }

    public String getGroup() {
        return group;
    }

    public String getAddress2() {
        return address2;
    }

    public String getPhone2() {
        return phone2;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setHomephone(String homephone) {
        this.homephone = homephone;
    }

    public void setMobilephone(String mobilephone) {
        this.mobilephone = mobilephone;
    }

    public void setWorkphone(String workphone) {
        this.workphone = workphone;
    }

    public void setEmail1(String email1) {
        this.email1 = email1;
    }

    public void setEmail2(String email2) {
        this.email2 = email2;
    }

    public void setBday(String bday) {
        this.bday = bday;
    }

    public void setBmonth(String bmonth) {
        this.bmonth = bmonth;
    }

    public void setByear(String byear) {
        this.byear = byear;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }
}
