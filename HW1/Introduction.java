package OOP.HW1;

public class Introduction {
    public static void main(String[] args){

        StringBuilder sb = new StringBuilder();
        sb.append("Đào Văn Đức");
        sb.append("\t");
        sb.append("24021409");
        sb.append("\t");
        sb.append("K69I-CS5");
        sb.append("\t");
        sb.append("LO2D168");
        sb.append("\t");
        sb.append("24021409@vnu.edu.vn");
        System.out.println(sb);

        for (int i = 9; i >= 2; i--) {
            System.out.printf("%d bottles of beer on the wall, %d bottles of beer.%n", i, i);
            System.out.println("Take one down, pass it around,");
        }

        System.out.println("1 bottles of beer on the wall, 1 bottles of beer.");
        System.out.println("Take one down, pass it around,");
        System.out.println("No more bottles of beer on the wall.");
    }
}
