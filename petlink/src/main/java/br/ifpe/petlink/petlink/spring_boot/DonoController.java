package br.ifpe.petlink.petlink.spring_boot;


 import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import br.ifpe.petlink.petlink.models.dono;
import br.ifpe.petlink.petlink.models.dao.donoDAO;

@Controller
public class DonoController {
    private final donoDAO donoDAO;

    public DonoController(donoDAO donoDAO) {
        this.donoDAO = donoDAO;
    }

    @GetMapping("/cadDono")
    public String abreFormulario(Model model) {
        model.addAttribute("dono", new dono());
        return "cadDono";
    }

    @PostMapping("/cadDono")
    public String insereDono(@ModelAttribute dono dono, Model model) {
        donoDAO.create(dono);
        model.addAttribute("dono", dono);
        model.addAttribute("mensagem", "Dono cadastrado com sucesso");
        return "resultInsertDono";
    }

    @GetMapping("/listarDonos")
    public String listarDonos(Model model) {
        List<dono> donos = donoDAO.listAll();
        model.addAttribute("donos", donos);
        return "listarDonos";
    }
}


