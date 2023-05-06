package catvet.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import catvet.entity.Cat;
import catvet.entity.Doctor;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;

@Validated
@RequestMapping("/doctors")
@OpenAPIDefinition(info = @Info(title = "Cat Vet Service"), servers = {
		@Server(url = "http://localhost:8080", description = "Local server.")})
public interface DoctorController {
	
	//GET doctors (read)
			@Operation(
				summary = "Returns a list of doctors",
				description = "Returns a list of doctors",
				responses = {
					@ApiResponse(
						responseCode = "200", 
						description = "A list of doctors is returned", 
						content = @Content(
								mediaType = "application/json", 
								schema = @Schema(implementation = Doctor.class))),
					@ApiResponse(
							responseCode = "400", 
							description = "The request parameters are invalid", 
							content = @Content(mediaType = "application/json")),
					@ApiResponse(
							responseCode = "404", 
							description = "No doctors were found with the input criteria", 
							content = @Content(mediaType = "application/json")),
					@ApiResponse(
							responseCode = "500", 
							description = "An unplanned error occurred.", 
							content = @Content(mediaType = "application/json"))
				},
				parameters = {
					@Parameter(
							name = "doctorId", 
							allowEmptyValue = false, 
							required = false, 
							description = "The doctor's ID (ex. FULL_NAME)")
				}
			)
			
			@GetMapping
			@ResponseStatus(code = HttpStatus.OK)
			List<Doctor> fetchDoctors(
					@RequestParam(required = false) 
					String doctorId				
					);
		//PUT cat_doctor (assigns cat and doctor relationship)
			
			@Operation(
					summary = "Updates a cat/doctor relationship",
					description = "Updates a Cat/Doctor relationship",
					responses = {
						@ApiResponse(
							responseCode = "200", 
							description = "A cat/doctor relationship is assigned", 
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
								name = "cat_pk", 
								allowEmptyValue = false, 
								required = false, 
								description = "The cat's primary key"),
						@Parameter(
								name = "doctor_pk", 
								allowEmptyValue = false, 
								required = false, 
								description = "The doctor's primary key")
					}
				)
				
				@PutMapping
				@ResponseStatus(code = HttpStatus.OK)
				Optional<Cat> updateCatDoctor(
						@RequestParam(required = false) 
						Long cat_pk,
						@RequestParam(required = false)
						Long doctor_pk
						);
}
