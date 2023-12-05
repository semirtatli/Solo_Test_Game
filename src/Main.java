public class Main {

    public FrontierList DFS(Node currNode) {
        FrontierList frontierList = new FrontierList();//Creating ArrayList
        frontierList.add(currNode); // add to frontier

        while (!resultCheck(currNode.getPeg())) {
            if (currNode.getNextNode() != null) {
                currNode = currNode.getNextNode();
            }
            //loop bitcek pop edilecek yer burası
            else {
                if (currNode.getDepth() != 0) {
                    System.out.println("BU ONEMLI" + currNode.getDepth());
//                    System.out.println("BU cok ONEMLI" + currNode.getPrevStep());

                    if(currNode.getPegNumber() == 2)
                        for (int i = 0; i < 7; i++){
                            for (int j = 0; j < 7; j++) {
                                //System.out.print(currNode.getPeg(i, j));
                                System.out.println();
                            }
                            System.out.println();
                            if(i == 6)
                                System.out.println();
                    }


                    frontierList.get().remove(frontierList.get().size() - 1);//remove the last node from frontier
                    currNode = currNode.getPreviousNode();//pick up the link from the previous node
                    currNode.setNextNode(null);//remove next node from the link
                }
            }
            int listPointer = 0;
            int dpCount = 0;
            // Nested for loop for moves that are available at the current state
            outerloop:
            for (int i = 0; i < 7; i++) {
                for (int j = 0; j < 7; j++) {
                    if (currNode.getNextNode() != null) {
                        currNode = currNode.getNextNode();
                    }

                    dpCount++;
                    if (currNode.getDpCount() != 0){
                        i = (dpCount-1) / 7;
                        j = (dpCount-1) % 7;
                        //set the i and j values according to pdCount that is received
                        //example dpCount = 16, then i = 1 and j = 1
                    }
                    if (j > 1 && currNode.getPeg(i, j) == 1 && currNode.getPeg(i, j - 1) == 1 && currNode.getPeg(i, j - 2) == 0 && currNode.getPrevStep() < 1) {
                        //left empty
              //          System.out.println("left");

                        int[][] newPeg = new int[7][7];
                        for (int t = 0; t < 7; t++) {
                            for (int k = 0; k < 7; k++) {
                                newPeg[t][k] = currNode.getPeg()[t][k];
                            }
                        }
                        currNode.setPrevStep(1);
                        int newDepth = currNode.getDepth() + 1;
                        int newPegNumber = currNode.getPegNumber() - 1;
                        newPeg[i][j] = 0;
                        newPeg[i][j - 1] = 0;
                        newPeg[i][j - 2] = 1;
                        Node tempNode = new Node(newPeg, newDepth, newPegNumber);
                        currNode.setNextNode(tempNode);
                        tempNode.setPreviousNode(currNode);
                        currNode.setDpCount(dpCount);
                        frontierList.add(tempNode);
              //          System.out.println("Depth " + currNode.getDepth());
                        break outerloop;
                    }
                    else if (j < currNode.getPeg(i).length - 2 && currNode.getPeg(i, j) == 1 && currNode.getPeg(i, j + 1) == 1 && currNode.getPeg(i, j + 2) == 0 && currNode.getPrevStep() < 2) {
                        //right empty
             //           System.out.println("right");

                        int[][] newPeg = new int[7][7];
                        for (int t = 0; t < 7; t++) {
                            for (int k = 0; k < 7; k++) {
                                newPeg[t][k] = currNode.getPeg()[t][k];
                            }
                        }

                        currNode.setPrevStep(2);
                        int newDepth = currNode.getDepth();
                        int newPegNumber = currNode.getPegNumber();
                        newPeg[i][j] = 0;
                        newPeg[i][j + 1] = 0;
                        newPeg[i][j + 2] = 1;
                        newDepth++;
                        newPegNumber--;
                        Node tempNode = new Node(newPeg, newDepth, newPegNumber);
                        currNode.setNextNode(tempNode);
                        tempNode.setPreviousNode(currNode);
                        currNode.setDpCount(dpCount);
                        frontierList.add(tempNode);
              //          System.out.println("Depth " + currNode.getDepth());
                        break outerloop;
                    }
                    else if (i >= 2 && currNode.getPeg(i, j) == 1 && currNode.getPeg(i - 1, j) == 1 && currNode.getPeg(i - 2, j) == 0 && currNode.getPrevStep() < 3) {
                        //above empty
            //            System.out.println("up");
                        int[][] newPeg = new int[7][7];
                        for (int t = 0; t < 7; t++) {
                            for (int k = 0; k < 7; k++) {
                                newPeg[t][k] = currNode.getPeg()[t][k];
                            }
                        }

                        currNode.setPrevStep(3);
                        int newDepth = currNode.getDepth();
                        int newPegNumber = currNode.getPegNumber();
                        newPeg[i][j] = 0;
                        newPeg[i - 1][j] = 0;
                        newPeg[i - 2][j] = 1;
                        newDepth++;
                        newPegNumber--;
                        Node tempNode = new Node(newPeg, newDepth, newPegNumber);
                        currNode.setNextNode(tempNode);
                        tempNode.setPreviousNode(currNode);
                        currNode.setDpCount(dpCount);
                        frontierList.add(tempNode);
            //            System.out.println("Depth " + currNode.getDepth());
                        break outerloop;
                    }
                    else if (i < currNode.getPeg().length - 2 && currNode.getPeg(i, j) == 1 && currNode.getPeg(i + 1, j) == 1 && currNode.getPeg(i + 2, j) == 0 && currNode.getPrevStep() < 4) {
                        //below empty
              //          System.out.println("down");

                        int[][] newPeg = new int[7][7];
                        for (int t = 0; t < 7; t++) {
                            for (int k = 0; k < 7; k++) {
                                newPeg[t][k] = currNode.getPeg()[t][k];
                            }
                        }

                        currNode.setPrevStep(4);
                        int newDepth = currNode.getDepth();
                        int newPegNumber = currNode.getPegNumber();
                        newPeg[i][j] = 0;
                        newPeg[i + 1][j] = 0;
                        newPeg[i + 2][j] = 1;
                        newDepth++;
                        newPegNumber--;
                        Node tempNode = new Node(newPeg, newDepth, newPegNumber);
                        currNode.setNextNode(tempNode);
                        tempNode.setPreviousNode(currNode);
                        currNode.setDpCount(dpCount);
                        frontierList.add(tempNode);
             //           System.out.println("Depth " + currNode.getDepth());
                        break outerloop;
                    }
                    }
//                    if (frontierList.get().size() != 0)
//                        System.out.println(frontierList.get().get(frontierList.get().size()-1).getDepth());
                }
            }
        return frontierList;
    }


    public FrontierList BFS(Node currNode) {
        FrontierList frontierList = new FrontierList();//Creating ArrayList
        frontierList.add(currNode); // add to frontier
        while (!resultCheck(currNode.getPeg())) {
            int listPointer = 0;
            // Nested for loop for moves that are available at the current state
            for (int i = 0; i < currNode.getPeg().length; i++) {
                for (int j = 0; j < currNode.getPeg(i).length; j++) {
                    if (j > 1 && currNode.getPeg(i, j) == 1 && currNode.getPeg(i, j - 1) == 1 && currNode.getPeg(i, j - 2) == 0) {
                        //left empty
                        System.out.println("left");

                        int[][] newPeg = new int[7][7];
                        for (int t = 0; t < 7; t++) {
                            for (int k = 0; k < 7; k++) {
                                newPeg[t][k] = currNode.getPeg()[t][k];
                            }
                        }

                        int newDepth = currNode.getDepth();
                        int newPegNumber = currNode.getPegNumber();
                        newPeg[i][j] = 0;
                        newPeg[i][j - 1] = 0;
                        newPeg[i][j - 2] = 1;
                        newDepth++;
                        newPegNumber--;
                        Node tempNode = new Node(newPeg, newDepth, newPegNumber);
                        frontierList.add(tempNode);
                    }
                    if (j < currNode.getPeg(i).length - 2 && currNode.getPeg(i, j) == 1 && currNode.getPeg(i, j + 1) == 1 && currNode.getPeg(i, j + 2) == 0) {
                        //right empty
                        System.out.println("right");

                        int[][] newPeg = new int[7][7];
                        for (int t = 0; t < 7; t++) {
                            for (int k = 0; k < 7; k++) {
                                newPeg[t][k] = currNode.getPeg()[t][k];
                            }
                        }

                        int newDepth = currNode.getDepth();
                        int newPegNumber = currNode.getPegNumber();
                        newPeg[i][j] = 0;
                        newPeg[i][j + 1] = 0;
                        newPeg[i][j + 2] = 1;
                        newDepth++;
                        newPegNumber--;
                        Node tempNode = new Node(newPeg, newDepth, newPegNumber);
                        frontierList.add(tempNode);
                    }
                    if (i >= 2 && currNode.getPeg(i, j) == 1 && currNode.getPeg(i - 1, j) == 1 && currNode.getPeg(i - 2, j) == 0) {
                        //above empty
                        System.out.println("up");

                        int[][] newPeg = new int[7][7];
                        for (int t = 0; t < 7; t++) {
                            for (int k = 0; k < 7; k++) {
                                newPeg[t][k] = currNode.getPeg()[t][k];
                            }
                        }

                        int newDepth = currNode.getDepth();
                        int newPegNumber = currNode.getPegNumber();
                        newPeg[i][j] = 0;
                        newPeg[i - 1][j] = 0;
                        newPeg[i - 2][j] = 1;
                        newDepth++;
                        newPegNumber--;
                        Node tempNode = new Node(newPeg, newDepth, newPegNumber);
                        frontierList.add(tempNode);
                    }
                    if (i < currNode.getPeg().length - 2 && currNode.getPeg(i, j) == 1 && currNode.getPeg(i + 1, j) == 1 && currNode.getPeg(i + 2, j) == 0) {
                        //below empty
                        System.out.println("down");

                        int[][] newPeg = new int[7][7];
                        for (int t = 0; t < 7; t++) {
                            for (int k = 0; k < 7; k++) {
                                newPeg[t][k] = currNode.getPeg()[t][k];
                            }
                        }

                        int newDepth = currNode.getDepth();
                        int newPegNumber = currNode.getPegNumber();
                        newPeg[i][j] = 0;
                        newPeg[i + 1][j] = 0;
                        newPeg[i + 2][j] = 1;
                        newDepth++;
                        newPegNumber--;
                        Node tempNode = new Node(newPeg, newDepth, newPegNumber);
                        frontierList.add(tempNode);
                    }
                }
                System.out.println(frontierList.get().get(0).getDepth());
            }
            frontierList.get().remove(0);
            currNode = frontierList.get().get(0);
        }
        return frontierList;
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.doMain();
    }

    public boolean resultCheck(int[][] result){
        int[][] expResult = {{0,0,0,0,0,0,0},{0,0,0,0,0,0,0},{0,0,0,0,0,0,0},{0,0,0,1,0,0,0},{0,0,0,0,0,0,0},{0,0,0,0,0,0,0},{0,0,0,0,0,0,0}};
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                if (result [i][j] != expResult[i][j]){
                    return false;
                }
            }
        }
        return true;
    }

    public void doMain() {
        //Initial state
        int[][] peg  = {{2, 2, 1, 1, 1, 2, 2}, {2, 2, 1, 1, 1, 2, 2}, {1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 0, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1}, {2, 2, 1, 1, 1, 2, 2}, {2, 2, 1, 1, 1, 2, 2}};
        //Initializing depth to 0
        int depth = 0;
        int currentDepth = 0;
        int pegNumber = 32;
        int prevStep = 0;

        Node newNode = new Node(peg, depth, pegNumber); //constructor a gitti
        FrontierList frontierList = DFS(newNode);

        for(int i = 0; i < frontierList.get().get(frontierList.get().size()-1).getDepth(); i++){
            System.out.println("Depth " + frontierList.get().get(i).getDepth());
        }

        for (int i = 0; i < peg.length; i++){
            for (int j = 0; j < peg[i].length; j++) {
                System.out.print(frontierList.get().get(0).getPeg(i, j));
            }
            System.out.println();
        }


    }
}