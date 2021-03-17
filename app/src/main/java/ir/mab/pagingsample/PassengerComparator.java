package ir.mab.pagingsample;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

public class PassengerComparator extends DiffUtil.ItemCallback<PassengerModel.Data> {

    @Override
    public boolean areItemsTheSame(@NonNull PassengerModel.Data oldItem, @NonNull PassengerModel.Data newItem) {
        Log.d("areItemsTheSame",oldItem + " " + newItem);
        return oldItem.id.equals(newItem.id);
    }

    @Override
    public boolean areContentsTheSame(@NonNull PassengerModel.Data oldItem, @NonNull PassengerModel.Data newItem) {
        return oldItem.name.equals(newItem.name);
    }
}