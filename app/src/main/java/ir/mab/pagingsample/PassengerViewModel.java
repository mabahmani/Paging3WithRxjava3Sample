package ir.mab.pagingsample;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import androidx.paging.Pager;
import androidx.paging.PagingConfig;
import androidx.paging.PagingData;
import androidx.paging.PagingLiveData;
import androidx.paging.rxjava3.PagingRx;

import io.reactivex.rxjava3.core.Flowable;
import kotlinx.coroutines.CoroutineScope;

public class PassengerViewModel extends ViewModel {
    Flowable<PagingData<PassengerModel.Data>> getPassengers(){
        CoroutineScope viewModelScope = ViewModelKt.getViewModelScope(this);
        Pager<Integer,PassengerModel.Data> pager = new Pager<>(
                new PagingConfig(10), 1, PassengerPagingSource::new);

        Flowable<PagingData<PassengerModel.Data>> flowable = PagingRx.getFlowable(pager);
        return PagingRx.cachedIn(flowable,viewModelScope );
    }
}
