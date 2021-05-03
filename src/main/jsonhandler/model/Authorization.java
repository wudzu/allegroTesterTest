package main.jsonhandler.model;

public class Authorization {
    private String access_token;
    private String token_type;
    private int expires_in;
    private String scope;
    private boolean allegro_api;
    private String jti;

    public Authorization(String access_token, String token_type, int expires_in, String scope, boolean allegro_api, String jti) {
        this.access_token = access_token;
        this.token_type = token_type;
        this.expires_in = expires_in;
        this.scope = scope;
        this.allegro_api = allegro_api;
        this.jti = jti;
    }

    public Authorization() {
    }


    public String getToken_type() {
        return token_type;
    }

    public void setToken_type(String token_type) {
        this.token_type = token_type;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public int getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(int expires_in) {
        this.expires_in = expires_in;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public boolean isAllegro_api() {
        return allegro_api;
    }

    public void setAllegro_api(boolean allegro_api) {
        this.allegro_api = allegro_api;
    }

    public String getJti() {
        return jti;
    }

    public void setJti(String jti) {
        this.jti = jti;
    }
}
