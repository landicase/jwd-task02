package by.tc.task02.main;

import by.tc.task02.entity.Appliance;
import by.tc.task02.entity.criteria.Criteria;
import by.tc.task02.service.ApplianceService;
import by.tc.task02.service.ServiceFactory;

import java.util.ArrayList;
import java.util.List;

import static by.tc.task02.entity.criteria.SearchCriteria.*;

public class Main {

	public static void main(String[] args) {

		List<Appliance> applianceList = new ArrayList<>();
		List<Appliance> saveApplianceList = new ArrayList<>();

		ServiceFactory factory = ServiceFactory.getInstance();
		ApplianceService service = factory.getApplianceService();

		//////////////////////////////////////////////////////////////////

		Criteria criteriaOven = new Criteria(Oven.class.getSimpleName());//"Oven"
		criteriaOven.add(Oven.CAPACITY.toString(), 33);

		try {
			applianceList = service.find(criteriaOven);
			PrintApplianceInfo.print(applianceList);
			saveApplianceList.addAll(applianceList);
			applianceList.clear();
		}
		catch(Exception exception){
			System.out.println(exception.getMessage());
		}

//		//////////////////////////////////////////////////////////////////

		criteriaOven = new Criteria(Oven.class.getSimpleName());
		criteriaOven.add(Oven.HEIGHT.toString(), 45.0);
		criteriaOven.add(Oven.DEPTH.toString(), 60);

		try {
			applianceList = service.find(criteriaOven);
			PrintApplianceInfo.print(applianceList);
			saveApplianceList.addAll(applianceList);
			applianceList.clear();
		}
		catch(Exception exception){
			System.out.println(exception.getMessage());
		}

//		//////////////////////////////////////////////////////////////////

		Criteria criteriaTabletPC = new Criteria(TabletPC.class.getSimpleName());
		criteriaTabletPC.add(TabletPC.COLOR.toString(), "BLUE");
		criteriaTabletPC.add(TabletPC.DISPLAY_INCHES.toString(), 14);
		criteriaTabletPC.add(TabletPC.MEMORY_ROM.toString(), 8000);

		try {
			applianceList = service.find(criteriaTabletPC);// find(Object...obj)
			PrintApplianceInfo.print(applianceList);
			saveApplianceList.addAll(applianceList);
			applianceList.clear();
		}
		catch(Exception exception){
			System.out.println(exception.getMessage());
		}

//		///////////////////////////////////////////////////////////////////

		Criteria criteriaRefrigerator = new Criteria(Refrigerator.class.getSimpleName());
		criteriaRefrigerator.add(Refrigerator.OVERALL_CAPACITY.toString(), 300.0);


		try {
			applianceList = service.find(criteriaRefrigerator);// find(Object...obj)
			PrintApplianceInfo.print(applianceList);
			saveApplianceList.addAll(applianceList);
			applianceList.clear();
		}
		catch(Exception exception){
			System.out.println(exception.getMessage());
		}
		service.save(saveApplianceList);
	}

}
