import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Chess {
    public static void main(String[] args) throws FileNotFoundException {
	if (args.length != 2) {
	    System.out.println("Usage: java Chess layout moves");
	}
	Piece.registerPiece(new KingFactory());
	Piece.registerPiece(new QueenFactory());
	Piece.registerPiece(new KnightFactory());
	Piece.registerPiece(new BishopFactory());
	Piece.registerPiece(new RookFactory());
	Piece.registerPiece(new PawnFactory());
	Board.theBoard().registerListener(new Logger());
	// args[0] is the layout file name
	// args[1] is the moves file name
	// Put your code to read the layout file and moves files
	// here.

//		String layoutFilename = args[0];
//		String moveFilename = args[1];

//		File layoutFilename = new File("C:\\1909IDEA\\ketang\\src\\main\\java\\layout1");
		File layoutFilename = new File(args[0]);
		Scanner sc1 = null;
		try {
			sc1 = new Scanner(layoutFilename);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		while (sc1.hasNextLine()) {
			String str = sc1.nextLine();
			if (str.charAt(0)!='#') {
				String loc = str.substring(0,2);
				String pieceName = str.substring(3,5);
				Piece piece = Piece.createPiece(pieceName);
				Board.theBoard().addPiece(piece,loc);
			}
		}

		File moveFilename = new File(args[1]);
		Scanner sc2 = null;
		try {
			sc2 = new Scanner(moveFilename);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		while (sc2.hasNextLine()) { // moves File
			String str = sc2.nextLine();
			if (str.charAt(0)!='#') {
				String from = str.substring(0,2);
				String to = str.substring(3,5);
				Board.theBoard().movePiece(from,to);
			}
		}



		// Leave the following code at the end of the simulation:
		System.out.println("Final board:");
		Board.theBoard().iterate(new BoardPrinter());
    }
}