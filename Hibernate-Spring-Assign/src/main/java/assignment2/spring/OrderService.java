package assignment2.spring;

public interface OrderService {
	
	
	void save(Order o);
	void update(Order o);
	Order get(int id);
	void delete(int id);
	
	


}
