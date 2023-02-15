package uz.pdp.libraryapp.book;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uz.pdp.libraryapp.author.AuthorDao;
import uz.pdp.libraryapp.category.CategoryDao;
import uz.pdp.libraryapp.language.LanguageDao;

import java.util.List;

@Controller
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {

    // FIELD INJECTION
    // SETTER INJECTION
    // CONSTRUCTOR INJECTION


    private final BookDao bookDao;
    private final AuthorDao authorDao;
    private final LanguageDao languageDao;
    private final CategoryDao categoryDao;


    @PostMapping
    public String create(BookDto bookDto, Model model) {
        boolean exist = bookDao.exist(bookDto.getIsbn());
        if (!exist) {
            bookDao.create(bookDto);
            return "redirect:/books";
        }
        model.addAttribute("book",bookDto);
        model.addAttribute("authorList", authorDao.read());
        model.addAttribute("languagesList", languageDao.read());
        model.addAttribute("categoriesList", categoryDao.read());
        return "book-form-error";

    }

    @GetMapping
    public String read(Model model) {
        List<BookDto> allBooksFromDb = bookDao.read();
        model.addAttribute("kitoblar", allBooksFromDb);
        return "view-books";
    }

    @PostMapping("/edit")
    public String update(BookDto bookDto) {
        bookDao.update(bookDto);
        return "redirect:/books";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        bookDao.delete(id);
        return "redirect:/books";
    }

    @GetMapping({"/get-form", "/edit"})
    public String getForm(@RequestParam(value = "id", required = false) Integer id, Model model) {
        if (id != null) {
            BookDto bookDto = bookDao.readById(id);
            model.addAttribute("book", bookDto);
        }
        model.addAttribute("authorList", authorDao.read());
        model.addAttribute("languagesList", languageDao.read());
        model.addAttribute("categoriesList", categoryDao.read());
        return "book-form";
    }

    @GetMapping("/{id}")
    public String readById(@PathVariable("id") int id, Model model) {
        BookDto bookDto = bookDao.readById(id);
        model.addAttribute("book", bookDto);
        return "book-by-id";
    }

    @GetMapping("/add-amount/{id}")
    public String addAmount(@PathVariable("id") int id,Model model){
        model.addAttribute("bookId",id);
        return "add-form";
    }
    @PostMapping("/add")
    public String addToAmount(BookDto bookDto){
        bookDao.addToAmount(bookDto);
        return "redirect:/books";
    }
}
