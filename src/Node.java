public class Node
{
    private int[][] peg;
    private int dpCount = 0;
    private Node nextNode;

    private Node previousNode;
    private int depth;
    private int pegNumber;

    private int prevStep = 0;

    public Node(int[][] peg_inst, int depth_inst, int pegNumber_inst) {
        this.peg = peg_inst;
        this.depth = depth_inst;
        this.pegNumber = pegNumber_inst;
    }

    public Node(int[][] peg_inst, int depth_inst, int pegNumber_inst, Node nextNode_inst, int dpCount_inst) {
        this.peg = peg_inst;
        this.depth = depth_inst;
        this.pegNumber = pegNumber_inst;
        this.nextNode = nextNode_inst;
        this.dpCount = dpCount_inst;
    }
    public int getPeg(int i, int j) {
        return this.peg[i][j];
    }

    public int[] getPeg(int i) {
        return this.peg[i];
    }

    public int[][] getPeg() {
        return this.peg;
    }


    public void setPeg(int[][] newPeg) {
        this.peg = newPeg;
    }

    public int getDepth() {
        return this.depth;
    }

    public void setDepth(int newDepth) {
        this.depth = newDepth;
    }

    public int getPegNumber() {
        return this.pegNumber;
    }

    public void setPegNumber(int newPegNumber) {
        this.pegNumber = newPegNumber;
    }

    public int getDpCount() {
        return this.dpCount;
    }

    public void setDpCount(int dpCount) {
        this.dpCount = dpCount;
    }

    public Node getNextNode() {
        return this.nextNode;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }

    public Node getPreviousNode() {
        return this.previousNode;
    }

    public void setPreviousNode(Node previousNode) {
        this.previousNode = previousNode;
    }

    public int getPrevStep() {
        return this.prevStep;
    }

    public void setPrevStep(int prevStep) {
        this.prevStep = prevStep;
    }

}
