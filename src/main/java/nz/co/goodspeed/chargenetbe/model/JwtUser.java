package nz.co.goodspeed.chargenetbe.model;

import nz.co.goodspeed.chargenetbe.auth.TokenParser;
import org.springframework.security.oauth2.jwt.Jwt;

import java.util.Arrays;

public class JwtUser {

    enum CognitoTokenType {
        ID_TOKEN("sub","id"),
        ACCESS_TOKEN("username","access");

        final String userIdField, tokenUse;
        CognitoTokenType(String idField, String tokenUse) {
            this.userIdField = idField;
            this.tokenUse = tokenUse;
        }

        public String getUserIdField() {
            return userIdField;
        }

        public String getTokenUse() {
            return tokenUse;
        }

    }

    private final Jwt jwt;
    private final CognitoTokenType type;
    public JwtUser(Jwt token) {
        this.jwt = token;
        String tokenType = jwt.getClaim("token_use");
        type =
                Arrays.stream(CognitoTokenType.values()).filter(
                i -> i.getTokenUse().equals(tokenType)
        ).findFirst().orElse(null);
    }

    public String getUser() {
        //this is dangerous, could result in a bunch of bad data
        return type == null ?
                "dev"
                :
                jwt.getClaim(type.getUserIdField());
    }
}
