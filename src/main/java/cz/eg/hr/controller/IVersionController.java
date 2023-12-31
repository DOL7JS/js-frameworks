package cz.eg.hr.controller;

import cz.eg.hr.data.Version;
import cz.eg.hr.dtos.VersionInDto;
import cz.eg.hr.dtos.VersionOutDto;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Interface for handling HTTP request for Versions
 *
 * @author Petr Dolejs
 */
public interface IVersionController {
    /**
     * Retrieves all Versions using a GET request if the operation is successful.
     * Returns with status codes:
     * 200: successfully retrieve Versions
     *
     * @return ResponseEntity that contains all Versions mapped to VersionOutDto if the operation is successful
     */
    ResponseEntity<Iterable<VersionOutDto>> getAllVersion();

    /**
     * Retrieves one Version by ID using a GET request if the operation is successful.
     * Returns with status codes:
     * 200: successfully retrieve Version
     * 404: Version is not found
     *
     * @param id ID of Version to be found
     * @return ResponseEntity that contains one Version found by ID mapped to VersionOutDto if the operation is successful
     */
    ResponseEntity<VersionOutDto> getVersion(@PathVariable Long id);

    /**
     * Update Version by ID using a PUT request if the operation is successful.
     * Returns with status codes:
     * 200: successfully updated Version
     * 400: Version with new name already exist
     * 404: Version is not found
     *
     * @param id           ID of Version to be updated
     * @param versionInDto DTO containing new values
     * @return ResponseEntity that contains updated Version mapped to VersionOutDto if the operation is successful
     */
    ResponseEntity<VersionOutDto> updateVersion(@PathVariable Long id, @RequestBody @Valid VersionInDto versionInDto);

    /**
     * Delete Version by ID using a DELETE request if the operation is successful.
     *
     * @param id ID of Version to be deleted
     */
    void deleteVersion(@PathVariable Long id);

    /**
     * Fulltext Search in Versions using a GET request if the operation is successful.
     * Returns with status codes:
     * 200: successfully retrieve Version
     *
     * @param text Text to be searched in table
     * @return ResponseEntity that contains found Versions mapped to VersionOutDto if the operation is successful
     */
    ResponseEntity<List<VersionOutDto>> fulltextSearch(@RequestParam String text);

}
