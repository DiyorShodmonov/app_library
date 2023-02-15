package uz.pdp.libraryapp.author;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Author {
    private Integer id;
    private String fullName;
    private String biography;

}
