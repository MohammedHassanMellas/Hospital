package net.mellas.hospital.repositories;

import net.mellas.hospital.entities.Consultation;
import net.mellas.hospital.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultationRepository extends JpaRepository<Consultation, Long> {
}
