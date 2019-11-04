package com.transcan.backendtranscan.domain;

import com.google.maps.errors.ApiException;
import com.transcan.backendtranscan.services.MapService;
import com.transcan.backendtranscan.services.MatchService;
import com.transcan.backendtranscan.services.RideSuggestionService;
import com.transcan.backendtranscan.services.SearchRideService;


import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;


public class ResultMatchObj {

    static final int TEXI = 0;
    static final int PRIVATE_CAR = 1;
    static final int TEXI6SEAT = 2;
    static final int MINIBUS = 3;
    static final int BUS = 4;

    private long mId;
    private String pName;
    private ArrayList<Long> mPassngersIdList;
    private int mVehicle;
    private String avargeLatDes;
    private String AvargeLatloc;
    private String mHouer;
    private String mDate;
    private ArrayList<String> mPassengerName;
    private String mLocation;
    private String mDestination;
    private String mMatchPointLocation;
    private String mMatchPointDestination;
    private String mVehicleTypeName;

    public String getmLocation() {
        return mLocation;
    }

    public void setmLocation(String mLocation) {
        this.mLocation = mLocation;
    }

    public String getmDestination() {
        return mDestination;
    }

    public void setmDestination(String mDestination) {
        this.mDestination = mDestination;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getHour() {
        return mHouer;
    }

    public void setHouer(String houer) {
        this.mHouer = houer;
    }

    public String getDate() {
        return mDate;
    }

    public void setDate(String mDate) {
        this.mDate = mDate;
    }



    public void setPassengerName(ArrayList<String> mPassengerName) {
        this.mPassengerName = mPassengerName;
    }

    public void setLocation(String location) {
        mLocation  =location;
    }

    public void setDestination(String mDestination) {
        this.mDestination = mDestination;
    }

    public void setmMatchPointLocation(String mMatchPointLocation) {
        this.mMatchPointLocation = mMatchPointLocation;
    }

    public void setmMatchPointDestination(String mMatchPointDestination) {
        this.mMatchPointDestination = mMatchPointDestination;
    }

    public ArrayList<Long> getPassngersIdList() {
        return mPassngersIdList;
    }

    public void setmPassngersIdList(ArrayList<Long> mPassngersIdList) {
        this.mPassngersIdList = mPassngersIdList;
    }

    public int getmVehicle() {
        return mVehicle;
    }

    public void setmVehicle(int mVehicle) {
        this.mVehicle = mVehicle;
    }

    public long getmId() {
        return mId;
    }

    public void setmId(long mId) {
        this.mId = mId;
    }

    public String getAvargeLatDes() {
        return avargeLatDes;
    }

    public void setAvargeLatDes(String avargeLatDes) {
        this.avargeLatDes = avargeLatDes;
    }

    public String getAvargeLatloc() {
        return AvargeLatloc;
    }

    public void setAvargeLatloc(String avargeLatloc) {
        AvargeLatloc = avargeLatloc;
    }

    public ResultMatchObj(long id) {
        mId = id;
        mPassngersIdList = new ArrayList();
        mVehicle = TEXI;
        mLocation="SSS";
    }
    public ResultMatchObj(long id,String pName) {
        this.pName = pName;
        this.mId = id;
        this.mPassngersIdList = new ArrayList();
        this.mVehicle = TEXI;
        this.mLocation="SSS";
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
    public ArrayList<String> getmPassengerName() {
        return mPassengerName;
    }

    public void setmPassengerName(ArrayList<String> mPassengerName) {
        this.mPassengerName = mPassengerName;
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

        ArrayList<ResultMatchObj> arrayList = new ArrayList<ResultMatchObj>();
        for (RideSearch current : rideSearch) {
            arrayList.add(new ResultMatchObj(current.getSearchId(), current.getUserInfo().getFirstname()+ " " +current.getUserInfo().getLastname()));
            arrayList.get(arrayList.size() - 1).mPassengerName = new ArrayList<String>();
            for (RideSearch passanger : rideSearch) {
                if (current.getSearchId() != passanger.getSearchId()) {
                    if (MapService.getDistanceGeoLocation(current.getDesLatLng(), passanger.getDesLatLng()) <= 500 &&
                            MapService.getDistanceGeoLocation(current.getLocLatLng(), passanger.getLocLatLng()) <= 500) {
                        arrayList.get(arrayList.size() - 1).addNewPassanger(passanger.getSearchId());
                        String temp = passanger.getUserInfo().getFirstname()+ " " +passanger.getUserInfo().getLastname();
                        arrayList.get(arrayList.size() - 1).mPassengerName.add(temp);
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



    public ArrayList<ResultMatchObj> getMatchObjList(ArrayList<ResultMatchObj > resultMatchObjArrayList, SearchRideService searchRideService) throws InterruptedException, ApiException, IOException {
        ArrayList<ResultMatchObj> bestRideList= new ArrayList<>();
        ArrayList<ResultMatchObj> resList=resultMatchObjArrayList;
        ArrayList<RideSearch> tempDB= new ArrayList<>();

        while (resList.size() > 0) {
            int theBestRide = 0;
            int indexBestRide = 0;
            for (int i = 0; i < resList.size()-1; i++) {
                if (resList.get(i).getPassengerNum() > theBestRide){
                    theBestRide = resList.get(i).getPassengerNum();
                    indexBestRide = i;
                }
            }
            bestRideList.add(resList.get(indexBestRide));

            ArrayList<Long> temp = resList.get(indexBestRide).getPassengerList();
            resList.get(indexBestRide).setAvargeLatloc(MapService.getMiddlePoint(temp,true,searchRideService));
            resList.get(indexBestRide).setAvargeLatDes(MapService.getMiddlePoint(temp,false,searchRideService));
            resList.get(indexBestRide).setLocation(MapService.convertAddressToLatLng(resList.get(indexBestRide).getAvargeLatloc()));
            resList.get(indexBestRide).setDestination(MapService.convertAddressToLatLng(resList.get(indexBestRide).getAvargeLatDes()));
            for (Long id : resList.get(indexBestRide).getPassengerList()) {
                   tempDB.add(searchRideService.findById(id).orElse(null));
                    searchRideService.deleteById(id);
            }
            tempDB.add(searchRideService.findById(resList.get(indexBestRide).mId).orElse(null));
            searchRideService.deleteById(resList.get(indexBestRide).mId);

            resList.remove(indexBestRide);
            resList = this.getMatchList(searchRideService.findAll());
        }

            searchRideService.saveAll(tempDB);

        return  bestRideList;
    }


    public  ArrayList<ResultMatchObj> findTheBestRideByUserId  (ArrayList<RideSearch> searchIdList, ArrayList<ResultMatchObj> rideList, long userId) throws InterruptedException, ApiException, IOException {
                    ArrayList<ResultMatchObj> res= new ArrayList<>();
                    for (ResultMatchObj ride : rideList) {
                        for (RideSearch rideSearch :searchIdList) {
                            if (ride.getPassengerList().contains(rideSearch.getSearchId()) || ride.mId == userId) {
                                ride.setmMatchPointDestination(MapService.convertAddressToLatLng(ride.getAvargeLatDes()));
                                ride.setmMatchPointLocation(MapService.convertAddressToLatLng(ride.getAvargeLatloc()));
                                ride.setLocation(rideSearch.getLocation());
                                ride.setDestination(rideSearch.getDestination());
                                ride.setHouer(rideSearch.getHours());
                                ride.setDate(rideSearch.getDate());
                                res.add(ride) ;
                            }
            }
        }
            return  res;
        }





    }



