package reader;


public class ConcreteCreaterAB extends Creater {

	@Override
	public Product factoryMethod(String typ){
		if("csv".equals(typ)) {
			return new ConcreteProductA();
		}else {
			return new ConcreteProductB();
		}
		
	}

}
