package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import web.models.Student;
import web.service.StudentService;

import javax.validation.Valid;

@Controller
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentServiceList;

    @Autowired
    public StudentController(StudentService studentServiceList) {
        this.studentServiceList = studentServiceList;
    }

    @GetMapping("")
    public String students(Model model) {
        model.addAttribute("students", studentServiceList.getAll());
        return "students";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("student", studentServiceList.getById(id));
        return "show";
    }

    @GetMapping("/new")
    public String newStudent(Model model) {
        model.addAttribute("student", new Student());
        return "new";
    }

    @PostMapping()
    public String create(@ModelAttribute("student") @Valid Student student,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "new";
        studentServiceList.save(student);
        return "redirect:/students";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("student", studentServiceList.getById(id));
        return "edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("student") @Valid Student student,
                         BindingResult bindingResult,
                         @PathVariable("id") int id) {
        if (bindingResult.hasErrors())
            return "edit";
        studentServiceList.update(id, student);
        return "redirect:/students";

    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        studentServiceList.delete(id);
        return "redirect:/students";
    }
}