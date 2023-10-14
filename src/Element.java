import java.util.HashMap;
import java.util.Map;

public class Element {
    //type Elements = {
    //elementId: null | number,
    //tag?: string, style?: string,
    //class?: string,
    //href?: string,
    //text?: string
    //}[];

    private Integer elementId;

    private String tag;

    private String style;

    private String clazz;

    private String href;

    private String text;

    private String html;

    public Element() {

    }

    public Element(Integer elementId, String tag, String style, String clazz, String href, String text) {
        this.elementId = elementId;
        this.tag = tag;
        this.style = style;
        this.clazz = clazz;
        this.href = href;
        this.text = text;
        StringBuilder sb = new StringBuilder();
        Map<String, String> map = new HashMap<>();
        map.put("style", this.style);
        map.put("clazz", this.clazz);
        map.put("href", this.href);
        sb.append("<").append(this.tag).append(" ");
        for (String key : map.keySet()) {
            if (map.get(key) != null) {
                sb.append(key).append("=\"").append(map.get(key)).append("\" ");
            }
        }
        sb.replace(sb.length() - 1, sb.length(), "");
        sb.append(">");
        sb.append("</").append(this.tag).append(">");
        this.html =  sb.toString();
    }

    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html;
    }

    public Integer getElementId() {
        return elementId;
    }

    public void setElementId(Integer elementId) {
        this.elementId = elementId;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
