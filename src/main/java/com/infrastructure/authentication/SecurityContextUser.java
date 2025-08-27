package com.infrastructure.authentication;

import com.application.authentication.CurrentUser;
import com.application.authentication.CurrentUserProvider;
import com.infrastructure.security.userdetails.UserInfoDetails;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class SecurityContextUser implements CurrentUserProvider {
    @Override
    public CurrentUser getAuthData() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserInfoDetails user = (UserInfoDetails) auth.getPrincipal();
        return new CurrentUser(user.getId(), user.getUsername());
    }
}
