import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;


public enum CardType {
    AMERICAN_EXPRESS( prefixesFromRange(new Range(34, 34), new Range(37, 37)), list(15) ,"Yasemin Yılmaz", "11/25", "333", "2000", 100, 1000),

    VISA( prefixesFromRange(new Range(4, 4)), list( 16), "Berfin Çiçek", "10/26", "467", "3000", 100 ,1000),

    MASTERCARD( prefixesFromRange(new Range(51, 55)), list(16), "Caner Çetin", "09/24", "123", "2500" , 150, 500);

    private Set<Long> prefixes;
    private List<Integer> lengths;
    private String nameSurname;
    private String skt;
    private String CVV;
    private String limit;
    private int ekPuan, borc;


    private CardType( final Set<Long> prefixes, final List<Integer> lengths ) {
        this.prefixes = prefixes;
        this.lengths = lengths;
    }

    private CardType(final Set<Long> prefixes, final List<Integer> lengths, String nameSurname, String skt, String CVV, String limit, int ekPuan, int borc) {
        this.prefixes = prefixes;
        this.lengths = lengths;
        this.nameSurname = nameSurname;
        this.skt = skt;
        this.CVV=CVV;
        this.limit=limit;
        this.ekPuan = ekPuan;
        this.borc=borc;
    }

    @Override
    public String toString() {
        return
                "\nAd/Soyad= " + nameSurname + '\n' +
                "SKT=" + skt + '\n' +
                "CVV= " + CVV + '\n' +
                "Kart Limiti= " + limit +
                "\nEk Puan= "  + ekPuan +
                "\nKart Nu= ";
    }

    public String getNameSurname() {
        return nameSurname;
    }

    public void setNameSurname(String nameSurname) {
        this.nameSurname = nameSurname;
    }

    public String getSkt() {
        return skt;
    }

    public void setSkt(String skt) {
        this.skt = skt;
    }

    public String getCVV() {
        return CVV;
    }

    public void setCVV(String CVV) {
        this.CVV = CVV;
    }

    public String getLimit() {
        return limit;
    }

    public void setLimit(String limit) {
        this.limit = limit;
    }

    public int getEkPuan() {
        return ekPuan;
    }

    public void setEkPuan(int ekPuan) {
        this.ekPuan = ekPuan;
    }

    public Set<Long> getPrefixes() {
        return prefixes;
    }

    public List<Integer> getLengths() {
        return lengths;
    }

    private static Set<Long> prefixesFromRange( final Range ... ranges ) {
        if( ranges == null || ranges.length == 0 ) throw new IllegalArgumentException( "Ranges is null or empty" );

        final Set<Long> prefixes = new LinkedHashSet<>();

        for( final Range r : ranges ) {
            if( r != null ) {
                final List<Long> list = new ArrayList<>( (int)(r.getEnd() - r.getStart() + 1) );

                for( long i = r.getStart(); i <= r.getEnd(); i++ ) {
                    list.add( i );
                }

                prefixes.addAll( list );
            }
        }

        return Collections.unmodifiableSet( prefixes );
    }

    @SafeVarargs
    private static <T> List<T> list( final T ... stuff ) {
        if( stuff == null || stuff.length == 0 ) throw new IllegalArgumentException( "Null or empty vararg" );

        final List<T> set = new ArrayList<>( stuff.length );

        for( final T t : stuff ) {
            set.add( t );
        }

        return Collections.unmodifiableList( set );
    }
}