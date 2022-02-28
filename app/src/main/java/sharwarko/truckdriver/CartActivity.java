package sharwarko.truckdriver;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import Domain.Order;
import Lists.MenuItemsList;
import Lists.OrdersListAdapter;
import Lists.SelectFoodListAdapter;
import Service.AdminCacheImplSvc;
import Service.IOrderSvc;
import Service.OrderCacheImplSvc;
import Service.Session;

/**
 * Cart activity
 */
public class CartActivity extends AppCompatActivity {
    Session session;
    private ArrayList<Order> orders = new ArrayList<>();
    private ListView orderList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        OrderCacheImplSvc orderCacheImplSvc = OrderCacheImplSvc.getInstance();
        session = new Session(this);
        //orderCacheImplSvc.clearAll();
        //orderCacheImplSvc.updateList(session.getEmail());
        supportInvalidateOptionsMenu();
        orders = orderCacheImplSvc.retrieveAll();
        //get list of user orders by session login
        orderList = (ListView) findViewById(R.id.orderList);
        OrdersListAdapter adapter = new OrdersListAdapter(this, R.layout.adapter_view4, orders);
        orderList.setAdapter(adapter);

    }
    @Override
    protected void onStart() {
        super.onStart();
        //load login and get orders on start
        supportInvalidateOptionsMenu();
    }
}