package br.ifpe.petlink.petlink.spring_boot;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import br.ifpe.petlink.petlink.models.Animal;
import br.ifpe.petlink.petlink.models.dao.AnimalDAO;

@Controller
public class AnimalController {
    private final AnimalDAO animalDAO;
    public AnimalController(AnimalDAO animalDAO) {
        this.animalDAO = animalDAO;
    }
 @GetMapping("/cadAnimal")
    public String abreFormulario(Model model) {
        model.addAttribute("animal", new Animal());
        return "cadAnimal";
    }

    @PostMapping("/cadAnimal")
    public String insereAnimal(@ModelAttribute Animal animal, Model model) {
        animalDAO.create(animal);
        model.addAttribute("animal", animal);
        model.addAttribute("mensagem", "Animal cadastrado com sucesso");
        return "resultInsertAnimal";
    }

    @GetMapping("/listarAnimais")
    public String listarAnimais(Model model) {
        List<Animal> animais = animalDAO.listAll();
        model.addAttribute("animais", animais);
        return "listarAnimais";
    }
}