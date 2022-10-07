package Service;

import Model.UserResponse;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.time.Period;
import Model.User;

public class UserService {

    public String nama;
    public long age;
    public String location;

    public UserResponse modifyresponse(User user){
        UserResponse response = new UserResponse();
        LocalDate today = LocalDate.now();
        response.setNama(user.getName());
        response.setAge(Period.between(user.getTahun_lahir(), today).getYears());
        response.setLocation(user.getLocation());
        return response;
    }

}
