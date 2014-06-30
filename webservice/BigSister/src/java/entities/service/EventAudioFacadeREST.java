/*
 * Team NRT
 * Niels Delestinne
 * Robrecht Conjaerts
 * Tom Jaspers
 */
package entities.service;

import entities.EventAudio;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 *
 * @author Niels
 */
@Stateless
@Path("entities.eventaudio")
public class EventAudioFacadeREST extends AbstractFacade<EventAudio> {
    @PersistenceContext(unitName = "BigSisterPU")
    private EntityManager em;

    public EventAudioFacadeREST() {
        super(EventAudio.class);
    }

    @POST
    @Override
    @Consumes({"application/xml", "application/json"})
    public void create(EventAudio entity) {
        super.create(entity);
    }

    @PUT
    @Override
    @Consumes({"application/xml", "application/json"})
    public void edit(EventAudio entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public EventAudio find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({"application/xml", "application/json"})
    public List<EventAudio> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/xml", "application/json"})
    public List<EventAudio> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String countREST() {
        return String.valueOf(super.count());
    }

    @GET
    @Path("livedata/{accountId}/{timestamp}")
    @Produces({"application/xml", "application/json"})
    public List<EventAudio> getLiveData(
            @PathParam("accountId") Integer accountId, 
            @PathParam("timestamp") Integer timestamp) 
    {
        return (List<EventAudio>) em.createNamedQuery("EventAudio.liveDataByAccountAndLastTimeStamp")
                .setParameter("accountId", accountId)
                .setParameter("timestamp", timestamp)
                .getResultList();
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
