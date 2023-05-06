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

import catvet.entity.Breed;
import catvet.entity.Cat;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;

@Validated
@RequestMapping("/cats")
@OpenAPIDefinition(info = @Info(title = "Cat Vet Service"), servers = {
		@Server(url = "http://localhost:8080", description = "Local server.")})
public interface CatVetController {
	// @formatter:off
	
	//POST cats (add, insert)
	@Operation(
			summary = "Adds a new cat",
			description = "Adds a new cat",
			responses = {
				@ApiResponse(
					responseCode = "200", 
					description = "A new cat is added", 
					content = @Content(
							mediaType = "application/json", 
							schema = @Schema(implementation = Cat.class))),
				@ApiResponse(
						responseCode = "400", 
						description = "The request parameters are invalid", 
						content = @Content(mediaType = "application/json")),
				@ApiResponse(
						responseCode = "404", 
						description = "No Cats were found with the input criteria", 
						content = @Content(mediaType = "application/json")),
				@ApiResponse(
						responseCode = "500", 
						description = "An unplanned error occurred.", 
						content = @Content(mediaType = "application/json"))
			},
			parameters = {
				@Parameter(
						name = "catId", 
						allowEmptyValue = false, 
						required = false, 
						description = "The cat's ID (ex. FULL_NAME)"),
				@Parameter(
						name = "owner_pk", 
						allowEmptyValue = false, 
						required = false, 
						description = "The cat's owner's primary key (ex. 1, 2, etc.)"),
				@Parameter(
						name = "catName", 
						allowEmptyValue = false, 
						required = false, 
						description = "The cat's name (ex. Name)"),
				@Parameter(
						name = "catAge", 
						allowEmptyValue = false, 
						required = false, 
						description = "The cat's age"),
				@Parameter(
						name = "breed", 
						allowEmptyValue = false, 
						required = false, 
						description = "The cat's breed (ex. SIAMESE)"),
				@Parameter(
						name = "color", 
						allowEmptyValue = false, 
						required = false, 
						description = "The cat's fur color (ex. orange)"),
				@Parameter(
						name = "neutered", 
						allowEmptyValue = false, 
						required = false, 
						description = "The cat's neuter status(ex. true or false)"),
				@Parameter(
						name = "personality", 
						allowEmptyValue = false, 
						required = false, 
						description = "The cat's personality (ex. affectionate)"),
				@Parameter(
						name = "notes", 
						allowEmptyValue = false, 
						required = false, 
						description = "Any relevant notes (ex. loves mouse toys)"),
			}
		)
		
		@PostMapping
		@ResponseStatus(code = HttpStatus.OK)
		Optional<Cat> addCats(
				@RequestParam(required = false) 
				String catId,
				@RequestParam(required = false)
				Long owner_pk,
				@RequestParam(required = false)
				String catName,
				@RequestParam(required = false)
				Integer catAge,
				@RequestParam(required = false)
				Breed breed,
				@RequestParam(required = false)
				String color,
				@RequestParam(required = false)
				boolean neutered,
				@RequestParam(required = false)
				String personality,
				@RequestParam(required = false)
				String notes
				);
	
	//GET cats (read)
		@Operation(
			summary = "Returns a list of Cats",
			description = "Returns a list of Cats",
			responses = {
				@ApiResponse(
					responseCode = "200", 
					description = "A list of Cats is returned", 
					content = @Content(
							mediaType = "application/json", 
							schema = @Schema(implementation = Cat.class))),
				@ApiResponse(
						responseCode = "400", 
						description = "The request parameters are invalid", 
						content = @Content(mediaType = "application/json")),
				@ApiResponse(
						responseCode = "404", 
						description = "No Cats were found with the input criteria", 
						content = @Content(mediaType = "application/json")),
				@ApiResponse(
						responseCode = "500", 
						description = "An unplanned error occurred.", 
						content = @Content(mediaType = "application/json"))
			},
			parameters = {
				@Parameter(
						name = "catId", 
						allowEmptyValue = false, 
						required = false, 
						description = "The cat's ID (ex. FULL_NAME)")
			}
		)
		
		@GetMapping
		@ResponseStatus(code = HttpStatus.OK)
		List<Cat> fetchCats(
				@RequestParam(required = false) 
				String catId				
				);
		
	//PUT cats (updates)
		
		@Operation(
				summary = "Updates a cat",
				description = "Updates a Cat",
				responses = {
					@ApiResponse(
						responseCode = "200", 
						description = "A cat is updated", 
						content = @Content(
								mediaType = "application/json", 
								schema = @Schema(implementation = Cat.class))),
					@ApiResponse(
							responseCode = "400", 
							description = "The request parameters are invalid", 
							content = @Content(mediaType = "application/json")),
					@ApiResponse(
							responseCode = "404", 
							description = "No Cats were found with the input criteria", 
							content = @Content(mediaType = "application/json")),
					@ApiResponse(
							responseCode = "500", 
							description = "An unplanned error occurred.", 
							content = @Content(mediaType = "application/json"))
				},
				parameters = {
					@Parameter(
							name = "catId", 
							allowEmptyValue = false, 
							required = false, 
							description = "The cat's ID (ex. FULL_NAME)"),
					@Parameter(
							name = "catName", 
							allowEmptyValue = false, 
							required = false, 
							description = "The cat's name (ex. Name)"),
					@Parameter(
							name = "catAge", 
							allowEmptyValue = false, 
							required = false, 
							description = "The cat's age"),
					@Parameter(
							name = "breed", 
							allowEmptyValue = false, 
							required = false, 
							description = "The cat's breed (ex. SIAMESE)"),
					@Parameter(
							name = "color", 
							allowEmptyValue = false, 
							required = false, 
							description = "The cat's fur color (ex. orange)"),
					@Parameter(
							name = "neutered", 
							allowEmptyValue = false, 
							required = false, 
							description = "The cat's neuter status"),
					@Parameter(
							name = "personality", 
							allowEmptyValue = false, 
							required = false, 
							description = "The cat's personality (ex. affectionate)"),
					@Parameter(
							name = "notes", 
							allowEmptyValue = false, 
							required = false, 
							description = "Any relevant notes (ex. loves mouse toys)"),
				}
			)
			
			@PutMapping
			@ResponseStatus(code = HttpStatus.OK)
			Optional<Cat> updateCats(
					@RequestParam(required = false) 
					String catId,
					@RequestParam(required = false)
					String catName,
					@RequestParam(required = false)
					Integer catAge,
					@RequestParam(required = false)
					Breed breed,
					@RequestParam(required = false)
					String color,
					@RequestParam(required = false)
					boolean neutered,
					@RequestParam(required = false)
					String personality,
					@RequestParam(required = false)
					String notes
					);
		
	//DELETE cats
		
		@Operation(
				summary = "Delete a cat",
				description = "Deletes a cat",
				responses = {
					@ApiResponse(
						responseCode = "200", 
						description = "The given cat is been deleted", 
						content = @Content(
								mediaType = "application/json", 
								schema = @Schema(implementation = Cat.class))),
					@ApiResponse(
							responseCode = "400", 
							description = "The request parameters are invalid", 
							content = @Content(mediaType = "application/json")),
					@ApiResponse(
							responseCode = "404", 
							description = "No Cats were found with the input criteria", 
							content = @Content(mediaType = "application/json")),
					@ApiResponse(
							responseCode = "500", 
							description = "An unplanned error occurred.", 
							content = @Content(mediaType = "application/json"))
				},
				parameters = {
					@Parameter(
							name = "catId", 
							allowEmptyValue = false, 
							required = false, 
							description = "The cat's ID (ex. FULL_NAME)")
				}
			)
			
			@DeleteMapping
			@ResponseStatus(code = HttpStatus.OK)
			Optional <Cat> deleteCats(
					@RequestParam(required = false) 
					String catId				
					);
		
	
		// @formatter:on
		
}
