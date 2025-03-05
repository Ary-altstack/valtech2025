package assignment2.spring;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;

public class OrderServiceImpl implements OrderService {
	
private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void save(Order o) {
		new HibernateTemplate(sessionFactory).save(o);

	}

	@Override
	public void update(Order o) {
		new HibernateTemplate(sessionFactory).update(o);

	}

	@Override
	public Order get(int id) {
		return new HibernateTemplate(sessionFactory).load(Order.class,id);
		
	}

	@Override
	public void delete(int id) {
		new HibernateTemplate(sessionFactory).delete(id);

	}

}
