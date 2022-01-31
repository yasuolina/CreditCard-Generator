public class Range {
    private long start,end;

    public Range( final long start, final long end ) {
        if( start > end ) throw new IllegalArgumentException( "Start cannot be greater than end" );

        this.start = start;
        this.end = end;
    }

    public long getStart() {
        return start;
    }

    public long getEnd() {
        return end;
    }

    public long size() {
        return Math.abs( getEnd() - getStart() ) + 1;
    }
}