package model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2015-02-09T13:43:55.267+0100")
@StaticMetamodel(Quote.class)
public class Quote_ {
	public static volatile SingularAttribute<Quote, Integer> idquote;
	public static volatile SingularAttribute<Quote, String> outcome;
	public static volatile SingularAttribute<Quote, Integer> quoteversion;
	public static volatile SingularAttribute<Quote, Date> timestamp;
	public static volatile SingularAttribute<Quote, Integer> value;
	public static volatile ListAttribute<Quote, Bet> bets;
	public static volatile SingularAttribute<Quote, Event> event;
}
