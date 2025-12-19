partition(A, p, r)
    x = A[r]
    i = p - 1
    for j = p to r-1
        if A[j] <= x
            i = i + 1
            swap(A[j], A[i])
    swap(A[r], A[i+1])
    return i+1

randomizedPartition(A, p, r)
    if p<r
        i = random(p,r)
        swap(A[i], A[r])
        return partition(A, p, r)

QuickSort(A, p, r)
    if p<r
        q = partition(A, p, r)
        QuickSort(A, p, q-1)
        QuickSort(A, q+1, r)

//Initial call: QuickSort(A, 1, n)

RandomQuickSort(A, p, r)
        if p<r
            q = randomizedPartition(A, p, r)
            RandomQuickSort(A, p, q-1)
            RandomQuickSort(A, q+1, r)

BuildMaxHeap(A)
    A.heapSize = A.length
    for i = (A.length/2) downto 1
        MaxHeapify(A, i)

MaxHeapify(A, i)
    L = Left(i)
    R = Right(i)
    if L <= A.heapSize and A[L] > A[i]
        Largest = L
    else Largest = i
    if R <= A.heapSize and A[R] > A[Largest]
        Largest = R
    if Largest != i
        swap(A[i], A[Largest])
        MaxHeapify(A, Largest)

HeapSort(A)
    BuildMaxHeap(A)
    for i = A.length downto 2
        swap(A[1], A[i])
        A.heapSize =- 1
        MaxHeapify(A, 1)

HeapExtractMax(A)
    if (A.heapSize < 1) {error}
    max = A[1]
    A[i] = A[heapSize]
    heapSize -= 1
    MaxHeapify(A, 1)
    return max

Inorder(x)
    if x != null
        Inorder(x.left)
        print(x.key)
        Inorder(x.right)

TreeSearchRec(x, k)
    if x.key == k or x == null
        return x
    if x.key > k
        return TreeSearchRec(x.left, k)
    else
        return TreeSearchRec(x.right, k)

TreeSearchIt(x, k)
    while x.key != k and x != null
        if x.key > k
            x = x.left
        else
            x = x.right
    return x

TreeMin(x)
    while x.left != null
        x = x.left
    return x