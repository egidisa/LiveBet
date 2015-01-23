package com.livebet.web.ejbclients;

import java.io.Serializable;

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

	@EJB
	Bookmaker bookmakerBean;

	public BookmakerClient() {
		// TODO Auto-generated constructor stub
	}

	public Bookmaker getBookmakerBean() {
		return bookmakerBean;
	}

	// TODO check if this method can be removed or not.
	public void setBookmakerBean(Bookmaker bookmakerBean) {
		this.bookmakerBean = bookmakerBean;
	}

}
