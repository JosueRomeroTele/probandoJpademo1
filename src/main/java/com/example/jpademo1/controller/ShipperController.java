package com.example.jpademo1.controller;

import com.example.jpademo1.entity.Shipper;
import com.example.jpademo1.repository.ShipperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/shipper")
public class ShipperController {

    @Autowired
    ShipperRepository shipperRepository;

    @GetMapping(value = {"", "/listar"})
    public String listaShipper(Model model) {
        List<Shipper> listaShippers = shipperRepository.findAll();
        model.addAttribute("lista", listaShippers);
        //model.addAttribute("lista",listaShippers);
        return "shipper/lista";
    }

    @GetMapping("/nuevo")
    public String nuevoTransportistaForm() {

        return "shipper/nuevoFormulario";
    }


    @PostMapping("/guardar")
    public String guardarShipper(Shipper shipper) {
        shipperRepository.save(shipper);
        return "redirect:/shipper";
    }

    @GetMapping("/editar")
    public String editarShipperForm(@RequestParam("id") int id,
                                    Model model) {
        Optional<Shipper> opt = shipperRepository.findById(id);
        if (opt.isPresent()) {
            Shipper shipper1 = opt.get();
            model.addAttribute("shipper", shipper1);
            return "shipper/editForm";

        } else {
            return "redirect:/shipper";
        }

    }

    @GetMapping("/borrar")
    public String borrarShipper(@RequestParam("id") int id) {
        Optional<Shipper> opt = shipperRepository.findById(id);

        if (opt.isPresent()) {
            shipperRepository.deleteById(id);

        }
        return "redirect:/shipper";
    }

}
