import java.util.*;

public class Bishop extends Piece {



    public Bishop(Color c) {
        String colorrrrr = "";
        this.color1 = c;
        if (this.color1.name().equals("BLACK")) colorrrrr = "b";
        if (this.color1.name().equals("WHITE")) colorrrrr = "w";
        this.PieceName = colorrrrr+"b";
    }
    // implement appropriate methods

    public String toString() {
        return PieceName;
    }

    public List<String> moves(Board b, String loc) {// 大主教的移动规则,不用考虑黑白
        List<String> stringList = new ArrayList<>();
        String str1 = "abcdefgh";
        String str2 = "12345678";

        int index1 = str1.indexOf(loc.charAt(0)); //a-h当中的数字
        int index2 = str2.indexOf(loc.charAt(1)); //返回1-8
        // 遍历棋盘的每一个点
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (Math.abs(i-index1)==Math.abs(j-index2)&&!(String.valueOf(str1.charAt(i))+(j+1)).equals(loc)){  //斜着走,不能原位
                    stringList.add(String.valueOf(str1.charAt(i))+(j+1));
                }
            }
        }
        return stringList;

    }

}