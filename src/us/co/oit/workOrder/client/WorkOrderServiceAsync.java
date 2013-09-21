package us.co.oit.workOrder.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface WorkOrderServiceAsync {


    void saveFieldValue(String fieldValue, AsyncCallback<String> async);
}
