package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.coderslab.dao.ResultsDao;
import pl.coderslab.dao.UnitDao;
import pl.coderslab.dao.ValuesDao;
import pl.coderslab.domain.Results;

import javax.validation.Valid;

@Controller
@RequestMapping("/results")
public class ResultsController {

    private final ValuesDao valuesDao;
    private final ResultsDao resultsDao;
    private final UnitDao unitDao;


    public ResultsController(ValuesDao valuesDao, ResultsDao resultsDao, UnitDao unitDao) {
        this.valuesDao = valuesDao;
        this.resultsDao = resultsDao;
        this.unitDao = unitDao;
    }

    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public String showList(@Valid Results resu, BindingResult result, Model model){
        model.addAttribute("resul", resultsDao.findAll());
        model.addAttribute("mvalues", valuesDao.findAll());
        model.addAttribute("uval", unitDao.findAll());
        return "results/show";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String showAddForm(Model model) {
        Results resu = new Results();
        model.addAttribute("mvalues", valuesDao.findAll());
        model.addAttribute("uval", unitDao.findAll());
        model.addAttribute("resu", resu);
        return "results/add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String processAddForm(@Valid Results resu, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("resu", resultsDao.findAll());
            return "results/add";
        }
        resultsDao.save(resu);
        return "redirect:/results/show";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editResult(@PathVariable int id, Model model) {
        Results one = resultsDao.findById(id);
        model.addAttribute("mvalues", valuesDao.findAll());
        model.addAttribute("uval", unitDao.findAll());
        model.addAttribute("resu", one);
        return "results/edit";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String editResult(@ModelAttribute("resu") Results resu) {
        resultsDao.update(resu);
        return "redirect:/results/show";
    }

    @RequestMapping(value = "/remove/{id}", method = RequestMethod.GET)
    public String removeResult(@PathVariable int id, Model model) {
        Results one = resultsDao.findById(id);
        resultsDao.delete(one);
        return "redirect:/results/show";
    }

}
