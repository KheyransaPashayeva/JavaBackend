package az.atl.springcustomer.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto {
    private Long id;
    @NotBlank
    private String name;
    @NotBlank
    private String lastname;
    @Email
    private String email;
    @NotNull
    private String country;
}
