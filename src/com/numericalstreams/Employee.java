package com.numericalstreams;

import java.util.List;

public class Employee {
    private int eid;
    private String ename;
    private List<String> activities;
    private int salary;
    private String gender;
    private String city;


    public void setEid(int eid) {
        this.eid = eid;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public void setActivities(List<String> activities) {
        this.activities = activities;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public Integer getEid() {
        return eid;
    }
    public String getGender(){
        return gender;
    }

    public String getEname() {
        return ename;
    }

    public List<String> getActivities() {
        return activities;
    }

    public int getSalary() {
        return salary;
    }

    public Employee(int eid, String ename, List<String> act, int salary, String gender,String city) {
        this.eid = eid;
        this.ename = ename;
        this.activities = act;
        this.salary = salary;
        this.gender = gender;
        this.city= city;
    }

    @Override
    public int hashCode() {
        return eid;
    }

    public String toString() {
        return eid + "--" + ename;
    }

    @Override
    public boolean equals(Object obj1) {
        if (this == obj1)
            return true;
        else if (obj1 instanceof Employee && obj1 != null) {
            Employee ob1 = (Employee) obj1;
            int eid = ob1.eid;
            if ((eid == this.eid)) {
                return true;
            }
        }
        return false;
    }


}
