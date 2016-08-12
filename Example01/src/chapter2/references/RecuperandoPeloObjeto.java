package chapter2.references;

public class RecuperandoPeloObjeto {
	
	public static void main(String[] args) {
		Number object = new Integer(100);
		Class<? extends Number> c = object.getClass();
		System.out.println(c.getName());
	}

}
