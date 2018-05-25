package CheckIdea;

public class Driver {
    public static void main(String[] args) {
        int[][]triangle=new int[10][10];
        for (int i = 0; i <triangle.length ; i++) {
                triangle[i][0]=1;//每一行第一个元素 填充1
                triangle[i][i]=1;//每一行的最后一个元素填充1
        }
        for (int i = 0; i <triangle.length ; i++) {
            for (int j = 1; j <=i ; j++) {
                triangle[i][j]=triangle[i-1][j]+triangle[i-1][j-1];//当前数值-->上一行该列的数+上一行该列的左边的第一个数
            }
        }
        for (int i = 0; i <triangle.length ; i++) {
            /*for (int j = 0; j <=triangle.length-i ; j++) {//打印空白
                System.out.print("  ");
            }*/
            for (int j = 0; j <=i ; j++) {//打印元素
                System.out.print("  "+triangle[i][j]+"  ");
            }
            System.out.println();
        }
    }
}
