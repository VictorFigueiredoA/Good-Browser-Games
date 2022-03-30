package ps2.restapidb;

import java.util.ArrayList;
import java.util.List;
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
class AvaliacaoController {

	@Autowired
	private AvaliacaoRepo AvaliacaoRepo;

	public AvaliacaoController() {

	}

    @GetMapping("/api/avaliacoes")
	Iterable<Avaliacao> getAvaliacoes() {
		return AvaliacaoRepo.findAll();
	}
	
	@GetMapping("/api/avaliacoes/{id}")
	Optional<Avaliacao> getAvaliacao(@PathVariable long id) {
		return AvaliacaoRepo.findById(id);
	}
	
	@PostMapping("/api/avaliacoes")
	Avaliacao createAvaliacao(@RequestBody Avaliacao a) {
		Avaliacao createdAvaliacao = AvaliacaoRepo.save(a);
		return createdAvaliacao;
	}
	
	
	@PutMapping("/api/avaliacoes/{avaliacaoId}")
	Optional<Avaliacao> updateAvaliacao(@RequestBody Avaliacao avaliacaoRequest, @PathVariable long avaliacaoId) {
		Optional<Avaliacao> opt = this.getAvaliacao(avaliacaoId);
		if (opt.isPresent()) {
			Avaliacao avaliacao = opt.get();
			if (avaliacaoRequest.getId() == avaliacao.getId()) {
				avaliacao.setNomeGame(avaliacaoRequest.getNomeGame());
				avaliacao.setEstrela(avaliacaoRequest.getEstrela());
				avaliacao.setComentario(avaliacaoRequest.getComentario());
				AvaliacaoRepo.save(avaliacao);
				return opt;
			}
		}
		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Não foi pssivel alterar a avaliação de ID:" + avaliacaoId);	
	}
	
	
	@DeleteMapping(value = "/api/avaliacoes/{id}")
	void deleteAvaliacao(@PathVariable long id) {
		AvaliacaoRepo.deleteById(id);
	}	
}