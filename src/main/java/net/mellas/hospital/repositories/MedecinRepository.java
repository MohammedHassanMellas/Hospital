package net.mellas.hospital.repositories;

import net.mellas.hospital.entities.Medecin;
import net.mellas.hospital.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedecinRepository extends JpaRepository<Medecin, Long> {
    Medecin findByNom(String nom);
}
