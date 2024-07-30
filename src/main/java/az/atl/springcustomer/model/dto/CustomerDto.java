package az.atl.springcustomer.model.dto;

import az.atl.springcustomer.dao.entity.OrderEntity;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto {
    private Long id;
    @NotBlank
    private String name;
    @NotBlank
    private String lastName;
    @Email
    private String email;
    @NotNull
    private String country;
   private List<OrderEntity> orders;
}
