package gomesmatheus.com.github.springteste.domain;

import gomesmatheus.com.github.springteste.dto.JogadorDTO;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Jogador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nickname;
    private Integer idade;
    private String main;
    private String elo;

    public Jogador(JogadorDTO jogadorDTO) {
        this.setNickname(jogadorDTO.getNickname());
        this.setIdade(jogadorDTO.getIdade());
        this.setMain(jogadorDTO.getMain());
        this.setElo(jogadorDTO.getElo());
    }
}
