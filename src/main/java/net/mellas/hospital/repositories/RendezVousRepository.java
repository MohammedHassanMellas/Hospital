package net.mellas.hospital.repositories;

import net.mellas.hospital.entities.Patient;
import net.mellas.hospital.entities.RendezVous;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RendezVousRepository extends JpaRepository<RendezVous, String> {
}
