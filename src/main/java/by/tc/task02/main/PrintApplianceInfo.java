package by.tc.task02.main;

import by.tc.task02.entity.Appliance;

import java.util.List;

public class PrintApplianceInfo {

	public static void print(List<Appliance> applianceList) {
		System.out.println("---------------------------");
		if(applianceList.size()>0){
			for (Appliance appliance : applianceList){
				System.out.println(appliance.toString());
			}
		}
		else{
			System.out.println("No results");
		}
	}


}
