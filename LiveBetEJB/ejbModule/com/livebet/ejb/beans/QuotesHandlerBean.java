package com.livebet.ejb.beans;

import javax.ejb.EJB;
import javax.ejb.Stateless;

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

	@EJB
	private RequestHandler requestHandlerBean;

	private BusinessResponse processRequest(BusinessRequest br) {

		requestHandlerBean.putReq(br);
		br = requestHandlerBean.takeReq();
		BusinessResponse bResp = null;
		if (br instanceof UpdateQuoteRequest) {
			UpdateQuoteRequest uQR = (UpdateQuoteRequest) br;
			bResp = new UpdateQuoteResponse();
			bResp.setResult(true);
			bResp.setCause("Quote updated.");
			// TODO chiamata DB per aggiornare quota
			// return
			// request.updateQuote(((UpdateQuoteRequest)br).getIDQuote(),((UpdateQuoteRequest)br).getNewNumericQuote());

		} else if (br instanceof RegisterBetRequest) {
			RegisterBetRequest rbr = (RegisterBetRequest) br;
			bResp = new RegisterBetResponse();
			Integer betMoney = rbr.getMoney();
			Integer money = 10; // TODO call to DB User.getMoney
			if ((money - betMoney) < 0) {

				bResp.setResult(false);
				bResp.setCause("not enough credit.");
			} else {
				bResp.setResult(true);
				money -= betMoney;
			}

			// return
			// request.updateQuote(((RegisterBetRequest)br).getIDQuote(),((RegisterBetRequest)br).getNewNumericQuote());
		}
		// TO DELETE.
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
