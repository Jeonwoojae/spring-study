# 스프링 시큐리티
![](필터 손그림.jpg)
- 시큐리티 구조의 처리 과정은 다음과 같다.

1. 사용자가 로그인 정보와 함께 인증 요청을 한다(http request)
2. authenticationFilter가 요청을 가로채고, 가로챈 정보를 통해 UsernamePasswordAuthenticationToken의 인증용 객체를 생성한다.
3. AuthenticationManager의 구현체인 ProviderManager에게 생성한 UsernamePasswordToken 객체를 전달한다.
4. AuthenticationManager는 등록된 AuthenticationProvider들을 조회하여 인증을 요구한다.
5. 실제 DB에서 사용자 인증정보를 가져오는 UserDetailsService에 사용자 정보를 넘겨준다.
6. 넘겨받은 사용자 정보를 통해 DB에서 찾은 사용자 정보인 UserDetails 객체를 만든다.
7. AuthenticationProvider들은 UserDetails를 넘겨받고 사용자 정보를 비교한다.
8. 인증이 완료되면 권한 등의 사용자 정보를 담은 Authentication 객체를 반환한다.
9. 다시 최초의 AuthenticationFilter에 Authentication 객체가 반환된다.
10. Authentication 객체를 SecurityContext에 저장한다.
- 최종적으로 SecurityContextHolder는 세션 영역에 있는 SecurityContext에 Authentication 객체를 저장한다.
- 사용자 정보를 저장한다는 것은 Spring Security가 전통적인 세션-쿠키 기반의 인증 방식을 사용한다는 것을 의미한다.

### Authentication
- Authentication는 현재 접근하는 주체의 정보와 권한을 담는 인터페이스이다. Authentication 객체는 Security Context에 저장되며,
SecurityContextHolder를 통해 SecurityContext에 접근하고, SecurityContext를 통해 Authentication에 접근할 수 있다.
```java
public interface Authentication extends Principal, Serializable {
    // 현재 사용자의 권한 목록을 가져옴
    Collection<? extends GrantedAuthority> getAuthorities();
    
    // credentials(주로 비밀번호)을 가져옴
    Object getCredentials();
    
    Object getDetails();
    
    // Principal 객체를 가져옴.
    Object getPrincipal();
    
    // 인증 여부를 가져옴
    boolean isAuthenticated();
    
    // 인증 여부를 설정함
    void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException;
}
```

### UsernamePasswordAuthenticationToken
- UsernamePasswordAuthenticationToken은 Authentication을 implements한
AbstractAuthenticationToken의 하위 클래스로, User의 ID가 Principal의 역할을 하고.
Password가 Credential의 역할을 한다. UsernamePasswordAuthenticationToken의 첫 번째
생성자는 인증 전의 객체를 생성하고, 두 번째 생성자는 인증이 완료된 객체를 생성한다.
```java
public class UsernamePasswordAuthenticationToken extends AbstractAuthenticationToken {
    // 주로 사용자의 ID에 해당함
    private final Object principal;
    // 주로 사용자의 PW에 해당함
    private Object credentials;
    
    // 인증 완료 전의 객체 생성
    public UsernamePasswordAuthenticationToken(Object principal, Object credentials) {
		super(null);
		this.principal = principal;
		this.credentials = credentials;
		setAuthenticated(false);
	}
    
    // 인증 완료 후의 객체 생성
    public UsernamePasswordAuthenticationToken(Object principal, Object credentials,
			Collection<? extends GrantedAuthority> authorities) {
		super(authorities);
		this.principal = principal;
		this.credentials = credentials;
		super.setAuthenticated(true); // must use super, as we override
	}
}


public abstract class AbstractAuthenticationToken implements Authentication, CredentialsContainer {
}
```

### AuthenticationProvider
- AuthenticationProvider에서는 실제 인증에 대한 부분을 처리하는데, 인증 전의 Authentication
객체를 받아서 인증이 완료된 객체를 반환하는 역할을 한다. 아래와 같은
AuthenticationProvider 인터페이스를 구현해서 Custom한 AuthenticationProvider을 작성해서 AuthenticationManager에
등록하면 된다.
```java
public interface AuthenticationProvider {

	// 인증 전의 Authenticaion 객체를 받아서 인증된 Authentication 객체를 반환
    Authentication authenticate(Authentication var1) throws AuthenticationException;

    boolean supports(Class<?> var1);
    
}
```

### Authentication Manager
- 인증에 대한 부분은 SpringSecurity의 AuthenticationManager를 통해서 처리하게 되는데,
실질적으로는 AuthenticationManager에 등록된 AuthenticationProvider에 의해 처리된다.
인증이 성공하면 2번째 생성자를 이용해 인증이 성공한(isAuthenticated=true) 객체를 생성하여
Security Context에 저장한다. 그리고 인증 상태를 유지하기 위해 세션에 보관하며, 인증이 실패한 경우는
AuthenticationException를 발생시킨다.
```java
public interface AuthenticationManager {
	Authentication authenticate(Authentication authentication) 
		throws AuthenticationException;
}
```
- AuthenticationManager를 implements한 ProviderManager는 실제 인증 과정에 대한 로직을 가지고
있는 AuthenticationProvider를 List로 가지고 있으며, ProviderManager는 for문을 통해 모든 provider를
조회하면서 authenticate 처리를 한다.
```java
public class ProviderManager implements AuthenticationManager, MessageSourceAware,
InitializingBean {
    public List<AuthenticationProvider> getProviders() {
		return providers;
	}
    public Authentication authenticate(Authentication authentication)
			throws AuthenticationException {
		Class<? extends Authentication> toTest = authentication.getClass();
		AuthenticationException lastException = null;
		Authentication result = null;
		boolean debug = logger.isDebugEnabled();
        //for문으로 모든 provider를 순회하여 처리하고 result가 나올 때까지 반복한다.
		for (AuthenticationProvider provider : getProviders()) {
            ....
			try {
				result = provider.authenticate(authentication);

				if (result != null) {
					copyDetails(authentication, result);
					break;
				}
			}
			catch (AccountStatusException e) {
				prepareException(e, authentication);
				// SEC-546: Avoid polling additional providers if auth failure is due to
				// invalid account status
				throw e;
			}
            ....
		}
		throw lastException;
	}
}
```
- 위에서 설명한 ProviderManager에 우리가 직접 구현한 CustomAuthenticationProvider를 등록하는 방법은
WebSecurityConfigurerAdapter를 상속해 만든 SecurityConfig에서 할 수 있다. WebSecurityConfigurer의
상위 클래스에서는 AuthenticationManager를 가지고 있기 때문에 우리가 직접 만든 CustomAuthenticationProvider
를 등록할 수 있다.
```java
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
  
    @Bean
    public AuthenticationManager getAuthenticationManager() throws Exception {
        return super.authenticationManagerBean();
    }
      
    @Bean
    public CustomAuthenticationProvider customAuthenticationProvider() throws Exception {
        return new CustomAuthenticationProvider();
    }
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(customAuthenticationProvider());
    }
}
```

### UserDetails
- 인증에 성공하여 생성된 UserDetails 객체는 Authentication 객체를 구현한 UsernamePasswordAuthenticationToken
을 생성하기 위해 사용된다. UserDetails 인터페이스를 살펴보면 아래와 같이 정보를 반환하는
메소드를 가지고 있다. UserDetails 인터페이스의 경우 직접 개발한 UserVO 모델에
UserDetails를 implements하여 이를 처리하거나 UserDetailsVO에 UserDetails를
implements하여 처리할 수 있다.
```java
public interface UserDetails extends Serializable {

    Collection<? extends GrantedAuthority> getAuthorities();

    String getPassword();

    String getUsername();

    boolean isAccountNonExpired();

    boolean isAccountNonLocked();

    boolean isCredentialsNonExpired();

    boolean isEnabled();
    
}
```

### UserDetailsService
- UserDetailsService 인터페이스는 UserDetails 객체를 반환하는 단 하나의 메소드를 가지고 있는데,
일반적으로 이를 구현한 클래스의 내부에 UserRepository를 주입받아 DB와 연결하여 처리한다. UserDetails
인터페이스는 아래와 같다.
```java
public interface UserDetailsService {

    UserDetails loadUserByUsername(String var1) throws UsernameNotFoundException;

}
```

### Password Encoding
- AuthenticationManagerBuilder.userDetailsService().passwordEncoder()를 통해 패스워드
암호화에 사용될 PasswordEncoder 구현체를 지정할 수 있다.
```java
@Override
protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	// TODO Auto-generated method stub
	auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
}

@Bean
public PasswordEncoder passwordEncoder(){
	return new BCryptPasswordEncoder();
}
```

### GrantedAuthority
- GrantAuthority는 현재 사용자(Principal)가 가지고 있는 권한을 의미한다. ROLE_ADMIN이나
ROLE_USER와 같이 ROLE_*의 형태로 사용하며, 보통 "roles"이라고 한다. GrantedAuthority
객체는 UserDetailsService에 의해 불러올 수 있고, 특정 자원에 대한 권한이 있는지를 검사하여
접근 허용 여부를 결정한다.


[참고](https://mangkyu.tistory.com/76)
