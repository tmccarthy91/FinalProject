package catvet.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import catvet.entity.Cat;
import catvet.entity.Owner;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;

@Validated
@RequestMapping("/owners")
@OpenAPIDefinition(info = @Info(title = "Cat Vet Service"), servers = {
		@Server(url = "http://localhost:8080", description = "Local server.")})
public interface OwnerController {

	//GET owners (read)
			@Operation(
				summary = "Returns a list of Owners",
				description = "Returns a list of Owners",
				responses = {
					@ApiResponse(
						responseCode = "200", 
						description = "A list of Owners is returned", 
						content = @Content(
								mediaType = "application/json", 
								schema = @Schema(implementation = Owner.class))),
					@ApiResponse(
							responseCode = "400", 
							description = "The request parameters are invalid", 
							content = @Content(mediaType = "application/json")),
					@ApiResponse(
							responseCode = "404", 
							description = "No owners were found with the input criteria", 
							content = @Content(mediaType = "application/json")),
					@ApiResponse(
							responseCode = "500", 
							description = "An unplanned error occurred.", 
							content = @Content(mediaType = "application/json"))
				},
				parameters = {
					@Parameter(
							name = "ownerId", 
							allowEmptyValue = false, 
							required = false, 
							description = "The owner's ID (ex. FULL_NAME)")
				}
			)
			
			@GetMapping
			@ResponseStatus(code = HttpStatus.OK)
			List<Owner> fetchOwner(
					@RequestParam(required = false) 
					String ownerId				
					);
			
	//POST owners (add)
			
			@Operation(
				summary = "Adds a new owner",
				description = "Adds a new owner",
				responses = {
					@ApiResponse(
						responseCode = "200", 
						description = "A new Owner is added", 
						content = @Content(
								mediaType = "application/json", 
								schema = @Schema(implementation = Owner.class))),
					@ApiResponse(
							responseCode = "400", 
							description = "The request parameters are invalid", 
							content = @Content(mediaType = "application/json")),
					@ApiResponse(
							responseCode = "404", 
							description = "No owners were found with the input criteria", 
							content = @Content(mediaType = "application/json")),
					@ApiResponse(
							responseCode = "500", 
							description = "An unplanned error occurred.", 
							content = @Content(mediaType = "application/json"))
				},
				parameters = {
					@Parameter(
							name = "ownerId", 
							allowEmptyValue = false, 
							required = false, 
							description = "The owner's ID (ex. FULL_NAME)")
				}
			)
			
			@PostMapping
			@ResponseStatus(code = HttpStatus.OK)
			Optional<Owner> addOwner(
					@RequestParam(required = false) 
					String ownerId,
					@RequestParam(required = false)
					String firstName,
					@RequestParam(required = false)
					String lastName			
					);
			
	//PUT owners (update)
			
			@Operation(
				summary = "Updates an Owner",
				description = "Updates an Owner",
				responses = {
					@ApiResponse(
						responseCode = "200", 
						description = "An owner is updated", 
						content = @Content(
								mediaType = "application/json", 
								schema = @Schema(implementation = Owner.class))),
					@ApiResponse(
							responseCode = "400", 
							description = "The request parameters are invalid", 
							content = @Content(mediaType = "application/json")),
					@ApiResponse(
							responseCode = "404", 
							description = "No owners were found with the input criteria", 
							content = @Content(mediaType = "application/json")),
					@ApiResponse(
							responseCode = "500", 
							description = "An unplanned error occurred.", 
							content = @Content(mediaType = "application/json"))
				},
				parameters = {
					@Parameter(
							name = "ownerId", 
							allowEmptyValue = false, 
							required = false, 
							description = "The owner's ID (ex. FULL_NAME)"),
					@Parameter(
							name = "firstName", 
							allowEmptyValue = false, 
							required = false, 
							description = "The owner's first name (ex. George)"),
					@Parameter(
							name = "lastName", 
							allowEmptyValue = false, 
							required = false, 
							description = "The owner's last name (ex. Bailey)")
				}
			)
			
			@PutMapping
			@ResponseStatus(code = HttpStatus.OK)
			Optional<Owner> updateOwner(
					@RequestParam(required = false) 
					String ownerId,
					@RequestParam(required = false)
					String firstName,
					@RequestParam(required = false)
					String lastName
					);
			
			//DELETE owner
			
			@Operation(
				summary = "Deletes an owner",
				description = "Deletes an owner",
				responses = {
					@ApiResponse(
						responseCode = "200", 
						description = "An owner is deleted", 
						content = @Content(
								mediaType = "application/json", 
								schema = @Schema(implementation = Owner.class))),
					@ApiResponse(
							responseCode = "400", 
							description = "The request parameters are invalid", 
							content = @Content(mediaType = "application/json")),
					@ApiResponse(
							responseCode = "404", 
							description = "No owners were found with the input criteria", 
							content = @Content(mediaType = "application/json")),
					@ApiResponse(
							responseCode = "500", 
							description = "An unplanned error occurred.", 
							content = @Content(mediaType = "application/json"))
				},
				parameters = {
					@Parameter(
							name = "ownerId", 
							allowEmptyValue = false, 
							required = false, 
							description = "The owner's ID (ex. FULL_NAME)")
				}
			)
			
			@DeleteMapping
			@ResponseStatus(code = HttpStatus.OK)
			Optional<Owner> deleteOwner(
					@RequestParam(required = false) 
					String ownerId				
					);
			
}
