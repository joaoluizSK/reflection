package example.generator;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import example.annotations.Ignorar;
import example.annotations.NomePropriedade;

public class GeradorMapaPerformance {

	private Map<String, Method> propriedades = new HashMap<>();
	private Class<?> classe;
	
	public GeradorMapaPerformance(Class<?> classe){
		this.classe = classe;
		
		for(Method method : classe.getMethods()){
			if(isGetter(method)){
				String propriedade = null;
				
				if(method.isAnnotationPresent(NomePropriedade.class)){
					propriedade = method.getAnnotation(NomePropriedade.class).value();
				} else {
					propriedade = deGetterParaPropriedade(method.getName());
				}
				
				propriedades.put(propriedade, method);
				
			}
		}
	}
	
	public Map<String, Object> gerarMapa(Object o ){
		if(!classe.isInstance(o)){
			throw new RuntimeException("O objeto não é da classe " + classe.getName());
		}
		
		Map<String, Object> mapa = new HashMap<>();
		
		for(String propriedade : propriedades.keySet()){
			try {
				Method m = propriedades.get(propriedade);
				Object valor = m.invoke(o);
				mapa.put(propriedade, valor);
			}catch (Exception e){
				throw new RuntimeException("Problema ao gerar mapa", e);
			}
		}
		
		return mapa;
		
	}
	
	private static boolean isGetter(Method m) {
		return m.getName().startsWith("get") && m.getReturnType() != void.class && m.getParameterTypes().length == 0 && !m.isAnnotationPresent(Ignorar.class);
	}

	private static String deGetterParaPropriedade(String nomeGetter) {
		StringBuffer retorno = new StringBuffer();
		retorno.append(nomeGetter.substring(3, 4).toLowerCase());
		retorno.append(nomeGetter.substring(4));
		return retorno.toString();
	}
	
}
