package chapter2.implementacoes;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class FornecedorImplementacoes {

	private Map<Class<?>, Class<?>> implementacoes = new HashMap<>();
	
	public FornecedorImplementacoes(String nomeArquivo) throws FileNotFoundException, IOException, ClassNotFoundException {
		Properties prop = new Properties();
		prop.load(new FileInputStream(nomeArquivo));
		
		for(Object interf : prop.keySet()){
			Class<?> interfType =  Class.forName(interf.toString());
			Class<?> implType = Class.forName(prop.get(interf).toString());
			
			implementacoes.put(interfType, implType);
		}
	}
	public Class<?> getImplementacao(Class<?> interf){
		return implementacoes.get(interf);
	}
	
}
