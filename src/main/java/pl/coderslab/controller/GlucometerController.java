package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.coderslab.dao.GlucometerDao;
import pl.coderslab.domain.Glucometer;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.LocalTime;

@Controller
@RequestMapping("/glucometer")
public class GlucometerController {
    private final GlucometerDao glucometerDao;

    public GlucometerController(GlucometerDao glucometerDao) {
        this.glucometerDao = glucometerDao;
    }


    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public String showList(@Valid Glucometer glucometer, BindingResult result, Model model) {
        model.addAttribute("gluc", glucometerDao.findAll());
        return "glucometer/show";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String showAddForm(Model model) {
        Glucometer glucometer = new Glucometer();
        glucometer.setDates(LocalDate.now().toString());
        glucometer.setTime(LocalTime.now().toString());
        model.addAttribute("gluc", glucometer);
        return "glucometer/add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String processAddForm(@Valid Glucometer glucometer, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("gluc", glucometerDao.findAll());
            return "glucometer/add";
        }
        glucometerDao.save(glucometer);
        model.addAttribute("gluc", glucometerDao.findAll());
        return "glucometer/show";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editGlucometer(@PathVariable int id, Model model) {
        Glucometer one = glucometerDao.findById(id);
        model.addAttribute("gluc", one);
        return "glucometer/edit";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String editGlucometerSuccess(@ModelAttribute("gluc") Glucometer gluc) {
        glucometerDao.update(gluc);
        return "redirect:/glucometer/show";
    }

    @RequestMapping(value = "/remove/{id}", method = RequestMethod.GET)
    public String removeGlucometer(@PathVariable int id, Model model) {
        Glucometer one = glucometerDao.findById(id);
        glucometerDao.delete(one);
        return "redirect:/glucometer/show";
    }
}
