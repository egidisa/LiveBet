package com.livebet.ejb.beans;

import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.livebet.data.ejb.interfaces.RequestDAO;
import com.livebet.domain.operation.BusinessRequest;
import com.livebet.domain.operation.BusinessResponse;
import com.livebet.domain.operation.RegisterBetRequest;
import com.livebet.domain.operation.RegisterBetResponse;
import com.livebet.domain.operation.UpdateQuoteRequest;
import com.livebet.domain.operation.UpdateQuoteResponse;
import com.livebet.ejb.interfaces.QuotesHandler;
import com.livebet.ejb.interfaces.RequestHandler;

/**
 * 
 * @author p3 Edit: Alessio
 */
@Stateless
public class QuotesHandlerBean implements QuotesHandler {

	private final static Logger log = Logger.getLogger(QuotesHandlerBean.class
			.getCanonicalName());

	@EJB
	private RequestHandler requestHandlerBean;

	@EJB
	RequestDAO requestDAO;

	private BusinessResponse processRequest(BusinessRequest br) {

		requestHandlerBean.putReq(br);
		br = requestHandlerBean.takeReq();

		BusinessResponse bResp = null;
		boolean res;

		if (br instanceof UpdateQuoteRequest) {
			UpdateQuoteRequest uQR = (UpdateQuoteRequest) br;
			bResp = new UpdateQuoteResponse();

			// Quote's versions must match
			int quoteDBVersion = requestDAO.getQuote(uQR.getIDQuote())
					.getVersion().get();
			int quoteClientVersion = uQR.getVersion().get();
			if (quoteDBVersion > quoteClientVersion) {
				bResp.setResult(false);
				bResp.setCause("Quote version mismatch.");
			} else if (quoteDBVersion == quoteClientVersion) {
				res = requestDAO.updateQuote(uQR.getIDQuote(), uQR
						.getNewNumericQuote().intValue());
				bResp.setResult(res);
				if (res)
					bResp.setCause("Quote updated.");
				else
					bResp.setCause("Error while updating!");
			} else {
				bResp.setResult(false);
				bResp.setCause("Quote UNEXPECTED version mismatch.");
			}
		} else if (br instanceof RegisterBetRequest) {
			RegisterBetRequest rbr = (RegisterBetRequest) br;
			log.info("RBR = " + rbr);
			bResp = new RegisterBetResponse();

			Integer betMoney = rbr.getMoney();

			log.info("RBR.money = " + rbr.getMoney());
			log.info("RBR.IDUser = " + rbr.getIDUser());
			Integer money = requestDAO.getCredit(rbr.getIDUser());

			// quote's version must match
			int quoteDBVersion = requestDAO.getQuote(rbr.getQuote().getId())
					.getVersion().get();
			int quoteClientVersion = rbr.getQuote().getVersion().get();
			log.info("QuoteDBVersion = " + quoteDBVersion + " QuoteClientVersion = " + quoteClientVersion);
			if (quoteDBVersion > quoteClientVersion) {
				bResp.setResult(false);
				bResp.setCause("Quote version mismatch.");
			} else if (quoteDBVersion == quoteClientVersion) {
				// enough credit?
				if ((money - betMoney) < 0) {
					bResp.setResult(false);
					bResp.setCause("Not enough credit.");
				} else {
					if (requestDAO.createBet(rbr.getQuote().getId(), betMoney,
							rbr.getIDUser())) {

						bResp.setResult(true);
						money -= betMoney;
						requestDAO.setCredit(rbr.getIDUser(), money);
					} else {
						bResp.setResult(false);
						bResp.setCause("Could not save your bet. please try later :(");
					}

				}

			} else {
				bResp.setResult(false);
				bResp.setCause("Quote UNEXPECTED version mismatch.");
			}

		}
		return bResp;
	}

	public UpdateQuoteResponse updateQuote(UpdateQuoteRequest uqr) {

		return (UpdateQuoteResponse) processRequest(uqr);
	}

	public RegisterBetResponse registerBet(RegisterBetRequest rbr) {
		return (RegisterBetResponse) processRequest(rbr);
	}

	public RequestHandler getSingleton() {
		return requestHandlerBean;
	}

	public void setSingleton(RequestHandler requestHandlerBean) {
		this.requestHandlerBean = requestHandlerBean;
	}

}
