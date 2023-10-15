import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        Element e1 = new Element(1, "h1", null, "title", null, null);
        Element e2 = new Element(2, "text", null, null, null, "Hello Digglue!");
        Element e3 = new Element(3, "header", "display: flex;", null, null, null);
        Element e4 = new Element(4, "ol", "list-style: none; display: flex;", null, null, null);
        Element e5 = new Element(5, "li", "margin: 0 0.25rem", null, null, null);
        Element e6 = new Element(6, "a", "margin: 0 0.25rem", null, "/home", null);
        Element e7 = new Element(7, "text", null, null, null, "HOME");
        Element e8 = new Element(8, "li", "margin: 0 0.25rem", null, null, null);
        Element e9 = new Element(9, "a", "margin: 0 0.25rem", null, "/users", null);
        Element e10 = new Element(10, "text", null, null, null, "Users");
        Element e11 = new Element(11, "li", "margin: 0 0.25rem", null, null, null);
        Element e12 = new Element(12, "a", "margin: 0 0.25rem", null, "/pages", null);
        Element e13 = new Element(13, "text", null, null, null, "HOMEPAGES");
        List<Element> elements = new ArrayList<>();
        elements.add(e1);
        elements.add(e2);
        elements.add(e3);
        elements.add(e4);
        elements.add(e5);
        elements.add(e6);
        elements.add(e7);
        elements.add(e8);
        elements.add(e9);
        elements.add(e10);
        elements.add(e11);
        elements.add(e12);
        elements.add(e13);
        List<Edge> edges = new ArrayList<>();
        edges.add(new Edge(null, 1, 0));
        edges.add(new Edge(null, 3, 1));
        edges.add(new Edge(1, 2, 0));
        edges.add(new Edge(3, 4, 0));
        edges.add(new Edge(4, 5, 0));
        edges.add(new Edge(5, 6, 0));
        edges.add(new Edge(6, 7, 0));
        edges.add(new Edge(4, 8, 1));
        edges.add(new Edge(8, 9, 0));
        edges.add(new Edge(9, 10, 0));
        edges.add(new Edge(4, 11, 2));
        edges.add(new Edge(11, 12, 0));
        edges.add(new Edge(12, 13, 0));
        Html html = new Html(edges, elements);
        //System.out.println(e12.getHtml());
        //System.out.println(html.getHtmlString());
        //System.out.println(html.getHtmlByElementId(4));
        List<Element> newElements = new ArrayList<>();
        List<Edge> newEdges = new ArrayList<>();
        newElements.add(new Element(14, "li", "margin: 0 0.25rem", null, null, null));
        newElements.add(new Element(15, "a", "margin: 0 0.25rem", null, "/history", null));
        newElements.add(new Element(16, "text", null, null, null, "HISTORIES"));
        newEdges.add(new Edge(4, 14, 3));
        newEdges.add(new Edge(14, 15, 0));
        newEdges.add(new Edge(15, 16, 0));
        System.out.println(html.addChildren(newElements, newEdges));

    }
}
