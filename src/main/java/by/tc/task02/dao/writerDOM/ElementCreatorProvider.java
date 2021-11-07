package by.tc.task02.dao.writerDOM;

import java.util.HashMap;
import java.util.Map;

public class ElementCreatorProvider {

    private static ElementCreatorProvider instance;

    private final Map<String, ElementCreator> provider;

    private ElementCreatorProvider() {
        provider = new HashMap<>();
        provider.put("Oven", new OvenElementCreator());
        provider.put("Laptop", new LaptopElementCreator());
        provider.put("Refrigerator", new RefrigeratorElementCreator());
        provider.put("TabletPC", new TabletPCElementCreator());
        provider.put("VacuumCleaner", new VacuumCleanerElementCreator());
        provider.put("Speakers", new SpeakersElementCreator());
    }

    public static ElementCreator getElementCreator(String applianceName) {
        if (instance == null) {
            instance = new ElementCreatorProvider();
        }
        return instance.provider.get(applianceName);
    }
}