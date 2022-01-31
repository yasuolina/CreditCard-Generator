import java.util.*;

public class CreditCardGeneratorDriver implements CreditCardGenerator {


    @Override
    public String generateByCardType( final CardType cardType ) {
        if( cardType == null ) throw new IllegalArgumentException( "Card type is null" );

        return generateCardNumber( cardType );
    }

    @Override
    public List<String> generateListByCardType( final int howMany, final CardType cardType ) {
        if( howMany <= 0 ) throw new IllegalArgumentException( "How many must be greater than zero" );
        if( cardType == null ) throw new IllegalArgumentException( "Card type is null" );

        final List<String> cardNums = new ArrayList<>( howMany );

        for( int i = 0; i < howMany; i++ ) {
            cardNums.add( generateCardNumber(cardType) );
        }

        return cardNums;
    }

    private static String generateCardNumber( final CardType cardType ) {
        final String cardNum = generateCardNumber( randomFromSet(cardType.getPrefixes()),
                cardType.getLengths().get(new Random().nextInt(cardType.getLengths().size())) );

        if(cardType == CardType.AMERICAN_EXPRESS){

            return cardType.toString()+cardNum.substring(0,3)+"-"+cardNum.substring(4,9)+"-"+cardNum.substring(10,14)+"\n";
        }
        else if(cardType == CardType.MASTERCARD){

            return cardType.toString()+cardNum.substring(0,3)+"-"+cardNum.substring(4,7)+"-"+cardNum.substring(8,11)+"-"+cardNum.substring(11,15)+"\n";
        }
        else if(cardType == CardType.VISA){


            return cardType.toString()+cardNum.substring(0,3)+"-"+cardNum.substring(4,7)+"-"+cardNum.substring(8,11)+"-"+cardNum.substring(11,15)+"\n";
        }
        return " ";
    }

    private static String generateCardNumber( final Long prefix, final int length ) {
        final StringBuffer num = new StringBuffer( prefix.toString() );

        final int howManyMore = length - num.toString().length() - 1;
        final Random random = new Random();

        for( int i = 0; i < howManyMore; i++ ) {
            num.append( Integer.valueOf(random.nextInt(9)) );
        }

        num.append( calculateCheckDigit(num.toString()) );

        return num.toString();
    }

    private static int calculateCheckDigit( final String str ) {
        final int sum = calculateLuhnSum( str, false );
        final int checkDigit = calculateCheckDigit( sum );

        return checkDigit;
    }

    private static int calculateCheckDigit( final int luhnSum ) {
        final int checkDigit = (luhnSum * 9) % 10;
        return checkDigit;
    }

    private static int calculateLuhnSum( final String str, final boolean hasCheckDigit ) {
        final int luhnNums[] = new int[str.length()];
        final int start = str.length() - (hasCheckDigit ? 2 : 1);
        int sum = 0;

        boolean doubleMe = true;

        for( int i = start; i >= 0; i-- ) {
            final int num = Integer.parseInt( str.substring(i, i + 1) );

            if( doubleMe ) {
                int x2 = num * 2;
                luhnNums[i] = x2 > 9 ? x2 - 9 : x2;
            } else {
                luhnNums[i] = num;
            }

            sum += luhnNums[i];
            doubleMe = !doubleMe;
        }

        return sum;
    }

    private static <T> T randomFromSet( final Set<T> set ) {
        T item = null;
        int random;

        if( set == null || set.size() < 1 ) throw new IllegalArgumentException( "Set is null or empty" );

        random = new Random().nextInt( set.size() );

        final Iterator<T> iterator = set.iterator();

        for( int i = 0; i <= random; i++ ) {
            item = iterator.next();
        }

        return item;
    }

    @Override
    public int harcama(final CardType cardType, int harcamaMiktari ) {
        if(cardType == CardType.AMERICAN_EXPRESS){

          int kalanLimit= Integer.parseInt(cardType.getLimit())-harcamaMiktari;
            System.out.print("Harcamanızdan sonra kalan limitiniz= "+kalanLimit);

        }
        else if(cardType == CardType.MASTERCARD){

            int kalanLimit= Integer.parseInt(cardType.getLimit())-harcamaMiktari;
            System.out.print("Harcamanızdan sonra kalan limitiniz= "+kalanLimit);

        }
        else if(cardType == CardType.VISA){

            int kalanLimit= Integer.parseInt(cardType.getLimit())-harcamaMiktari;
            System.out.print("Harcamanızdan sonra kalan limitiniz= "+kalanLimit);

        }
        return 0;
    }

    @Override
    public int borcOdeme(final CardType cardType ,int borc, int para) {
        if(cardType == CardType.AMERICAN_EXPRESS){

            int kalanBorc = borc- para;
            if(kalanBorc<=0){
                System.out.println("Borcunuz kalmamıştır.");
            }
            else
                System.out.print("Kalan borcunuz= "+kalanBorc);


        }
        else if(cardType == CardType.MASTERCARD){

            int kalanBorc = borc- para;
            if(kalanBorc<=0){
                System.out.println("Borcunuz kalmamıştır.");
            }
            else
                System.out.print("Kalan borcunuz= "+kalanBorc);

        }
        else if(cardType == CardType.VISA){

            int kalanBorc = borc- para;
            if(kalanBorc<=0){
                System.out.println("Borcunuz kalmamıştır.");
            }
            else
                System.out.print("Kalan borcunuz= "+kalanBorc);
        }
        return 0;
    }

    @Override
    public int puanIleborcOde(final CardType cardType , int ekPuan,  int borc) {

        if(cardType == CardType.AMERICAN_EXPRESS){

            int kalanBorc = borc- ekPuan;
            if(kalanBorc<=0){
                System.out.println("Borcunuz kalmamıştır.");
            }
            else
                System.out.print("Kalan borcunuz= "+kalanBorc);


        }
        else if(cardType == CardType.MASTERCARD){

            int kalanBorc = borc- ekPuan;
            if(kalanBorc<=0){
                System.out.println("Borcunuz kalmamıştır.");
            }
            else
                System.out.print("Kalan borcunuz= "+kalanBorc);

        }
        else if(cardType == CardType.VISA){

            int kalanBorc = borc- ekPuan;
            if(kalanBorc<=0){
                System.out.println("Borcunuz kalmamıştır.");
            }
            else
                System.out.print("Kalan borcunuz= "+kalanBorc);
        }
        return 0;
    }
}