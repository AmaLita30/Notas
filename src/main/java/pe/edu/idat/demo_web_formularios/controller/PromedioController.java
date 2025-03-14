package pe.edu.idat.demo_web_formularios.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PromedioController {
    @GetMapping ("/notas")
    public String formularioNotas(){
        return "promedio";

    }

}
