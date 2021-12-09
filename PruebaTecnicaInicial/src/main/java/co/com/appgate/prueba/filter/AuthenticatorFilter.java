package co.com.appgate.prueba.filter;

import java.io.IOException;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.Provider;

import co.com.appgate.prueba.util.Constants;
import io.jsonwebtoken.Claims;

import io.jsonwebtoken.Jwts;

@Provider
@PreMatching
public class AuthenticatorFilter implements ContainerRequestFilter {

	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		String path = requestContext.getUriInfo().getPath();


		if (path.equalsIgnoreCase(Constants.JWTConstants.LOGIN_PATH)) {
			return;
		}

		String token = requestContext.getHeaderString(Constants.JWTConstants.HEADER_JWT);
		
		if (token == null || token.isEmpty()) {
			throw new WebApplicationException(Status.UNAUTHORIZED);
		}
		
		if (token.contains(Constants.JWTConstants.PREFIX)) {
			token = token.replace(Constants.JWTConstants.PREFIX + " ", "");
		}

		Claims claims = validateToken(token);

		if (claims.isEmpty()) {
			throw new WebApplicationException(Status.FORBIDDEN);
		}

	}

	private Claims validateToken(String token) {
		return Jwts.parser().setSigningKey(Constants.JWTConstants.SECRET_KEY).parseClaimsJws(token).getBody();
	}

}
