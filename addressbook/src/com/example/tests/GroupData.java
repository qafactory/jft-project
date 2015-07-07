package com.example.tests;

public class GroupData implements Comparable<GroupData>{

    public String name;
    public String header;
    public String footer;

    public GroupData(String name, String header, String footer) {
        this.name = name;
        this.header = header;
        this.footer = footer;
    }

    public GroupData() {
    }

    @Override
    public String toString() {
        return "GroupDate [name=" + name + ", header=" + header + ", footer=" + footer + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GroupData groupData = (GroupData) o;

        return !(name != null ? !name.equals(groupData.name) : groupData.name != null);
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    @Override
    public int compareTo(GroupData other) {
        return this.name.toLowerCase().compareTo(other.name.toLowerCase());
    }
}
