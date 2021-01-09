package pl.sdaacademy.covidacademyapi.states_metadata.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StatesMetadataDbRepository extends JpaRepository<StatesMetadata, String> {
Optional<StatesMetadata> findByNameIgnoreCase(String name);
}
