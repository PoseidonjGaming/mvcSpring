package fr.perso.mvc.controller;

import fr.perso.mvc.jpa.service.IPersonService;
import fr.perso.mvc.jpa.service.IVehiculeService;
import fr.perso.mvc.model.Person;
import fr.perso.mvc.model.Vehicule;
import fr.perso.mvc.model.VehiculeDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/vehicule")
public class VehiculeController {


    private final IVehiculeService service;

    @Autowired
    private IPersonService personService;

    @Autowired
    public VehiculeController(IVehiculeService service) {
        this.service = service;
    }

    @GetMapping("/list")
    public String getAll(Model model) {
        List<Vehicule> list = service.getAll();
        model.addAttribute("vehicules", list);
        return "vehicule/list";
    }

    @GetMapping("/{id}")
    public String getById(@PathVariable long id, Model model) {
        model.addAttribute("vehicule", service.getById(id));
        model.addAttribute("persons", personService.getAll());
        return "vehicule/byId";
    }

    @PostMapping("/add")
    public String getById(@ModelAttribute @Valid VehiculeDto vehicule, BindingResult result) {
        if (result.hasErrors()) {
            return "vehicule/byId";
        }
        Vehicule newVehicule=new Vehicule();
        newVehicule.setOwner(personService.getById(vehicule.getOwner()));
        newVehicule.setWheelCount(vehicule.getWheelCount());
        newVehicule.setId(vehicule.getId());
        service.save(newVehicule);
        return "redirect:/vehicule/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable long id) {
        service.delete(id);
        return "redirect:/vehicule/list";
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
