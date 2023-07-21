class Solution {
    public String longestPalindrome(String str) {  
        String result="";
        for(int i=0;i<str.length();i++){
            for(int j=i,k=i;j>=0 && k<str.length() && str.charAt(j)==str.charAt(k);j--,k++){
                if(result.length()<k-j+1) result=str.substring(j,k+1);
            }
            for(int j=i,k=i+1;j>=0 && k<str.length() && str.charAt(j)==str.charAt(k);j--,k++){
                if(result.length()<k-j+1) result=str.substring(j,k+1);
            }
        }
        return result;
    }
}

