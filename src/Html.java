import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Html {

    private List<Edge> edges;

    private List<Element> elements;

    public Html() {
        /*## 1
        <h1 class="title">Hello Digglue!</h1>
        <header style="display: flex;">
            <ol style="list-style: none; display: flex;">
                <li style="margin: 0 0.25rem">
                    <a style="margin: 0 0.25rem" href="/home">HOME</a>
                </li>
                <li style="margin: 0 0.25rem">
                    <a style="margin: 0 0.25rem" href="/users">Users</a>
                </li>
                <li style="margin: 0 0.25rem">
                    <a style="margin: 0 0.25rem" href="/pages">PAGES</a>
                </li>
            </ol>
        </header>**/
        int num = 0;
        if (elements.size() > 0) {
            num = elements.size();
        }
        int[] parentsChildren = new int[num];

        for (int i = 0; i < num; i++) {
            Edge edge = edges.get(i);
            parentsChildren[edge.getElementId()] = edge.getParentId() == null ? 0 : edge.getParentId();
        }
        StringBuilder sb = new StringBuilder();
        Map<Integer, String> idToHtml = new HashMap<>();
        for (int i = 1; i < parentsChildren.length; i++) {
            Element element = elements.get(i);
            String html = null;
            int parentId = parentsChildren[element.getElementId()];
            if (element.getText() != null) {
                int lastIndexOf = sb.lastIndexOf("<");

            } else {
                html = oneLineWithoutText(element);
                int indent = 0;
                while (parentId != 0) {
                    parentId = parentsChildren[parentId];
                    indent++;
                }
                String htmlWithIndent = null;
                for (int j = 0; j < indent; j++) {
                    htmlWithIndent = htmlWithIndent + " ";
                }
                htmlWithIndent = htmlWithIndent + html;
                idToHtml.put(element.getElementId(), htmlWithIndent);
                sb.append(htmlWithIndent);
            }



        }



    }


    private String oneLineWithoutText(Element element) {
        StringBuilder sb = new StringBuilder();
        Element element1 = elements.get(0);
        String tag = element1.getTag();
        String style = element1.getStyle();
        String clazz = element1.getClazz();;
        String href = element1.getHref();
        Map<String, String> map = new HashMap<>();
        map.put("tag", tag);
        map.put("style", style);
        map.put("clazz", clazz);
        map.put("href", href);
        sb.append("<").append(tag).append(" ");
        for (String key : map.keySet()) {
            if (map.get(key) != null) {
                sb.append(key).append("=\"").append(map.get(key)).append("\"").append(" ");
            }
        }
        sb.append(">");
        sb.append("</").append(map.get(tag)).append(">");
        return sb.toString();
    }


}
