package com.opensource.securcar_platform.iam.infrastructure.hashing.bcrypt;

import com.opensource.securcar_platform.iam.application.internal.outboundservices.hashing.HashingService;
import org.springframework.security.crypto.password.PasswordEncoder;

public interface BCryptHashingService extends HashingService, PasswordEncoder {

}

