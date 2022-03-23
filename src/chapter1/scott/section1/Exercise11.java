package chapter1.scott.section1;

public class Exercise11 {

    public static void main(String[] args) {
      Boolean[][] twoDimensionalBoolean = new Boolean[3][2];
        twoDimensionalBoolean[0][0] = true;
        twoDimensionalBoolean[0][1] = false;
        twoDimensionalBoolean[1][0] = false;
        twoDimensionalBoolean[1][1] = true;
        twoDimensionalBoolean[2][0] = false;
        twoDimensionalBoolean[2][1] = true;
        print(twoDimensionalBoolean);
    }

    private static void print(Boolean[][] input) {
        int outLength = input.length;
        for (int i = 0; i < outLength; i ++) {
            int innerLength = input[i].length;
            for (int j = 0; j < innerLength; j ++) {
                if (input[i][j]) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println("");
        }
    }

}
