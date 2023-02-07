package controllers;

public class Person {
    private String name;
    private int age;
    private long id;

    public Person(long id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;


    }


    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
