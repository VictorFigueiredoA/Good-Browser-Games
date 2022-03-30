package ps2.restapidb;

import org.springframework.data.repository.CrudRepository;

public interface GameRepo extends CrudRepository<Game, Long> {
}