package com.metasoft.restyle.platform.iam.application.internal.commandservices;

import com.metasoft.restyle.platform.iam.application.internal.outboundservices.hashing.HashingService;
import com.metasoft.restyle.platform.iam.application.internal.outboundservices.tokens.TokenService;
import com.metasoft.restyle.platform.iam.domain.model.aggregates.User;
import com.metasoft.restyle.platform.iam.domain.model.commands.SignInCommand;
import com.metasoft.restyle.platform.iam.domain.model.commands.SignUpCommand;
import com.metasoft.restyle.platform.iam.domain.services.UserCommandService;
import com.metasoft.restyle.platform.iam.infrastructure.persistence.jpa.repositories.RoleRepository;
import com.metasoft.restyle.platform.iam.infrastructure.persistence.jpa.repositories.UserRepository;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserCommandServiceImpl{

}
