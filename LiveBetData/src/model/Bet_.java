package model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2015-02-13T09:02:46.132+0100")
@StaticMetamodel(Bet.class)
public class Bet_ {
	public static volatile SingularAttribute<Bet, Integer> idbet;
	public static volatile SingularAttribute<Bet, Integer> betamount;
	public static volatile SingularAttribute<Bet, Quote> quote;
	public static volatile SingularAttribute<Bet, User> user;
	public static volatile SingularAttribute<Bet, Date> timestamp;
}
