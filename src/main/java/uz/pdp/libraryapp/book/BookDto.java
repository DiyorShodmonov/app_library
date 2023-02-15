package uz.pdp.libraryapp.book;

import lombok.*;
import uz.pdp.libraryapp.author.AuthorDto;
import uz.pdp.libraryapp.category.Category;
import uz.pdp.libraryapp.category.CategoryDto;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@ToString
public class BookDto {
    private Integer id;
    private String title;
    private String isbn;
    private Integer count;
    private String description;
    private List<AuthorDto> authorDtoList;
    private List<Integer> authorsIds;
    private List<CategoryDto> categoryDtoList;
    private List<Integer> categoriesIds;
    private Integer languageId;
    private String languageName;

}
