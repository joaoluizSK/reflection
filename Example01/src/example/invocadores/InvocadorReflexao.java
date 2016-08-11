package example.invocadores;

import java.lang.reflect.Method;

import example.interfaces.InvocadorMetodo;

public class InvocadorReflexao implements InvocadorMetodo{

	@Override
	public void invocarMetodo(int vezes) {
		try{
			ClasseTeste ct = new ClasseTeste();
			for (int i = 0; i < vezes; i++) {
				Method m = ct.getClass().getMethod("metodoVazio");
				m.invoke(ct);
			}
		}catch (Exception e){
			throw new RuntimeException("Não conseguiu invocar o método", e);
		}
	}
}
