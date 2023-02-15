package uz.pdp.libraryapp.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uz.pdp.libraryapp.author.Author;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    public final UserDao userDao;
    @PostMapping
    public String create(User user) {
        userDao.create(user);
        return "redirect:/users";
    }
    @GetMapping
    public String read(Model model){
        List<UserDto> userDtoList = userDao.read();
        model.addAttribute("users",userDtoList);
        return "view-users";
    }
    @PostMapping("/edit")
    public String update(User user) {
        userDao.update(user);
        return "redirect:/users";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id) {
        int delete = userDao.delete(id);
        if (delete==1) {
            return "redirect:/users";
        }
        return "error";
    }

    @GetMapping("/{id}")
    public String readById(@PathVariable("id") int id, Model model) {
        User user = userDao.readById(id);
        model.addAttribute("user", user);
        return "user-by-id";
    }

    @GetMapping({"/get-form", "/edit"})
    public String getForm(@RequestParam(value = "id", required = false) Integer id, Model model) {
        if (id != null) {
            User user = userDao.readById(id);
            model.addAttribute("user", user);
        }
        return "user-form";
    }
}
