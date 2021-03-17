package ir.mab.pagingsample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.paging.PagingData;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import org.reactivestreams.Subscription;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.FlowableSubscriber;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    PassengerViewModel passengerViewModel;
    PassengerAdapter passengerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.list);
        passengerViewModel = new ViewModelProvider(this).get(PassengerViewModel.class);
        passengerAdapter = new PassengerAdapter(new PassengerComparator());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(passengerAdapter);

        passengerViewModel.getPassengers().subscribe(pagingData ->{
            Log.d("passengerViewModel" , pagingData.toString());
            passengerAdapter.submitData(getLifecycle(), pagingData);
        });
    }
}