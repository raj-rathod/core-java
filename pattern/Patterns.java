package pattern;

public class Patterns {
    public  void invertedPyramid(int n) {
        for (int i = 0; i < n; i++) {

            for (int s = 0; s < i; s++) {
                System.out.print(" ");
            }

            for (int j = n - i; j > 0; j--) {
                System.out.print("* ");
            }

            System.out.println();
        }
    }

    public void pyramid(int n){
          for (int i = 0; i < n; i++) {

            for (int s = n - i; s > 0; s--) {
                System.out.print(" ");
            }

            for (int j = 0; j <= i; j++) {
                System.out.print("* ");
            }

            System.out.println();
        }
    }

    public void squarePattern(int n){
        for(int i = 0; i<n;i++){
            for(int j = 0; j<n;j++){
                System.out.print("* ");
            }
             System.out.println();
        }
    }

    public void rightAngleTriangle(int n){
        for(int i=0; i<n;i++){
            for(int j=0; j<=i; j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public void invertedTriangle(int n){
        for(int i=0; i<n;i++){
            for(int j=n-i; j>0; j--){
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public void hollowSqure(int n){
        for(int i = 0; i<n;i++){
            for(int j = 0; j<n;j++){
                if(i == 0 || j==0 || j==n-1 || i==n-1){
                    System.out.print("* ");
                }else{
                  System.out.print("  ");  
                }
            }
             System.out.println();
        }
    }
}
