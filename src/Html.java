import java.util.*;

public class Html {

    private List<Edge> edges;

    private List<Element> elements;

    private String htmlString;

    private Map<Integer, Element> elementMap;

    private Map<Integer, List<Integer>> neighbors;

    public String getHtmlString() {
        return htmlString;
    }

    public void setHtmlString(String htmlString) {
        this.htmlString = htmlString;
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public void setEdges(List<Edge> edges) {
        this.edges = edges;
    }

    public List<Element> getElements() {
        return elements;
    }

    public void setElements(List<Element> elements) {
        this.elements = elements;
    }


        /*
    1 2 <h1 class="title">Hello Digglue!</h1>
    3   <header style="display: flex;">
    4       <ol style="list-style: none; display: flex;">
    5           <li style="margin: 0 0.25rem">
    6 7             <a style="margin: 0 0.25rem" href="/home">HOME</a>
                </li>
    8           <li style="margin: 0 0.25rem">
    9 10             <a style="margin: 0 0.25rem" href="/users">Users</a>
                </li>
    11           <li style="margin: 0 0.25rem">
    12 13            <a style="margin: 0 0.25rem" href="/pages">PAGES</a>
                </li>
            </ol>
        </header>**/
    public Html(List<Edge> edges, List<Element> elements) {
        this.edges = edges;
        this.elements = elements;
        this.elementMap = new HashMap<>();
        elementMap.put(0, new Element());
        for (Element element : elements) {
            elementMap.put(element.getElementId(), element);
        }
        this.neighbors = new HashMap<>();
        neighbors.put(0, new ArrayList<>());
        for (Edge edge : edges) {
            if (edge.getParentId() == null) {
                neighbors.get(0).add(edge.getElementId());
            }
            if (!neighbors.containsKey(edge.getParentId())) {
                neighbors.put(edge.getParentId(), new ArrayList<>());
            }
            neighbors.get(edge.getParentId()).add(edge.getElementId());
        }
        StringBuilder htmlSb = dfs(0, neighbors, new HashSet<>(), elementMap, -2);
        this.htmlString = htmlSb.toString().trim();
    }

    private StringBuilder dfs(int curr, Map<Integer, List<Integer>> neighbors, Set<Integer> visit,
                              Map<Integer, Element> elementMap, int indent) {
        Element currElement = elementMap.get(curr);
        if (currElement.getText() != null) {
            return new StringBuilder(currElement.getText());
        }
        visit.add(curr);
        StringBuilder currSb = new StringBuilder();
        if (currElement.getHtml() != null) {
            currSb.append(currElement.getHtml());
        }
        StringBuilder neiSb = new StringBuilder();
        for (int i = 0; i < neighbors.get(curr).size(); i++) {
            int nei = neighbors.get(curr).get(i);
            if (!visit.contains(nei) && nei > curr) {
                neiSb.append(dfs(nei, neighbors, visit, elementMap, indent + 2));
                if (i < neighbors.get(curr).size() - 1) {
                    neiSb.append(System.getProperty("line.separator"));
                }
            }
        }
        for (int i = 0; i < indent; i++) {
            currSb.insert(0, " ");
        }
        int insertIndex = currElement.getHtml() != null ? currSb.lastIndexOf("<") : 0;
        if (neighbors.get(curr).size() != 1 || elementMap.get(neighbors.get(curr).get(0)).getText() == null) {
            neiSb.insert(0, System.getProperty("line.separator")).append(System.getProperty("line.separator"));
            neiSb.append(" ".repeat(Math.max(0, indent)));
        }
        currSb.insert(insertIndex, neiSb);
        return currSb;
    }

    public String getHtmlByElementId(Integer id) {
        return dfs(id, this.neighbors, new HashSet<>(), this.elementMap, 0).toString().trim();
    }

    public String addChildren(List<Element> newElements, List<Edge> newEdges) {
        for (Element e : newElements) {
            elementMap.put(e.getElementId(), e);
        }
        for (Edge edge : newEdges) {
            if (!neighbors.containsKey(edge.getParentId())) {
                neighbors.put(edge.getParentId(), new ArrayList<>());
            }
            neighbors.get(edge.getParentId()).add(edge.getElementId());
        }
        return dfs(0, neighbors, new HashSet<>(), elementMap, -2).toString().trim();
    }
}
