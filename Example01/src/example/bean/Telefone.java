package example.bean;

import example.annotations.Ignorar;
import example.annotations.NomePropriedade;

public class Telefone {

	public String codigoPais;
	
	public String operadora;

	public Telefone(String codigoPais, String operadora) {
		this.codigoPais = codigoPais;
		this.operadora = operadora;
	}

	@NomePropriedade("codigoInternacional")
	public String getCodigoPais() {
		return codigoPais;
	}

	public void setCodigoPais(String codigoPais) {
		this.codigoPais = codigoPais;
	}

	@Ignorar
	public String getOperadora() {
		return operadora;
	}

	public void setOperadora(String operadora) {
		this.operadora = operadora;
	}
	
}
