package ir.mab.pagingsample;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    PassengerViewModel passengerViewModel;
    PassengerAdapter passengerAdapter;
    PassengerLoadStateAdapter loadStateAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.list);
        passengerViewModel = new ViewModelProvider(this).get(PassengerViewModel.class);
        passengerAdapter = new PassengerAdapter(new PassengerComparator());
        loadStateAdapter = new PassengerLoadStateAdapter(v -> passengerAdapter.retry());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(
                passengerAdapter.withLoadStateFooter(loadStateAdapter)
        );

        passengerViewModel.getPassengers().subscribe(pagingData ->{
            Log.d("passengerViewModel" , pagingData.toString());
            passengerAdapter.submitData(getLifecycle(), pagingData);
        });
    }
}