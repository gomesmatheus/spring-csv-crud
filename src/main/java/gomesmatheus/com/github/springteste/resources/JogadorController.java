package gomesmatheus.com.github.springteste.resources;

import gomesmatheus.com.github.springteste.domain.Jogador;
import gomesmatheus.com.github.springteste.dto.JogadorDTO;
import gomesmatheus.com.github.springteste.services.JogadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JogadorController {

    @Autowired
    JogadorService jogadorService;

    @RequestMapping(value = "/csv/inserir", method = RequestMethod.GET)
    public ResponseEntity<Void> inserir(){
        jogadorService.inserir();
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/inserir", method = RequestMethod.POST)
    public ResponseEntity<Void> inserir(@RequestBody JogadorDTO jogador){
        jogadorService.inserir(jogador);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/retornar/{id}", method = RequestMethod.GET)
    public ResponseEntity<Jogador> retornar(@PathVariable Integer id){
        Jogador jogador = jogadorService.retornar(id);
        return ResponseEntity.ok().body(jogador);
    }

    @RequestMapping(value = "/retornar", method = RequestMethod.GET)
    public ResponseEntity<List<Jogador>> retornarTodos(){
        List<Jogador> jogador = jogadorService.retornarTodos();
        return ResponseEntity.ok().body(jogador);
    }

    @RequestMapping(value = "/alterar/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> alterar(@PathVariable Integer id, @RequestBody JogadorDTO jogador){
        jogadorService.alterar(id, jogador);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/deletar/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deletar(@PathVariable Integer id){
        jogadorService.deletar(id);
        return ResponseEntity.noContent().build();
    }

}
