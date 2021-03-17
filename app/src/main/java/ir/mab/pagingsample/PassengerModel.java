package ir.mab.pagingsample;

import androidx.lifecycle.LiveData;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PassengerModel {
    Integer totalPassengers;
    Integer totalPages;
    List<Data> data;

    public Integer getTotalPassengers() {
        return totalPassengers;
    }

    public void setTotalPassengers(Integer totalPassengers) {
        this.totalPassengers = totalPassengers;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public List<Data> getData() {
        return data;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "PassengerModel{" +
                "totalPassengers=" + totalPassengers +
                ", totalPages=" + totalPages +
                ", data=" + data +
                '}';
    }

    public static class Data{
        @SerializedName("_id")
        String id;
        String name;
        Integer trips;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getTrips() {
            return trips;
        }

        public void setTrips(Integer trips) {
            this.trips = trips;
        }

        @Override
        public String toString() {
            return "Data{" +
                    "id='" + id + '\'' +
                    ", name='" + name + '\'' +
                    ", trips=" + trips +
                    '}';
        }
    }
}
