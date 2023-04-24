package fr.perso.mvc.controller;

import fr.perso.mvc.jpa.service.IPersonService;
import fr.perso.mvc.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/person")
public class PersonController {


    private final IPersonService service;
    @Autowired
    public PersonController(IPersonService service) {
        this.service = service;
    }

    @GetMapping("/list")
    public String getAll(Model model){
        List<Person> list=service.getAll();
        model.addAttribute("persons",list);
        return "person/list";
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
