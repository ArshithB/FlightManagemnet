package com.spring.orm.dao;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import com.spring.orm.entities.Flight;

public class FlightDao {
	
	@Autowired
	private HibernateTemplate hibernateTemplate;
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	@Transactional
	public int insert(Flight flight) {
		int i=(Integer) this.hibernateTemplate.save(flight);
		return i;
	}
	
	//Getting a particular details from the database:
	public Flight getFlight(int fId) {
		Flight flight = this.hibernateTemplate.get(Flight.class, fId);
		return flight;
	}
	
	//Getting all details:
	public List getAllFlight() {
		List flight = (List) this.hibernateTemplate.loadAll(Flight.class);
		return flight;
	}
	
	//Updating the data:
	@Transactional //this will helps for reflecting the new data into the database
	public void updateFlight (int fId, String fName) {
		Flight ff = this.hibernateTemplate.get(Flight.class, fId);
		ff.setfName(fName);
	}
	
	//Delete:
    @Transactional
    public void deleteFlight(int fId) {
    	Flight flight = this.hibernateTemplate.get(Flight.class, fId);
    	this.hibernateTemplate.delete(flight);		
    }
}
