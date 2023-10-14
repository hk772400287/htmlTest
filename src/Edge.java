public class Edge {
    //{ parentId: number | null, elementId: number, index: number

    private Integer parentId;

    private Integer elementId;

    private int number;

    public Edge(Integer parentId, Integer elementId, int number) {
        this.parentId = parentId;
        this.elementId = elementId;
        this.number = number;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getElementId() {
        return elementId;
    }

    public void setElementId(Integer elementId) {
        this.elementId = elementId;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
