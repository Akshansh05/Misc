
public class ImplementMinHeap {
    static int a[];
    static int n;

    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, World!");

        a = new int[50];
        n = 0;
        a[0] = Integer.MIN_VALUE;

        ImplementMinHeap minHeap = new ImplementMinHeap();

        minHeap.insert(20);
        minHeap.insert(10);
        minHeap.insert(50);
        minHeap.insert(40);
        minHeap.insert(30);

        minHeap.print();

        System.out.println("Min Element " + minHeap.getMin());

        System.out.println("Min Element Removed  " + minHeap.extractMin());
        minHeap.insert(70);
        minHeap.print();
    }

    int parent(int i) {
        return (i) / 2;
    }

    int left(int i) {
        return (2 * i);
    }

    int right(int i) {
        return (2 * i + 1);
    }

    int getMin() throws Exception {
        if (n < 0)
            throw new Exception("n is less than 0");
        return a[1];
    }

    int extractMin() throws Exception {
        if (n < 0)
            throw new Exception("n is less than 0");
        ;
        int val = a[1];
        a[1] = a[n--];
        minHeapify(1);
        return val;
    }

    void minHeapify(int i) {
        int l = left(i);
        int r = right(i);
        int smallest = i;

        if (i < n && a[l] < a[smallest])
            smallest = l;
        if (i < n && a[r] < a[smallest])
            smallest = r;
        if (smallest != i) {
            swap(smallest, i);
            minHeapify(smallest);
        }
    }

    void insert(int key) {
        if (n >= a.length)
            return;
        a[++n] = key;
        int curr = n;
        while (a[parent(curr)] > a[curr]) {
            swap(parent(curr), curr);
            curr = parent(curr);
        }
    }

    void swap(int i, int f) {
        int temp = a[i];
        a[i] = a[f];
        a[f] = temp;
    }

    boolean isLeaf(int i) {
        if (i > n / 2 && i < a.length) {
            return true;
        }
        return false;
    }

    void print() {
        for (int i = 1; i <= n / 2; i++) {
            Integer left = left(i) > n ? null : a[left(i)];
            Integer right = right(i) > n ? null : a[right(i)];
            System.out.print(
                    " PARENT : " + a[i]
                            + " LEFT CHILD : " + left
                            + " RIGHT CHILD :" + right);

            System.out.println();
        }
    }
}
