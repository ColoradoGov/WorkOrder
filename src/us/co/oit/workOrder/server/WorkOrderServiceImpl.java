package us.co.oit.workOrder.server;

import com.google.appengine.api.datastore.*;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import us.co.oit.workOrder.client.WorkOrderService;

import java.util.UUID;

public class WorkOrderServiceImpl extends RemoteServiceServlet implements WorkOrderService {
    @Override
    public String saveFieldValue(String fieldValue) {

        DatastoreServiceConfig config =
                DatastoreServiceConfig.Builder.withReadPolicy(new ReadPolicy(ReadPolicy.Consistency.STRONG));
        DatastoreService service = DatastoreServiceFactory.getDatastoreService(config);
        Key key = KeyFactory.createKey("WorkOrders", UUID.randomUUID().toString());

        Entity objectToSave = new Entity(key);
        objectToSave.setProperty("workLocation", fieldValue);
        service.put(objectToSave);

        /*
        try
        {
            Entity loadedObject = service.get(key);
            return "Reload object " + loadedObject.getProperty("workLocation");
        }
        catch(EntityNotFoundException ex)
        {
            throw new RuntimeException(ex);
        }*/

        Query query = new Query("WorkOrders");
        query.setFilter(new Query.FilterPredicate("workLocation", Query.FilterOperator.EQUAL, fieldValue));
        PreparedQuery pq = service.prepare(query);
        Iterable<Entity> iter  = pq.asIterable();
        int counter = 0;
        for (Entity ent: iter)
        {
           counter++;
        }
        return "Loaded " + counter + " values with the passed in value of " + fieldValue;




    }
    // Implementation of sample interface method


}