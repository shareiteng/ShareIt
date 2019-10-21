package com.transcan.backendtranscan.domain;

import com.transcan.backendtranscan.services.MapService;
import com.transcan.backendtranscan.services.RideSuggestionService;
import com.transcan.backendtranscan.services.SearchRideService;
import org.springframework.beans.factory.annotation.Autowired;
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
        mId = id;
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

    public int getVehicleType() {
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

    public void setVehicle(int vehicle){
    mVehicle=vehicle;
    }


    public ArrayList<ResultMatchObj> getMatchList(Iterable<RideSearch> rideSearch ) {
        int index=0;
        ArrayList<ResultMatchObj> arrayList = new ArrayList<ResultMatchObj>();
        for (RideSearch current : rideSearch) {
            arrayList.add(new ResultMatchObj(current.getSearchId()));
            for (RideSearch passanger : rideSearch) {
                if (current.getSearchId() != passanger.getSearchId()) {
                    if (MapService.getDistanceGeoLocation(current.getDesLatLng(), passanger.getDesLatLng()) <= 500 &&
                            MapService.getDistanceGeoLocation(current.getLocLatLng(), passanger.getLocLatLng()) <= 500) {
                        arrayList.get(index).addNewPassanger(passanger.getSearchId());
                    }
                }
            }

        }
        return arrayList;
    }


    public ResultMatchObj getDriverMatchList(Iterable<RideSearch> rideSearch, String locLatLang, String desLatLang, int seatNum, long id,SearchRideService searchRideService,RideSuggestionService rideSuggestionService ) {
        int counter = 0;
        ResultMatchObj resultMatchObj = new ResultMatchObj(id);
        resultMatchObj.setVehicle(PRIVATE_CAR);
        for (RideSearch passenger : rideSearch) {
            if (MapService.getDistanceGeoLocation(desLatLang, passenger.getDesLatLng()) <= 500 &&
                    MapService.getDistanceGeoLocation(locLatLang, passenger.getLocLatLng()) <= 500 &&
                    seatNum >= counter) {
                counter++;
                resultMatchObj.addNewPassanger(passenger.getSearchId());
                searchRideService.deleteById(passenger.getSearchId());
            }
        }
        rideSuggestionService.deleteById(id);
        return resultMatchObj;
    }



    public ArrayList<ResultMatchObj> getMatchObjList(ArrayList<ResultMatchObj > resultMatchObjArrayList, SearchRideService searchRideService){
        ArrayList<ResultMatchObj> bestRideList= new ArrayList<>();
        ArrayList<ResultMatchObj> resList=resultMatchObjArrayList;

        while (resList.size() > 0) {
            int theBestRide = 0;
            int indexBestRide = 0;
            for (int i = 0; i < resList.size()-1; i++) {
                if (resList.get(i).getPassengerNum() > theBestRide)
                    theBestRide = resList.get(i).getPassengerNum();
                indexBestRide = i;
            }
            bestRideList.add(resList.get(indexBestRide));

            for (Long id : resList.get(indexBestRide).getPassengerList()) {
                    searchRideService.deleteById(id);

            }
            searchRideService.deleteById(resList.get(indexBestRide).mId);

            resList.remove(indexBestRide);
            resList = this.getMatchList(searchRideService.findAll());
        }
        return  bestRideList;


    }





}


