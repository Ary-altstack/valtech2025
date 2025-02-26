package assignment2.spring;

public interface CustomerService {
	
	void save(Customer c);
	void update(Customer c);
	Customer get(int id);
	void delete(int id);
	
		

}
