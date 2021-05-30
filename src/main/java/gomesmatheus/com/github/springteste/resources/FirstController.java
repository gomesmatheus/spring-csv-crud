package gomesmatheus.com.github.springteste.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstController {

    @GetMapping("/{nome}")
    public String saudacao(@PathVariable String nome){
        return "Olá " + nome;
    }
}
