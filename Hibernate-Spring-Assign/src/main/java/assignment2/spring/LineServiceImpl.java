package assignment2.spring;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;

public class LineServiceImpl implements LineService {
	
private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void save(LineOrder lineOrder) {
		new HibernateTemplate(sessionFactory).save(lineOrder);
	}

	@Override
	public void update(LineOrder lineOrder) {
		new HibernateTemplate(sessionFactory).update(lineOrder);
		
	}

	@Override
	public LineOrder get(int id) {
		new HibernateTemplate(sessionFactory).load(LineOrder.class,id);
		return null;
	}

	@Override
	public void delete(int id) {
		new HibernateTemplate(sessionFactory).delete(id);
		
	}

}
