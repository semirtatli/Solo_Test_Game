import java.util.ArrayList;

public class FrontierList {
    private final ArrayList<Node> frontier_list = new ArrayList<Node>();  //frontier list

    public void add(Node node)
    {
        frontier_list.add(node);
    }

    public void set(int listPointer, Node node)
    {
        frontier_list.set(listPointer, node);
    }

    public ArrayList<Node> get()
    {
        return frontier_list;
    }

}
