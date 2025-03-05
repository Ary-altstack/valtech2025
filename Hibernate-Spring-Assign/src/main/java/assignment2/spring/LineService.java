package assignment2.spring;

public interface LineService {
	
	
	void save(LineOrder lineOrder);
    void update(LineOrder lineOrder);
    LineOrder get(int id);	
    void delete(int id);

}
