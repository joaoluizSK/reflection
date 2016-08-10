package example;

import java.util.Map;

import example.bean.Produto;
import example.bean.Telefone;
import example.generator.MapGenerator;

public class Principal {

	public static void main(String[] args) {
		Produto p = new Produto("Design Patterns", "LIVRO", 59.90, "Publicado pela Casa do Código");
		Map<String, Object> props = MapGenerator.gerarMapa(p);

		for (String prop : props.keySet()) {
			System.out.println(prop + " = " + props.get(prop));
		}
		
		Telefone tel = new Telefone("5595", "VIVO");
		
		Map<String, Object> propsTel = MapGenerator.gerarMapa(tel);

		for (String prop : propsTel.keySet()) {
			System.out.println(prop + " = " + props.get(prop));
		}
		
	}

}
