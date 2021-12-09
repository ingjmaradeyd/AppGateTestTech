package co.com.appgate.prueba.util;

public class Constants {

	public static final class JWTConstants {
		private JWTConstants() {
		}

		public static final String HEADER_JWT = "Authorization";
		public static final String LOGIN_PATH = "init/login";
		public static final String SECRET_KEY = "AppGateSecret";
		public static final String SECRET_ID = "AppGateId";
		public static final String PREFIX = "Bearer";
		public static final String GROUPS = "groups";
	}

	public static final class Errors {
		private Errors() {}
		public static final String ERROR_PATH = "error";
	}
	
	public static final class ServiceCall {
		private ServiceCall() {}
		public static final String PATH = "http://localhost:";
	}

}
