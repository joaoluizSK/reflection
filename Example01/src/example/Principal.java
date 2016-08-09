package example;

import java.util.Map;

import example.bean.Produto;
import example.generator.MapGenerator;

public class Principal {

	public static void main(String[] args) {
		Produto p = new Produto("Design Patterns", "LIVRO", 59.90, "Publicado pela Casa do Código");
		Map<String, Object> props = MapGenerator.gerarMapa(p);

		for (String prop : props.keySet()) {
			System.out.println(prop + " = " + props.get(prop));
		}
	}

}
