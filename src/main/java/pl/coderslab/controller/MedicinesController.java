package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.coderslab.dao.MedicinesDao;
import pl.coderslab.domain.Medicines;

import javax.validation.Valid;

@Controller
@RequestMapping("/medicines")
public class MedicinesController {
    private final MedicinesDao medicinesDao;

    public MedicinesController(MedicinesDao medicinesDao) {
        this.medicinesDao = medicinesDao;
    }

    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public String showList(@Valid Medicines medicines, BindingResult result, Model model) {
        model.addAttribute("med", medicinesDao.findAll());
        return "medicines/show";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String showAddForm(Model model) {
        Medicines medicines = new Medicines();
        model.addAttribute("med", medicines);
        return "medicines/add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String processAddForm(@Valid Medicines medicines, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("med", medicinesDao.findAll());
            return "medicines/add";
        }
        medicinesDao.save(medicines);
        model.addAttribute("med", medicinesDao.findAll());
        return "medicines/show";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editMedicines(@PathVariable int id, Model model) {
        Medicines one = medicinesDao.findById(id);
        model.addAttribute("med", one);
        return "medicines/edit";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String editMedicinesSuccess(@ModelAttribute("med") Medicines medicines) {
        medicinesDao.update(medicines);
        return "redirect:/medicines/show";
    }

    @RequestMapping(value = "/remove/{id}", method = RequestMethod.GET)
    public String removeMedicines(@PathVariable int id, Model model) {
        Medicines one = medicinesDao.findById(id);
        medicinesDao.delete(one);
        return "redirect:/medicines/show";
    }
}
