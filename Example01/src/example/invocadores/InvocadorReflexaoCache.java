package example.invocadores;

import java.lang.reflect.Method;

import example.interfaces.InvocadorMetodo;

public class InvocadorReflexaoCache implements InvocadorMetodo{

	@Override
	public void invocarMetodo(int vezes) {

		try{
			ClasseTeste ct = new ClasseTeste();
			Method m = ct.getClass().getMethod("metodoVazio");
			for (int i = 0; i < vezes; i++) {
				m.invoke(ct);
			}
		}catch (Exception e){
			throw new RuntimeException("Não conseguiu invocar o método", e);
		}
		
	}

}
