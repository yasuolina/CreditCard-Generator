import java.util.List;


public interface CreditCardGenerator {


    public String generateByCardType( CardType cardType );

    public List<String> generateListByCardType( int howMany, CardType cardType );

    public int harcama(final CardType cardType, int harcamaMiktari);
    public int borcOdeme(final CardType cardType , int borc, int para);
    public int puanIleborcOde(final CardType cardType , int ekPuan, int borc);
}