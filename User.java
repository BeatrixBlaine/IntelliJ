package Model;

import java.util.Calendar;

public class User {

    private String name, location;
    private long age, tahun_lahir;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public long getAge() {
        return age;
    }

    public void setAge(long age) {
        this.age = age;
    }

    public long getTahun_lahir() {
        return tahun_lahir;
    }

    public void setTahun_lahir(long tahun_lahir) {
        this.tahun_lahir = tahun_lahir;
    }
}
