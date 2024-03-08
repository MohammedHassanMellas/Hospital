package net.mellas.hospital.service;

import net.mellas.hospital.entities.Consultation;
import net.mellas.hospital.entities.Medecin;
import net.mellas.hospital.entities.Patient;
import net.mellas.hospital.entities.RendezVous;

public interface IHospital  {
    Patient savePatient(Patient patient);
    Medecin saveMedecin(Medecin medecin);
    RendezVous saveRendezvous(RendezVous rendezVous);
    Consultation saveConsultation(Consultation consultation);

}
