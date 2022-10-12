package Model;

import java.util.Calendar;
import java.time.LocalDate;

public class User {

    private String name, location;

    private LocalDate tahun_lahir;

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


    public LocalDate getTahun_lahir() {
        return tahun_lahir;
    }

    public void setTahun_lahir(LocalDate tahun_lahir) {
        this.tahun_lahir = tahun_lahir;
    }
}
