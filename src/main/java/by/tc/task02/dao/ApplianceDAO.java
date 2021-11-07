package by.tc.task02.dao;

import by.tc.task02.entity.Appliance;
import by.tc.task02.entity.criteria.Criteria;

import java.util.List;

public interface ApplianceDAO {
	List<Appliance> find(Criteria criteria);

	void save(List<Appliance> applianceList);
}
