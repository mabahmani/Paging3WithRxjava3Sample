package ir.mab.pagingsample;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.paging.PagingState;
import androidx.paging.rxjava3.RxPagingSource;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class PassengerPagingSource extends RxPagingSource<Integer,PassengerModel.Data> {
    @Nullable
    @Override
    public Integer getRefreshKey(@NotNull PagingState<Integer, PassengerModel.Data> pagingState) {
        Integer anchorPosition = pagingState.getAnchorPosition();
        if (anchorPosition == null) {
            return null;
        }

        LoadResult.Page<Integer, PassengerModel.Data> anchorPage = pagingState.closestPageToPosition(anchorPosition);
        if (anchorPage == null) {
            return null;
        }

        Integer prevKey = anchorPage.getPrevKey();
        if (prevKey != null) {
            return prevKey + 1;
        }

        Integer nextKey = anchorPage.getNextKey();
        if (nextKey != null) {
            return nextKey - 1;
        }

        return null;
    }

    @NotNull
    @Override
    public Single<LoadResult<Integer, PassengerModel.Data>> loadSingle(@NotNull LoadParams<Integer> loadParams) {
        Integer page = loadParams.getKey();
        if (page == null) {
            page = 1;
        }

        Integer finalPage = page;
        return ApiServiceInstance.get().getPassengers(String.valueOf(page),"10")
                .subscribeOn(Schedulers.io())
                .map(PassengerModel::getData)
                .map(data -> toLoadResult(data, finalPage))
                .onErrorReturn(LoadResult.Error::new);
    }

    private LoadResult<Integer, PassengerModel.Data> toLoadResult(@NonNull List<PassengerModel.Data> passengers , Integer page) {
        Log.d("toLoadResult ", passengers.toString());
        return new LoadResult.Page<>(
                passengers,
                page.equals(1) ? null: page - 1,
                page + 1,
                LoadResult.Page.COUNT_UNDEFINED,
                LoadResult.Page.COUNT_UNDEFINED);
    }
}
