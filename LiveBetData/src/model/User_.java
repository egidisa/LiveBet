package model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2015-02-07T19:18:37.365+0100")
@StaticMetamodel(User.class)
public class User_ {
	public static volatile SingularAttribute<User, Integer> iduser;
	public static volatile SingularAttribute<User, Integer> credit;
	public static volatile SingularAttribute<User, Date> lastseen;
	public static volatile SingularAttribute<User, String> password;
	public static volatile SingularAttribute<User, String> role;
	public static volatile SingularAttribute<User, String> username;
	public static volatile ListAttribute<User, Bet> bets;
}
