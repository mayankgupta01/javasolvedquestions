package hiredintech_topcoder.blitz_rounds.round4;

/**
 * Created by mayank.gupta on 27/04/17.
 */
public class RotateImage {

    public int[][] ninetyDegrees(int[][] image) {
        int n = image.length;
        int[][] rotatedImage = new int[n][n];

        for(int i=0; i < n; i++) {

            for(int j=0; j < n; j++) {

                rotatedImage[i][j] = image[n-j-1][i];
            }
        }

        return rotatedImage;
    }

    public static void main(String[] args) {
        int[][] image = new int[2][2];

        image[0][0] = 1;
        image[0][1] = 2;
        image[1][0] = 3;
        image[1][1] = 4;

        RotateImage rm = new RotateImage();
        image = rm.ninetyDegrees(image);

        for(int i = 0; i < 2; i++) {
            for(int j = 0; j < 2; j++) {
                System.out.println(image[i][j]);
            }
        }
    }
}
