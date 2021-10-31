package by.tc.task02.service;

import by.tc.task02.entity.Appliance;
import by.tc.task02.entity.criteria.Criteria;

import java.util.List;

public interface ApplianceService {	
	
	List<Appliance> find(Criteria criteria);
	
}
