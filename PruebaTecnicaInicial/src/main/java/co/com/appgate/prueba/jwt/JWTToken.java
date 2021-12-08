package co.com.appgate.prueba.jwt;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Component;

import co.com.appgate.prueba.util.Constants;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JWTToken {

	public String getJWTToken(String username) throws ParseException {

		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
		Date expirationDate = new Date();
		Calendar c = Calendar.getInstance(); 
		c.setTime(expirationDate); 
		c.add(Calendar.DATE, 1);
		expirationDate = c.getTime();
		expirationDate = dateFormat.parse(dateFormat.format(expirationDate));

		String token = Jwts.builder().setSubject(username).setExpiration(expirationDate)
				.claim(Constants.JWTConstants.GROUPS, new String[] { "user", "admin" })
				.signWith(SignatureAlgorithm.HS512, Constants.JWTConstants.SECRET_KEY).compact();
		return "Bearer " + token;
	}

}
