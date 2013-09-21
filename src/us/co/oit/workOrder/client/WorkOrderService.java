package us.co.oit.workOrder.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("WorkOrderService")
public interface WorkOrderService extends RemoteService {
    // Sample interface method of remote interface

    public String saveFieldValue(String fieldValue);
    /**
     * Utility/Convenience class.
     * Use WorkOrderService.App.getInstance() to access static instance of WorkOrderServiceAsync
     */
    public static class App {
        private static WorkOrderServiceAsync ourInstance = GWT.create(WorkOrderService.class);

        public static synchronized WorkOrderServiceAsync getInstance() {
            return ourInstance;
        }
    }
}
