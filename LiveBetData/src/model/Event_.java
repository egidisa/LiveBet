package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2015-02-07T19:18:37.360+0100")
@StaticMetamodel(Event.class)
public class Event_ {
	public static volatile SingularAttribute<Event, Integer> idevente;
	public static volatile SingularAttribute<Event, String> eventname;
	public static volatile SingularAttribute<Event, String> outcome;
	public static volatile ListAttribute<Event, Quote> quotes;
}
