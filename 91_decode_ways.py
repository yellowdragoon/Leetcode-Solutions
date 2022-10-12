class Solution:
    def numDecodings(self, s: str) -> int:
        
        m = len(s)
        dp = [0] * m
        
        if s[0] == '0':
            return 0
        else:
            dp[0] = 1
        
        for i in range(1, m):
       
            if int(s[i]) > 0 and i > 0:
                dp[i] += dp[i-1]
                
            
            if i > 0:
                if int(s[i-1:i+1]) < 27 and not s[i-1] == '0':
                    dp[i] += dp[i-2] if i > 1 else 1
                    
                    
        #print(dp)
        return dp[-1]