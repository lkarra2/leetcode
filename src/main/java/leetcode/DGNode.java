package main.java.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class DGNode {

    private int val;
    List<DGNode> adj = new ArrayList<DGNode>();

    public DGNode(int v) {
        this.val = v;
    }

    void addAdj(DGNode node) {
        adj.add(node);
    }

    private static boolean isReachableBFS(List<DGNode>glist, int from, int to) {

        return false;
    }

    private static boolean isReachableDFS(int from, int to) {

        return false;
    }

    private static void printGraph(List<DGNode> glist) {
        for(int i = 0; i < glist.size(); i++) {
            System.out.print("Node = " + glist.get(i).val + " Children = ");
            for(int j = 0; j < glist.get(i).adj.size(); j++) {
                System.out.print(glist.get(i).adj.get(j).val + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        List<DGNode> glist = new ArrayList<>();
        for(int i = 1; i <= 20; i++) {
            DGNode tmp = new DGNode(i);
            glist.add(tmp);
            for(int j = 1; j < glist.size(); j++) {
                if(i%j == 0) {
                    DGNode pos = glist.get(j-1);
                    pos.addAdj(tmp);
                }
            }
        }
        printGraph(glist);
    }
}
