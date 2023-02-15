package uz.pdp.libraryapp.user;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserDto {
    private int id;
    private String fullName;
    private String phoneNumber;
}
