class MedianFinder {

    Heap minHeap;
    Heap maxHeap;
    double median;

    public MedianFinder() {
        minHeap = new Heap(25001);
        maxHeap = new Heap(25001);
        median = 0;
    }

    public double findMedian(){
        return median;
    }
    
    public void addNum(int num) {
        if(minHeap.getNumElements() == maxHeap.getNumElements()){ // add to correct heap and reference max/min
            if(num > median){
                minHeap.insert(-num);
                median = -minHeap.getMax();
            }

            else{
                maxHeap.insert(num);
                median = maxHeap.getMax();
            }
        }

        else{ // add to correct heap, rebalance, dynamically calc median
            if(num > median){
                minHeap.insert(-num);
                if(minHeap.getNumElements() > maxHeap.getNumElements()){
                    maxHeap.insert(-minHeap.delMax());
                }
            }

            else{
                maxHeap.insert(num);
                if(minHeap.getNumElements() < maxHeap.getNumElements()){
                    minHeap.insert(-maxHeap.delMax());
                }
            }

            median = (double)(-minHeap.getMax() + maxHeap.getMax())/2.0;
        }
    }

}


class Heap{
    // MaxHeap based
    int[] arrayHeap;
    int numElements;
    int maxSize;

    public Heap(int size){
        arrayHeap = new int[size+1];
        numElements = 0;
        maxSize = size;
    }

    private void swim(int index){
        while(index > 1 && arrayHeap[index] > arrayHeap[index/2]){
            swap(index, index/2);
            index /= 2;
        }
    }

    private void sink(int index){
        while(index * 2 <= numElements){
            int j = 2 * index;
            if(j < numElements && arrayHeap[j] < arrayHeap[j+1]){
                j++;
            }

            if(arrayHeap[index] >= arrayHeap[j]){
                break;
            }

            swap(index, j);
            index = j;
        }
    }

    private void swap(int a, int b){ //indices
        int temp = arrayHeap[a];
        arrayHeap[a] = arrayHeap[b];
        arrayHeap[b] = temp;
    }

    public int getMax(){
        return arrayHeap[1];
    }

    public void insert(int element){
        //add to end and swim up
        arrayHeap[++numElements] = element;
        swim(numElements);
    }

    public int delMax(){
        //swap first and end and sink down
        int result = arrayHeap[1];
        swap(1, numElements--);
        sink(1);
        return result;
    }

    public int getNumElements(){
        return numElements;
    }

}
/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */