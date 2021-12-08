package co.com.appgate.prueba.suma;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.text.ParseException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import co.com.appgate.prueba.dto.OperationDTO;
import co.com.appgate.prueba.dto.ResponseObject;
import co.com.appgate.prueba.dto.UserDTO;
import co.com.appgate.prueba.jwt.JWTToken;
import co.com.appgate.prueba.servicelogin.impl.LoginUserImpl;
import co.com.appgate.prueba.serviceoperation.impl.OperationCalculatorImpl;
import co.com.appgate.prueba.util.Constants;

@SpringBootTest
class PruebaTecnicaInicialApplicationTests {

	private LoginUserImpl userLogin;

	private JWTToken token;

	private OperationCalculatorImpl calculator;

	private UserDTO user;

	@BeforeEach
	public void init() {
		userLogin = mock(LoginUserImpl.class);
		token = mock(JWTToken.class);
		calculator = mock(OperationCalculatorImpl.class);
		user = new UserDTO();
		user.setUser("admin");
		user.setPassword("123456789");
	}
	


	@Test
	void suma() {
		OperationDTO operation = new OperationDTO();
		operation.setNumber1(BigDecimal.TEN);
		operation.setNumber2(BigDecimal.TEN);
		operation.setOperation("SUM");
		when(userLogin.isUserValid(user)).thenReturn(true);
		when(calculator.operate(operation)).thenCallRealMethod();
		ResponseObject responseObj = calculator.operate(operation);	
		assertEquals(responseObj.getResponse(),new BigDecimal("20"));
	}
	
	@Test
	void resta() {
		OperationDTO operation = new OperationDTO();
		operation.setNumber1(BigDecimal.TEN);
		operation.setNumber2(BigDecimal.TEN);
		operation.setOperation("SUBSTRACCION");
		when(userLogin.isUserValid(user)).thenReturn(true);
		when(calculator.operate(operation)).thenCallRealMethod();
		ResponseObject responseObj = calculator.operate(operation);	
		assertEquals(BigDecimal.ZERO, responseObj.getResponse());
	}
	
	@Test
	void producto() {
		OperationDTO operation = new OperationDTO();
		operation.setNumber1(new BigDecimal("3"));
		operation.setNumber2(new BigDecimal("2"));
		operation.setOperation("MULTIPLICACTION");
		when(userLogin.isUserValid(user)).thenReturn(true);
		when(calculator.operate(operation)).thenCallRealMethod();
		ResponseObject responseObj = calculator.operate(operation);	
		assertEquals(responseObj.getResponse(),new BigDecimal("6"));
	}
	
	@Test
	void division() {
		OperationDTO operation = new OperationDTO();
		operation.setNumber1(new BigDecimal("2"));
		operation.setNumber2(new BigDecimal("2"));
		operation.setOperation("DIVISION");
		when(userLogin.isUserValid(user)).thenReturn(true);
		when(calculator.operate(operation)).thenCallRealMethod();
		ResponseObject responseObj = calculator.operate(operation);	
		assertEquals(BigDecimal.ONE, responseObj.getResponse());
	}
	
	@Test
	void divisionPorCero() {
		OperationDTO operation = new OperationDTO();
		operation.setNumber1(new BigDecimal("2"));
		operation.setNumber2(BigDecimal.ZERO);
		operation.setOperation("DIVISION");
		when(userLogin.isUserValid(user)).thenReturn(true);
		when(calculator.operate(operation)).thenCallRealMethod();
		ResponseObject responseObj = calculator.operate(operation);	
		assertEquals("Divide by zero", responseObj.getOperation());
	}
	
	@Test
	void potencia() {
		OperationDTO operation = new OperationDTO();
		operation.setNumber1(new BigDecimal("3"));
		operation.setNumber2(new BigDecimal("2"));
		operation.setOperation("POW");
		when(userLogin.isUserValid(user)).thenReturn(true);
		when(calculator.operate(operation)).thenCallRealMethod();
		ResponseObject responseObj = calculator.operate(operation);	
		assertEquals(responseObj.getResponse(),new BigDecimal("9"));
	}
	
	@Test
	void generaToken() throws ParseException {
		when(token.getJWTToken(user.getUser())).thenCallRealMethod();
		String tokenObtenido = token.getJWTToken(user.getUser());
		assertTrue(tokenObtenido.length() > 0);
		assertTrue(tokenObtenido.contains(Constants.JWTConstants.PREFIX));
		assertTrue(tokenObtenido.length() > Constants.JWTConstants.PREFIX.length());
	}
	
	

}
