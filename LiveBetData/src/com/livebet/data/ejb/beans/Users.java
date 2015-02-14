package com.livebet.data.ejb.beans;

import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.Event;
import model.Quote;

/**
 * Session Bean implementation class Users
 */
@Stateless
public class Users implements UsersRemote {

	@PersistenceContext(name = "LiveBetData") private EntityManager em;
    /**
     * Default constructor. 
     */
    public Users() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public boolean usernameExists(String username) {
		boolean exists = false;	
		Logger log = Logger.getLogger(Users.class.getCanonicalName());
//		Player usernameExists = em.find(Player.class, new Integer(5));
		//Player usernameExists = (Player) em.createQuery("select username from dbLivebet.PLAYER where PLAYER.idUser ="+username);
		List<Event> ciao = em.createNamedQuery("Event.findAll").getResultList();
		Event prova = ciao.get(1);
		log.info("Evento: "+prova.getEventname());
		log.info("Quote evento: ");
		List<Quote> listaQuote= prova.getQuotes();
		for (Quote q: listaQuote) {
			log.info("Quota: "+q.getIdquote());
		}
		log.info("Aggiungo quota id 6");
		//Quote quotaProva = new Quote();
		//quotaProva.setIdquote(6);
		//quotaProva.setEvent(prova);
		//prova.addQuote(quotaProva);
		log.info("Nuove Quote");
		for (Quote q: listaQuote) {
			log.info("Quota: " + q.getIdquote());
		}
		//for(Event p: ciao){
			//log.info(p.addQuote(quote));
		//}
		//if (usernameExists != null) exists=true;
		
		return ciao.isEmpty();
	}

}
