package uz.pdp.libraryapp.author;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/authors")
@RequiredArgsConstructor
public class AuthorController {
    public final AuthorDao authorDao;

    @PostMapping
    public String create(Author author) {
        authorDao.create(author);
        return "redirect:/authors";
    }

    @GetMapping
    public String read(Model model) {
        List<AuthorDto> authors = authorDao.read();
        model.addAttribute("authors", authors);
        return "view-authors";
    }

    @PostMapping("/edit")
    public String update(Author author) {
        authorDao.update(author);
        return "redirect:/authors";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id) {
        int delete = authorDao.delete(id);
        if (delete==1) {
            return "redirect:/authors";
        }
        return "error";
    }

    @GetMapping("/{id}")
    public String readById(@PathVariable("id") int id, Model model) {
        Author author = authorDao.readById(id);
        model.addAttribute("author", author);
        return "author-by-id";
    }

    @GetMapping({"/get-form", "/edit"})
    public String getForm(@RequestParam(value = "id", required = false) Integer id, Model model) {
        if (id != null) {
            Author author = authorDao.readById(id);
            model.addAttribute("author", author);
        }
        return "author-form";
    }


}
