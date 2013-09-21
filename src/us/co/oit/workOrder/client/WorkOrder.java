package us.co.oit.workOrder.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.DOM;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;

/**
 * Entry point classes define <code>onModuleLoad()</code>
 */
public class WorkOrder implements EntryPoint {

    /**
     * This is the entry point method.
     */
    public void onModuleLoad() {
        final Button button = new Button("Click me");
        final Label label = new Label();
        final TextBox field1 = new TextBox();
        button.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                if (label.getText().equals("")) {
//                    WorkOrderService.App.getInstance().getMessage("Hello, World!", field1.getValue(), new MyAsyncCallback(label));
                    WorkOrderService.App.getInstance().saveFieldValue(field1.getValue(), new ObjectSavedCallback());
                } else {
                    label.setText("");
                }
            }
        });

        // Assume that the host HTML has elements defined whose
        // IDs are "slot1", "slot2".  In a real app, you probably would not want
        // to hard-code IDs.  Instead, you could, for example, search for all
        // elements with a particular CSS class and replace them with widgets.
        //
        Panel panel = new FlowPanel();

        panel.add(field1);
        panel.add(button);


        RootPanel.get("slot1").add(panel);
        RootPanel.get("slot2").add(label);
    }


    private static class ObjectSavedCallback implements AsyncCallback<String>{

        @Override
        public void onFailure(Throwable caught) {
            Window.alert("Failed to save");
            //To change body of implemented methods use File | Settings | File Templates.
        }

        @Override
        public void onSuccess(String result) {
            Window.alert("Success return value is " + result);
            //To change body of implemented methods use File | Settings | File Templates.
        }
    }

    private static class MyAsyncCallback implements AsyncCallback<String> {
        private Label label;

        public MyAsyncCallback(Label label) {
            this.label = label;
        }

        public void onSuccess(String result) {
            label.getElement().setInnerHTML(result);
        }

        public void onFailure(Throwable throwable) {
            label.setText("Failed to receive answer from server!");
        }
    }
}
