package gomesmatheus.com.github.springteste.repositories;

import gomesmatheus.com.github.springteste.domain.Jogador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JogadorRepository extends JpaRepository<Jogador, Integer> {

}
