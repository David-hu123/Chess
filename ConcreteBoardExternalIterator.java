public class ConcreteBoardExternalIterator implements BoardExternalIterator {
    @Override
    public void visit(String loc, Piece p) {
        System.out.println(loc+" is viewed, and the piece is "+p.toString());
    }
}
