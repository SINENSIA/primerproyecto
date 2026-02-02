package com.sinensia.primerprograma.ejercicios.spring.controller;

import com.sinensia.primerprograma.ejercicios.spring.model.Usuario;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/registro")
public class RegistroController {

    private static final Logger log = LoggerFactory.getLogger(RegistroController.class);

    @ModelAttribute("usuario")
    public Usuario usuario(Model model) {
        if (model.containsAttribute("usuario")) {
            return (Usuario) model.asMap().get("usuario");
        }
        return new Usuario();
    }

    @GetMapping
    public String mostrarFormulario() {
        return "formulario";
    }

    @PostMapping
    public String procesarFormulario(
        @Valid @ModelAttribute("usuario") Usuario usuario,
        BindingResult bindingResult,
        RedirectAttributes redirectAttributes
    ) {
        if (bindingResult.hasErrors()) {
            return "formulario";
        }

        log.info(
            "Formulario válido recibido: {} (longitud contraseña: {})",
            usuario,
            usuario.getPassword() != null ? usuario.getPassword().length() : 0
        );

        redirectAttributes.addFlashAttribute("usuario", usuario);
        return "redirect:/registro/exito";
    }

    @GetMapping("/exito")
    public String mostrarExito(Model model) {
        if (!model.containsAttribute("usuario")) {
            return "redirect:/registro";
        }
        return "exito";
    }
}
