package by.tc.task02.dao.writerDOM;

import by.tc.task02.entity.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import static java.util.Map.entry;
import java.util.Map;

public class ApplianceDOMWriter {

    public static final String SAVE_FILE_PATH = "src/main/resources/appliances_new.xml";

    private static final ApplianceDOMWriter instance = new ApplianceDOMWriter();

    public static ApplianceDOMWriter getInstance() {
        return instance;
    }

    public void saveAppliances(List<Appliance> applianceList) throws ParserConfigurationException, IOException, TransformerException {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.newDocument();

        Element applianceListElement = document.createElement("appliance-list");

        for (Appliance appliance : applianceList) {
            String applianceName = appliance.getClass().getSimpleName();
            ElementCreator creator = ElementCreatorProvider.getElementCreator(applianceName);
            Element applianceElement = creator.createElement(appliance, document);
            applianceListElement.appendChild(applianceElement);
        }

        document.appendChild(applianceListElement);

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(document);
        StreamResult result = new StreamResult(new FileWriter(SAVE_FILE_PATH));
        transformer.transform(source, result);

    }
    private ApplianceDOMWriter() {}
}
