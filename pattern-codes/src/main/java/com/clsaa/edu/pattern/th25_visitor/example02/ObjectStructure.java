package com.clsaa.edu.pattern.th25_visitor.example02;

import java.util.ArrayList;
import java.util.Collection;

public class ObjectStructure {
    private Collection<Element> collection = new ArrayList<Element>();

    public void handleRequest(Visitor visitor) {
        for (Element e : collection) {
            e.accept(visitor);
        }
    }

    public void addElement(Element e) {
        this.collection.add(e);
    }
}
