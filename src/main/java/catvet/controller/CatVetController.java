package catvet.controller;

import java.util.List;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

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
						name = "breed", 
						allowEmptyValue = false, 
						required = false, 
						description = "The breed name (i.e., 'PERSIAN')")
			}
		)
		
		@GetMapping
		@ResponseStatus(code = HttpStatus.OK)
		List<Cat> fetchCats(
				@RequestParam(required = false) 
					Cat cat				
				);
		// @formatter:on
}
