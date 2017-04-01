package lzy.module.security.jwt;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

    private final Log logger = LogFactory.getLog(this.getClass());

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Value("${jwt.tokenHeader}")
    private String tokenHeader;
//    private String tokenHeader = "Authorization";

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
        String authToken = request.getHeader(tokenHeader);
        String username = jwtTokenUtil.getUsernameFromToken(authToken);
//        if (null!=authTokenHeader) {
//            boolean startsWith = authTokenHeader.startsWith("Bearer ");
//            if (startsWith) {
//                String authToken = authTokenHeader.substring(7);
//                if (!authToken.isEmpty()) {
//                    username = jwtTokenUtil.getUsernameFromToken(authToken);
//                }
//
//            }
//
//        }


        logger.info("checking authentication for user " + username);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (username != null && authentication == null) {

            /**
             *  此时可以认为是合法用户，但不一定是有权限的用户,简单的处理方式就是重新获取用户信息
             * [2017-03-20 add by longzhiyou]
             */
            // It is not compelling necessary to load the use details from the database.
            // You could also store the information in the token and read it from it. It's up to you ;)
            UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                    userDetails, null, userDetails.getAuthorities());
//                authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);

            // For simple validation it is completely sufficient to just check the token integrity.
            // You don't have to call
            // the database compellingly. Again it's up to you ;)

            /**
             *
             * 事实上如果我们足够相信token中的数据，也就是我们足够相信签名token的secret的机制足够好，这种情况下，
             *  我们可以不用再查询数据库，而直接采用token中的数据。本例中，我们还是通过Spring Security的
             * @UserDetailsService 进行了数据查询，但简单验证的话，你可以采用直接验证token是否合法来避免昂贵的数据查询。
             * [2017-03-20 add by longzhiyou]
             */

//            if (jwtTokenUtil.validateToken(authToken, userDetails)) {
//                UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
//                        userDetails, null, userDetails.getAuthorities());
////                authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//                logger.info("authenticated user " + username + ", setting security context");
////                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
//            }
        }


        chain.doFilter(request, response);

    }
}