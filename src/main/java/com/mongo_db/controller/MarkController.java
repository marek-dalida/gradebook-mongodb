package com.mongo_db.controller;

import com.mongo_db.models.Mark;
import com.mongo_db.repository.MarkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
public class MarkController {

    @Autowired
    private MarkRepository markRepository;

    @RequestMapping("/")
    public String homePage(Model model){
        List<Mark> marks =  getMarks();
        model.addAttribute("marks", marks);
        return "index";

    }

    @RequestMapping("/new")
    public String newMarkPage(Model model) {
        Mark mark = new Mark();
        model.addAttribute("mark", mark);

        return "new_mark";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView editMarkPage(@PathVariable(name = "id") int id) {
        ModelAndView modelAndView = new ModelAndView("edit_mark");
        Optional<Mark> mark = getMarkById(id);
        modelAndView.addObject("mark", mark);
        return modelAndView;
    }

    @RequestMapping("/delete/{id}")
    public String deleteMarkPage(@PathVariable Integer id){
        markRepository.deleteById(id);
        return "redirect:/";
    }


    @PostMapping("/marks")
    public String save(@ModelAttribute("mark") Mark mark){
        if(mark.getId() == 0){
            long id = 1;
            List<Mark> marks =  getMarks();
            if(marks == null) id = 1;
            else for( Mark x : marks)
            {
                if(x.getId() >= id){
                  id = x.getId() + 1;
                }
            }
            mark.setId(id);
        }
        markRepository.save(mark);

        return "redirect:/";
    }

    @GetMapping("/marks")
    public List<Mark> getMarks() {
        return markRepository.findAll();
    }

    @GetMapping("/marks/{id}")
    public Optional<Mark> getMarkById(@PathVariable Integer id) {
        return markRepository.findById(id);
    }

    @DeleteMapping("/marks/{id}")
    public String deleteById(@PathVariable Integer id){
        markRepository.deleteById(id);
        return "Deleted mark with id = " + id;
    }
}
