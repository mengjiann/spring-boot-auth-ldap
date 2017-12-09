package com.mj.authldap.repository;

import com.mj.authldap.domain.UserLdap;
import org.springframework.data.ldap.repository.LdapRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserLdapRepository extends LdapRepository<UserLdap>{


    UserLdap findByUsernameAndPassword(String username, String password);

}
