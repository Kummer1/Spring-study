package br.com.alura.screematch;

import model.DadosSerie;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import service.ConsumoAPI;
import service.ConverteDados;

@SpringBootApplication
public class ScreematchApplication implements CommandLineRunner {

	public static void main(String[] args){
		SpringApplication.run(ScreematchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		ConsumoAPI consumoAPI = new ConsumoAPI();
		var json =
		consumoAPI.obterDados(
				"http://www.omdbapi.com/?t=gilmore+girls&apikey=1c72e09e");

		System.out.println(json);
		System.out.println("Teste");

		ConverteDados conversor = new ConverteDados();
		var i = conversor.obterDados(json, DadosSerie.class);
		System.out.println(i);
	}
}
