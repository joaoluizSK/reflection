package example;

import example.interfaces.InvocadorMetodo;
import example.invocadores.InvocadorNormal;
import example.invocadores.InvocadorReflexao;
import example.invocadores.InvocadorReflexaoCache;

public class TesteDesempenho {
	public static void main(String[] args) {
		double normal = executarTeste(new InvocadorNormal());
		double reflection = executarTeste(new InvocadorReflexao());
		System.out.println((reflection / normal) + " vezes mais que o normal");
		double reflectionCache = executarTeste(new InvocadorReflexaoCache());
		System.out.println((reflectionCache / normal) + " vezes mais que o normal");

	}

	public static double executarTeste(InvocadorMetodo invoc) {
		long milis = System.nanoTime();
		invoc.invocarMetodo(100000);
		String nomeClasse = invoc.getClass().getName();
		long diferenca = System.nanoTime() - milis;
		System.out.println("A classe " + nomeClasse + " demorou " + diferenca + " nano segundos");
		return diferenca;

	}

}
