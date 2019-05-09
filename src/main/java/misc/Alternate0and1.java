package main.java.misc;

public class Alternate0and1 {

    private int[] n;

    public Alternate0and1(int[] n) {
        this.n = n;
    }

    public static void main(String[] args) {
        int[] n = {0, 0, 0, 1, 0, 1, 0, 1, 0, 1};
        Alternate0and1 a = new Alternate0and1(n);
        a.print();
        a.n = a.sortAlternate();
        a.print();
    }

    private int[] sortAlternate() {
        for (int i = 0; i < n.length; i++) {
            if (i % 2 == 0) {
                if (n[i] == 0)
                    continue;
                else
                    replace(i);
            } else {
                if (i % 2 != 0) {
                    if (n[i] == 1)
                        continue;
                    else
                        replace(i);
                }
            }
        }
        return n;
    }

    private void replace(int i) {
        for(int j = i+1; j < n.length; j++) {
            if(i%2 == 0 && n[j] == 1) {
                n[j] = 0;
                n[i] = 1;
                return;
            }
            if(i%2 != 0 && n[j] == 1) {
                n[j] = 0;
                n[i] = 1;
                return;
            }
        }
    }

    private void print() {
        for(int a: n) {
            System.out.print(a + " ");
        }
        System.out.println();
    }
}
