package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.coderslab.dao.ConsultationsDao;
import pl.coderslab.domain.Consultations;

import javax.validation.Valid;

@Controller
@RequestMapping("/consultations")
public class ConsultationsController {
    private final ConsultationsDao consultationsDao;

    public ConsultationsController(ConsultationsDao consultationsDao) {
        this.consultationsDao = consultationsDao;
    }

    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public String showList(@Valid Consultations cons, BindingResult result, Model model){
        model.addAttribute("cons", consultationsDao.findAll());
        return "consultations/show";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String showAddForm(Model model) {
        Consultations cons = new Consultations();
        model.addAttribute("cons", consultationsDao.findAll());
        cons.setName("Konsultacja");
        model.addAttribute("cons", cons);
        return "consultations/add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String processAddForm(@Valid Consultations cons, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("cons", consultationsDao.findAll());
            return "consultations/add";
        }
        consultationsDao.save(cons);
        model.addAttribute("cons", consultationsDao.findAll());
        return "consultations/show";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editConsultations(@PathVariable int id, Model model) {
        Consultations one = consultationsDao.findById(id);
        model.addAttribute("cons", one);
        return "consultations/edit";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String editConsultationsSuccess(@ModelAttribute("cons") Consultations cons) {
        consultationsDao.update(cons);
        return "redirect:/consultations/show";
    }

    @RequestMapping(value = "/remove/{id}", method = RequestMethod.GET)
    public String removeConsultations(@PathVariable int id, Model model) {
        Consultations one = consultationsDao.findById(id);
        consultationsDao.delete(one);
        return "redirect:/consultations/show";
    }

}
