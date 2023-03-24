package nz.co.goodspeed.chargenetbe.auth;

import org.springframework.core.convert.converter.Converter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

public class CognitoRolesClaimConverter implements Converter<Jwt, AbstractAuthenticationToken> {

    private final JwtGrantedAuthoritiesConverter authConverter;

    public CognitoRolesClaimConverter(JwtGrantedAuthoritiesConverter authConverter) {
        this.authConverter = authConverter;
    }

    @Override
    public AbstractAuthenticationToken convert(Jwt source) {
        List<GrantedAuthority> convertedItems = new ArrayList(authConverter.convert(source));
        List<String> roles = (List<String>) source.getClaims().get("cognito:groups");
        if (!CollectionUtils.isEmpty(roles)) {
            roles.forEach(
                    i -> convertedItems.add(new SimpleGrantedAuthority(String.format("ROLE_%s", i)))
            );
        }
        return new JwtAuthenticationToken(source, convertedItems);
    }
}
