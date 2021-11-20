theHeap = []


#Swapper function
def Swap(heap, i0, i1):
    heap[i0], heap[i1] = heap[i1] , heap[i0]


#Minimum Heapify From Bottom Function
def HeapifyBottom(heap, index):
    ind = (index - 1) // 2

    if index == 0:
        return

    if heap[ind] > heap[index]:
        Swap(heap, index, ind)

        #Recursion
        HeapifyBottom(heap, ind)


#Minimum Heapify From Top Function
def HeapifyTop(heap, index):

    length = len(heap)
    
    if length < 2:
        return

    left = index * 2 + 1

    if length > left+1:
        if heap[left] < heap[left+1]:
            if heap[left] < heap[index]:
                Swap(heap,index,left)
                HeapifyTop(heap,left)

        else:
            if heap[left+1] < heap[index]:
                Swap(heap,index,left+1)
                HeapifyTop(heap,left+1)


    elif length > left and heap[left] < heap[index]:
        Swap(heap,index,left)
        HeapifyTop(heap,left)


#Append to the Heap
def HeapEkle(heap,newVal):
    heap.append(newVal)
    HeapifyBottom(heap,len(heap)-1)


#Pop from the Heap
def HeapAl(heap):

    if len(heap) < 2:
        if len(heap) < 1:
            return -1
        else:
            return heap.pop()

    outp = heap[0]
    heap[0] = heap.pop()
    HeapifyTop(heap,0)

    return outp


#Sort the heap from min to max
def Heap2Array(heap):
    sorted = [0] * len(heap)

    for i in range(0,len(heap)):
        sorted[i] = HeapAl(heap)

    return sorted


#This part is written for quick testing
#Can be completely ignored

x = None
print("Type any positive integer to append to, 0 to view the heap")
print("Type -1 to pop min, -2 to sort the heap, -3 or lower to exit the program.")

while True:
    x = int(input())

    if x > 0:
        HeapEkle(theHeap,x)

    elif x == 0:
        print(theHeap)

    elif x == -1:
        print(HeapAl(theHeap))

    elif x == -2:
        print(Heap2Array(theHeap))

    else:
        break