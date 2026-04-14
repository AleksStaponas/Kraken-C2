package com.example.Kraken_C2.API.DBController.AccountControllerAPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PersonController {

    @Autowired
    private PersonRepo personRepo;

    // Create a new person
    @PostMapping("/addPerson")
    public ResponseEntity<Person> createPerson(@RequestBody Person person){
        Person savedPerson = personRepo.save(person);
        return ResponseEntity.ok(savedPerson);
    }

    // Add multiple persons
    @PostMapping("/addAll")
    public List<Person> addAllPersons(@RequestBody List<Person> personList) {
        return personRepo.saveAll(personList);
    }

    // Get all persons
    @GetMapping("/fetchAllPersons")
    public List<Person> getAllPersons() {
        return personRepo.findAll();
    }

    // Get person by ID
    @GetMapping("/fetchById/{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable Long id) {
        return personRepo.findById(id)
                .map(person -> ResponseEntity.ok(person))
                .orElse(ResponseEntity.notFound().build());
    }

    // Check username availability and create a new user if available
    @PostMapping("/SignUpCheck/{name}")
    public ResponseEntity<String> checkAndCreatePerson(
            @PathVariable String name,
            @RequestParam String password,
            @RequestParam String email
    ) {
        long personCount = personRepo.countByUsername(name);
        if (personCount > 0) {
            return ResponseEntity.badRequest().body("Username is in use");
        } else {
            Person newPerson = new Person();
            newPerson.setUsername(name);
            newPerson.setPassword(password);
            newPerson.setEmail(email);
            personRepo.save(newPerson);
            return ResponseEntity.ok("Successfully created the user");
        }
    }

    // Update person data by ID
    @PutMapping("/update/{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable Long id, @RequestBody Person updatedData) {
        return personRepo.findById(id)
                .map(existingPerson -> {
                    existingPerson.setUsername(updatedData.getUsername());
                    existingPerson.setEmail(updatedData.getEmail());
                    personRepo.save(existingPerson);
                    return ResponseEntity.ok(existingPerson);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // Delete person by ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deletePerson(@PathVariable Long id) {
        if (personRepo.existsById(id)) {
            personRepo.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    // Get the maximum ID (or some field, adjust query if needed)
    @GetMapping("/getMax")
    public Long getMax() {
        return personRepo.getMax();
    }

    // Get the minimum ID (or some field, adjust query if needed)
    @GetMapping("/getMin")
    public Long getMin() {
        return personRepo.getMin();
    }

    // Get sorted list of persons
    @GetMapping("/sort")
    public List<Person> getSortedPersons(@RequestParam String sortDir, @RequestParam String sortBy) {
        Sort.Direction direction = sortDir.equals("asc") ? Sort.Direction.ASC : Sort.Direction.DESC;
        return personRepo.findAll(Sort.by(direction, sortBy));
    }

    // Get a paginated list of persons
    @GetMapping("/sortPage")
    public List<Person> getPagedPersons(@RequestParam int page, @RequestParam int size, @RequestParam String sortDir) {
        Sort.Direction direction = sortDir.equals("asc") ? Sort.Direction.ASC : Sort.Direction.DESC;
        Pageable pageable = PageRequest.of(page, size, Sort.by(direction, "id"));
        return personRepo.findAll(pageable).getContent();
    }
}
