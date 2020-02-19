import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Board {

    private Piece[][] pieces = new Piece[8][8];

    private Board() { }

    public static Board b = null;

    private List<BoardListener> listenerList = new ArrayList<BoardListener>();
    
    public static Board theBoard() {
	    if (b==null){
	        b = new Board();
        }
	    return b;
	 // implement this
    }

    // Returns piece at given loc or null if no such piece
    // exists

    // return location
    public Piece getPiece(String loc) {
        if (loc.length()!=2){
            throw new UnsupportedOperationException();
        }
        int index1 = "abcdefgh".indexOf(loc.charAt(0)); //a-h当中的数字
        int index2 = "12345678".indexOf(loc.charAt(1)); //返回1-8
        if (index1==-1||index2==-1) throw new UnsupportedOperationException(); //输入格式不正确
        return pieces[index1][index2];
    }

    // raise an exception (any exception) if the location is already occupied or is invalid.
    public void addPiece(Piece p, String loc) {
        if (loc.length()!=2){
            throw new UnsupportedOperationException();
        }
        if (getPiece(loc)!=null){
            throw new UnsupportedOperationException();
        }
        int index1 = "abcdefgh".indexOf(loc.charAt(0)); //a-h当中的数字
        int index2 = "12345678".indexOf(loc.charAt(1)); //返回1-8
        if (index1==-1||index2==-1) throw new UnsupportedOperationException(); //invalid
        pieces[index1][index2] = p;

    }
    public void removePiece(String loc){
        int index1 = "abcdefgh".indexOf(loc.charAt(0)); //a-h当中的数字
        int index2 = "12345678".indexOf(loc.charAt(1)); //返回1-8
        pieces[index1][index2] = null;
    }
    //
    public boolean noCrossPiece(String from, String to){
        boolean crossPiece = false;

        int fromX = "abcdefgh".indexOf(from.charAt(0)); //a-h当中的数字
        int fromY = "12345678".indexOf(from.charAt(1)); //返回1-8
        int toX = "abcdefgh".indexOf(to.charAt(0)); //a-h当中的数字
        int toY = "12345678".indexOf(to.charAt(1)); //返回1-8

//        int xCross = toX-fromX;
//        int yCross = toY-fromY;


        do {
            if (toY!=fromY) {
                fromY = fromY + (toY - fromY) / Math.abs(toY - fromY);
            }
            if (toX!=fromX) {
                fromX = fromX + (toX - fromX) / Math.abs(toX - fromX);
            }
            if (toY!=fromY||toX!=fromX) {  // 不需要检查目标地点
                if (pieces[fromX][fromY] != null) crossPiece = true;
            }
        }while (toY!=fromY||toX!=fromX);

        return crossPiece;
    }

    public void movePiece(String from, String to) {  //
        if (getPiece(from)==null) throw new UnsupportedOperationException(); //没有棋子
        // 检查移动是否合法
        List<String> list = getPiece(from).moves(Board.theBoard(),from);

        // 兵，斜吃
        if (getPiece(from).PieceName.charAt(1) =='p'){
            // 如果是兵，检查之前的合法move是否带有棋子，
            Stack<String> strings = new Stack<>();
            for (String str : list){
                if (getPiece(str)!=null&&!str.equals(from)){
                    strings.push(str);
                }
            }
            while (!strings.empty()) {
                list.remove(strings.pop());
            }
            String str1 = "abcdefgh";
            String str2 = "12345678";
            // 起始位置
            int index1 = str1.indexOf(from.charAt(0)); //a-h当中的数字
            int index2 = str2.indexOf(from.charAt(1)); //返回1-8
            if (getPiece(from).PieceName.charAt(0)=='b'){ //黑棋
                    if (0 < index1 && index1 < 7) {  //不为0或7
                        if (pieces[index1 - 1][index2 - 1]!=null) {
                            if (pieces[index1 - 1][index2 - 1].PieceName.charAt(0) == 'w') {
                                String cur = String.valueOf(str1.charAt(index1 - 1)) + str2.charAt(index2 - 1);
                                list.add(cur);
                            }
                        }
                        if (pieces[index1 + 1][index2 - 1]!=null){
                            if (pieces[index1 + 1][index2 - 1].PieceName.charAt(0) == 'w') {
                                String cur = String.valueOf(str1.charAt(index1 + 1)) + str2.charAt(index2 - 1);
                                list.add(cur);
                            }
                        }
                    } else if (index1 == 0) {
                        if (pieces[index1 + 1][index2 - 1]!=null){
                            if (pieces[index1 + 1][index2 - 1].PieceName.charAt(0) == 'w') {
                                String cur = String.valueOf(str1.charAt(index1 + 1)) + str2.charAt(index2 - 1);
                                list.add(cur);
                            }
                        }
                    } else if (index1 == 7) {
                        if (pieces[index1 - 1][index2 - 1] != null){
                            if (pieces[index1 - 1][index2 - 1].PieceName.charAt(0) == 'w') {
                                String cur = String.valueOf(str1.charAt(index1 - 1)) + str2.charAt(index2 - 1);
                                list.add(cur);
                            }
                        }
                    }
            }
            if (getPiece(from).PieceName.charAt(0)=='w'){ //白棋
                    if (0 < index1 && index1 < 7) {  //不为0或7
                        if (pieces[index1 - 1][index2 + 1]!=null){
                            if(pieces[index1 - 1][index2 + 1].PieceName.charAt(0) == 'b') {
                                String cur = String.valueOf(str1.charAt(index1 - 1)) + str2.charAt(index2 + 1);
                                list.add(cur);
                            }
                        }
                        if (pieces[index1 + 1][index2 + 1]!=null){
                            if (pieces[index1 + 1][index2 + 1].PieceName.charAt(0) == 'b') {
                                String cur = String.valueOf(str1.charAt(index1 + 1)) + str2.charAt(index2 + 1);
                                list.add(cur);
                            }
                        }
                    } else if (index1 == 0) {
                        if (pieces[index1 + 1][index2 + 1]!=null) {
                            if (pieces[index1 + 1][index2 + 1].PieceName.charAt(0) == 'b') {
                                String cur = String.valueOf(str1.charAt(index1 + 1)) + str2.charAt(index2 + 1);
                                list.add(cur);
                            }
                        }
                    } else if (index1 == 7) {
                        if (pieces[index1 - 1][index2 + 1]!=null) {
                            if (pieces[index1 - 1][index2 + 1].PieceName.charAt(0) == 'b') {
                                String cur = String.valueOf(str1.charAt(index1 - 1)) + str2.charAt(index2 + 1);
                                list.add(cur);
                            }
                        }
                    }
            }
        }
        if (list.contains(to)) {
            System.out.println("移动合法");
            // 目的地是空
            if (getPiece(to)==null){
                if (getPiece(from).PieceName.charAt(1)!='n') { // 马没有越子一说
                    if (noCrossPiece(from, to)) {
                        System.out.println("越子了");
                        throw new UnsupportedOperationException();
                    }
                }
                addPiece(getPiece(from),to);
                System.out.println("已经移动");
                if (!listenerList.isEmpty()){
                    listenerList.get(0).onMove(from,to,getPiece(from));
                }
                removePiece(from);
            } else if (getPiece(to).PieceName.charAt(0)!=getPiece(from).PieceName.charAt(0)) { // 吃子
                    if (getPiece(to).PieceName.charAt(1) != 'n') {
                        if (noCrossPiece(from, to)) {
                            System.out.println("越子了");
                            throw new UnsupportedOperationException();
                        }
                    }
                    Piece targetPiece = getPiece(to);
                    Piece originPiece = getPiece(to);
                    removePiece(to);
                    addPiece(getPiece(from), to);
                    System.out.println("已经移动," + targetPiece.toString() + "已被占领");
                    if (!listenerList.isEmpty()) {
                        listenerList.get(0).onCapture(originPiece, targetPiece);
                    }
                    removePiece(from); //原始位置变成null


            } else if (from.equals(to)) {
                System.out.println("我自己都把自己干掉了");

            }else{
                System.out.println("位置合法，但有己方棋子，不能移动");
                throw new UnsupportedOperationException();

            }

        }
        else {
            System.out.println("移动非法");
            throw new UnsupportedOperationException();
        }

    }

    // remove all piece
    public void clear() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                pieces[i][j] = null;
            }
        }
    }

    public void registerListener(BoardListener bl) {
	    listenerList.add(bl);
        System.out.println("A listener has been added");
    }

    public void removeListener(BoardListener bl) {
        listenerList.remove(bl);
        System.out.println("Listener "+bl+ " has been remove");
    }

    public void removeAllListeners() {
        listenerList.clear();
        System.out.println("All listener has been removed");
    }

    public void iterate(BoardExternalIterator bi) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                String loc = "abcdefgh".charAt(j)+String.valueOf(i+1);
                bi.visit(loc , pieces[i][j]);
                System.out.println(loc+":"+getPiece(loc));
            }
        }
    }
}