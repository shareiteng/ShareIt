package com.transcan.backendtranscan.payload;

import javax.validation.constraints.NotNull;

public class SearchRequest {
    @NotNull
    private long searchId;
    @NotNull
    private String location;
    @NotNull
    private String desination;
    @NotNull
    private String time;
    @NotNull
    private long userId;
}



