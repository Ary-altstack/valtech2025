package assignment2.spring;

public interface ItemService {
	
	void save(Item i);
	void update(Item i);
	Item get(int id);
	void delete(int id);

}
