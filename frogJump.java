class Solution {
  public:
    int f(int n, vector<int> &h, vector<int> &dp) {
        if(n==0) return 0;
        if(dp[n]!=-1) return dp[n];
        int fj=f(n-1, h, dp)+abs(h[n-1]-h[n]), sj=INT_MAX;
        if(n-2>=0) sj=f(n-2, h, dp)+abs(h[n-2]-h[n]);
        return dp[n]=min(fj, sj);
    }
    
    int minimumEnergy(vector<int>& h, int n) {
        // Code here
        //vector<int> dp(n, -1);
        int prev1=0, prev2=0, curr=0;
        for(int i=1; i<n; i++) {
            int fj=prev1+abs(h[i-1]-h[i]), sj=INT_MAX;
            if(i-2>=0) sj=prev2+abs(h[i-2]-h[i]);
            curr=min(fj, sj);
            prev2=prev1;
            prev1=curr;
        }
        return curr;
    }
};
