import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class Test {

    // Run "java -ea Test" to run with assertions enabled (If you run
    // with assertions disabled, the default, then assert statements
    // will not execute!)

    public static void test1() {
		Board b = Board.theBoard();
		Piece.registerPiece(new PawnFactory());
		Piece p = Piece.createPiece("bp");
		b.addPiece(p, "a3");
		assert b.getPiece("a3") == p;
    }
	public static void test11() {
		Board b = Board.theBoard();
		Piece.registerPiece(new PawnFactory());
		Piece.registerPiece(new KnightFactory());
		Piece bp = Piece.createPiece("bp");
		Piece wq = Piece.createPiece("wq");
		b.addPiece(bp, "a3");
		List<String> move1 = bp.moves(b,"a6");
		List<String> move2 = wq.moves(b,"c2");
		assert b.getPiece("a3") == bp;
		assert move1.contains("a7");
		assert move1.contains("b6");
	}
    //Listener Test
    public static void test2(){
		Board board = Board.theBoard();
		BoardListener boardListener = new ConcreteBoardListener();
		BoardListener boardListener1 = new ConcreteBoardListener();
		board.registerListener(boardListener);
		board.registerListener(boardListener1);
		board.removeAllListeners();
		board.registerListener(boardListener1);
		board.removeListener(boardListener1);
	}
    public static void test3(){
		//		String loc = "t1";
//		int index1 = "abcdefgh".indexOf(loc.charAt(0));
//		int index2 = "12345678".indexOf(loc.charAt(1));
//		System.out.println(index1);
//		System.out.println(index2);
		System.out.println("abcdefgh".charAt(3)+String.valueOf(3));
	}
	// Pawn capture 对方棋子
	public static void test4(){
		Board b = Board.theBoard();
		Piece.registerPiece(new PawnFactory());
		Piece p1 = Piece.createPiece("wp");
		Piece p2 = Piece.createPiece("bp");
		b.addPiece(p1, "a2");
		b.addPiece(p2, "a4");
		b.movePiece("a2","a3");
		b.movePiece("a3","a4");
	}
	// 是否越子
	public static void test5(){
    	// Pawn
//		Board b = Board.theBoard();
//		Piece.registerPiece(new PawnFactory());
//		Piece p1 = Piece.createPiece("wp");
//		Piece p2 = Piece.createPiece("bp");
//		b.addPiece(p1, "a2");
//		b.addPiece(p2, "a3");
//		b.movePiece("a2","a5");
//		Board b = Board.theBoard();
//		Piece.registerPiece(new PawnFactory());
//		Piece p1 = Piece.createPiece("wp");
//		Piece p2 = Piece.createPiece("bp");
//		b.addPiece(p1, "a3");
//		b.addPiece(p2, "a4");
//		b.movePiece("a3","a4");
		// Bishop
//		Board b = Board.theBoard();
//		Piece.registerPiece(new BishopFactory());
//		Piece p1 = Piece.createPiece("wb");
//		Piece p2 = Piece.createPiece("bb");
//		b.addPiece(p1, "c1");
//		b.addPiece(p2, "b2");
//		b.movePiece("c1","a3");
		// King
//		Board b = Board.theBoard();
//		Piece.registerPiece(new KingFactory());
//		Piece p1 = Piece.createPiece("wk");
//		Piece p2 = Piece.createPiece("bk");
//		b.addPiece(p1, "e1");
//		b.addPiece(p2, "d2");
//		b.addPiece(p2, "e2");
//		b.addPiece(p2, "d1");
//		b.movePiece("e1","c3");
		// Knight
//		Board b = Board.theBoard();
//		Piece.registerPiece(new KnightFactory());
//		Piece p1 = Piece.createPiece("wn");
//		Piece p2 = Piece.createPiece("wn");
//		b.addPiece(p1, "e1");
//		b.addPiece(p2, "d3");
//		b.addPiece(p2, "e2");
//		b.addPiece(p2, "d1");
//		b.movePiece("e1","d3");
		// Queen
//		Board b = Board.theBoard();
//		Piece.registerPiece(new QueenFactory());
//		Piece p1 = Piece.createPiece("wq");
//		Piece p2 = Piece.createPiece("bq");
//		b.addPiece(p1, "d1");
//		b.addPiece(p2, "d8");
//		b.addPiece(p2, "d4");
//		b.movePiece("d1","b3");
//		b.addPiece(p2, "c2");
//		b.movePiece("b3","d1");
		// rook
//		Board b = Board.theBoard();
//		Piece.registerPiece(new RookFactory());
//		Piece p1 = Piece.createPiece("wr");
//		Piece p2 = Piece.createPiece("br");
//		b.addPiece(p1, "d1");
//		b.addPiece(p2, "d8");
//		b.addPiece(p2, "d7");
//		b.movePiece("d1","d8");
	}
    public static void main(String[] args) {
//
		Board.theBoard();
		Piece.registerPiece(new PawnFactory());
		Piece p1 = Piece.createPiece("wp");
		Piece p2 = Piece.createPiece("bp");
//		Piece.registerPiece(new KingFactory());
//		Piece p1 = Piece.createPiece("bk");
//		Piece p2 = Piece.createPiece("wk");
		Board.theBoard().addPiece(p1, "a3");
		Board.theBoard().addPiece(p2, "b5");
		Board.theBoard().movePiece("a3","b4");
//		Board.theBoard().addPiece(p2, "c3");
//		Board.theBoard().addPiece(p1, "b3");
//		Board.theBoard().addPiece(p1, "d2");
//		Board.theBoard().movePiece("c3","d2");
//		System.out.println("----------------");
//		System.out.println(Board.theBoard().getPiece("g6") == p1);
	}

}