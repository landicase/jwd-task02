package by.tc.task02.dao.writerDOM;

import by.tc.task02.entity.Appliance;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public interface ElementCreator {

    Element createElement (Appliance appliance, Document document);
}
