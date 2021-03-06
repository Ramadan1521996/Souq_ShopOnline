package com.marwaeltayeb.souq.net;

import android.arch.lifecycle.MutableLiveData;
import android.arch.paging.DataSource;
import android.arch.paging.PageKeyedDataSource;

import com.marwaeltayeb.souq.model.Product;

public class LaptopDataSourceFactory extends DataSource.Factory{

    // Creating the mutable live database
    private MutableLiveData<PageKeyedDataSource<Integer, Product>> laptopLiveDataSource = new MutableLiveData<>();

    public static ProductDataSource laptopDataSource;

    private String category;
    private int userId;

    public LaptopDataSourceFactory(String category, int userId){
        this.category = category;
        this.userId = userId;
    }

    @Override
    public DataSource<Integer, Product> create() {
        // Getting our Data source object
        laptopDataSource = new ProductDataSource(category,userId);

        // Posting the Data source to get the values
        laptopLiveDataSource.postValue(laptopDataSource);

        // Returning the Data source
        return laptopDataSource;
    }


    // Getter for Product live DataSource
    public MutableLiveData<PageKeyedDataSource<Integer, Product>> getLaptopLiveDataSource() {
        return laptopLiveDataSource;
    }
}