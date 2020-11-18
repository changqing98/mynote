class UniqueBinarySearchTrees {
    public int numTrees(int n) {
        if(n <= 2){
            return n;
        }
        int result[] = new int[n + 1];
        result[0] = 1;
        result[1] = 1;
        for(int k = 2; k <= n; k++){
            int count = 0;
            for(int i = 1; i <= k; i++){
                int leftNum = i-1;
                int rightNum = k - i;
                count += result[rightNum] * result[leftNum];
            }
            result[k] = count;
        }
        return result[n];
    }
}