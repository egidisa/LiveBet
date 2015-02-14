package com.livebet.data.ejb.beans;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2015-02-06T17:41:56.551+0100")
@StaticMetamodel(Player.class)
public class Player_ {
	public static volatile SingularAttribute<Player, Integer> iduser;
	public static volatile SingularAttribute<Player, Date> lastseen;
	public static volatile SingularAttribute<Player, String> password;
	public static volatile SingularAttribute<Player, String> role;
	public static volatile SingularAttribute<Player, String> username;
}
