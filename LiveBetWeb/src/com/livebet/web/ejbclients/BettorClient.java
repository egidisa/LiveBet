package com.livebet.web.ejbclients;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;

import com.livebet.domain.Event;
import com.livebet.ejb.interfaces.Bettor;

/**
 * This class is the only one responsible of handling the per user interaction
 * with the Bettor EJB. That is: since a Stateful EJB can have only one client
 * to converse with, then this class is intended to have the role of client for
 * the BettorBean EJB. So, it has been annotated as SessionScoped according to
 * the Stateful definition of the BettorBean session EJB. For each user there
 * will be one instance of BettorClient running, such that along with the whole
 * user session, it will be always possible to call the BettorBean EJB.
 * 
 * It is kind of a "gateway" to the BettorBean EJB.
 */

/*
 * A top-level Java class is a managed bean if it is defined to be a managed
 * bean by any other Java EE technology specification, such as the JavaServer
 * Faces technology specification, or if it meets all the following conditions.
 * - It is not a nonstatic inner class. - It is a concrete class or is annotated
 * 
 * @Decorator. - It is not annotated with an EJB component-defining annotation
 * or declared as an EJB bean class in ejb-jar.xml. - It has an appropriate
 * constructor. That is, one of the following is the case. – The class has a
 * constructor with no parameters. – The class declares a constructor annotated
 * 
 * @Inject. No special declaration, such as an annotation, is required to define
 * a managed bean.
 */

/*
 * @SessionScoped Specifies that a bean is session scoped.
 * 
 * The session scope is active:
 * 
 * during the service() method of any servlet in the web application, during the
 * doFilter() method of any servlet filter and when the container calls any
 * HttpSessionListener, AsyncListener or ServletRequestListener.
 * 
 * The session context is shared between all servlet requests that occur in the
 * same HTTP session. The session context is destroyed when the HTTPSession
 * times out, after all HttpSessionListeners have been called, and at the very
 * end of any request in which invalidate() was called, after all filters and
 * ServletRequestListeners have been called.
 */

@SessionScoped
public class BettorClient implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1385271758129246391L;
	// Beans that use session, application, or conversation scope must be
	// serializable, but
	// beans that use request scope do not have to be serializable. (from JEET
	// doc)

	private final static Logger log = Logger.getLogger(BettorClient.class
			.getCanonicalName());

	@EJB
	Bettor bettorBean;

	List<Event> eventList = null;
	
	public List<Event> getEventList() {
		return eventList;
	}

	public void setEventList(List<Event> eventList) {
		this.eventList = eventList;
	}

	public BettorClient() {
		log.info("ENTERING --> " + getClass().getCanonicalName()
				+ ".CONSTRUCTOR");

		log.info("LEAVING <-- " + getClass().getCanonicalName()
				+ ".CONSTRUCTOR");
	}

	public Bettor getBettorBean() {
		return bettorBean;
	}

	// TODO check if this method can be removed or not.
	public void setBettorBean(Bettor bettorBean) {
		this.bettorBean = bettorBean;
	}

}
