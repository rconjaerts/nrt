/*
 * Group NRT
 * Hackiothon
 */
package entities.service;

import entities.Event;
import entities.unpersisted.SleepComfort;
import java.util.ArrayList;
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
import settings.Parameters;

/**
 *
 * @author Niels
 */
@Stateless
@Path("entities.event")
public class EventFacadeREST extends AbstractFacade<Event> {
    @PersistenceContext(unitName = "BigSisterRebootPU")
    private EntityManager em;

    public EventFacadeREST() {
        super(Event.class);
    }

    @POST
    @Override
    @Consumes({"application/xml", "application/json"})
    public void create(Event entity) {
        super.create(entity);
    }

    @PUT
    @Override
    @Consumes({"application/xml", "application/json"})
    public void edit(Event entity) {
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
    public Event find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({"application/xml", "application/json"})
    public List<Event> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/xml", "application/json"})
    public List<Event> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String countREST() {
        return String.valueOf(super.count());
    }

    @GET
    @Path("livedata/{accountId}/{typeId}/{timestamp}")
    @Produces({"application/xml", "application/json"})
    public List<Event> getLiveData(
            @PathParam("accountId") Integer accountId,
            @PathParam("typeId") Integer typeId, 
            @PathParam("timestamp") Integer timestamp) 
    {
        return (List<Event>) em.createNamedQuery("Event.liveDataByAccountAndLastTimeStamp")
                .setParameter("accountId", accountId)
                .setParameter("typeId", typeId)
                .setParameter("timestamp", timestamp)
                .getResultList();
    }
    
    @GET
    @Path("historydata/{accountId}/{typeId}/{from}/{to}")
    @Produces({"application/xml", "application/json"})
    public List<Event> getHistoryData(
            @PathParam("accountId") Integer accountId,
            @PathParam("typeId") Integer typeId,
            @PathParam("from") Integer from, 
            @PathParam("to") Integer to) 
    {
        List<Event> eventList = (List<Event>) em.createNamedQuery("Event.historyDataByAccountFromTo")
                .setParameter("accountId", accountId)
                .setParameter("typeId", typeId)
                .setParameter("from", from)
                .setParameter("to", to)
                .getResultList();
        if(eventList.size()>1)
            return generateEmptyDataStream(eventList, typeId);
        return eventList;
    }
    
    @GET
    @Path("sleepcomfort/{accountId}/{from}/{to}")
    @Produces({"application/xml", "application/json"})
    public SleepComfort getSleepComfort(
            @PathParam("accountId") Integer accountId,
            @PathParam("from") Integer from, 
            @PathParam("to") Integer to) 
    {
        List<Event> eventAudioList = (List<Event>) em.createNamedQuery("Event.sleepComfort")
                .setParameter("accountId", accountId)
                .setParameter("typeId", 1)
                .setParameter("from", from)
                .setParameter("to", to)
                .getResultList();
        
        List<Event> eventVideoList = (List<Event>) em.createNamedQuery("Event.sleepComfort")
                .setParameter("accountId", accountId)
                .setParameter("typeId", 2)
                .setParameter("from", from)
                .setParameter("to", to)
                .getResultList();
        
        return new SleepComfort(
                calculateSleepComfort(eventAudioList), 
                calculateSleepComfort(eventVideoList));
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    private float calculateSleepComfort(List<Event> eventList) {
        float total = 0;
        for (Event event : eventList) {
            total += event.getValue();
        }
        return total / eventList.size();
    }
    
    private List<Event> generateEmptyDataStream(List<Event> eventList, int typeId) {
        ArrayList<Event> addedEventList = new ArrayList<Event>();
        for(int i = 0; i < eventList.size()-1; i++) {
            int j = i + 1;
            addedEventList.add(eventList.get(i));
            addedEventList.addAll(generateEmptyDataStreamBetweenTwoEvents(eventList.get(i), eventList.get(j), typeId));
            // Last videoEvent should be added
            if(j == eventList.size()-1)
                addedEventList.add(eventList.get(j));
        }
        return addedEventList;
    }
    
    private List<Event> generateEmptyDataStreamBetweenTwoEvents(Event ev1, Event ev2, int typeId) {
        int intervalInMilliseconds = 60000 * Parameters.SENDING_INTERVAL;
        int difference = Math.abs(ev1.getTimestamp() - ev2.getTimestamp());
        int minutes = (int) (((difference / (1000*60)) % 60)/ Parameters.SENDING_INTERVAL);
        List<Event> addedEventList = new ArrayList<Event>();
        for(int i = 1; i <= minutes; i++) {
            int timestamp = (ev1.getTimestamp() + (intervalInMilliseconds * i));
            addedEventList.add(new Event(-1, -1, 0, timestamp, typeId));
        }
        return addedEventList;
    }
    
}
