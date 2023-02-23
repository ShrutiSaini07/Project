package com.shruti.anas;

public class Model_Students {

    String Name,Uid;

    public Model_Students(String name, String uid) {
        Name = name;
        Uid = uid;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getUid() {
        return Uid;
    }

    public void setUid(String uid) {
        Uid = uid;
    }
}
