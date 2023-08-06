class MinHeap {
    public static void main(String[] args) {
        System.out.println("Hello, World!"); 
        
        int a[]  = new int[50];
        
    }
    
    int parent(int i){
        return (i-1)/2;
    }
    int left(int i){
        return (2*i+1);
    }
    int right(int i){
        return (2*i+2);
    }
    int getMin(int a[],int n){
        int (n<0)
            return;
        return a[0];
    }
    int extractMin(int a[],int n){
           int (n<0)
            return;
        int val = a[0];
        a[0]=a[n--];
        minheapify(0);
        return val;
    }
    void minHeapify(int a[],int i,int n){
        int l = left(i);
        int r = right(i);
        int smallest = i;
        
        if(i<n && a[l]<a[smallest])
            smallest = l;
        if(i<n && a[r]<a[smallest])     
            smallest =r;
        if(smallest !=i) {
            swap(a,smallest,i);
            minHeapify(a,smallest,n);
        }   
    }
    void insert(int a[] ,int n,int key ){
        if(n>=a.length)
            return;
        a[n++]=key;
        int curr = n;
        while(a[parent(curr)]>a[curr]){
            swap(a,parent(curr),curr);
            curr = parent(curr);
        }
    }
    
    void swap(int a[],int i ,int f){
        int temp = a[i];
        a[i]=a[f];
        a[f]c=temp;
    }
    boolean isLeaf(int i){
        if(i>n/2 && i<a.length){
            return true;
        }
        return false;
    }
    
void print(int a [],int n){
    for(int i=0;i<n/2;i++){
        System.out.print(a[i]+","+a[left(i)]+ "," +a[right(i)]);
    }
}
}
