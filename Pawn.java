import java.util.*;

public class Pawn extends Piece {

    public Pawn(Color c) {
        String colorrrrr = "";
        this.color1 = c;
        if (this.color1.name().equals("BLACK")) colorrrrr = "b";
        if (this.color1.name().equals("WHITE")) colorrrrr = "w";
        this.PieceName = colorrrrr+"p";
    }
    // implement appropriate methods

    public String toString() {
        return PieceName;
    }

    public List<String> moves(Board b, String loc) {
        List<String> stringList = new ArrayList<>();
        String str1 = "abcdefgh";
        String str2 = "12345678";
        // 起始位置
        int index1 = str1.indexOf(loc.charAt(0)); //a-h当中的数字
        int index2 = str2.indexOf(loc.charAt(1)); //返回1-8
        // 遍历棋盘的每一个点
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                // 首先得是合法移动
                // 其次，合法移动的位置是否有棋子，若有同颜色棋子则不行，空和不同颜色棋子都行
                // 白棋
                if (PieceName.charAt(0) == 'w') {
                    // 初始位置,可以移动两格
                    if (index2 == 1 && i - index1 == 0 && (j - index2 == 1 || j - index2 == 2)&&!(String.valueOf(str1.charAt(i))+(j+1)).equals(loc)) {  //只能竖着走

                        stringList.add(String.valueOf(str1.charAt(i)) + (j + 1));
                    }else if (i - index1 == 0 && j - index2 == 1&&!(String.valueOf(str1.charAt(i))+(j+1)).equals(loc)) {  //只能竖着走
                        stringList.add(String.valueOf(str1.charAt(i)) + (j + 1));
                    }

                }

                // 黑棋
                if (PieceName.charAt(0) == 'b') {
                    // 初始位置,可以移动两格
                    if (index2 == 6 && i - index1 == 0 && (index2 - j == 1 || index2 - j == 2)) {  //只能竖着走

                        stringList.add(String.valueOf(str1.charAt(i)) + (j + 1));
                    }else if (i - index1 == 0 && index2 - j == 1&&!(String.valueOf(str1.charAt(i))+(j+1)).equals(loc)) {  //只能竖着走
                        stringList.add(String.valueOf(str1.charAt(i)) + (j + 1));
                    }

                }
            }
        }
        return stringList;
    }

}