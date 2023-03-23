package nz.co.goodspeed.chargenetbe.auth;

import com.nimbusds.jwt.JWT;
import com.nimbusds.jwt.JWTParser;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.logging.LogFactory;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;
import org.springframework.util.CollectionUtils;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Slf4j
public class TokenParser {

    public static Jwt parseToken(String token) {
        try {
            String toParse = token.substring(7);
            JWT parsed = JWTParser.parse(toParse);
            Map<String, Object> headers = parsed.getHeader().toJSONObject();
            Map<String, Object> claims = parsed.getJWTClaimsSet().getClaims();
            return Jwt.withTokenValue(toParse)
                    .headers(h -> h.putAll(headers))
                    .claims(c -> c.putAll(claims))
                    .build();
        }
        catch(ParseException err) {
            log.error("could not parse token");
            log.error(err.getMessage());
        }
        return null;
    }
}
