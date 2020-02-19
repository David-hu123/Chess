public class ConcreteBoardListener implements BoardListener {
    @Override
    public void onMove(String from, String to, Piece p) {
        System.out.println("The piece move from from to to");
    }

    @Override
    public void onCapture(Piece attacker, Piece captured) {
        System.out.println("heiheihei");
    }
}
