package ra.demo_regist_login_logout.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDto {
    @NotEmpty(message = "Username is empty!")
    private String userName;
    @NotEmpty(message = "Username is empty!")
    private String password;
    @NotEmpty(message = "Username is empty!")
    private String fullName;
    @NotEmpty(message = "Username is empty!")
    private String address;
    @NotEmpty(message = "Username is empty!")
    @Email(message = "Email not valid")
    private String email;
}
