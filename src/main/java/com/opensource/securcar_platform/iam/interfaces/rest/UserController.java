package com.opensource.securcar_platform.iam.interfaces.rest;

import com.opensource.securcar_platform.iam.application.internal.commandservices.UserCommandServiceImpl;
import com.opensource.securcar_platform.iam.application.internal.queryservices.UserQueryServiceImpl;
import com.opensource.securcar_platform.iam.domain.model.commands.SignInCommand;
import com.opensource.securcar_platform.iam.domain.model.commands.SignUpCommand;
import com.opensource.securcar_platform.iam.domain.model.queries.GetAllUsersQuery;
import com.opensource.securcar_platform.iam.domain.model.queries.GetUserByIdQuery;
import com.opensource.securcar_platform.iam.domain.model.queries.GetUserByUsernameQuery;
import com.opensource.securcar_platform.iam.domain.model.aggregates.User;
import com.opensource.securcar_platform.shared.interfaces.rest.resources.MessageResource;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserCommandServiceImpl userCommandService;
    private final UserQueryServiceImpl userQueryService;

    public UserController(UserCommandServiceImpl userCommandService, UserQueryServiceImpl userQueryService) {
        this.userCommandService = userCommandService;
        this.userQueryService = userQueryService;
    }

    @PostMapping("/signup")
    public ResponseEntity<MessageResource> signUp(@RequestBody SignUpCommand command) {
        userCommandService.handle(command);
        return new ResponseEntity<>(new MessageResource("User created successfully"), HttpStatus.CREATED);
    }

    @PostMapping("/signin")
    public ResponseEntity<ImmutablePair<User, String>> signIn(@RequestBody SignInCommand command) {
        var result = userCommandService.handle(command);
        return result.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        var users = userQueryService.handle(new GetAllUsersQuery());
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable Long userId) {
        var user = userQueryService.handle(new GetUserByIdQuery(userId));
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<User> getUserByUsername(@PathVariable String username) {
        var user = userQueryService.handle(new GetUserByUsernameQuery(username));
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}

