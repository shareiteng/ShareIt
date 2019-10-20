package com.transcan.backendtranscan.domain;

import com.transcan.backendtranscan.services.MapService;
import com.transcan.backendtranscan.services.RideSuggestionService;
import com.transcan.backendtranscan.services.SearchRideService;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ResultMatchObj {
    static final int TEXI = 0;
    static final int PRIVATE_CAR = 1;
    static final int TEXI6SEAT = 2;
    static final int MINIBUS = 3;
    static final int BUS = 4;

    private long mId;
    private ArrayList<Long> mPassngersIdList;
    private int mVehicle;


    public ResultMatchObj(long id) {
        this.mId = id;
        mPassngersIdList = new ArrayList();
        mVehicle = TEXI;
    }

    public void addNewPassanger(long id) {
        mPassngersIdList.add(id);
    }

    public int getPassengerNum() {
        return mPassngersIdList.size();
    }

    public ArrayList<Long> getPassengerList() {
        return mPassngersIdList;
    }

    public int VehicleType() {
        if (getPassengerNum() <= 4)
            mVehicle = TEXI;
        else if (getPassengerNum() <= 8)
            mVehicle = TEXI6SEAT;
        else if (getPassengerNum() <= 15)
            mVehicle = MINIBUS;
        else
            mVehicle = BUS;

        return mVehicle;
    }

    public ArrayList<ResultMatchObj> getMatchList(Iterable<RideSearch> rideSearch ) {

        ArrayList<ResultMatchObj> arrayList = new ArrayList<ResultMatchObj>();
        for (RideSearch current : rideSearch) {
            for (RideSearch passanger : rideSearch) {
                if (current.getSearchId() != passanger.getSearchId()) {
                    arrayList.add(new ResultMatchObj(current.getSearchId()));
                    if (MapService.getDistanceGeoLocation(current.getDesLatLng(), passanger.getDesLatLng()) <= 500 &&
                            MapService.getDistanceGeoLocation(current.getLocLatLng(), passanger.getLocLatLng()) <= 500) {
                        arrayList.get(arrayList.size() - 1).addNewPassanger(passanger.getSearchId());
                    }
                }
            }

        }
        return arrayList;
    }

    public ArrayList<ResultMatchObj> getDriverMatchList(Iterable<RideSearch> rideSearch ) {

        ArrayList<ResultMatchObj> arrayList = new ArrayList<ResultMatchObj>();
        for (RideSearch current : rideSearch) {
        }
            }


    public void removeMatchList(ResultMatchObj resultMatchObj){};





}


