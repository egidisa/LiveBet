package com.livebet.web.ejbclients;

import java.io.Serializable;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;

import com.livebet.ejb.interfaces.Bookmaker;

@SessionScoped
public class BookmakerClient implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7577407048410489432L;
	// Beans that use session, application, or conversation scope must be
	// serializable, but
	// beans that use request scope do not have to be serializable. (from JEET
	// doc)

	private final static Logger log = Logger.getLogger(BookmakerClient.class
			.getCanonicalName());

	@EJB
	Bookmaker bookmakerBean;

	public BookmakerClient() {
		log.info("ENTERING --> " + getClass().getCanonicalName()
				+ ".CONSTRUCTOR");

		log.info("LEAVING <-- " + getClass().getCanonicalName()
				+ ".CONSTRUCTOR");

	}

	public Bookmaker getBookmakerBean() {
		return bookmakerBean;
	}

	// TODO check if this method can be removed or not.
	public void setBookmakerBean(Bookmaker bookmakerBean) {
		this.bookmakerBean = bookmakerBean;
	}

}
