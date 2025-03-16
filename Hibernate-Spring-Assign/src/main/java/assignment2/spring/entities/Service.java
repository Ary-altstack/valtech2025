package assignment2.spring.entities;

import assignment2.spring.LineService;

public interface Service {

	void setLineService(LineService lineService);
	void saveOrder(Order o);
	void saveLineOrder(LineOrder lo);

}