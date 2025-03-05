package assignment2.spring;

public interface Service {

	void setLineService(LineService lineService);
	void saveOrder(Order o);
	void saveLineOrder(LineOrder lo);

}