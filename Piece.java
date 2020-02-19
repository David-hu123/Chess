import java.util.*;

abstract public class Piece{

    public String PieceName;
    public Color color1;
    public static HashMap<String , PieceFactory> mapFactory = new HashMap<>();

    public Piece() {}
    // 构造方法们


    public static void registerPiece(PieceFactory pf) { //注册一个工厂？？\

        if (pf.symbol()=='q'){// 注册一个皇后
            mapFactory.put("q",pf);
        }
        if (pf.symbol()=='k'){// 注册一个国王
            mapFactory.put("k",pf);
        }
        if (pf.symbol()=='n'){// 注册一个皇后
            mapFactory.put("n",pf);
        }
        if (pf.symbol()=='p'){// 注册一个士兵
            mapFactory.put("p",pf);
        }
        if (pf.symbol()=='r'){// 注册一个皇后
            mapFactory.put("r",pf);
        }
        if (pf.symbol()=='b'){// 注册一个皇后
            mapFactory.put("b",pf);
        }

    }
    //赋予其名字
    public static Piece createPiece(String name) { // 调用map创建
        //黑色 qknprb
        if (name.charAt(1)=='q'&&name.charAt(0)=='b'){
            return mapFactory.get("q").create(Color.BLACK);
        }
        if (name.charAt(1)=='k'&&name.charAt(0)=='b'){
            return mapFactory.get("k").create(Color.BLACK);
        }
        if (name.charAt(1)=='n'&&name.charAt(0)=='b'){
            return mapFactory.get("n").create(Color.BLACK);
        }
        if (name.charAt(1)=='p'&&name.charAt(0)=='b'){
            return mapFactory.get("p").create(Color.BLACK);
        }
        if (name.charAt(1)=='r'&&name.charAt(0)=='b'){
            return mapFactory.get("r").create(Color.BLACK);
        }
        if (name.charAt(1)=='b'&&name.charAt(0)=='b'){ // black bishop
            return mapFactory.get("b").create(Color.BLACK);
        }

        // 白色 qknprb
        if (name.charAt(1)=='q'&&name.charAt(0)=='w'){
            return mapFactory.get("q").create(Color.WHITE);
        }
        if (name.charAt(1)=='k'&&name.charAt(0)=='w'){
            return mapFactory.get("k").create(Color.WHITE);
        }
        if (name.charAt(1)=='n'&&name.charAt(0)=='w'){
            return mapFactory.get("n").create(Color.WHITE);
        }
        if (name.charAt(1)=='p'&&name.charAt(0)=='w'){
            return mapFactory.get("p").create(Color.WHITE);
        }
        if (name.charAt(1)=='r'&&name.charAt(0)=='w'){
            return mapFactory.get("r").create(Color.WHITE);
        }
        if (name.charAt(1)=='b'&&name.charAt(0)=='w'){ // black bishop
            return mapFactory.get("b").create(Color.WHITE);
        } else {
            throw new UnsupportedOperationException();
        }


    }
    //赋予其颜色
    public Color color() {
        // You should write code here and just inherit it in
        // subclasses. For this to work, you should know
        // that subclasses can access superclass fields.
        return color1;

    }

    abstract public String toString();

    abstract public List<String> moves(Board b, String loc);
}