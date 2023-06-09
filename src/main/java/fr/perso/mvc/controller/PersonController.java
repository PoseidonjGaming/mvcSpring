package fr.perso.mvc.controller;

import fr.perso.mvc.jpa.service.IPersonService;
import fr.perso.mvc.model.Person;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/person")
public class PersonController {


    private final IPersonService service;

    @Autowired
    public PersonController(IPersonService service) {
        this.service = service;
    }

    @GetMapping("/list")
    public String getAll(Model model) {
        List<Person> list = service.getAll();
        model.addAttribute("persons", list);
        return "person/list";
    }

    @GetMapping("/{id}")
    public String getById(@PathVariable long id, Model model) {
        model.addAttribute("person", service.getById(id));
        return "person/byId";
    }

    @PostMapping("/add")
    public String getById(@ModelAttribute @Valid Person person, BindingResult result) {
        if (result.hasErrors()) {
            return "person/byId";
        }
        service.save(person);
        return "redirect:/person/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable long id) {
        service.delete(id);
        return "redirect:/person/list";
    }

   /* public ModelAndView all(){
        ModelAndView mav=new ModelAndView();
        mav.addObject("persons", service.getAll());
        mav.setViewName("person/list");
        return mav;
    }*/

    /*public ModelAndView all() {
        return new ModelAndView(
                "person/all",
                Map.of(
                        "persons",service.getAll()
                )
        );
    }*/
}
