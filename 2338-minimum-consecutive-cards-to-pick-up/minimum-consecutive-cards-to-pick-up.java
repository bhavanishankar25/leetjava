class Solution {
    public int minimumCardPickup(int[] cards) {
    int ans = Integer.MAX_VALUE;
        int i = 0;
        int j = 0;
        
        int n = cards.length;
        
        Set<Integer> set = new HashSet<Integer>();
        
        
        while(j < n)
        {
		   
            set.add(cards[j]);
            
			
            if(set.size() != (j - i + 1))
            {
				
				
                while(cards[i] != cards[j] )
                {
					
                    set.remove(cards[i]);
                    i++;
                }
                
                ans = ans > (j - i + 1) ? (j - i + 1) : ans;

                set.remove(cards[i]);
                i++;
                
                set.add(cards[j]); 
            }
            j++;                            
        }
        if(j - i == n) return -1;
        return ans;
}
}