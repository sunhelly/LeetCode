package leetcode.algorithms;

public class Match {

    public static boolean isMatch(String s, String p) {
      int ns = s.length()+1;
      int np = p.length()+1;

      boolean[][] matches = new boolean[ns][np];
      matches[0][0]=true;
      for(int i=0;i<ns;i++){
        for(int j=1;j<np;j++){
          if(i>0&&match(s.charAt(i-1),p.charAt(j-1))){
            matches[i][j]=matches[i-1][j-1];
            System.out.println("path1:matches["+i+"]["+j+"]="+matches[i][j]);
          }
          if(p.charAt(j-1)=='*'){
            if(i==0||!match(s.charAt(i-1),p.charAt(j-2))){
              matches[i][j]=matches[i][j-2];
              System.out.println("path2:matches["+i+"]["+j+"]="+matches[i][j]);
            }else{
              matches[i][j]=matches[i-1][j]||matches[i][j-1]||matches[i][j-2];
              System.out.println("path3:matches["+i+"]["+j+"]="+matches[i][j]);
            }
          }
        }
      }
      return matches[ns-1][np-1];

    }
    public static boolean match(char a, char b){
      if(a==b||a=='.'||b=='.'){
        return true;
      }
      return false;
    }

    public static void main(String[] args){
      isMatch("", "a*");
    }
}
