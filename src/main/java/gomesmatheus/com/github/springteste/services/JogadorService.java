package gomesmatheus.com.github.springteste.services;

import gomesmatheus.com.github.springteste.domain.Jogador;
import gomesmatheus.com.github.springteste.dto.JogadorDTO;
import gomesmatheus.com.github.springteste.repositories.JogadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JogadorService {

    @Autowired
    private CSVService csvService;

    @Autowired
    private JogadorRepository jogadorRepository;

    public void inserir(JogadorDTO jogadorDTO) {
        Jogador jogador = new Jogador(jogadorDTO);
        jogadorRepository.save(jogador);
    }

    public void inserir() {
        List<Jogador> jogadores = csvService.lerArquivo(CSVService.CAMINHO_CSV);
        jogadorRepository.saveAll(jogadores);
    }

    public Jogador retornar(Integer id) {
        return jogadorRepository.findById(id).get();
    }

    public List<Jogador> retornarTodos() {
        return jogadorRepository.findAll();
    }

    public void alterar(Integer id, JogadorDTO jogadorDTO) {
        Jogador jogador = new Jogador(jogadorDTO);
        jogador.setId(id);
        jogadorRepository.save(jogador);
    }

    public void deletar(Integer id) {
        Jogador jogador = jogadorRepository.findById(id).get();
        jogadorRepository.delete(jogador);
    }
}
