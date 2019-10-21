package com.transcan.backendtranscan.payload;


public class JwtAuthenticationResponse {
    private String accessToken;
    private String tokenType = "Bearer";
    private Long id;

    public JwtAuthenticationResponse(String accessToken,Long id) {
        this.accessToken = accessToken;
        this.id = id;
    }
    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
