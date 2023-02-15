package uz.pdp.libraryapp.book;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.pdp.libraryapp.author.Author;
import uz.pdp.libraryapp.category.Category;
import uz.pdp.libraryapp.language.Language;

import java.util.List;
import java.util.Locale;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
//@Entity
public class Book {
    private Integer id;
    private String title;
    private String description;
//    @ManyToMany
    private List<Author> authors;
    private String isbn;
//    @ManyToMany
    private List<Category> category;
    private Language language;
}
