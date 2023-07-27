package level2;

class 피로도 {
    
    public int N, maxDungeon;
    public boolean[] isSelected;
    
    public int solution(int k, int[][] dungeons) {
        
        N = dungeons.length;
        maxDungeon = 0;
        isSelected = new boolean[N];
        
        dfs(0, k, dungeons);
        return maxDungeon;
    }
    
    public void dfs(int cnt, int k, int[][] dungeons) {
        if(cnt == N) {
            maxDungeon = N;
            return;
        }
        
        if (maxDungeon == N){
            return;
        }
        
        for (int i = 0; i < N; i++) {
            
            if (isSelected[i]) continue;
            
            if (k >= dungeons[i][0]) {
                isSelected[i] = true;
                dfs(cnt + 1, k - dungeons[i][1], dungeons);   
                isSelected[i] = false;
            }
            else {
                maxDungeon = Math.max(maxDungeon, cnt);
            }
            
        }
    }
}