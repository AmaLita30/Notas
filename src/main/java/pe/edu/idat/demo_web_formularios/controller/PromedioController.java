package pe.edu.idat.demo_web_formularios.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pe.edu.idat.demo_web_formularios.model.PromedioModel;

@Controller
public class PromedioController {
    @GetMapping ("/notas")
    public String formularioNotas(Model model){
        model.addAttribute("promediomodel", new PromedioModel());
        model.addAttribute("visualizaralerta", false);
        return "promedio";
    }

    @PostMapping
    public String calcularPromedio(@ModelAttribute("promediomodel") PromedioModel promedido, Model model){
        double n1 = promedido.getNota1();
        double n2 = promedido.getNota2();
        double n3 = promedido.getNota3();
        double n4 = promedido.getNota4();
        double promedioFinal = (n1 * .04) + (n2 * .12) + (n3 * .24) + (n4 * .60);

        String estado = "";
        if (promedioFinal>=13){
            estado = "Aprobado";
        }else {
            estado = "Desaprobado";
        }
        model.addAttribute("resultado", "Su promedio es: "+ String.format("%.2f", promedioFinal) + ", Usted se encuentra: " + estado);
        model.addAttribute("visualizaralerta", true);
        model.addAttribute("estilodiagnostico", estado);
        return "promedio";

    }

}
