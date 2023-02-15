package uz.pdp.libraryapp.user;


import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class User {
    private int id;
    private String fullName;
    private String phoneNumber;
    private Boolean isAdmin;
    private String password;
}
