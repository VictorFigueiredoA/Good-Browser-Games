package ps2.restapidb;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
class GameController {

	@Autowired
	private GameRepo gameRepo;

	public GameController() {

	}

	@GetMapping("/api/games")
	Iterable<Game> getGames() {
		return gameRepo.findAll();
	}
	
	@GetMapping("/api/games/{id}")
	Optional<Game> getGame(@PathVariable long id) {
		return gameRepo.findById(id);
	}
	
	@PostMapping("/api/games")
	Game createGame(@RequestBody Game g) {
		Game createdGame = gameRepo.save(g);
		return createdGame;
	}
	

	@PutMapping("/api/games/{gameId}")
	Optional<Game> updateGame(@RequestBody Game gameRequest, @PathVariable long gameId) {
		Optional<Game> opt = this.getGame(gameId);
		if (opt.isPresent()) {
			Game game = opt.get();
			if (gameRequest.getId() == game.getId()) {
				game.setNome(gameRequest.getNome());
				game.setCategoria(gameRequest.getCategoria());
				game.setUrl(gameRequest.getUrl());
				game.setDescricao(gameRequest.getDescricao());
				game.setImagem(gameRequest.getImagem());
				gameRepo.save(game);
				return opt;
			}
		}
		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Não foi pssivel alterar os dados do Game de id: " + gameId);	
	}
	

	
	@DeleteMapping(value = "/api/games/{id}")
	void deleteGame(@PathVariable long id) {
		gameRepo.deleteById(id);
	}	
}

