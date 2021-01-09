package com.fish.security.pojo;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
@Data
public class Member implements UserDetails {

    private String username;
    private String password;
    private boolean isAccountNonExpired;
    private boolean isAccountNonLocked;
    private boolean isCredentialsNonExpired;
    private boolean isEnabled;
    private Collection<? extends GrantedAuthority> collection;

    public Member(Builder b){
        this.username = b.username;
        this.password = b.password;
        this.isAccountNonExpired = b.isAccountNonExpired;
        this.isAccountNonLocked = b.isAccountNonLocked;
        this.isCredentialsNonExpired = b.isCredentialsNonExpired;
        this.isEnabled = b.isEnabled;
        this.collection = b.collection;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return collection;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return isAccountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return isAccountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return isCredentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return isEnabled;
    }

    public static class Builder{
        private String username;
        private String password;
        private boolean isAccountNonExpired =  true;
        private boolean isAccountNonLocked =  true;
        private boolean isCredentialsNonExpired =  true;
        private boolean isEnabled =  true;
        private Collection<? extends GrantedAuthority> collection;

        public Builder username(String username){
            this.username = username;
            return this;
        }
        public Builder password(String password){
            this.password = password;
            return this;
        }
        public Builder isAccountNonExpired(Boolean isAccountNonExpired){
            this.isAccountNonExpired = isAccountNonExpired;
            return this;
        }
        public Builder isAccountNonLocked(Boolean isAccountNonLocked){
            this.isAccountNonLocked = isAccountNonLocked;
            return this;
        }
        public Builder isCredentialsNonExpired(Boolean isCredentialsNonExpired){
            this.isCredentialsNonExpired = isCredentialsNonExpired;
            return this;
        }
        public Builder isEnabled(Boolean isEnabled){
            this.isEnabled = isEnabled;
            return this;
        }
        public Builder collection(Collection<? extends GrantedAuthority> collection){
            this.collection = collection;
            return this;
        }




        public Member build(){
            return new Member(this);
        }

    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAccountNonExpired(boolean accountNonExpired) {
        isAccountNonExpired = accountNonExpired;
    }

    public void setAccountNonLocked(boolean accountNonLocked) {
        isAccountNonLocked = accountNonLocked;
    }

    public void setCredentialsNonExpired(boolean credentialsNonExpired) {
        isCredentialsNonExpired = credentialsNonExpired;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }

    public Collection<? extends GrantedAuthority> getCollection() {
        return collection;
    }

    public void setCollection(Collection<? extends GrantedAuthority> collection) {
        this.collection = collection;
    }
}
