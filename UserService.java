package Service;

import Model.UserResponse;

import java.time.LocalDate;
import java.time.Period;
import Model.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public UserResponse modifyresponse(User user){
        UserResponse response = new UserResponse();
        LocalDate today = LocalDate.now();
        response.setNama(user.getName());
        response.setAge(Period.between(user.getTahun_lahir(), today).getYears());
        response.setLocation(user.getLocation());
        return response;
    }

}
